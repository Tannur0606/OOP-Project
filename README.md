# 🛒 Online Shop Management System

## 📋 Project Description
The **Online Shop Management System** is a Java-based e-commerce application designed to manage products, users, and orders. The project utilizes **Maven** for build management and **PostgreSQL** for database operations.

---

## 🚀 Main Features

### For Customers:
- View products
- Add products to the cart
- Manage and review the cart
- Place orders

### For Administrators:
- Manage products (add, edit, delete)
- Manage users
- View orders
- Generate reports

---

## ⚙️ Technologies Used
- **Programming Language**: Java 17+
- **Build Tool**: Maven
- **Database**: PostgreSQL
- **Architecture**: OOP, Design Patterns (DAO, Singleton)
- **Database Connection**: JDBC

---

## 📂 Project Structure
- **`Main.java`** — Entry point of the application.
- **`AdminPanel.java`** — Admin interface for managing users and products.
- **`Product.java`** — Represents product entities.
- **`Customer.java`** — Represents user entities.
- **`Order.java`** — Handles order management.
- **`DatabaseConnection.java`** — Manages database connection.
- **`Cart.java`** — Implements shopping cart logic.
- **`Payment.java`** — Implements payment logic.

---

## 📖 How to Run

### Prerequisites:
1. **Java 17+** installed.
2. **Maven** installed.
3. **PostgreSQL** installed:
    - Create a database named `online_store`.
    - Import the provided SQL schema if available.

### Project Setup:
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo-link.git
   cd OnlineShop
