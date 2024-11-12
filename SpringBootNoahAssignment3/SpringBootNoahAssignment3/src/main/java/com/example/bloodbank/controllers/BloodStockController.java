package com.example.bloodbank.controllers;

import com.example.bloodbank.models.BloodStock;
import com.example.bloodbank.services.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/bloodstocks")
public class BloodStockController {

    private final BloodStockService bloodStockService;

    @Autowired
    public BloodStockController(BloodStockService bloodStockService) {
        this.bloodStockService = bloodStockService;
    }

    @GetMapping
    public ResponseEntity<Map<Long, BloodStock>> getAllBloodStocks() {
        return ResponseEntity.ok(bloodStockService.getAllBloodStocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodStock> getBloodStockById(@PathVariable("id") Long id) {
        Optional<BloodStock> bloodStock = bloodStockService.getBloodStockById(id);
        if (bloodStock.isPresent()) {
            return ResponseEntity.ok(bloodStock.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping
    public ResponseEntity<BloodStock> createBloodStock(@RequestBody BloodStock bloodStock) {
        BloodStock createdBloodStock = bloodStockService.addBloodStock(bloodStock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBloodStock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodStock> updateBloodStock(@PathVariable("id") Long id, @RequestBody BloodStock bloodStock) {
        Optional<BloodStock> updatedBloodStock = bloodStockService.updateBloodStock(id, bloodStock);
        if (updatedBloodStock.isPresent()) {
            return ResponseEntity.ok(updatedBloodStock.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodStock(@PathVariable("id") Long id) {
        if (bloodStockService.deleteBloodStock(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

