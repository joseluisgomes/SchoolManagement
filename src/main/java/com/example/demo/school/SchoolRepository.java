package com.example.demo.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email= ?1")
    Optional<Student> findStudentByEmail(String email);
}
