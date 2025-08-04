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

1.Open a terminal in the folder containing your index.html.

2.Run a simple web server (for CORS support):
python -m http.server 5500

3.Open your browser and go to:
http://localhost:5500

🔗 Ensure backend server is running at http://localhost:8083

---
## 🧪 Output of Spring Tool
 <img width="960" height="540" alt="Image" src="https://github.com/user-attachments/assets/47218cf1-f73b-420a-abe0-36ecbcbf723e" />



## 🧪 Tested Using Postman

<img width="960" height="540" alt="Image" src="https://github.com/user-attachments/assets/028de5b0-e10b-46ac-bd94-78a3922cdba4" />



## 📸 Final Web Interface (Frontend)
<img src="C:\Users\admin\Desktop\outputs\frontend.png" />



---
## 📦 Dependencies (Maven)
Add the following dependencies in your pom.xml:
```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```
---

## 👩‍💻 Author
Name:-
Supriya Awatade

Email:-
supriyaawatade1205@email.com

GitHub:-
https://github.com/Supriya-Awatade

---


