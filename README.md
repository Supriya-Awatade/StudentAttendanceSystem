# 🎓 Student Attendance Management System (REST API)

A simple and beginner-friendly RESTful backend application to manage student attendance records in a school or college environment. This project is built using *Spring Boot*, **PostgreSQL**, and follows the **MVC architecture**.

---

## 🔧 Technologies Used

- *Java 21*
- *Spring Boot 3.5.4*
- *Spring Web (REST Controller)*
- *Spring Data JPA (Hibernate)*
- *PostgreSQL*
- *Postman* (for API testing)

---

## 📁 Project Structure (MVC)
```
    src
    └── main
    ├── java
    │ └── com.example.stdAttendance
    │ ├── controller (AttendanceRestController, stdRestController)
    │ ├── entity (Student, attendance)
    │ ├── dto (AttendanceDTO, StudentAttendancePivotDTO)
    │ ├── repository (attendanceRepository, studentsRepository)
    │ └── service (attendanceService, studentsService)
    └── resources
    └── application.properties
```

    
---

## 📌 Features

- 👨‍🎓 Add / update / delete students
- ✅ Mark attendance for students
- 📅 View attendance by date
- 📊 Pivot table view for Excel-style summary
- 📤 Export-ready attendance format
- 🧩 DTO usage to avoid infinite recursion in JSON

---

## ▶ How to Run the Project

### 🧩 Step 1: Backend (Spring Boot + PostgreSQL)

1. Clone the repository:
  git clone https://github.com/your-username/student-attendance-system.git
  cd student-attendance-system
---
2. Set up your PostgreSQL database:
   - Create a database: gsbilling
   - Update application.properties with your credentials
---
3. Run the Spring Boot Application:
  ./mvnw spring-boot:run
  OR run it from *Eclipse STS* as Spring Boot App
---
### 🌐 Step 2: Frontend (HTML + CSS + JS)
Open a terminal in the folder containing your index.html.
---
Run a simple web server (for CORS support):
python -m http.server 5500
---
Open your browser and go to:
http://localhost:5500
---
🔗 Ensure backend server is running at http://localhost:8083
---
### 📡 REST API Endpoints
## 👨‍🎓 Student APIs
Method	Endpoint	Description
GET	/students	Get all students
GET	/students/{id}	Get a student by ID
POST	/students	Add a new student
PUT	/students/{id}	Update student details
DELETE	/students/{id}	Delete a student

## 📋 Attendance APIs
Method	Endpoint	Description
POST	/attendance	Mark attendance
GET	/attendance	List all attendance records
GET	/attendance/{id}	Get specific attendance by ID
PUT	/attendance/{id}	Update an attendance record
DELETE	/attendance/{id}	Delete attendance record
GET	/attendance/pivot	Get pivot-style attendance summary

## 🧪 Tested Using Postman
<img width="1013" alt="postman-add-student" src="https://github.com/user-attachments/assets/example1.png" /> <img width="980" alt="postman-attendance" src="https://github.com/user-attachments/assets/example2.png" />

## 📸 Final Web Interface (Frontend)
<img width="1886" alt="pivot-table" src="https://github.com/user-attachments/assets/example3.png" /> <img width="1881" alt="form-entry" src="https://github.com/user-attachments/assets/example4.png" />


---
## 📦 Dependencies (Maven)
Add the following dependencies in your pom.xml:
<dependencies>
    <!-- Spring Boot Starter for RESTful APIs -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter for JPA and Hibernate -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- PostgreSQL JDBC Driver -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Boot DevTools (optional, for live reload) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- Spring Boot Starter for Tests -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

---

## 👩‍💻 Author
Name:-
Supriya Awatade

Email:-
supriyaawatade1205@email.com

GitHub:-
https://github.com/Supriya-Awatade




