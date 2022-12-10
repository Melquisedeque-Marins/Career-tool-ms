package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.Experience;
import com.melck.carrertoolms.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    public Experience insert(Experience experience) {
        return repository.save(experience);
    }
}
