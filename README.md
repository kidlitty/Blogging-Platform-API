# Modern Blogging Platform API

![Java 21](https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white)
![Spring Boot 3.5.0](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-4.0-red?logo=apache-maven&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)
![GitHub stars](https://img.shields.io/github/stars/kidlitty/Blogging-Platform-API?style=social)

A robust RESTful API for a complete blogging platform, built with Java and the Spring Boot framework.

**Explore the docs »** | [View API Endpoints](#api-endpoints-guide) |
[Report Bug](https://github.com/kidlitty/Blogging-Platform-API/issues) |
[Request Feature](https://github.com/kidlitty/Blogging-Platform-API/issues)

## Table of Contents
- [About The Project](#about-the-project)
- [Tech Stack](#tech-stack)
- [Key Features](#key-features)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints Guide](#api-endpoints-guide)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## About The Project
This project provides a complete and scalable backend API for a modern blogging platform. It is built on a clean architecture, separating concerns for maintainability and ease of development. The API supports full CRUD operations for posts, categories, and tags, along with a secure JWT-based authentication system for user management.

It serves as a strong foundation for any front-end application (web or mobile) to build a feature-rich blogging experience.

---

## 🛠️ Tech Stack
This project is built with a modern and robust set of technologies:

| Backend | Database | Build & Tooling |
|---------|----------|----------------|
| ![Java 21](https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white) | ![H2](https://img.shields.io/badge/H2-InMemory-orange?logo=h2&logoColor=white) | ![Maven](https://img.shields.io/badge/Maven-4.0-red?logo=apache-maven&logoColor=white) |
| ![Spring Boot 3.5.0](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?logo=spring&logoColor=white) | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue?logo=postgresql&logoColor=white) | ![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange?logo=postman&logoColor=white) |
| ![Spring Security 6](https://img.shields.io/badge/Spring%20Security-6-green?logo=spring-security&logoColor=white) |  | ![Git](https://img.shields.io/badge/Git-VCS-orange?logo=git&logoColor=white) |
| ![JWT](https://img.shields.io/badge/JWT-Authentication-purple?logo=json-web-tokens&logoColor=white) |  |  |

---

## ✨ Key Features
- **Full CRUD Operations:** For Posts, Categories, and Tags
- **Secure Authentication:** JWT-based user registration and login
- **Author Attribution:** Posts are automatically linked to the logged-in author
- **Data Validation:** Incoming data is validated to ensure integrity
- **Centralized Exception Handling:** Consistent and meaningful error responses
- **Relational Data Model:** Well-defined relationships between Posts, Categories, and Tags
- **DTO Pattern:** Clean separation between internal entities and external API models

---

## 🚀 Getting Started
Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
You will need the following software installed on your machine:
- **Java Development Kit (JDK):** Version 21 or higher
- **Apache Maven:** Version 3.8 or higher
- **Git:** For cloning the repository
- An API testing tool like **Postman** or **Insomnia**

### Installation
1. **Clone the repository**
   ```bash
   git clone https://github.com/kidlitty/Blogging-Platform-API.git
   cd Blogging-Platform-API
   ```
2. **Install Maven dependencies**
This command will download all the necessary libraries defined in the pom.xml
    ```bash
   mvn clean install
    ```
   
## ▶️ Running the Application
Once the dependencies are installed, run the application using:
    ```bash
    mvn spring-boot:run
    ```
The API server will start on http://localhost:8080. Access the H2 in-memory database console at http://localhost:8080/h2-console to inspect data.

---

## 🗺️ API Endpoints Guide

> For protected routes (`POST`, `PUT`, `DELETE`), include authorization header:  
> `Authorization: Bearer <YOUR_JWT_TOKEN>`

| Resource    | Method   | Endpoint                   | Description                      |
|-------------|----------|----------------------------|----------------------------------|
| **Auth**    | `POST`   | `/api/auth/register`       | Register new user                |
|             | `POST`   | `/api/auth/login`          | Login to receive JWT             |
| **Posts**   | `GET`    | `/api/posts`               | Get all posts                    |
|             | `GET`    | `/api/posts/{id}`          | Get single post by ID            |
|             | `POST`   | `/api/posts`               | Create new post (protected)      |
|             | `PUT`    | `/api/posts/{id}`          | Update post (protected)          |
|             | `DELETE` | `/api/posts/{id}`          | Delete post (protected)          |
| **Categories** | `GET` | `/api/categories`          | Get all categories               |
|             | `GET`    | `/api/categories/{id}`     | Get category by ID               |
|             | `POST`   | `/api/categories`          | Create category (protected)      |
|             | `PUT`    | `/api/categories/{id}`     | Update category (protected)      |
|             | `DELETE` | `/api/categories/{id}`     | Delete category (protected)      |
| **Tags**    | `GET`    | `/api/tags`                | Get all tags                     |
|             | `GET`    | `/api/tags/{id}`           | Get tag by ID                    |
|             | `POST`   | `/api/tags`                | Create tag (protected)           |
|             | `PUT`    | `/api/tags/{id}`           | Update tag (protected)           |
|             | `DELETE` | `/api/tags/{id}`           | Delete tag (protected)           |

---

## 🧪 Running Tests

Run test suite with:
```bash
mvn test
```
This executes:

- Unit tests for services and utilities

- Integration tests for controllers

- Repository tests for database operations

- Security tests for authentication

Test coverage report will be generated at:
target/site/jacoco/index.html

---

## 🤝 Contributing

Contributions are what make the open-source community amazing! Any contributions are **greatly appreciated**.

1. **Fork the Project**
2. **Create Feature Branch**  
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. Commit Changes
   ```bash
   git commit -m 'Add AmazingFeature'
   ```
4. Push to Branch
   ```bash
   git push origin feature/AmazingFeature
   ```
5. Open Pull Request

Contribution Guidelines

- Follow existing code style and patterns

- Write tests for new features

- Update documentation when needed

- Keep pull requests focused on a single feature

## 📜 License

Distributed under the MIT License. See `LICENSE` file for full text.


## 📞 Contact

**Uphile Ntuli**  
Email: [uphilentuli43@gmail.com](mailto:uphilentuli43@gmail.com)  
GitHub: [@kidlitty](https://github.com/kidlitty)  
Project Repository: [Blogging-Platform-API](https://github.com/kidlitty/Blogging-Platform-API)
