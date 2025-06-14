package com.kidlitty.blogging_platform_api;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        // We need 64 bytes for a 512-bit key (HS512)
        byte[] key = new byte[64];
        secureRandom.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated JWT Secret (for HS512): " + encodedKey);
    }
}
