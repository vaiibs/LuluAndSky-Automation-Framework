# Lulu & Sky E-Commerce Automation Framework

## 🚀 Overview
A Hybrid Test Automation Framework for Lulu & Sky using **Selenium WebDriver**, **Java**, and **TestNG**.
It follows industry best practices like Page Object Model (POM), data-driven testing, utility layers, and reusable components, making it scalable, maintainable, and easy to enhance.

## 🛠 Tech Stack
* **Language:** Java
* **Automation:** Selenium WebDriver (4.x)
* **Testing Engine:** TestNG
* **Build Tool:** Maven
* **Reporting:** Extent Reports / TestNG Listeners
* **Pattern:** Page Object Model (POM)
* **Version Control:** Git & GitHub
  
## 📂 Framework Structure
HybridFramework
│
├── src/main/java
│ ├── pom # Page Object classes
│ ├── utilities # Reusable utility classes (Waits, Excel, Config, JS, etc.)
│ └── base # Base class (WebDriver setup & teardown)
│
├── src/test/java
│ └── testcases # TestNG test classes
│
├── src/test/resources
│ ├── testdata # Excel / JSON test data files
│ └── config.properties
│
├── reports # Execution reports
├── screenshots # Failure screenshots
├── pom.xml # Maven dependencies
├── testng.xml # TestNG suite file
└── README.md

## 📁 Modules Covered
* **Login/Register:** Handling multi-browser session persistence.
* **Search/Filter/Sort:** Valid/Invalid keyword verification.
* **PDP/PLP:** Size selection and image slider validation.
* **Cart/Wishlist & Checkout:** Product math verification and guest flow logic.

## ⚙️ Key Features
* Hybrid framework combining POM + Data Driven + Utility approach
* Cross-browser execution support
* Explicit wait implementation
* Centralized WebDriver management
* Reusable utilities for waits, actions, alerts, frames
* Screenshot capture on test failure
* Easy integration with CI/CD tools

## 🐛 Key Bugs Identified
* "Logout" button reverts to Login in the header.
* "Add to Wishlist" is non-responsive for guest users.
* "Remove from Wishlist" button text fails to toggle back to "Add to Wishlist" after item removal.
* "Add to bag" button is not working from Wishlist page.

## Prerequisites
* Java JDK 8 or above
* Maven installed
* Chrome / Edge browser
* IDE (Eclipse / IntelliJ)

## 📊 Reporting & Logs
* Execution reports are generated after each run
* Screenshots are captured automatically on failures
* Logs help track execution flow and debugging

## 🧪 Types of Testing Covered
* Functional Testing
* Regression Testing
* Smoke Testing
* UI Validation

