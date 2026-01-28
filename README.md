# Lulu & Sky E-Commerce Automation Framework

## 🚀 Overview
A Hybrid Test Automation Framework for Lulu & Sky using **Selenium WebDriver**, **Java**, and **TestNG**.

## 🛠 Tech Stack
* **Language:** Java
* **Automation:** Selenium WebDriver (4.x)
* **Testing Engine:** TestNG
* **Reporting:** Extent Reports / TestNG Listeners
* **Pattern:** Page Object Model (POM)

## 📁 Modules Covered
* **Login/Register:** Handling multi-browser session persistence.
* **Search/Filter/Sort:** Valid/Invalid keyword verification.
* **PDP/PLP:** Size selection and image slider validation.
* **Cart/Wishlist & Checkout:** Product math verification and guest flow logic.

## 🐛 Key Bugs Identified
* "Logout" button reverts to Login in the header.
* "Add to Wishlist" is non-responsive for guest users.
* "Remove from Wishlist" button text fails to toggle back to "Add to Wishlist" after item removal.
* "Add to bag" button is not working from Wishlist page.
