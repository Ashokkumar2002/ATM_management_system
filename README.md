# ATM Management System

A Java-based ATM Management System using JDBC for database connectivity.

## Author
- **Author Name:** Ashok Kumar C

## Description
The ATM Management System is a Java application that simulates the functionality of an Automated Teller Machine (ATM). It provides various features commonly found in ATM systems, such as account balance inquiry, cash withdrawal, cash deposit, and account transfer. The system interacts with a MySQL database to store and retrieve user account information.

## Features
- User authentication with PIN verification
- Account balance inquiry
- Cash withdrawal
- Cash deposit
- Account transfer between accounts
- Error handling for invalid inputs and insufficient funds
- Secure database connectivity using JDBC

## Installation
1. Clone the repository
2. Import the project into your preferred Java IDE.
3. Set up the MySQL database and configure the database connection details in the code.
4. Create the necessary database schema and tables using the provided SQL script.

## Usage
1. Run the `Main` class to start the ATM Management System.
2. Follow the on-screen prompts to perform various ATM transactions.
3. Use the menu options to navigate through different functionalities.
4. Ensure to handle exceptions gracefully and provide appropriate feedback to the user.

## Database Schema
The following is the schema for the database used by the ATM Management System:
- `users` table: Stores user account information (e.g., account number, PIN, balance).
- Additional tables as needed for storing transaction history, ATM logs, etc.

## Contributing
Contributions to this project are welcome. Please follow the standard GitHub workflow:
1. Fork the repository.
2. Create a new branch for your feature/fix: `git checkout -b feature-name`
3. Make your changes and commit them: `git commit -m "Description of changes"`
4. Push to the branch: `git push origin feature-name`
5. Submit a pull request.

