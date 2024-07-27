# Spring Boot JWT Authentication with SQL Database

This project demonstrates how to implement JWT (JSON Web Token) authentication in a Spring Boot application using a SQL database.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Built With](#built-with)
- [Contributing](#contributing)
- [License](#license)

## Features

- User registration and login
- JWT authentication and authorization
- Password hashing with BCrypt
- Role-based access control
- Global exception handling

## Prerequisites

- Java 17
- Spring Boot 3.3.1
- Maven
- A SQL database (e.g., MySQL, PostgreSQL)

## Getting Started

### Clone the repository

```
git clone https://github.com/yourusername/your-repo-name.git
```

```
cd your-repo-name
```

### Configure the database

Create a database for the application and update the `application.properties` file with your database details.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

### Install dependencies and build the project

`mvn clean install`

## Project Structure

```src
└── main
├── java
│   └── net.lakhwan.basic_auth
│       ├── config
│       │   └── SpringSecurityConfig.java
│       ├── controller
│       │   └── AuthController.java
│       ├── entity
│       │   ├── Role.java
│       │   └── User.java
│       ├── exceptions
│       │   ├── AuthAPIException.java
│       │   ├── GlobalExceptionHandler.java
│       │   └── ResourceNotFoundException.java
│       ├── repository
│       │   ├── RoleRepository.java
│       │   └── UserRepository.java
│       ├── security
│       │   ├── CustomUserDetailsService.java
│       │   ├── JwtAuthenticationEntryPoint.java
│       │   ├── JwtAuthenticationFilter.java
│       │   ├── JwtTokenProvider.java
│       │   └── SecurityUtils.java
│       └── BasicAuth.java
└── resources
├── application.properties
└── data.sql
```

## Configuration

### Security Configuration

The security configuration is defined in `SpringSecurityConfig.java` where the JWT filter and authentication entry point are set up.

### JWT Configuration

The JWT utility classes (`JwtTokenProvider`, `JwtAuthenticationFilter`, and `JwtAuthenticationEntryPoint`) handle token generation, validation, and authentication.

### Exception Handling

Global exception handling is managed in `GlobalExceptionHandler.java`, which handles various exceptions and returns appropriate HTTP status codes.

## Running the Application

`mvn spring-boot:run`

## API Endpoints

### Authentication

- `POST /api/auth/register`

  **Request Body:** `{ "username": "user", "password": "password", "roles": ["ROLE_USER"] }`

  **Response:** `201 Created`

- `POST /api/auth/login`

  **Request Body:** `{ "username": "user", "password": "password" }`

  **Response:** `{ "token": "jwt-token" }`

### Protected Endpoints

- `GET /api/users`

  Requires JWT token in the Authorization header

  Response: `200 OK`

## Built With

- Spring Boot
- Spring Security
- JWT
- Maven
- MySQL

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
