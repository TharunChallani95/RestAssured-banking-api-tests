# RestAssured Banking API Tests

## Overview
This repository provides a mock Banking API built with Spring Boot and an automated API testing framework using RestAssured and TestNG. It is designed for practicing, demonstrating, and validating API endpoints related to banking operations such as account management, user creation, and transactions.

## Features

- **Spring Boot API:** Real-time mock endpoints for banking domain (Accounts, Users, Transactions).
- **RestAssured Test Suite:** Automated tests for API endpoints, including validations for status codes, response bodies, and edge cases.
- **TestNG Integration:** Structured test organization and reporting.
- **Easy Setup:** Minimal dependencies, in-memory H2 database for demo purposes.
- **Extensible:** Easily add new endpoints, test cases, and validations.

## Project Structure

```
RestAssured-banking-api-tests/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── bankingapi/
│   │               └── app/
│   │                   ├── BankingApiApplication.java
│   │                   ├── controller/
│   │                   │   └── AccountController.java
│   │                   ├── model/
│   │                   │   └── Account.java
│   │                   └── repository/
│   │                       └── AccountRepository.java
│   └── test/
│       └── java/
│           └── com/
│               └── bankingapi/
│                   └── tests/
│                       └── AccountTests.java
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Build & Run the API

1. **Clone the repository**
   ```bash
   git clone https://github.com/TharunChallani95/RestAssured-banking-api-tests.git
   cd RestAssured-banking-api-tests
   ```

2. **Start the API server**
   ```bash
   mvn spring-boot:run
   ```
   The API will be available at `http://localhost:8080`.

### Run Automated Tests

```bash
mvn test
```

Test results will be displayed in the console. You can extend the test suite by adding more test classes under `src/test/java/com/bankingapi/tests/`.

## Example API Endpoints

- **GET /accounts** – Retrieve all accounts
- **POST /accounts** – Create a new account
- **GET /accounts/{id}** – Get account by ID
- **DELETE /accounts/{id}** – Delete an account

## Example Test

```java
@Test
public void testCreateAccount() {
    String payload = "{\"userId\":1,\"balance\":1000.0}";
    Response response = RestAssured.given()
        .contentType("application/json")
        .body(payload)
        .post("http://localhost:8080/accounts");

    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertTrue(response.asString().contains("id"));
}
```

## Contribution

1. Fork this repository.
2. Create your feature branch (`git checkout -b feature/my-feature`).
3. Commit your changes (`git commit -am 'Add feature'`).
4. Push to the branch (`git push origin feature/my-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License.
