# API Automation with RestAssured (Java)

![API Automation](https://github.com/PramodDutta/APIAutomationRestAssured/assets/1409610/69f398b3-8798-4fba-a091-3b1e321dcc7d)

## 🚀 Introduction
This API Automation framework is designed for testing the CRUD operations of Restful Booker using **RestAssured in Java**. It provides a robust and scalable testing solution with detailed reporting and CI/CD integration.

📌 **Author:** *SHAILESH SINGH*

## 🛠 Tech Stack
- **Java (JDK > 22)**
- **RestAssured** (for API Testing)
- **Apache POI, TestNG, Maven**
- **AssertJ** (Advanced assertions)
- **Jackson API and GSON**
- **Log4j** (Logging)
- **Allure Report** (Test reporting)
- **Hybrid Framework Structure**
- **Jenkins File** (CI/CD Integration)

## 📂 Framework Components
![Framework Components](https://github.com/PramodDutta/APIAutomationFramworkATB6x/assets/1409610/98bbc62d-7837-4bdc-900b-b214c675af6d)

## 🔄 Running via CI/CD
![CI/CD Execution](https://github.com/PramodDutta/APIAutomationRestAssured/assets/1409610/2d58bf82-0ffb-4fcb-a2d9-cf26920fa7b5)

## ▶️ Running the Tests

### ✅ Basic Test Execution
Ensure **Maven** is installed and run the following command:
```sh
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

### 🔀 Parallel Execution
Modify `testng.xml` to run tests in parallel:
```xml
<suite name="All Test Suite" parallel="methods" thread-count="2"></suite>
```

### 🔗 Integration Tests
Run the full suite including Create, Update, and Delete tests:
```sh
mvn clean test -DsuiteXmlFile=testng-integration.xml
```

## 📊 Allure Report Generation
Generate and view the test execution report with:
```sh
allure serve allure-results/
```
![Allure Report](https://github.com/PramodDutta/APIAutomationFramworkATB6x/assets/1409610/79ba2093-a1b7-4b36-ba16-9a6827af7afe)

### 🛠 Setting Up Allure Reporting
#### 1️⃣ Install Allure
```sh
brew install allure  # (For Mac users)
```
For other OS, refer to [Allure Installation Guide](https://docs.qameta.io/allure/).

#### 2️⃣ Add Dependencies in `pom.xml`
```xml
<dependency>
    <groupId>io.qameta.allure</groupId>
    <artifactId>allure-testng</artifactId>
    <version>2.13.0</version>
</dependency>
```

#### 3️⃣ Configure Allure Plugin
```xml
<build>
    <plugins>
        <plugin>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-maven</artifactId>
            <version>2.10.0</version>
            <configuration>
                <reportVersion>2.13.0</reportVersion>
            </configuration>
        </plugin>
    </plugins>
</build>
```

#### 4️⃣ Generate Allure Report
```sh
allure generate target/allure-results --clean -o allure-report
allure open allure-report
```

## 📝 Postman Assignments
### 📌 API Testing Tasks
1. **Create a Booking**, Update Booking Name, Get Booking by ID, and Verify.
2. **Create & Delete Booking**, then verify it's deleted using GET.
3. **Get an Existing Booking**, Update & Verify.
4. **Invalid Cases**: Attempt booking with incorrect JSON payload.
5. **Edge Cases**: Update on a deleted Booking ID.

### ✅ Response Validation Checklist
✔️ Status Code
✔️ Response Body
✔️ Headers

## 📌 Additional API Test Collections
- [ ] **CRUD operations on Restful Booker**
- [ ] **Postman Snippets & Test Cases**
- [ ] **Integration Test Scenarios**

---
🎯 This framework is designed to enhance API testing efficiency and CI/CD integration with robust reporting. Happy testing! 🚀
