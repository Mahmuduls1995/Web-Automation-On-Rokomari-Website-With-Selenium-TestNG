# Web Automation on <a href="https://www.rokomari.com/book"> Rokomari </a> Website with Selenium TestNG
This project aims to automate the testing of the Rokomari website using Selenium WebDriver and TestNG. Rokomari is a popular online bookstore, and ensuring its website functions correctly is crucial for providing a seamless user experience. This automation framework helps in validating various functionalities of the Rokomari website, including book searches, user login, purchase processes, and more

## Getting Started
The below instructions will explain how to get the project up and running on a local machine for development and testing purposes.
## Contents
- [Introduction](#Introduction)
- [Prerequisites](#Prerequisites)
- [Installing](#Installing)
- [Dependencies](#Dependencies)
- [Running The Tests](#Running-The-Tests)
- [Video of Test Automation](#Video-of-Test-Automation)
- [Data Driven Test](#Data-driven-Test)
- [Automated Bug Screenshot](#Automated-Bug-Screenshot)
- [Report](#Report)
- [Author](#Author)
- [Acknowledgment](#Acknowledgment)
### First of You Can See Video For Autumation Result Video

https://github.com/user-attachments/assets/bf8965ab-30db-400a-ae42-79ef82e31d3c
## Introduction
Selenium and TestNg are used to automate the web application of Rokomari, a well-known online bookstore in Bangladesh. Various test cases are developed for automatic.
 - Sign-up from the registration page, 
 - Log-in,
 - Author search and Author selection, 
 - Add-to-cart Book action with filter,
 - and order actions.
 - Shipping Address Info 
 
 A bug screenshot is captured through the selenium 'TakesScreenshot' method when the test case fails.**'testng.xml'** which includes the **test-suit**, is run for executing all test cases.
### Prerequisites
Required software to run the project.
```
- jdk 17 or above
- Apache Maven 3.8.x
- Eclipse or IntelliJ IDE ( recommended for development and debugging purposes).
- Selenium WebDriver
- TestNG
- Maven Repositories
```
### Installing

A step-by-step series of examples of how to get a development environment running

[jdk download and installation](https://www.oracle.com/java/technologies/downloads/)

```
- Download from - https://www.oracle.com/java/technologies/downloads/
- Install the installer
- Set system environment variable
- Check the version from cmd
```

[Apache Maven download and installation](https://maven.apache.org/download.cgi)

```
- Download from - https://maven.apache.org/download.cgi
- Install the installer
- Set system environment variable
- Check the version from cmd
```
[IDE download and installation](https://maven.apache.org/download.cgi)

```
- Download from - https://www.jetbrains.com/idea/download/?section=windows
- Install the installer
```
## Dependencies
- Required maven dependencies
```
- TestNG
- Selenium
- apache-poi-ooxml
- WebDriverManager
```
- Installation
```
- Go to the URL - https://mvnrepository.com/
- copy the aforementioned dependencies and paste on the project's pom.xml
```

## Running The Tests
- Clone the project from the repository.
- Open the project in the IDE.
- Create testdata folder and create testdata.xlsx (Mobile, Password) file for login test.

[//]: # (- Create testdata folder and create testdata.xlsx &#40;Book Name, Author Name&#41; file for search test.)

[//]: # (- Create testdata folder and create testdata.xlsx &#40;Book Name, Author Name&#41; file for add-to-cart test.)

[//]: # (- Create testdata folder and create testdata.xlsx &#40;Name, Email, Phone, Address&#41; file for shipping address test.)

[//]: # (- Create testdata folder and create testdata.xlsx &#40;Name, Email, Phone, Address&#41; file for order test.)
- Run the 'testng.xml' file to run the Test-suit and all test cases.
- Test cases will be executed one by one and the result will be shown in the console.
- If any test case fails, a bug screenshot will be captured automatically.
- The report will be generated after the test execution.
- The report will show the number of test cases passed, failed, and skipped.
- The report will also show the time taken for each test case execution.
- The report will show the test case name and the class name.
- The report will show the test case status.
```
- Run the 'testng.xml' file to run the Test-suit and all test cases.
```
## Video of Test Automation
- Video of automated category selection from the home page, sign-up from the registration page, product search, product selection, add-to-cart etc. through Selenium and TestNG.

https://github.com/user-attachments/assets/bf8965ab-30db-400a-ae42-79ef82e31d3c

## Data Driven Test
- Data-driven test for the registration page.
- Test data is stored in a CSV file.
- The apache-poi-ooxml dependency is used for accessing and handling CSV data.
- External CSV data is used for testing.

## Automated Bug Screenshot
- When a test case fails, a bug screenshot is captured through the selenium 'Screenshots' method in an automated way.

## Report
![Rokomari-Passed](https://github.com/user-attachments/assets/b7341d62-a56e-4f24-9b90-6f4208339a9a)

![Rokomari-passed2](https://github.com/user-attachments/assets/454c5f4a-e4ef-4f5c-8cfc-a04672b0cfaa)

## Built With

- [Java](https://www.oracle.com/java/technologies/downloads/) - The language used
- [Maven](https://maven.apache.org/) - Dependency and Project Management
- [Selenium](https://www.selenium.dev/) - The Framework used to Automate
- [TestNG](https://testng.org/) - The Framework used to Test

## Versioning

[GitHub](http://github.com/) is used for versioning.

## Author

- **Sheikh Mahmudul Hasan**