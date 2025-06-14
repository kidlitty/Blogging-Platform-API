package com.kidlitty.blogging_platform_api.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private static final String JWT_KEY_FILE = "jwt.key";

    @Value("${jwt.expiration.ms}")
    private int jwtExpirationMs;

    private SecretKey jwtSigningKey;

    public JwtUtils (@Value("${jwt.expiration.ms}") int jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
        this.jwtSigningKey = loadOrCreateJwtSecretKey();
    }

    private SecretKey loadOrCreateJwtSecretKey() {
        try {
            Path keyPath = Paths.get(JWT_KEY_FILE);

            if (Files.exists(keyPath) && Files.size(keyPath) > 0) {
                String encodedKey = Files.readString(keyPath);
                byte [] keyBytes = Base64.getDecoder().decode(encodedKey);
                logger.info("JWT secret loaded from file: {}", JWT_KEY_FILE);
                return Keys.hmacShaKeyFor(keyBytes);
            } else {
                SecureRandom secureRandom = new SecureRandom();
                byte[] keyBytes = new byte[64];
                secureRandom.nextBytes(keyBytes);
                String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
                Files.writeString(keyPath, encodedKey);
                logger.info("Generated new JWT secret and saved to file: {}", JWT_KEY_FILE);
                return Keys.hmacShaKeyFor(keyBytes);
            }
        } catch (IOException e) {
            logger.error("Error reading or writing JWT secret key file: {}", e.getMessage());

            logger.warn("Falling back to transient JWT secret key due to file error. This is not production safe!");

            return Keys.secretKeyFor(SignatureAlgorithm.HS512);
        }
    }

    private SecretKey getSigningKey() {
        return jwtSigningKey;
    }

    public String generateJwtToken(Authentication authentication) {

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (io.jsonwebtoken.security.SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claim string is empty: {}", e.getMessage());
        }
        return false;
    }
}
