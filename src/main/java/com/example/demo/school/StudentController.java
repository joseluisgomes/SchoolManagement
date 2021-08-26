package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") long studentId) {
        return studentService.getStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.registerNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void removeStudent(@PathVariable("studentId") long studentId) {
        studentService.removeStudent(studentId);
    }
}
