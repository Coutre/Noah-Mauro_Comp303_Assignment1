package com.noah.Noah_COMP303_Assignment2;

import com.noah.Noah_COMP303_Assignment2.Models.Program;
import com.noah.Noah_COMP303_Assignment2.Repositories.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    @Autowired
    private final ProgramRepo myProgramRepo;

    public DataInit(ProgramRepo myProgramRepo) {
        this.myProgramRepo = myProgramRepo;
    }

    @Override
    public void run(String... args) {
        myProgramRepo.save(new Program("Computer Science", 36, 12000.00, "Dr. Smith"));
        myProgramRepo.save(new Program("Data Science", 24, 15000.00, "Prof. Johnson"));
        myProgramRepo.save(new Program("Cybersecurity", 30, 14000.00, "Dr. Lee"));
        myProgramRepo.save(new Program("Web Development", 18, 10000.00, "Prof. Adams"));
        myProgramRepo.save(new Program("Mobile App Development", 12, 11000.00, "Dr. Brown"));
    }
}
