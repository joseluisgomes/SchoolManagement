package com.example.demo.school.student;

import com.example.demo.school.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public StudentService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<Student> getStudents() {
        return schoolRepository.findAll();
    }

    public Student getStudent(long studentId) {
        return schoolRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Student with %s does not exist!", studentId)
                ));
    }

    @Transactional
    public void updateStudent(long studentId,
                              String name,
                              String email) {
        Student student = getStudent(studentId);

        if (name.length() > 0 && !(student.getName().equals(name)))
            student.setName(name);
        if (email.length() > 0 && !(student.getEmail().equals(email))) {
            Optional<Student> optionalStudent = schoolRepository.findStudentByEmail(email);

            if (optionalStudent.isPresent())
                throw new IllegalStateException("Email already taken!");
            else
                student.setEmail(email);
        }
    }

    public void registerNewStudent(Student student) {
        Optional<Student> optionalStudent = schoolRepository
                .findStudentByEmail(Objects.requireNonNull(student).getEmail());
        if (optionalStudent.isPresent())
            throw new IllegalStateException("Email already taken!");
        else
            schoolRepository.save(student);
    }

    public void removeStudent(long studentId) {
        boolean isPresent = schoolRepository.existsById(studentId);

        if (isPresent)
            schoolRepository.deleteById(studentId);
        else
            throw new IllegalStateException("Student with id " + studentId + "does not exist");
    }
}
