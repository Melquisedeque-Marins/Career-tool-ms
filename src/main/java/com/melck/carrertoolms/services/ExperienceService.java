package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.Experience;
import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.repositories.ExperienceRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    @Transactional
    public Experience insert(Experience experience) {
        return repository.save(experience);
    }

    @Transactional(readOnly = true)
    public Experience findById(Long id) {
        Optional<Experience> experience = repository.findById(id);
        return experience.orElseThrow(() -> new ObjectNotFoundException("Experienca não encontrada"));
    }

    @Transactional(readOnly = true)
    public List<Experience> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        Experience experience = findById(id);
        repository.delete(experience);
    }

    public Experience update(Long id, Experience dto) {
        Experience experience = findById(id);
        dto.setId(experience.getId());
        return repository.save(dto);
    }
}
