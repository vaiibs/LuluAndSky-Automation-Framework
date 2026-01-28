# Lulu & Sky E-Commerce Automation Framework
Lulu & Sky is a fashion-focused e-commerce web application that primarily offers women’s clothing, dresses, bags, shoes, and accessories, along with a dedicated kids section for boys and girls.
The platform allows users to browse fashion categories, view detailed product information, select sizes and variants, add items to the cart, and complete purchases through a seamless checkout flow.

<img width="1871" height="873" alt="image" src="https://github.com/user-attachments/assets/cba13df3-9ac6-4430-a65f-213cb3b2ea9c" />

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

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/961e876f-6b7e-43e6-8741-f55d50d67255" />

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

## Prerequisites
* Java JDK 8 or above
* Maven installed
* Chrome / Edge browser
* IDE (Eclipse / IntelliJ)

## 📊 Reporting & Logs
* Execution reports are generated after each run
* Screenshots are captured automatically on failures
* Logs help track execution flow and debugging

## 📊 Report 
[https://vaiibs.github.io/LuluAndSky-Automation-Framework/src/test/resources/Report/TestRunner.html]

## 🧪 Automation Scope
* UI functional testing
* Smoke and regression testing
* Cross-browser testing
* Validation of dynamic elements (price, cart count, filters)
* Handling alerts, frames, waits, and popups

## 🐛 Key Bugs Identified
* "Logout" button reverts to Login in the header.
* "Add to Wishlist" is non-responsive for guest users.
* "Remove from Wishlist" button text fails to toggle back to "Add to Wishlist" after item removal.
* "Add to bag" button is not working from Wishlist page.
