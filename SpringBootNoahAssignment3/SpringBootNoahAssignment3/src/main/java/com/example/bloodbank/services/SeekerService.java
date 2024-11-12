package com.example.bloodbank.services;
import com.example.bloodbank.models.Seeker;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@Service
public class SeekerService {
    private Map<Long, Seeker> seekers = new HashMap<>();
    private Long nextId = 1L;

    public Seeker addSeeker(Seeker seeker) {
        seeker.setId(nextId++);
        seekers.put(seeker.getId(), seeker);
        return seeker;
    }

    public Seeker getSeekerById(Long id) {
        return seekers.get(id);
    }

    public List<Seeker> getAllSeekers() {
        return new ArrayList<>(seekers.values());
    }

    public Seeker updateSeeker(Long id, Seeker seeker) {
        seeker.setId(id);
        seekers.put(id, seeker);
        return seeker;
    }

    public void deleteSeeker(Long id) {
        seekers.remove(id);
    }
}

