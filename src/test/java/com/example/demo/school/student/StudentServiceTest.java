package com.example.demo.school.student;

import com.example.demo.school.SchoolRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class StudentServiceTest {
    
    @Mock
    private SchoolRepository schoolRepository;
    private AutoCloseable autoCloseable;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(schoolRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getStudents() {
        // when
        underTest.getStudents();
        // then
        verify(schoolRepository).findAll();
    }

    @Test
    @Disabled
    void getStudent() {
    }

    @Test
    @Disabled
    void updateStudent() {
    }

    @Test
    void registerNewStudent() {
        // given
        var student = new Student(
                "Bob Dickson",
                "bob@gmail.com",
                LocalDate.of(1954, Month.AUGUST, 26)
        );

        // when
        underTest.registerNewStudent(student);

        // then
        ArgumentCaptor<Student> argumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(schoolRepository).save(argumentCaptor.capture());

        Student capturedStudent = argumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // given
        var student = new Student(
                "Bob Dickson",
                "bob@gmail.com",
                LocalDate.of(1954, Month.AUGUST, 26)
        );

        // when
        given(schoolRepository.findStudentByEmail(student.getEmail())).willReturn(Optional.of(student));

        // then
        assertThatThrownBy(() -> underTest.registerNewStudent(student))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Email already taken!");
    }

    @Test
    @Disabled
    void removeStudent() {
    }
}