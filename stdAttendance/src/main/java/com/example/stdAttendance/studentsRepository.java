package com.example.stdAttendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentsRepository extends JpaRepository<Student, Long> {
}
