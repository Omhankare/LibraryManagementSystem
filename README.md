# 📚 Library Management System (Java + JDBC)

A **console-based Library Management System** developed using **Core Java and JDBC**.  
The project follows **DAO (Data Access Object)** and **DTO (Data Transfer Object)** design patterns and connects to a **MySQL database**.

This project is actively evolving and will be extended with a **web interface (HTML/CSS)** and later migrated to **Spring Boot**.

---

## 🚀 Features (Current)

- Admin login authentication
- Add new books to the library
- Update book details:
  - Book name
  - Author name
  - Quantity
  - Serial number
- Search books by:
  - Serial number
  - Author name
- View all available books
- JDBC-based database interaction
- Clean separation of concerns using DAO & DTO patterns
- Secure database configuration using properties file (no credentials in code)

---

## 🛠️ Technologies Used (Current)

- **Java**
- **JDBC**
- **MySQL**
- **IntelliJ IDEA**
- **Git & GitHub**

---

<h2>📂 Project Structure</h2>

<pre><code>
LibraryManagementSystem/
│
├── dao/                    (Database access logic - DAO layer)
│   ├── BookDAO.java
│   ├── LibraryDAO.java
│   └── LoginDAO.java
│
├── dto/                    (Data Transfer Objects)
│   └── Book.java
│
├── service/                (Business logic layer)
│   └── BookService.java
│
├── login/                  (Authentication logic)
│   └── LoginService.java
│
├── LibraryManagementSystem.java   (Main entry point)
├── db.properties.example          (Sample DB configuration)
├── .gitignore                     (Git ignore rules)
└── LibraryManagementSystem.iml
</code></pre>


## 🔐 Database Configuration

Database credentials are **NOT hardcoded**.

---

▶️ How to Run the Project (Current)  

  - Clone the repository  
  
  - git clone https://github.com/your-username/LibraryManagementSystem.git  
  
  - Open the project in IntelliJ IDEA  
  
  - Create a MySQL database:  
  
  - CREATE DATABASE librarymanagementsystem;  
  
  - Update db.properties with your local MySQL credentials  
  
  - Run the LibraryManagementSystem.java file  
  
  - Use the console menu to interact with the system  
  
---

🌐 Upcoming Enhancements (Planned)  

🔜 Web Interface (HTML & CSS)

- Admin dashboard using HTML & CSS

- Forms for adding and updating books

- Tables to display books on localhost

- Output visible in browser instead of console

🔜 Spring Boot Migration

- Convert project to Spring Boot

- RESTful APIs

- Controller → Service → Repository architecture

- Use application.properties for configuration

- Integration with Thymeleaf / REST frontend

🔜 Deployment

- Local deployment on localhost

- Public deployment so anyone can access the project

- Database configuration via environment variables

---

🎯 Learning Outcomes

1 Strong understanding of JDBC and database connectivity

2 Practical use of DAO & DTO patterns

3 Secure handling of configuration files

4 Real-world project structuring

5 Version control with Git & GitHub

6 Foundation for Spring Boot and full-stack development

👤 Author

Om Hankare  

B.E. Computer Science (AI & ML)  

Java | JDBC | Backend Development | JavaScript  

---
