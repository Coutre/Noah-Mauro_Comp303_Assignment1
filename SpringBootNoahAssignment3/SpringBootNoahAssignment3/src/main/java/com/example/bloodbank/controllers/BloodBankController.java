package com.example.bloodbank.controllers;

import com.example.bloodbank.models.BloodBank;
import com.example.bloodbank.services.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodbanks")
public class BloodBankController {

    private final BloodBankService bloodBankService;

    @Autowired
    public BloodBankController(BloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankService.getAllBloodBanks();
    }

    @GetMapping("/{id}")
    public BloodBank getBloodBankById(@PathVariable Long id) {
        return bloodBankService.getBloodBankById(id);
    }

    @PostMapping
    public BloodBank addBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankService.addBloodBank(bloodBank);
    }

    @PutMapping("/{id}")
    public BloodBank updateBloodBank(@PathVariable Long id, @RequestBody BloodBank bloodBank) {
        return bloodBankService.updateBloodBank(id, bloodBank);
    }

    @DeleteMapping("/{id}")
    public void deleteBloodBank(@PathVariable Long id) {
        bloodBankService.deleteBloodBank(id);
    }
}
