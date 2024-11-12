package com.example.bloodbank.controllers;

import com.example.bloodbank.models.Seeker;
import com.example.bloodbank.services.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seekers")
public class SeekerController {

    private final SeekerService seekerService;

    @Autowired
    public SeekerController(SeekerService seekerService) {
        this.seekerService = seekerService;
    }

    @GetMapping
    public List<Seeker> getAllSeekers() {
        return seekerService.getAllSeekers();
    }

    @GetMapping("/{id}")
    public Seeker getSeekerById(@PathVariable Long id) {
        return seekerService.getSeekerById(id);
    }

    @PostMapping
    public Seeker addSeeker(@RequestBody Seeker seeker) {
        return seekerService.addSeeker(seeker);
    }

    @PutMapping("/{id}")
    public Seeker updateSeeker(@PathVariable Long id, @RequestBody Seeker seeker) {
        return seekerService.updateSeeker(id, seeker);
    }

    @DeleteMapping("/{id}")
    public void deleteSeeker(@PathVariable Long id) {
        seekerService.deleteSeeker(id);
    }
}
