# Easy User Info System

This project is a user information management system built using Spring Boot. It allows users to create, update, and store information such as personal details (name, national code, birthdate), contact information (mobile number, email, address), and more.

## Features
- **User Creation**: Allows the creation of a user with necessary details like name, national code, birthdate, mobile number, etc.
- **Validation**: Ensures that the data entered is valid, including checks for national code, mobile number, and password strength.
- **Persian Date Support**: The system supports Persian date format for birthdates.
- **Database Integration**: Data is stored in a relational database using JPA for efficient data management.
  
## Technologies Used
- **Spring Boot**: The main framework for building the backend.
- **JPA (Java Persistence API)**: For interacting with the database.
- **H2 Database**: For local database storage (can be replaced with any other database like MySQL or PostgreSQL).
- **Validation**: Jakarta Validation API is used for input validation.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/username/repository-name.git
    ```

2. Navigate to the project directory:
    ```bash
    cd repository-name
    ```

3. Run the project:
    ```bash
    ./mvnw spring-boot:run
    ```

4. The application will run on `http://localhost:8080`.

## Endpoints
- **POST** `/user/apis/create`: Create a new user.
- **PUT** `/user/apis/update/{id}`: Update an existing user's information.

## Installation

To run this project locally, you’ll need to have:
- **Java 11+** installed on your machine.
- **Maven** for building the project.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
