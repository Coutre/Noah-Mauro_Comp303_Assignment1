package com.example.bloodbank.services;

import com.example.bloodbank.models.BloodStock;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@Service
public class BloodStockService {
    private Map<Long, BloodStock> bloodStockMap = new HashMap<>();

    private Long nextId = 1L;
    public Map<Long, BloodStock> getAllBloodStocks() {
        return bloodStockMap;
    }

    public Optional<BloodStock> getBloodStockById(Long id) {
        return Optional.ofNullable(bloodStockMap.get(id));
    }

    public BloodStock addBloodStock(BloodStock bloodStock) {
        bloodStock.setId(nextId++);
        bloodStockMap.put(bloodStock.getId(), bloodStock);
        return bloodStock;
    }

    public Optional<BloodStock> updateBloodStock(Long id, BloodStock updatedBloodStock) {
        if (bloodStockMap.containsKey(id)) {
            BloodStock existingBloodStock = bloodStockMap.get(id);
            existingBloodStock.setBloodGroup(updatedBloodStock.getBloodGroup());
            existingBloodStock.setQuantity(updatedBloodStock.getQuantity());
            existingBloodStock.setBestBefore(updatedBloodStock.getBestBefore());
            existingBloodStock.setStatus(updatedBloodStock.getStatus());
            return Optional.of(existingBloodStock);
        }
        return Optional.empty();
    }

    public boolean deleteBloodStock(Long id) {
        if (bloodStockMap.containsKey(id)) {
            bloodStockMap.remove(id);
            return true;
        }
        return false;
    }
}
