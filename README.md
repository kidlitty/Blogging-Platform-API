<div align="center">
  <br />
  <h1 align="center">Modern Blogging Platform API</h1>
  <p align="center">
    A robust RESTful API for a complete blogging platform, built with Java and the Spring Boot framework.
    <br />
    <a href="#about-the-project"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="#-api-endpoints-guide">View API Endpoints</a>
    ·
    <a href="https://github.com/YOUR_USERNAME/YOUR_REPO/issues">Report Bug</a>
    ·
    <a href="https://github.com/YOUR_USERNAME/YOUR_REPO/issues">Request Feature</a>
  </p>
</div>

<div align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=spring&logoColor=white" alt="Spring Boot 3.x">
  <img src="https://img.shields.io/badge/Maven-4.0-red?logo=apache-maven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License: MIT">
  <img src="https://img.shields.io/github/stars/YOUR_USERNAME/YOUR_REPO?style=social" alt="GitHub stars">
</div>

<br/>

---

## Table of Contents

- [About The Project](#about-the-project)
- [Tech Stack](#-tech-stack)
- [Key Features](#-key-features)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Running the Application](#-running-the-application)
- [API Endpoints Guide](#-api-endpoints-guide)
- [Running Tests](#-running-tests)
- [Contributing](#-contributing)
- [License](#-license)
- [Contact](#-contact)

---

## About The Project

This project provides a complete and scalable backend API for a modern blogging platform. It is built on a clean architecture, separating concerns for maintainability and ease of development. The API supports full CRUD operations for posts, categories, and tags, along with a secure JWT-based authentication system for user management.

It serves as a strong foundation for any front-end application (web or mobile) to build a feature-rich blogging experience.

---

## 🛠️ Tech Stack

This project is built with a modern and robust set of technologies:

| Backend                                     | Database                               | Build & Tooling                                |
| ------------------------------------------- | -------------------------------------- | ---------------------------------------------- |
| ![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white) | ![H2](https://img.shields.io/badge/H2-InMemory-orange?logo=h2&logoColor=white) | ![Maven](https://img.shields.io/badge/Maven-4.0-red?logo=apache-maven&logoColor=white) |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=spring&logoColor=white) | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue?logo=postgresql&logoColor=white) | ![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange?logo=postman&logoColor=white) |
| ![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-green?logo=spring-security&logoColor=white) |                                        | ![Git](https://img.shields.io/badge/Git-VCS-orange?logo=git&logoColor=white) |
| ![JWT](https://img.shields.io/badge/JWT-Authentication-purple?logo=json-web-tokens&logoColor=white) |                                        |                                                |

---

## ✨ Key Features

- **Full CRUD Operations:** For Posts, Categories, and Tags.
- **Secure Authentication:** JWT-based user registration and login.
- **Author Attribution:** Posts are automatically linked to the logged-in author.
- **Data Validation:** Incoming data is validated to ensure integrity.
- **Centralized Exception Handling:** Consistent and meaningful error responses.
- **Relational Data Model:** Well-defined relationships between Posts, Categories, and Tags.
- **DTO Pattern:** Clean separation between internal entities and external API models.

---

## 🚀 Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need the following software installed on your machine:
* **Java Development Kit (JDK)**: Version 17 or higher.
* **Apache Maven**: Version 3.8 or higher.
* **Git**: For cloning the repository.
* An API testing tool like **Postman** or **Insomnia**.

### Installation

1.  **Clone the repository**
    ```sh
    git clone [https://github.com/YOUR_USERNAME/YOUR_REPO.git](https://github.com/YOUR_USERNAME/YOUR_REPO.git)
    cd YOUR_REPO
    ```
2.  **Install Maven dependencies**
    This command will download all the necessary libraries defined in the `pom.xml`.
    ```sh
    mvn clean install
    ```
---

## ▶️ Running the Application

Once the dependencies are installed, you can run the application using the Spring Boot Maven plugin:

```sh
mvn spring-boot:run
