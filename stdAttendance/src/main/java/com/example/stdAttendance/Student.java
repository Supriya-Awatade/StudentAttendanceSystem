package com.example.stdAttendance;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "std_name", nullable = false)
    private String stdName;

    @Column(name = "std_email", nullable = false, unique = true)
    private String stdEmail;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<attendance> attendances;

    
    public Student() {}

    public Student(Long studentId, String stdName, String stdEmail) {
        this.studentId = studentId;
        this.stdName = stdName;
        this.stdEmail = stdEmail;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", stdName='" + stdName + '\'' +
                ", stdEmail='" + stdEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
	   Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
               Objects.equals(stdName, student.stdName) &&
               Objects.equals(stdEmail, student.stdEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, stdName, stdEmail);
    }
}
