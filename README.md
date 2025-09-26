# API Automation Framework - Reqres

This project is an **API Automation Framework** built to test the [Reqres](https://reqres.in/) APIs.  
The framework is developed using **Java**, **Rest-Assured**, **TestNG**, **Jackson** for payload management, and **Allure** for reporting.  

---

## 🚀 Features
- Automated API testing for **Reqres endpoints** (User creation, fetching, updating, deleting).
- Payload creation and serialisation using **Jackson ObjectMapper**.
- Modular design with separation of concerns:
  - **Endpoints** for constants
  - **Modules** for payload management
  - **POJOs** for request/response mapping
  - **Tests** organised by CRUD, Integration, and Sample flows
- Assertion layer for reusable validations.
- Integrated with **Allure Reports** for rich test reporting.
- Test execution controlled via **TestNG XMLs**.

---

## 🏗️ Project Structure

### Root Level
API_Automation_Framework_Restful-Booker
│── .idea/ # IDE specific files
│── allure-results/ # Allure report results
│── src/ # Source folder
│── pom.xml # Maven dependencies
│── testng_*.xml # TestNG suite files
│── .gitignore


### Source (src/main/java)
com.avinashsinha.endpoints
└── APIConstants # Base URLs and endpoint constants

com.avinashsinha.modules
└── PayloadManager # Jackson-based payload builders

com.avinashsinha.pojos
├── DataResponse
├── DetailsResponse
├── Login
├── LoginResponse
├── Register
├── RegisterResponse
├── SupportResponse
├── UpdateResponse
├── UserResponse
└── Users

### Tests (src/test/java)
com.avinashsinha.asserts
└── AssertActions # Custom assertion actions

com.avinashsinha.base
└── BaseTest # Test setup and teardown

com.avinashsinha.tests.crud
├── TestCreateUser
├── TestLoginUser_Negative
├── TestLoginUser_Positive
├── TestRegisterUser_Negative
├── TestRegisterUser_Positive
├── TestUserDeletion
├── TestUserDetails
├── TestUserDetailsById
├── TestUserFullUpdate
└── TestUserPartialUpdate

com.avinashsinha.tests.integration
└── TestE2EFlow # End-to-End booking workflow tests

com.avinashsinha.tests.sample
└── TestIntegrationSample

---

## ⚙️ Tech Stack
- **Java 11+**
- **Maven** (Build tool)
- **Rest-Assured** (HTTP client for API automation)
- **TestNG** (Testing framework)
- **AssertJ** (Advanced assertions)
- **Jackson** (Payload serialization & deserialization)
- **Allure Reports** (Test reporting)
- **Full Folder Structure** (Hybrid Framework)

---

## ▶️ Running Tests

Run specific TestNG suite:
mvn clean test -DsuiteXmlFile=testng_Integration.xml

Available TestNG XMLs:
- testng_sample.xml

---

## 📊 Reporting

Generate Allure Report

1. Execute tests:
   mvn clean test

3. Generate Allure Report:
   allure serve allure-results

![reqres](https://github.com/user-attachments/assets/714983f1-f2e6-451a-8978-eba361e77f0d)

This will launch an interactive report in your browser.

---

## ✅ Example Payload with Jackson

Example of booking payload creation using Jackson:

Register register = new Register();
register.setEmail("eve.holt@reqres.in");
register.setPassword("pistol");

---

## 📌 Author

👤 Avinash Sinha
