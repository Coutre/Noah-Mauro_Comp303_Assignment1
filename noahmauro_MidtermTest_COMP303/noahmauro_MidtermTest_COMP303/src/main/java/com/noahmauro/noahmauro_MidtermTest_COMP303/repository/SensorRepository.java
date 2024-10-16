package com.noahmauro.noahmauro_MidtermTest_COMP303.repository;

import com.noahmauro.noahmauro_MidtermTest_COMP303.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
