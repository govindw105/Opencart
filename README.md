🛒 Selenium TestNG POM Framework – OpenCart Automation

📌 Project Overview

This project is a Selenium WebDriver automation framework developed using the Page Object Model (POM) design pattern to automate key functionalities of the OpenCart e-commerce application.

The framework covers end-to-end user workflows including:

User Registration

Login (Valid & Invalid Scenarios)

Product Search

Add to Cart

Logout functionality

The project is structured using TestNG and Maven, with support for Data-Driven Testing and detailed reporting.

🛠️ Tech Stack

Language: Java

Automation: Selenium WebDriver

Framework: TestNG

Design Pattern: Page Object Model (POM)

Data-Driven Testing: Apache POI + Excel

Reporting: ExtentReports

Logging: Log4j2

Build Tool: Maven

Version Control: Git & GitHub

🧪 Test Cases Automated
🔹 Account Registration

Register user using randomly generated data

Validate successful registration

🔹 Login Validation

Valid login scenario

Invalid login scenario

Error message validation

🔹 Data-Driven Login

Read test data from Excel file

Execute multiple login combinations using TestNG DataProvider

🔹 Product Search & Add to Cart

Search product by name

Validate search results

Add product to cart

Verify product added successfully

⚙️ Framework Highlights
✅ Page Object Model

Separate page classes for each module

Locators and actions maintained independently

Improved maintainability & reusability

✅ Base Class Implementation

Browser initialization

Cross-browser execution (Chrome, Edge, Firefox)

Screenshot capture on failure

Configuration via properties file

✅ TestNG Features

Test grouping (Sanity, Regression)

Suite configuration using testng.xml

DataProvider integration for DDT

✅ Reporting & Logging

ExtentReports for detailed HTML reporting

Log4j2 for execution logs

TestNG default reports

📂 Project Structure
src/test/java/
 ├── pageObject/
 ├── testCases/
 ├── testBase/
 └── utilities/

testng.xml
pom.xml
log4j2.xml
config.properties
▶️ How to Execute
mvn clean test

Run specific group:

mvn test -Dgroups=Sanity
🎯 Key Learning Outcomes

Building a complete POM automation framework

Implementing Data-Driven Testing

Handling cross-browser execution

Configuring TestNG suites and groups

Integrating ExtentReports and Log4j2

Managing reusable automation architecture
