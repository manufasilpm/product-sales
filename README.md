# 📦 Product and Sales Management System - Spring Boot REST API

A **Spring Boot 3.2.4 (LTS)** application offering a secure REST API to manage products, sales, and revenue tracking. Designed with best practices in security, documentation, and extensibility.

---

## 🔧 Tech Stack

- **Java**: 17  
- **Framework**: Spring Boot 3.2.4 (LTS)  
- **Database**: MySQL  
- **Security**: Spring Security + JWT + IP Whitelisting  
- **PDF Generation**: OpenPDF 1.3.30  
- **API Docs**: SpringDoc OpenAPI 2.5.0  
- **Build Tool**: Maven  
- **Boilerplate Reduction**: Lombok  

---

## 📚 Features

- ✅ Full CRUD for Products
- 🧾 Sales Recording & Revenue Calculation
- 📊 Total & Per-Product Revenue APIs
- 🔒 JWT Authentication with Role-based Access (ADMIN/USER)
- 🌐 IP-based Access Restrictions
- 📄 PDF Export of Product Data
- 🧪 Swagger/OpenAPI 3 Documentation with Role-Specific Visibility

---

## 🚀 API Endpoints

### 🔹 Product Controller

| Method | Endpoint | Description | Role |
|--------|----------|-------------|------|
| GET    | `/api/products` | List all products (paginated) | USER, ADMIN |
| GET    | `/api/products/{id}` | Get product by ID | USER, ADMIN |
| POST   | `/api/product` | Create a new product | **ADMIN only** |
| PUT    | `/api/products/{id}` | Update a product | **ADMIN only** |
| DELETE | `/api/products/{id}` | Delete a product | **ADMIN only** |
| GET    | `/api/products/{id}/revenue` | Revenue for specific product | USER, ADMIN |
| GET    | `/api/products/revenue/total` | Total revenue | USER, ADMIN |

### 🔹 Sales Controller

| Method | Endpoint | Description | Role |
|--------|----------|-------------|------|
| GET    | `/api/sales` | List all sales | USER, ADMIN |
| POST   | `/api/sales` | Create a sale record | **ADMIN only** |
| GET    | `/api/sales/product/{productId}` | Sales for specific product | USER, ADMIN |
| DELETE | `/api/sales/{id}` | Delete a sale | **ADMIN only** |

### 🔹 Export Controller

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/export/products/pdf` | Export product data as PDF |

### 🔹 Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/auth/login` | Authenticate & receive JWT token |

---

## 🔐 Security Overview

- ✅ JWT-based Authentication (via `jjwt 0.11.5`)
- 🔐 Role-based Access Control (ADMIN / USER)
- 🌍 IP Whitelisting
- 🔒 Spring Security Integration

---

## 🗃️ Database Schema

- `Product` – Product details (name, price, etc.)
- `Sale` – Sales records (product ref, quantity, etc.)
- `User` – Credentials and roles

---

## ⚙️ Setup & Installation

### ✅ Prerequisites

- Java 17+
- Maven 3.9+
- MySQL 8.0+

### 🏁 Getting Started

```bash
git clone https://github.com/your-repo/product-sales.git
cd product-sales
```

## 🛠 Configure Database
Edit src/main/resources/application.properties:

properties
Copy &Edit
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/product_sales
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```


##🚀 Run the App
```bash
mvn clean install
mvn spring-boot:run
```
