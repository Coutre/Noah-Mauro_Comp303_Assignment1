package com.noah.Noah_COMP303_Assignment2.Repositories;

import com.noah.Noah_COMP303_Assignment2.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByuserName(String userName);
}
