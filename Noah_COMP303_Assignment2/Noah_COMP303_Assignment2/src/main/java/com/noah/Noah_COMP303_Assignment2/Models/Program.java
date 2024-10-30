package com.noah.Noah_COMP303_Assignment2.Models;
import jakarta.persistence.*;

@Entity
@Table(name = "Program")
public class Program {

    public Program() {
    }

    public Program(String programName, int duration, double fee, String professor) {
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.professor = professor;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programCode;

    @Column(nullable = false, name = "program_name")
    private String programName;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private double fee;

    @Column
    private String professor;


    public Long getProgramCode() {
        return programCode;
    }

    public void setProgramCode(Long programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getProfessor(){return professor;}

    public void setProfessor(String professor){this.professor = professor;}

    @Override
    public String toString() {
        return "Program{" +
                "programCode=" + programCode +
                ", programName='" + programName + '\'' +
                ", duration=" + duration +
                ", fee=" + fee +
                ", professor='" + professor + '\'' +
                '}';
    }

}

