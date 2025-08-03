package com.example.stdAttendance;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class studentsService {

    private final studentsRepository stdRepo;

    public studentsService(studentsRepository stdRepo) {
        this.stdRepo = stdRepo;
    }

    public List<Student> getAllStudents() {
        return stdRepo.findAll();
    }

    public Optional<Student> getStudentById(Long stdId) {
        return stdRepo.findById(stdId);
    }

    public Student saveStudent(Student std) {
        return stdRepo.save(std);
    }

    public void deleteStudent(Long stdId) {
        stdRepo.deleteById(stdId);
    }
}
