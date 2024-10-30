package com.noah.Noah_COMP303_Assignment2.Repositories;

import com.noah.Noah_COMP303_Assignment2.Models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
