📝 Blogging Platform API

A robust and secure RESTful API serving as the backend for a modern blogging platform. Developed with Spring Boot, this is a prototype project demonstrating core backend development concepts. It provides comprehensive functionalities for content management, user authentication, and role-based authorization, showcasing a strong foundation in backend development best practices.
✨ Core Features

    Secure User Authentication & Authorization: Implements a stateless, token-based security model using JSON Web Tokens (JWT). Supports user registration, login, and robust role-based access control (ROLE_USER, ROLE_ADMIN) for protecting sensitive endpoints.

    Comprehensive Content Management: Provides full CRUD (Create, Read, Update, Delete) operations for blog posts, categories, and tags.

    Automatic Author Assignment: Posts are automatically linked to the authenticated user who created them, ensuring proper content attribution.

    Flexible Data Relationships: Posts are effectively linked to categories (many-to-one) and tags (many-to-many), demonstrating strong relational database design.

    Public & Protected Access: Allows public read access to all posts, categories, and tags, while requiring authentication for content modification operations.

    Developer-Friendly API Documentation: Integrated Swagger UI provides interactive documentation for easy endpoint exploration and testing.

🛠️ Tech Stack

Leveraging industry-standard tools and frameworks to build a scalable and maintainable backend.

Technology


Icon


Description

Java 22


The foundational language, chosen for its robustness, performance, and extensive ecosystem.

Spring Boot 3.x


Streamlines standalone, production-grade Spring applications, minimizing boilerplate and simplifying configuration.

Spring Security


The go-to framework for authentication and authorization in Spring applications, ensuring robust security.

JWT (jjwt)


Enables stateless, secure API communication by verifying user identity and permissions through cryptographic tokens.

Spring Data JPA


Simplifies database interactions with powerful repository abstractions, reducing data access code.

Hibernate


The ORM (Object-Relational Mapping) solution, effectively bridging Java objects with relational database tables.

H2 Database


An in-memory, file-based relational database used for efficient local development and testing.

Maven


The primary build automation tool, managing dependencies and standardizing the project build lifecycle.

Lombok


A productivity tool that reduces boilerplate code in Java classes (e.g., getters, setters, constructors).

MapStruct


A code generator for type-safe and performant object mapping between entities and DTOs, crucial for clean API contracts.

Swagger UI


Generates interactive API documentation directly from code, enabling easy exploration and testing of endpoints.

Postman


(Recommended) A comprehensive API platform used for efficient development, testing, and documentation of API endpoints.
🚀 Getting Started

Follow these steps to get the Blogging Platform API up and running on your local machine.
Prerequisites

Ensure you have the following installed:

    Java Development Kit (JDK) 22 or higher

    Apache Maven 3.8.x or higher

    An Integrated Development Environment (IDE) like IntelliJ IDEA (Community Edition is highly recommended for Spring Boot development).

    (Optional but Recommended) Postman for interacting with the API.

Setup Instructions

    Clone the Repository:

    git clone <repository-url> # Replace with your project's repository URL
    cd blogging-platform-api


    Build the Project:
    Navigate to the project's root directory (where pom.xml is located) and execute the Maven build command. This compiles the source code, runs tests, and resolves all dependencies.

    mvn clean install


    Run the Application:
    Start the Spring Boot application using Maven:

    mvn spring-boot:run


    Alternatively, open the project in your IDE and run the main method within src/main/java/com/kidlitty/blogging_platform_api/BloggingPlatformApiApplication.java.

    The application will typically start on http://localhost:8080.

Local Development Environment Details

    In-Memory H2 Database: Configured for rapid development, the H2 database (jdbc:h2:mem:blogdb) resets its data on every application restart.

    JWT Secret Management: For local convenience, the API automatically generates and persists the JWT secret key to a jwt.key file in the project root on its first run, ensuring token validity across restarts within a development session.

    H2 Console Access: You can inspect the database directly via the H2 Console at http://localhost:8080/h2-console.

        JDBC URL: jdbc:h2:mem:blogdb

        User Name: sa

        Password: (leave blank)

💡 API Endpoint Guide

The API adheres to RESTful conventions, with all core endpoints accessible under the /api prefix.
🌐 Interactive API Documentation

Explore all available endpoints, their parameters, and expected responses using Swagger UI:
➡️ http://localhost:8080/swagger-ui.html
🔑 Authentication Flow

All endpoints requiring user authentication expect a JWT provided in the Authorization header as a Bearer token (e.g., Authorization: Bearer YOUR_GENERATED_JWT_TOKEN).

    Register a New User:

        POST /api/auth/register

        Request Body Example: {"username": "johndoe", "password": "securePass123"}

        Success Response: 201 Created

    Login User & Obtain JWT:

        POST /api/auth/login

        Request Body Example: {"username": "johndoe", "password": "securePass123"}

        Success Response: 200 OK (Includes the JWT in the token field)

        {
          "token": "eyJhbGciOiJIUzUxMiJ9...", // Your JWT
          "type": "Bearer",
          "id": 1,
          "username": "johndoe",
          "roles": ["ROLE_USER"]
        }


✍️ Blog Post Management (/api/posts)

    Create Post: (POST /api/posts) - Requires authenticated user (ROLE_USER or ROLE_ADMIN). Author is automatically set.

    Get All Posts: (GET /api/posts) - Publicly accessible.

    Get Post by ID: (GET /api/posts/{id}) - Publicly accessible.

    Update Post: (PUT /api/posts/{id}) - Requires authenticated user (ROLE_USER or ROLE_ADMIN).

    Delete Post: (DELETE /api/posts/{id}) - Requires authenticated user (ROLE_USER or ROLE_ADMIN).

🏷️ Category & Tag Management (/api/categories, /api/tags)

Similar CRUD operations are available for Categories and Tags. GET requests are publicly accessible, while POST, PUT, and DELETE requests require an authenticated user with ROLE_USER or ROLE_ADMIN.
📜 License

This project is licensed under the MIT License - see the LICENSE file for details.