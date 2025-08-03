package com.example.stdAttendance;

import java.util.Map;

public class StudentAttendancePivotDTO {
    private String studentName;
    private Long studentId;
    private Map<String, String> attendance;
    
    
    
    
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Map<String, String> getAttendance() {
		return attendance;
	}
	public void setAttendance(Map<String, String> attendance) {
		this.attendance = attendance;
	}
	
    
    
}
