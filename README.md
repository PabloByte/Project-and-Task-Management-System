# Project and Task Management System

Project and Task Management System is a practice-based backend application built with Java and Spring Boot to manage projects, assign tasks, and organize collaborators within each project.

The main purpose of this project is to strengthen practical knowledge in:

- Spring Security with JWT
- entity relationships using JPA/Hibernate
- DTO-based request/response handling
- custom exception handling
- logging
- backend architecture with Spring Boot

## Overview

This system allows users to create and manage projects, assign collaborators, and define tasks associated with each project.  
Each project can have assigned collaborators, and each collaborator can be responsible for one or multiple tasks.

The application was developed as a hands-on learning project focused on applying real backend concepts in a structured way.

## Main Features

- User account management
- Role-based access control
- Authentication with Spring Security and JWT
- Project creation and management
- Task assignment inside projects
- Collaborator association with projects
- Dashboard visualization
- DTO usage for input and output data
- Custom exception handling
- Application logging

## Tech Stack

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **Bean Validation**
- **Spring AOP**
- **MapStruct**
- **Lombok**
- **MySQL**
- **Apache PDFBox**
- **Maven**

## Learning Goals Behind This Project

This project was mainly built to practice and consolidate the following topics:

- Spring Security with JWT authentication
- Role-based authorization
- JPA/Hibernate entity relationships
- DTO design for safer API exposure
- Custom exception handling
- Logging in backend applications
- Layered architecture with controller, service, repository, and model
- Validation and cleaner request handling

## Security Implementation

This project includes a security layer built with Spring Security and JWT to handle authentication and authorization.

Implemented security features include:

- authentication using JWT
- role-based authorization
- password encryption with BCrypt
- protected endpoints through Spring Security rules
- custom `UserDetailsService` implementation
- `JWTAuthenticationFilter` for login and token generation
- `JWTValidationFilter` for token validation on secured requests
- persistence of users and roles with dedicated tables and an intermediate relationship table
- custom handling for successful and unsuccessful authentication
- CORS configuration for frontend/client integration
- exclusion of sensitive attributes from JSON responses

### Roles

The system uses roles to determine what each user can do inside the application.

Current role model:

- **ADMIN**
- **USER**

Example of intended authorization logic:

- **ADMIN** can create and manage projects
- **USER** has limited access depending on assigned permissions

## Domain Model

The project uses multiple entity relationships to represent real collaboration flows between users, projects, and tasks.

### Main Entities

- `UserAccount`
- `Role`
- `Project`
- `Task`
- `Collaborator`

### Relationship Summary

#### UserAccount -> Role
A user account is associated with a role, and that role determines the permissions available in the system.

#### Project -> Task
A project can contain multiple tasks.

- `Project` has a `@OneToMany` relationship with `Task`
- `Task` has a `@ManyToOne` relationship with `Project`

#### Project <-> Collaborator
A project can include multiple collaborators, and a collaborator can participate in multiple projects.

- `Project` has a `@ManyToMany` relationship with `Collaborator`
- `Collaborator` maps that relationship back with `mappedBy`

#### Collaborator -> Task
A collaborator can be assigned multiple tasks.

- `Collaborator` has a `@OneToMany` relationship with `Task`
- `Task` has a `@ManyToOne` relationship with `Collaborator`

## Entity Design Highlights

This project was especially useful to practice:

- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`
- `@Embedded`
- enum mapping with `@Enumerated(EnumType.STRING)`
- cascading and orphan removal
- real use cases for entity association in business logic

## DTO Usage

The application uses DTOs to avoid exposing internal entities directly through the API.

This helps with:

- cleaner request and response structures
- better control over exposed data
- improved maintainability
- separation between persistence and API contracts

## Exception Handling

The project includes custom exception handling to improve error management and provide clearer responses.

This was implemented to practice:

- custom exception classes
- centralized exception handling
- cleaner controller logic
- better separation of concerns

## Logging

Logging is one of the highlighted learning points in this project.

The goal of including logs is to improve:

- traceability of actions
- debugging during development
- visibility of important backend events
- cleaner monitoring of application behavior

## Project Structure

The application follows a layered structure inspired by Spring Boot best practices:

- `controller`
- `service`
- `repository`
- `model`
- `dto`
- `security`
- `exceptions`
- `config`
- `validations`

This structure helps keep the code organized and easier to maintain.

## Database

The project currently uses a local **MySQL** database for development.

Migration support with **Flyway** is planned as the next improvement to simplify and professionalize schema evolution.

## Current Project Status

This is a **practice project in active development**.

Current focus areas include:

- improving security implementation
- refining entity relationships
- improving API design with DTOs
- adding database migrations with Flyway
- enabling Swagger/OpenAPI documentation
- enabling Actuator monitoring endpoints

## Planned Improvements

- Flyway database migrations
- Swagger/OpenAPI integration
- Spring Boot Actuator endpoints
- better API documentation
- more complete role-based restrictions
- additional validations
- improved frontend integration
- more polished dashboard experience

## Local Development

### Requirements

- Java 21
- Maven
- MySQL
- IDE such as IntelliJ IDEA, VS Code, or Spring Tool Suite

### Run the project

1. Create the MySQL database locally
2. Configure the database connection in `application.properties`
3. Build the project with Maven
4. Run the Spring Boot application

## Why This Project Matters

This repository is not only a CRUD exercise.  
It was built to practice backend concepts that are commonly used in real Java applications, especially:

- security with JWT
- entity relationships with JPA/Hibernate
- DTO-driven API design
- exception handling
- logging
- maintainable layered architecture

## Author

Developed as part of a personal learning path focused on Java backend development with Spring Boot.
