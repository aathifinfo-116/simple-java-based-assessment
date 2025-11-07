# Simple Java-Based HTTP API

This project implements a simple Spring Boot-based HTTP API with a `/hello-world` endpoint. The API returns a personalized greeting or an error message based on the first letter of the provided name.

## How to Run the Application

### 1. Clone the Repository

Clone the project to your local machine:

```bash
git clone https://github.com/aathifinfo-116/simple-java-based-assessment.git
cd simple-java-based-assessment
```

### 2. Build and Run the Application
```bash
mvn spring-boot:run
```

### 3. Access the API
```
http://localhost:8080/hello-world?name=<name>
```

## How to Run the Tests

### Running Tests with Maven
```bash
mvn -Dtest=HelloWorldTest test
```


## Project Structure
```
src/
 ├── main/
 │   ├── java/
 │   │   └── com/
 │   │       └── java/
 │   │           └── simple/
 │   │               └── java/
 │   │                   └── based/
 │   │                       └── assessment/
 │   │                           ├── HelloWorldApplication.java  // Main entry point
 │   │                           ├── controller/
 │   │                           │   └── HelloWorldController.java  // API Controller
 │   │                           └── service/
 │   │                           |   └── HelloWorldService.java  // Business Logic
 │   │                           └── dto/
 │   │                               └── ErrorResponse.java  // Data Transfer Object
 │   │                               └── MessageResponse.java  // Data Transfer Object
 │   └── resources/
 │       └── application.properties  // Application configurations
 └── test/
     └── java/
         └── com/
             └── java/
                 └── simple/
                     └── java/
                         └── based/
                             └── assessment/
                                     └── HelloWorldControllerTest.java  // Test cases for the service

```

## Best Practices Used

1. **Single Responsibility Principle:** Each class in the project has a single responsibility. For instance, HelloWorldController handles HTTP requests, while HelloWorldService processes the logic of greeting or error message creation.
2. **Interface Segregation Principle:** The HelloWorldService interface is simple and only exposes the necessary methods for service operations.
3. **Dependency Inversion Principle:** The controller depends on abstractions (HelloWorldService), not concrete implementations, which makes it easier to swap implementations without affecting the controller.

### MVC Architecture:
The project follows the Model-View-Controller (MVC) architecture:

1. **Model:** The CommonResponse, MessageResponse, and ErrorResponse classes represent the data models. 
2. **View:** In this case, the "view" is represented by the responses sent back to the client (in JSON format). 
3. **Controller:** The HelloWorldController class serves as the controller, handling incoming HTTP requests and responding with appropriate data. 
4. **Service Layer:** HelloWorldService and its implementation HelloWorldServiceImpl encapsulate the business logic, ensuring that the controller remains lightweight.

### Commenting and Documentation:

* Every method, class, and constructor is documented using JavaDoc comments. This improves code readability and maintainability. 
* Each REST API request method is well-documented, specifying its expected behavior, input parameters, and the response.

### Unit Testing:

* Unit tests are written using JUnit 5 and mockito to ensure the API’s correctness.
* The tests cover all edge cases (valid name, invalid name, empty name, etc.), ensuring the application behaves as expected under different conditions.
