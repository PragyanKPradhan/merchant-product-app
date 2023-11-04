## merchant-product-app (Merchant Product Management Application)

This is a Java-based application that manages users and their associated products. It uses Spring Framework for dependency injection, Hibernate for persistence, and MySQL as the database.

### Table of Contents

- Prerequisites
- Setup
- Project Structure
- Usage
- Contributing
- License

### Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven
- MySQL Server

### Setup

1. Clone the repository:
   ```
   git clone https://github.com/PragyanKPradhan/merchant-product-app.git
   ```
2. Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).
3. Set up your MySQL database and update the `persistence.xml` file with your database connection details.

### Project Structure

- `src/main/java/org/jsp/merchantproductapp`: Contains the Java source code.
  - `controller`: Contains the `MerchantProductController` class which serves as the main entry point for the application.
  - `dao`: Contains the data access objects (`MerchantDao` and `ProductDao`) responsible for interacting with the database.
  - `dto`: Contains the data transfer objects (`Merchant` and `Product`) representing the entities in the database.
  - `MerchantProductConfig.java`: Configuration class for Spring framework.
- `src/main/resources`: Contains the `persistence.xml` file for Hibernate configuration.
- `pom.xml`: Maven project configuration file specifying dependencies.

![image](https://github.com/PragyanKPradhan/merchant-product-app/assets/144383179/3663fbdb-043c-450b-87d4-23c200348d10)

### Usage

1. Run the application using your preferred IDE.
2. Follow the instructions in the console to interact with the application. You can save Merchants, update Merchant details, add products, and perform various queries.

![image](https://github.com/PragyanKPradhan/merchant-product-app/assets/144383179/dd93e3ed-26ac-4498-a5b8-f8a91bd83f52)

### Contributing

If you'd like to contribute to this project, please fork the repository and create a pull request with your changes.

### License

This project is licensed under the MIT License.

