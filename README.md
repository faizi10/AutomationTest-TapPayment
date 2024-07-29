AutomationTest_TapPayment

Introduction

Welcome to the test automation project for the Tap Payment website. This documentation serves as a comprehensive guide for understanding and contributing to the automation efforts. Whether you're a new user or an experienced test engineer, this guide provides all the necessary information to help you achieve your goals.

Requirements

Operating System

The test automation project is compatible with any operating system that supports Java and Maven.

Development Environment Setup

1. IntelliJ:

Download and install the latest version of IntelliJ IDEA.
Open IntelliJ and create a new Maven project or open an existing one.
Install necessary plugins, such as Cucumber for Java, to enhance your development experience.

2. Maven:

Download and install the latest version of Maven.
Ensure that the MAVEN_HOME environment variable is set, and the bin directory is added to your PATH.
In your project's POM file, add the necessary dependencies for your testing frameworks (e.g., Selenium, Cucumber, TestNG).

3. Java SDK:

Download and install the latest version of the Java SDK.
Set the JAVA_HOME environment variable to the installation directory of the Java SDK, and add the bin directory to your PATH.

Programming Language

The Tap Payment website is built on the Java programming language.

Testing Framework

The test automation project uses TestNG and Cucumber for test management, and Allure for reporting.

Dependencies

Install the necessary dependencies such as Cucumber, Allure, WebDriverManager, TestNG, and Selenium.

Test Design

1. Cucumber: Crafting Test Scenarios

Cucumber is a Behavior-Driven Development (BDD) framework supporting human-readable Gherkin syntax.

Create a feature file with a .feature extension.
Provide a concise feature description.
Formulate test scenarios using Gherkin keywords.

2. TestNG

TestNG is a powerful testing framework that seamlessly integrates with Cucumber.

Create a Java class for the test suite extending AbstractTestNGCucumberTests.
Utilize TestNG's SoftAssert class for soft assertions.

3. Page Object Model

Implement the Page Object Model (POM) design pattern for maintainable and reusable test automation.

Develop a separate Java class for each page or screen.
Define instance variables for page elements.
Create methods for interacting with elements and executing actions.

Test Execution

Cucumber with TestNG Configuration

Configure Cucumber with TestNG for test execution.

Create a test runner class extending the base test class (e.g., TestBase).
Add the @CucumberOptions annotation to configure Cucumber settings.

Test Reporting

Allure

Utilize Allure for comprehensive test reporting.

Configure the test automation framework to use the Allure plugin.
Install the Allure command-line tool.
Generate and view the Allure report after test execution.

Conclusion

This test automation project for the Tap Payment website, powered by Cucumber, Allure, Selenium, and TestNG aims to make test automation accessible and efficient. Follow the provided instructions to quickly set up and contribute to the project. Keep the project and dependencies up-to-date for maximum compatibility and reliability. Happy testing!
