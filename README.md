# Online Shop Management System

## Project Description

The Online Shop Management System is a backend application developed in Java, focusing on Object-Oriented Programming (OOP) principles. It provides modules for managing customers, products, orders, payments, and more. The system includes features for customers, sellers, and administrators, supporting functionalities such as adding products to the cart, placing orders, viewing order history, and managing inventory.

---

## Tech Stack

- **Programming Language**: Java
- **Frameworks and Libraries**: Spring Framework, Spring Boot, Spring Data JPA, Hibernate
- **Database**: PostgreSQL
- **Build Tool**: Maven

---

## Modules and Features

### 1. **Login & Logout Module**
- **Features**:
    - Customer and seller authentication and validation with session tokens.
    - Session validity for 1 hour for enhanced security.
    - Supports login and logout for both customers and sellers.
- **Endpoints**:
    - `POST /register/customer`: Register a new customer.
    - `POST /login/customer`: Log in as a customer.
    - `POST /logout/customer`: Log out as a customer.
    - `POST /register/seller`: Register a new seller.
    - `POST /login/seller`: Log in as a seller.
    - `POST /logout/seller`: Log out as a seller.

---

### 2. **Customer Module**
- **Features**:
    - Registering customers and logging in.
    - Viewing available products, adding them to the cart, and placing orders.
    - Access to order history and updating account details.
- **Endpoints**:
    - `GET /customer/current`: Get currently logged-in customer details.
    - `GET /customer/orders`: Retrieve order history for the logged-in customer.
    - `GET /customers`: Fetch all customers.
    - `PUT /customer`: Update customer details.
    - `DELETE /customer`: Delete a customer.

---

### 3. **Seller Module**
- **Features**:
    - Administrator access to manage products and view customer details.
    - Adding, updating, and deleting products.
- **Endpoints**:
    - `GET /seller/{sellerId}`: Get seller details by ID.
    - `GET /sellers`: Fetch all sellers.
    - `POST /addseller`: Add a new seller.
    - `PUT /seller/update`: Update seller details.
    - `DELETE /seller/{sellerId}`: Delete a seller by ID.

---

### 4. **Product Module**
- **Features**:
    - Managing product inventory, including adding, updating, and deleting products.
    - Viewing products by category, seller, or all.
- **Endpoints**:
    - `GET /products`: View all products.
    - `POST /products`: Add a new product.
    - `PUT /products`: Update product details.
    - `DELETE /products/{id}`: Delete a product.

---

### 5. **Cart Module**
- **Features**:
    - Add, view, and remove items from the cart.
    - Clear the cart before creating a new order.
- **Endpoints**:
    - `GET /cart`: View all items in the customer's cart.
    - `POST /cart/add`: Add an item to the cart.
    - `DELETE /cart/remove`: Remove an item from the cart.
    - `DELETE /cart/clear`: Clear the entire cart.

---

### 6. **Order Module**
- **Features**:
    - Place new orders and view order details.
    - Update order status and cancel orders.
- **Endpoints**:
    - `GET /orders`: Retrieve all orders.
    - `POST /orders/place`: Place a new order.
    - `PUT /orders/update`: Update an existing order.
    - `DELETE /orders/cancel`: Cancel an order.

---

### 7. **Payment Module**
- **Features**:
    - Manage payments associated with orders.
    - Update payment methods and view payment details.
- **Database Integration**:
    - Payment methods include `CREDIT_CARD`, `DEBIT_CARD`, `PAYPAL`, and `CASH_ON_DELIVERY`.

---

## OOP Concepts and Design Patterns

- **Classes and Objects**: Representing users, products, orders, and payments.
- **Encapsulation**: Secure field access using getters and setters.
- **Inheritance**: Users have roles such as Admin and Customer, inheriting common properties.
- **Polymorphism**:
    - **Method Overloading**: For example, `addToCart(Product product)` and `addToCart(Product product, int quantity)`.
    - **Method Overriding**: For example, `viewOrders()` for `Admin` and `Customer`.
- **Exception Handling**: Handles invalid inputs and database errors gracefully.

---

## Installation and Run

1. Clone the repository from the GitHub link provided during submission.
2. Update the database configuration in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
