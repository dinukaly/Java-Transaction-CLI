# Library Management System (Java, Console-Based)

A simple console-based Library Management System built in Java, following the MVC pattern. The application allows users to manage students and books, including borrowing and returning books, with data stored in a database.

## Features
- **Student Management**: Add, search, update, and delete student records
- **Book Management**: Add, search, update, and delete books
- **Borrow/Return Books**: Issue and return books for students
- **Console Menu Interface**: Simple interactive menu for all operations

## Requirements
- **Java 11** or higher
- **JDBC-compatible Database** (e.g., MySQL, PostgreSQL, etc.)
- (Optional) **JavaFX** if you plan to extend the UI

## Setup & Running
1. **Clone the repository**
2. **Configure the database connection**
   - Update database credentials and connection details in the relevant DAO or configuration files (see `src/dao` or similar)
3. **Build and run**
   - Using an IDE: Open the project and run `Main.java`
   - Using command line:
     ```sh
     javac -d out src/**/*.java
     java -cp out Main
     ```

## Usage
- On startup, you'll see a menu:
  - `1. Student Management`
  - `2. Book Management`
  - `0. Exit`
- Select an option and follow prompts to manage students or books.

## Project Structure
```
databaseProgramming/
├── src/
│   ├── controller/         # Controllers for menu and logic
│   ├── view/               # Console views for Student and Book
│   ├── dao/                # Data access objects (if present)
│   └── Main.java           # Application entry point
├── out/                    # Compiled classes
├── .gitignore
├── README.md
└── ...
```

## License
This project is for educational purposes.

---
Feel free to update this README with database setup details or additional features as your project evolves.
