package com.example.stdAttendance;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class stdRestController {
    private final studentsService stdService;

    public stdRestController(studentsService stdService) {
        this.stdService = stdService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return stdService.getAllStudents();
    }

    @GetMapping("/{stdId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long stdId) {
        return stdService.getStudentById(stdId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student std) {
        return stdService.saveStudent(std);
    }

    @PutMapping("/{stdId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long stdId, @RequestBody Student std) {
        return stdService.getStudentById(stdId).map(student -> {
            student.setStdName(std.getStdName());
            student.setStdEmail(std.getStdEmail());
            stdService.saveStudent(student);
            return ResponseEntity.ok(student);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{stdId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long stdId) {
        stdService.deleteStudent(stdId);
        return ResponseEntity.noContent().build();
    }
}
