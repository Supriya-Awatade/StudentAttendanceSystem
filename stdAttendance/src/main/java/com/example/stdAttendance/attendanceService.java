package com.example.stdAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class attendanceService {

    @Autowired
    private attendanceRepository attendanceRepo;

    @Autowired
    private studentsRepository studentRepo;

    // ✅ Add attendance
    public attendance markAttendance(attendance attendance) {
        // studentId वरून student शोधा
        Long studentId = attendance.getStudentId();
        if (studentId == null) {
            throw new IllegalArgumentException("studentId is required in attendance JSON");
        }

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + studentId));

        attendance.setStudent(student);
        return attendanceRepo.save(attendance);
    }

    // ✅ Get all attendances
    public List<attendance> getAllAttendances() {
        return attendanceRepo.findAll();
    }

    // ✅ Get attendance by ID
    public Optional<attendance> getAttendanceById(Long id) {
        return attendanceRepo.findById(id);
    }

    // ✅ Update attendance
    public attendance updateAttendance(Long id, attendance attendanceDetails) {
        Optional<attendance> existingOpt = attendanceRepo.findById(id);
        if (existingOpt.isPresent()) {
            attendance existing = existingOpt.get();
            existing.setDate(attendanceDetails.getDate());
            existing.setPresent(attendanceDetails.isPresent());

            // studentId बदलला असेल तर student update करा
            if (attendanceDetails.getStudentId() != null) {
            	Student student = studentRepo.findById(attendanceDetails.getStudentId())
                        .orElseThrow(() -> new RuntimeException("Student not found with ID: " + attendanceDetails.getStudentId()));
                existing.setStudent(student);
            }

            return attendanceRepo.save(existing);
        }
        return null;
    }

    // ✅ Delete attendance
    public boolean deleteAttendance(Long id) {
        if (attendanceRepo.existsById(id)) {
            attendanceRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
