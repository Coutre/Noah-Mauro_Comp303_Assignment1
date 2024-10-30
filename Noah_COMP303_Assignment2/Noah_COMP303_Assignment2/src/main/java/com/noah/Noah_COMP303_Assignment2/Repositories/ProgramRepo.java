package com.noah.Noah_COMP303_Assignment2.Repositories;

import com.noah.Noah_COMP303_Assignment2.Models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepo extends JpaRepository<Program, Long> {
    Program findByprogramName(String programName);
}
