package com.example.stdAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/attendance")
public class AttendanceRestController {

    @Autowired
    private attendanceService attendanceService;

    @PostMapping
    public ResponseEntity<attendance> markAttendance(@RequestBody attendance attend) {
        attendance savedAttendance = attendanceService.markAttendance(attend);
        return ResponseEntity.ok(savedAttendance);
    }
    
    @GetMapping
    public List<AttendanceDTO> getAllAttendances() {
        List<attendance> attendances = attendanceService.getAllAttendances();
        return attendances.stream().map(att -> {
            AttendanceDTO dto = new AttendanceDTO();
            dto.setAttendanceId(att.getAttendanceId());
            dto.setDate(att.getDate());
            dto.setPresent(att.isPresent());

            Student s = att.getStudent();
            if (s != null) {
                dto.setStudentId(s.getStudentId());
                dto.setStudentName(s.getStdName());
                dto.setStudentEmail(s.getStdEmail());
            }

            return dto;
        }).toList();
    }


    @GetMapping("/pivot")
    public List<StudentAttendancePivotDTO> getPivotAttendance() {
        List<attendance> attendances = attendanceService.getAllAttendances();
        Map<Long, StudentAttendancePivotDTO> pivotMap = new HashMap<>();

        for (attendance att : attendances) {
            Long studentId = att.getStudent().getStudentId();
            String studentName = att.getStudent().getStdName();
            String date = att.getDate().toString(); // eg. "2025-08-01"
            String status = att.isPresent() ? "Present" : "Absent";

            StudentAttendancePivotDTO dto = pivotMap.getOrDefault(studentId, new StudentAttendancePivotDTO());
            dto.setStudentId(studentId);
            dto.setStudentName(studentName);
            if (dto.getAttendance() == null) {
                dto.setAttendance(new HashMap<>());
            }

            dto.getAttendance().put(date, status);
            pivotMap.put(studentId, dto);
        }

        return new ArrayList<>(pivotMap.values());
    }


    @GetMapping("/{id}")
    public ResponseEntity<attendance> getAttendanceById(@PathVariable("id") Long stdId) {
        Optional<attendance> attendanceOptional = attendanceService.getAttendanceById(stdId);
        return attendanceOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<attendance> updateAttendance(@PathVariable("id") Long stdId, @RequestBody attendance attendanceDetails) {
        attendance updatedAttendance = attendanceService.updateAttendance(stdId, attendanceDetails);
        if (updatedAttendance != null) {
            return ResponseEntity.ok(updatedAttendance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable("id") Long stdId) {
        boolean deleted = attendanceService.deleteAttendance(stdId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
