# Online Shop Management System

## Project Description

The Online Shop Management System is a backend application developed in Java, focusing on Object-Oriented Programming (OOP) principles. It provides modules for managing customers, products, orders, payments, and more. The system includes features for customers, sellers, and administrators, supporting functionalities such as adding products to the cart, placing orders, viewing order history, and managing inventory.

---

## Tech Stack

- **Programming Language**: Java
- **Database**: PostgreSQL
- **Build Tool**: Maven

---


## Main Features
- **Customer Management**: Register, view, update, and delete customer accounts.
- **Product Management**: Add, view, update, and delete products from the database.
- **Cart Operations**: Add products to a cart, view cart contents, and clear the cart.
- **Order Management**: Create, view, and manage orders for customers.
- **Payment Management**: Update payment methods and manage payment records.
- **Admin Features**: View all users, manage products, and oversee order and payment operations.

---

## Core Classes and Responsibilities

### 1. **Main.java**
- Entry point of the application.
- Provides the main menu for accessing the customer and admin features.
- Initializes dependencies like `ProductService`, `UserService`, and `Cart`.

### 2. **AdminPanel.java**
- Manages administrative operations such as viewing all users, managing products, and orders.
- Key administrative functions include:
  - Adding products.
  - Deleting users and products.
  - Managing orders and payments.

### 3. **Cart.java**
- Represents the customer cart functionality.
- Handles operations like adding products to the cart and clearing cart items.

### 4. **ProductService.java**
- Contains business logic for product management.
- Interfaces with the database to perform CRUD operations for products.

### 5. **UserService.java**
- Manages customer and admin account operations.
- Contains methods for:
  - Adding, updating, and deleting users.
  - Updating payment methods for orders.

### 6. **DatabaseConnection.java**
- Manages the database connection using JDBC.
- Ensures smooth database operations by providing reusable connection objects.

### 7. **Order.java**
- Represents an order entity.
- Contains properties like order ID, products, total amount, and order status.

### 8. **Payments.java**
- Represents payment operations and payment method records.
- Includes constants like `CREDIT_CARD`, `DEBIT_CARD`, `PAYPAL`, and `CASH_ON_DELIVERY`.

---

## Object-Oriented Programming Concepts and Design Principles

### **Classes and Objects**
- Representing users, products, orders, and payments.

### **Encapsulation**
- Used in all classes to secure field access via getters and setters.
- Example: `User.java` and `Product.java` encapsulate their fields to ensure controlled access.

### **Inheritance**
- Implemented in the user hierarchy with roles like `Customer` and `Admin` inheriting common properties from `User`.

### **Polymorphism**
- **Method Overloading**:
  - Example: `addToCart(Product product)` and `addToCart(Product product, int quantity)` in `Cart.java`.
- **Method Overriding**:
  - Example: `toString()` method in `Order.java` overrides the default behavior to provide a custom string representation.

### **Exception Handling**
- Implemented in methods interacting with the database to handle SQL exceptions gracefully.
- Example: `UserService.java` and `ProductService.java` use try-catch blocks to handle database errors.

### **SOLID Principles**
- **Single Responsibility Principle**: Each class is focused on a single responsibility (e.g., `UserService` handles user-related operations).
- **Open-Closed Principle**: The design allows adding new features like payment methods without altering existing code.
- **Dependency Inversion Principle**: High-level modules depend on abstractions for database operations.

### **Design Patterns**
- **Singleton Pattern**: Used in `DatabaseConnection` to manage a single database connection instance.
- **Factory Pattern**: Could be extended for creating user or product objects dynamically.




