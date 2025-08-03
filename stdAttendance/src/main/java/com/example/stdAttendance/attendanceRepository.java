package com.example.stdAttendance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface attendanceRepository extends JpaRepository<attendance, Long> 
{
}
