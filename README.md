# Student Data Management

This is a simple Spring Boot RESTful API project for managing student data.  
It supports basic CRUD operations to create, read, update, and delete student records.

---

## Features

- Create a new student  
- Retrieve all students  
- Retrieve a student by ID  
- Update an existing student  
- Delete a student  
- Supports student details: name, email, course, and city  

---

## Technologies Used

- Java 17  
- Spring Boot 3.5.4  
- Spring Data JPA  
- MySQL (with Hikari connection pool)  
- Maven for build automation  
- Lombok for boilerplate code reduction  

---

## Getting Started

### Prerequisites

- Java 17 installed  
- MySQL database up and running  
- Maven installed 

## Database Setup Instructions
Before running this project for the first time, **you need to create a MySQL database**.

### 1. Create Database in MySQL
Open your MySQL Workbench (or use MySQL CLI) and run:
CREATE DATABASE your_database_name;

You can use any name, but make sure it matches the value in the `application.properties` file.


### Setup

1. Clone this repository:
    git clone https://github.com/SasiVenkatGowdDasari/Student-Data-Management.git
    cd Student-Data-Management

2. Configure your database settings in `src/main/resources/application.properties`:
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update

3. Build and run the project:
    mvn clean install
    mvn spring-boot:run

The application will start at `http://localhost:8081`.

---

## API Endpoints

| Method | URL                  | Description                  |
|--------|----------------------|------------------------------|
| POST   | `/students`           | Create a new student          |
| GET    | `/students`           | Retrieve all students         |
| GET    | `/students/{id}`      | Retrieve a student by ID      |
| PUT    | `/students/{id}`      | Update a student by ID        |
| DELETE | `/students/{id}`      | Delete a student by ID        |

---

## Example JSON Payloads

### Create Student (POST `/students`)
    {
    "name": "sasi",
    "email": "sasi@example.com",
    "course": "CSE-AIML",
    "city": "Hyderabad"
    }

### Update Student (PUT `/students/{id}`)
    {
    "name": "Sasi D",
    "email": "sasid@example.com",
    "course": "CSE-DS",
    "city": "Bangalore"
    }

---

## Notes

- For updates, include the `id` in the URL path and omit it from the JSON body.  
- The `city` field was added later and existing data may have this field set to `null`.  

---

## License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## Contact

Created by Sasi Venkat Gowd Dasari  
Feel free to reach out for questions or contributions!

