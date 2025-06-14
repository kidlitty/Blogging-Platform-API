<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modern Blogging Platform API - README</title>
    <style>
        /* General Body Styles */
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji";
            line-height: 1.6;
            color: #333;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }

        /* Main Container */
        .container {
            max-width: 900px;
            margin: 0 auto;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            padding: 40px;
        }

        /* Header Section */
        .header {
            text-align: center;
            border-bottom: 1px solid #e9ecef;
            padding-bottom: 20px;
            margin-bottom: 30px;
        }
        .header img.logo {
            width: 120px;
            height: 120px;
        }
        .header h1 {
            font-size: 2.5em;
            margin: 20px 0 10px;
            color: #212529;
        }
        .header p {
            font-size: 1.1em;
            color: #6c757d;
        }
        .header .links a {
            margin: 0 10px;
            font-weight: 500;
        }
        .badges {
            margin-top: 20px;
        }
        .badges img {
            margin: 0 5px;
        }

        /* Headings */
        h2 {
            font-size: 2em;
            color: #212529;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
            margin-top: 40px;
            margin-bottom: 20px;
        }

        /* Links */
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }

        /* Lists */
        ul {
            list-style-type: disc;
            padding-left: 20px;
        }
        li {
            margin-bottom: 10px;
        }

        /* Tables */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border: 1px solid #dee2e6;
        }
        thead th {
            background-color: #f2f2f2;
            font-weight: 600;
            color: #495057;
        }
        tbody tr:nth-of-type(even) {
            background-color: #f8f9fa;
        }
        tbody tr:hover {
            background-color: #e9ecef;
        }
        td code {
            padding: 3px 6px;
        }

        /* Code Blocks */
        pre {
            background-color: #282c34;
            color: #abb2bf;
            border-radius: 6px;
            padding: 15px;
            overflow-x: auto;
            font-family: "SFMono-Regular", Consolas, "Liberation Mono", Menlo, monospace;
            font-size: 0.9em;
        }
        code {
            font-family: "SFMono-Regular", Consolas, "Liberation Mono", Menlo, monospace;
            background-color: #e9ecef;
            border-radius: 4px;
            padding: 2px 5px;
            font-size: 0.9em;
        }

        /* Horizontal Rule */
        hr {
            border: 0;
            height: 1px;
            background-color: #e9ecef;
            margin: 40px 0;
        }

    </style>
</head>
<body>

<div class="container">
    <header class="header">
        <h1>Modern Blogging Platform API</h1>
        <p>
            A robust RESTful API for a complete blogging platform, built with Java and the Spring Boot framework.
        </p>
        <div class="links">
            <a href="#about-the-project"><strong>Explore the docs »</strong></a>
            <a href="#api-endpoints-guide">View API Endpoints</a>
            ·
            <a href="https://github.com/kidlitty/Blogging-Platform-API/issues">Report Bug</a>
            ·
            <a href="https://github.com/kidlitty/Blogging-Platform-API/issues">Request Feature</a>
        </div>
        <div class="badges">
            <img src="https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white" alt="Java 21">
            <img src="https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?logo=spring&logoColor=white" alt="Spring Boot 3.5.0">
            <img src="https://img.shields.io/badge/Maven-4.0-red?logo=apache-maven&logoColor=white" alt="Maven">
            <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License: MIT">
            <img src="https://img.shields.io/github/stars/kidlitty/Blogging-Platform-API?style=social" alt="GitHub stars">
        </div>
    </header>

    <main>
        <h2 id="table-of-contents">Table of Contents</h2>
        <ul>
            <li><a href="#about-the-project">About The Project</a></li>
            <li><a href="#tech-stack">Tech Stack</a></li>
            <li><a href="#key-features">Key Features</a></li>
            <li><a href="#getting-started">Getting Started</a></li>
            <li><a href="#running-the-application">Running the Application</a></li>
            <li><a href="#api-endpoints-guide">API Endpoints Guide</a></li>
            <li><a href="#running-tests">Running Tests</a></li>
            <li><a href="#contributing">Contributing</a></li>
            <li><a href="#license">License</a></li>
            <li><a href="#contact">Contact</a></li>
        </ul>

        <hr>

        <h2 id="about-the-project">About The Project</h2>
        <p>This project provides a complete and scalable backend API for a modern blogging platform. It is built on a clean architecture, separating concerns for maintainability and ease of development. The API supports full CRUD operations for posts, categories, and tags, along with a secure JWT-based authentication system for user management.</p>
        <p>It serves as a strong foundation for any front-end application (web or mobile) to build a feature-rich blogging experience.</p>

        <hr>

        <h2 id="tech-stack">🛠️ Tech Stack</h2>
        <p>This project is built with a modern and robust set of technologies:</p>
        <table>
            <thead>
            <tr>
                <th>Backend</th>
                <th>Database</th>
                <th>Build & Tooling</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><img src="https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white" alt="Java 21"></td>
                <td><img src="https://img.shields.io/badge/H2-InMemory-orange?logo=h2&logoColor=white" alt="H2"></td>
                <td><img src="https://img.shields.io/badge/Maven-4.0-red?logo=apache-maven&logoColor=white" alt="Maven"></td>
            </tr>
            <tr>
                <td><img src="https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?logo=spring&logoColor=white" alt="Spring Boot 3.5.0"></td>
                <td><img src="https://img.shields.io/badge/PostgreSQL-Ready-blue?logo=postgresql&logoColor=white" alt="PostgreSQL"></td>
                <td><img src="https://img.shields.io/badge/Postman-API%20Testing-orange?logo=postman&logoColor=white" alt="Postman"></td>
            </tr>
            <tr>
                <td><img src="https://img.shields.io/badge/Spring%20Security-6-green?logo=spring-security&logoColor=white" alt="Spring Security 6"></td>
                <td></td>
                <td><img src="https://img.shields.io/badge/Git-VCS-orange?logo=git&logoColor=white" alt="Git"></td>
            </tr>
            <tr>
                <td><img src="https://img.shields.io/badge/JWT-Authentication-purple?logo=json-web-tokens&logoColor=white" alt="JWT"></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>

        <hr>

        <h2 id="key-features">✨ Key Features</h2>
        <ul>
            <li><strong>Full CRUD Operations:</strong> For Posts, Categories, and Tags.</li>
            <li><strong>Secure Authentication:</strong> JWT-based user registration and login.</li>
            <li><strong>Author Attribution:</strong> Posts are automatically linked to the logged-in author.</li>
            <li><strong>Data Validation:</strong> Incoming data is validated to ensure integrity.</li>
            <li><strong>Centralized Exception Handling:</strong> Consistent and meaningful error responses.</li>
            <li><strong>Relational Data Model:</strong> Well-defined relationships between Posts, Categories, and Tags.</li>
            <li><strong>DTO Pattern:</strong> Clean separation between internal entities and external API models.</li>
        </ul>

        <hr>

        <h2 id="getting-started">🚀 Getting Started</h2>
        <p>Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.</p>
        <h3>Prerequisites</h3>
        <p>You will need the following software installed on your machine:</p>
        <ul>
            <li><strong>Java Development Kit (JDK):</strong> Version 21 or higher.</li>
            <li><strong>Apache Maven:</strong> Version 3.8 or higher.</li>
            <li><strong>Git:</strong> For cloning the repository.</li>
            <li>An API testing tool like <strong>Postman</strong> or <strong>Insomnia</strong>.</li>
        </ul>
        <h3>Installation</h3>
        <ol>
            <li><strong>Clone the repository</strong>
                <pre>git clone https://github.com/kidlitty/Blogging-Platform-API.git
cd Blogging-Platform-API</pre>
            </li>
            <li><strong>Install Maven dependencies</strong>
                <p>This command will download all the necessary libraries defined in the <code>pom.xml</code>.</p>
                <pre>mvn clean install</pre>
            </li>
        </ol>

        <hr>

        <h2 id="running-the-application">▶️ Running the Application</h2>
        <p>Once the dependencies are installed, you can run the application using the Spring Boot Maven plugin:</p>
        <pre>mvn spring-boot:run</pre>
        <p>The API server will start on <code>http://localhost:8080</code>. You can access the H2 in-memory database console at <code>http://localhost:8080/h2-console</code> to inspect the data.</p>

        <hr>

        <h2 id="api-endpoints-guide">🗺️ API Endpoints Guide</h2>
        <p>Below is a summary of the available API endpoints. For all <code>POST</code>, <code>PUT</code>, and <code>DELETE</code> requests on protected routes, you must include an <code>Authorization</code> header with a valid JWT.<br>
            <code>Authorization: Bearer &lt;YOUR_JWT_TOKEN&gt;</code></p>

        <table>
            <thead>
            <tr>
                <th>Resource</th>
                <th>HTTP Method</th>
                <th>Endpoint</th>
                <th>Description</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td rowspan="2"><strong>Auth</strong></td>
                <td><code>POST</code></td>
                <td><code>/api/auth/register</code></td>
                <td>Register a new user.</td>
            </tr>
            <tr>
                <td><code>POST</code></td>
                <td><code>/api/auth/login</code></td>
                <td>Log in to receive a JWT.</td>
            </tr>
            <tr>
                <td rowspan="5"><strong>Posts</strong></td>
                <td><code>GET</code></td>
                <td><code>/api/posts</code></td>
                <td>Get a list of all posts.</td>
            </tr>
            <tr>
                <td><code>GET</code></td>
                <td><code>/api/posts/{id}</code></td>
                <td>Get a single post by its ID.</td>
            </tr>
            <tr>
                <td><code>POST</code></td>
                <td><code>/api/posts</code></td>
                <td>Create a new post (protected).</td>
            </tr>
            <tr>
                <td><code>PUT</code></td>
                <td><code>/api/posts/{id}</code></td>
                <td>Update an existing post (protected).</td>
            </tr>
            <tr>
                <td><code>DELETE</code></td>
                <td><code>/api/posts/{id}</code></td>
                <td>Delete a post (protected).</td>
            </tr>
            <tr>
                <td rowspan="5"><strong>Categories</strong></td>
                <td><code>GET</code></td>
                <td><code>/api/categories</code></td>
                <td>Get a list of all categories.</td>
            </tr>
            <tr>
                <td><code>GET</code></td>
                <td><code>/api/categories/{id}</code></td>
                <td>Get a single category by its ID.</td>
            </tr>
            <tr>
                <td><code>POST</code></td>
                <td><code>/api/categories</code></td>
                <td>Create a new category (protected).</td>
            </tr>
            <tr>
                <td><code>PUT</code></td>
                <td><code>/api/categories/{id}</code></td>
                <td>Update an existing category (protected).</td>
            </tr>
            <tr>
                <td><code>DELETE</code></td>
                <td><code>/api/categories/{id}</code></td>
                <td>Delete a category (protected).</td>
            </tr>
            <tr>
                <td rowspan="5"><strong>Tags</strong></td>
                <td><code>GET</code></td>
                <td><code>/api/tags</code></td>
                <td>Get a list of all tags.</td>
            </tr>
            <tr>
                <td><code>GET</code></td>
                <td><code>/api/tags/{id}</code></td>
                <td>Get a single tag by its ID.</td>
            </tr>
            <tr>
                <td><code>POST</code></td>
                <td><code>/api/tags</code></td>
                <td>Create a new tag (protected).</td>
            </tr>
            <tr>
                <td><code>PUT</code></td>
                <td><code>/api/tags/{id}</code></td>
                <td>Update an existing tag (protected).</td>
            </tr>
            <tr>
                <td><code>DELETE</code></td>
                <td><code>/api/tags/{id}</code></td>
                <td>Delete a tag (protected).</td>
            </tr>
            </tbody>
        </table>

        <hr>

        <h2 id="running-tests">🧪 Running Tests</h2>
        <p>To run the suite of unit and integration tests, use the following Maven command:</p>
        <pre>mvn test</pre>
        <p>This ensures that all components of the API are functioning as expected.</p>

        <hr>

        <h2 id="contributing">🤝 Contributing</h2>
        <p>Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are <strong>greatly appreciated</strong>.</p>
        <p>If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".</p>
        <ol>
            <li><strong>Fork the Project</strong></li>
            <li><strong>Create your Feature Branch</strong> (<code>git checkout -b feature/AmazingFeature</code>)</li>
            <li><strong>Commit your Changes</strong> (<code>git commit -m 'Add some AmazingFeature'</code>)</li>
            <li><strong>Push to the Branch</strong> (<code>git push origin feature/AmazingFeature</code>)</li>
            <li><strong>Open a Pull Request</strong></li>
        </ol>

        <hr>

        <h2 id="license">📜 License</h2>
        <p>Distributed under the MIT License. See <code>LICENSE</code> file for more information.</p>

        <hr>

        <h2 id="contact">📞 Contact</h2>
        <p>Uphile Ntuli - uphilentuli43@gmail.com</p>
        <p>Project Link: <a href="https://github.com/kidlitty/Blogging-Platform-API">https://github.com/kidlitty/Blogging-Platform-API</a></p>

    </main>
</div>

</body>
</html>