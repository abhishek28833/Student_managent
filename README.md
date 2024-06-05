# Student Management System

A web-based application for managing student records and performing CRUD operations using Java Servlets, MySQL, and Apache Tomcat.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Student Management System is designed to streamline the process of managing student information within an educational institution. It allows administrators to add, view, update, and delete student records through a web interface.

## Features

- **Add Student**: Input student details including name, roll number, email, date of birth, and eligibility criteria.
- **View All Students**: Display a table of all students currently stored in the database.
- **Update Student**: Modify existing student information such as name, email, and date of birth.
- **Delete Student**: Remove a student record based on their unique ID.
- **Interactive UI**: Designed with user-friendly interfaces for easy navigation and data manipulation.

## Technologies Used

- **Java Servlets**: Handle HTTP requests and responses for dynamic web application development.
- **MySQL Database**: Store and manage student information securely.
- **Apache Tomcat**: Serve the Java Servlets and JSP files over HTTP.
- **HTML/CSS**: Structure and style the web pages for a visually appealing user interface.

## Setup Instructions

1. **Clone the Repository**:
  git clone https://github.com/abhishek28833/Student_management.git

2. **Database Setup**:
- Install MySQL and create a database named `exam`.
- Import the SQL schema from `database.sql` to set up the necessary tables.

3. **Eclipse Setup**:
- Import the project into Eclipse IDE.
- Ensure Apache Tomcat server is configured in Eclipse.

4. **Run the Application**:
- Deploy the application on Apache Tomcat server.
- Access the application at `http://localhost:8080/Student_management`.

## Usage

1. **Adding a Student**:
- Navigate to `AddStudent.html`, fill in the student details, and submit the form.

2. **Viewing Students**:
- Click on `View All Students` to see a table listing all students currently in the database.

3. **Updating Student Information**:
- Access `updateStudent.html`, enter the student ID and update the required fields.

4. **Deleting a Student**:
- Go to `deleteStudent.html`, input the student ID, and click `Delete Student` to remove the record.

## Screenshots

![Home page](/index.png)
![Add student](/add_students.png)
![View Databases records](/database_records.png)
![delete record](/delete_record.png)
![Update record in database](/update_student_data.png)

## Contributing

Contributions are welcome! Please fork the repository and create a pull request for any enhancements or bug fixes.

