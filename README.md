# 📚 Library Management System (Java + JDBC + React Planned)
<img width="1003" height="1006" alt="Screenshot 2026-04-18 144928" src="https://github.com/user-attachments/assets/d97d0646-cef4-4304-953b-2bdeebcb4707" />
<img width="1020" height="1056" alt="Screenshot 2026-04-18 145004" src="https://github.com/user-attachments/assets/41ff1f5f-fc31-4efa-b718-a9739acf240c" />

A **console-based Library Management System** built using **Core Java and JDBC**, following **DAO (Data Access Object)** and **DTO (Data Transfer Object)** design patterns.

This project simulates a real-world library workflow with **Admin and Student roles**.
It will be extended with a **modern frontend using React**, while keeping the current Java backend.

---

## 🚀 Features 

**🔐 Authentication System**
- User Registration (Student)
- Login system (Admin / Student)
- Role-based access (admin / user)
---
**👨‍💼 Admin Functionalities**
  - Add new books
  - Update book details:
    - Book name
    - Author name
    - Quantity
    - Serial number
  - View all books
  - Search books by:
    - Serial number
    - Author name
- Fetch all registered students
- Register students manually
---
 **👨‍🎓 Student Functionalities**
  - Self-registration
  - Login access
  - View available books (extendable)
---
**🧩 System Design**
- DAO Layer → Database interaction
- DTO Layer → Data transfer objects
- Service Layer → Business logic
- JDBC-based MySQL connectivity
- Externalized DB configuration (db.properties)

---

## 🛠️ Technologies Used 

- **Java (Core Java)**
- **JDBC**
- **MySQL**
- **IntelliJ IDEA**
- **Git & GitHub**
- **React (Planned Frontend)**

---

<h2>📂 Project Structure</h2>

<pre><code>
LibraryManagementSystem/
│
├── dao/                    (Database access logic - DAO layer)
│   ├── BookDAO.java
│   ├── DatabaseServiceDAO.java
│   ├── LoginDAO.java
|   ├── RegisterDAO.java  
|   └── StudentDAO.java  
│
├── dto/                    (Data Transfer Objects)
|   ├── AdminMenu.java
|   ├── Book.java
|   ├── BookingDetails.java  
│   └── StudentMenu.java
│
├── login/                (Authentication logic)
|   ├── LoginService.java  
│   └── RegisterService.java
│
├── Service/                  (Business logic layer)
|   ├── BookService.java  
│   └── StudentService.java
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
