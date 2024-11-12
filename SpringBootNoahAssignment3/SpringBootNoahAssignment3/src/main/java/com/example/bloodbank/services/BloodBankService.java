package com.example.bloodbank.services;

import com.example.bloodbank.models.BloodBank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BloodBankService {
    private Map<Long, BloodBank> BloodBanks = new HashMap<>();

    private Long nextId = 1L;

    public BloodBank addBloodBank(BloodBank bloodBank) {
        bloodBank.setId(nextId++);
        BloodBanks.put(bloodBank.getId(), bloodBank);
        return bloodBank;
    }

    public BloodBank getBloodBankById(Long id) {
        return BloodBanks.get(id);
    }

    public List<BloodBank> getAllBloodBanks() {
        return new ArrayList<>(BloodBanks.values());
    }

    public BloodBank updateBloodBank(Long id, BloodBank bloodBank) {
        bloodBank.setId(id);
        BloodBanks.put(id, bloodBank);
        return bloodBank;
    }

    public void deleteBloodBank(Long id) {
        BloodBanks.remove(id);
    }
}
