
# CRM System

This project is a **Customer Relationship Management (CRM)** system designed to manage customer and user data efficiently. It provides an interface for creating, updating, and managing customers and users through a simple web application.

## Features

- ✅ **Customer Management**: Add, edit, and delete customers, with fields for name, email, region, and registration dates.
- ✅ **User Management**: Manage user accounts with roles like admin and user, alongside their respective regions.
- ✅ **Responsive Forms**: Interactive forms for creating or updating customers and users.
- ✅ **Unit Tests with JUnit & Mockito**: Comprehensive tests for services ensuring reliability of the code.
- ✅ **Docker Integration**: The project is containerized using Docker for easy setup and deployment.
- ✅ **MySQL Database**: The system uses MySQL for data storage.
- ⚙️ **API as a Service**: Runs outside of Docker to ease debugging during development.
- ⏳ **Authentication System**: Will be added in the future using **Spring Security** for role-based access control.

## Technologies Used

- **Java 22**
- **Spring Boot 3.3.1**: A framework for building Java applications.
- **JSP**: Used for frontend rendering.
- **MySQL**: The database management system.
- **Hibernate**: For managing the database through Java.
- **Docker**: Containerization of the project for easier deployment.
- **Bootstrap**: For responsive design of the forms and tables.
- **JUnit 5**: Used for unit testing.
- **Mockito**: Mocking framework to isolate and test service logic.

## Screenshots

### Customer Form

![Ekran Resmi 2024-09-29 00 43 14](https://github.com/user-attachments/assets/91066f29-a94f-473b-ad0e-f818c7b87530)

### Customer List

![Ekran Resmi 2024-09-29 00 43 02](https://github.com/user-attachments/assets/80ec9bc0-ceaf-4979-a9db-4c35d7c0f654)

### User Form

![Ekran Resmi 2024-09-29 00 42 27](https://github.com/user-attachments/assets/926b49a8-7194-4cee-8de5-cf584911ff2b)

### User List

![Ekran Resmi 2024-09-29 00 42 16](https://github.com/user-attachments/assets/f22c9c77-e3e2-46dd-8e16-3a9ceb455c74)

### DataBase 

![Ekran Resmi 2024-09-29 01 05 05](https://github.com/user-attachments/assets/f1e7f4e4-5bae-405f-81cc-cff3b785b8e6)

## Prerequisites

- **Java 22** or later
- **Maven**: To manage dependencies and build the project.
- **Docker**: For containerizing the application and database.
- **MySQL**: The project uses MySQL for database management.

## Setup

1. **Clone the repository**:
   ```bash
   git clone <https://github.com/ATalhaTimur/CRMSystem>
   cd CRMSystem
   ```

2. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

3. **Run the project** using Docker:
   ```bash
   docker-compose up --build
   ```

4. **Access the application**:
   - Navigate to `http://localhost:8080` to access the web interface.
   
5. **Database setup**:
   The MySQL database container will automatically set up the database required for this project. You can modify the database credentials in the `docker-compose.yml` file if needed.

## Database Structure

- **Customer Table**: Contains information about customers such as `firstName`, `lastName`, `email`, `region`, `registrationDate`, and timestamps for updates.
- **User Table**: Stores user data including `username`, `password`, `role`, `region`, and timestamps.

## Unit Testing with JUnit & Mockito

We have added comprehensive unit tests to validate the service layer, ensuring the correctness of our business logic. The unit tests are written using **JUnit 5** and **Mockito** to mock the repository layer.

- **JUnit** is used to structure the tests, making sure that all methods behave as expected.
- **Mockito** is used to mock dependencies and simulate interactions with the data repository, ensuring isolated tests of the service logic.
## Future Enhancements

- **Authentication**: Add security to the application using Spring Security for role-based access.
- **Search Functionality**: Implement search filters on customer and user lists.
