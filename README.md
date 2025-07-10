Product and Sales Management System - Spring Boot REST API
Overview
This is a Spring Boot 3.2.4 (LTS) application that provides a secure REST API for managing products 
and sales with revenue tracking capabilities. The system includes comprehensive features for product 
CRUD operations, sales management, revenue calculation, PDF export, and IP-based access control.

Technology Stack
Framework: Spring Boot 3.2.4 (LTS)

Java Version: 17

Database: MySQL

Security: JWT Authentication + Spring Security

API Documentation: SpringDoc OpenAPI 2.5.0

PDF Generation: OpenPDF 1.3.30

Build Tool: Maven

Lombok: For boilerplate code reduction

API Endpoints
Product Controller
GET /api/products - Retrieve all products (with pagination)

GET /api/products/{id} - Get a specific product by ID

POST /api/product - Add a new product (ADMIN only)

PUT /api/products/{id} - Update a product (ADMIN only)

DELETE /api/products/{id} - Delete a product (ADMIN only)

GET /api/products/{id}/revenue - Get revenue for a specific product

GET /api/products/revenue/total - Get total revenue across all products

Sale Controller
GET /api/sales - Get all sales

POST /api/sales - Create a new sale (ADMIN only)

GET /api/sales/product/{productId} - Get sales for a specific product

DELETE /api/sales/{id} - Delete a sale (ADMIN only)

Product Export Controller
GET /api/export/products/pdf - Export product data as PDF

Authentication Controller
POST /auth/login - Authenticate and get JWT token

Security Implementation
The API is secured with:

JWT authentication (using jjwt 0.11.5)

Role-based access control (ADMIN/USER)

IP address whitelisting

Spring Security integration

Database Configuration
The application uses MySQL with JPA/Hibernate for ORM. Key entities:

Product - Stores product information

Sale - Stores sales records

User - Stores authentication details

Getting Started
Prerequisites
Java 17+ JDK

MySQL 8.0+

Maven 3.9+

Installation
Clone the repository:

bash
git clone https://github.com/manufasilpm/product-sales.git
cd product-sales
Configure MySQL in application.properties:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_sales
spring.datasource.username= your_username
spring.datasource.password= your_password
spring.jpa.hibernate.ddl-auto=update
Build and run the application:

bash
mvn clean install
mvn spring-boot:run
Default Users
Admin User:

Username: admin

Password: ........

Roles: ADMIN (full access)

Regular User:

Username: user

Password: .......

Roles: USER (read-only access)

API Documentation
The application includes Swagger UI with role-based visibility:

Access Swagger UI at: http://localhost:8080/swagger-ui.html

OpenAPI JSON at: http://localhost:8080/v3/api-docs
