# Student Management RESTful CRUD API

## Project Description
A RESTful CRUD API built using Spring Boot, Spring Data JPA, and MySQL. The application manages student records.

## Technologies Used
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Project Architecture
The project follows a layered architecture:

- **Model:** Defines the Student entity.
- **Repository:** Handles database operations using JpaRepository.
- **Service:** Contains the business logic.
- **Controller:** Handles HTTP requests and API endpoints.

## Student Entity
The Student entity contains:
- id
- firstName
- lastName
- email
- department

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/students` | Create a student |
| GET | `/api/students` | Retrieve all students |
| GET | `/api/students/{id}` | Retrieve a student by ID |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |

## Database Configuration
Create a MySQL database named `student_db`.

Configure your database username and password in:

`src/main/resources/application.properties`

## How to Run

1. Clone or download the project.
2. Configure your MySQL connection.
3. Open the project in IntelliJ IDEA.
4. Run `RestfulCrudApiApplication.java`.
5. Test the endpoints using Postman.

The application runs on:

`http://localhost:8080`

## Testing
All five CRUD operations were tested successfully using Postman.