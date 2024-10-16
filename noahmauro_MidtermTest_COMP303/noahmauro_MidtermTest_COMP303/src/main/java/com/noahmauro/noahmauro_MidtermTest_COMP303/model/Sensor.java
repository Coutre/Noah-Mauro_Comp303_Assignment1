package com.noahmauro.noahmauro_MidtermTest_COMP303.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorID;

    @NotBlank
    private String sensorName;

    @NotNull
    private String sensorType;

    @NotNull
    @Min(0)
    @Max(1000)
    private Integer sensorPin;

    private String sensorLocation;

    @NotNull
    private String sensorStatus;

    public Long getSensorID() {
        return sensorID;
    }

    public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getSensorPin() {
        return sensorPin;
    }

    public void setSensorPin(Integer sensorPin) {
        this.sensorPin = sensorPin;
    }

    public String getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(String sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    public String getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(String sensorStatus) {
        this.sensorStatus = sensorStatus;
    }
}
