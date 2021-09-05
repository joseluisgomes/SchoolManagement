package com.example.demo.school;

import com.example.demo.school.student.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SchoolRepositoryTest {

    @Autowired
    private SchoolRepository underTest;

    @Test
    void findStudentByEmail() {
        // given
        String email = "bob@gmail.com";
        var student = new Student(
                "Bob Dickson",
                email,
                LocalDate.of(1954, Month.AUGUST, 26)
        );
        underTest.save(student);

        // when
        Optional<Student> studentOptional = underTest.findStudentByEmail(email);

        // then
        assertThat(studentOptional).isPresent();
    }
}