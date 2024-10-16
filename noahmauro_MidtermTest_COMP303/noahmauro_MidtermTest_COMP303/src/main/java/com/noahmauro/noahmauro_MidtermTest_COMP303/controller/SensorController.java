package com.noahmauro.noahmauro_MidtermTest_COMP303.controller;

import com.noahmauro.noahmauro_MidtermTest_COMP303.model.Sensor;
import com.noahmauro.noahmauro_MidtermTest_COMP303.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sensor", new Sensor());
        return "index";
    }
    @GetMapping("/sensors")
    public String getSensors(Model model){
        List<Sensor> sensors = sensorRepository.findAll();
        model.addAttribute("sensors", sensors);
        return "Sensors";
    }

    @PostMapping("/sensors/add")
    public String addSensor(@ModelAttribute Sensor sensor){
        sensorRepository.save(sensor);
        return"redirect:/sensors";
    }

    @GetMapping("/sensors/count")
    public String countSensors(Model model){
        long sensorCount = sensorRepository.count();
        model.addAttribute("sensorCount", sensorCount);
        return "Count";
    }
}
