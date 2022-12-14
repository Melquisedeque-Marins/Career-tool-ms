package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.repositories.SkillRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    @Autowired
    private SkillRepository repository;

    public Skill insert(Skill skill) {
        return repository.save(skill);
    }

    public List<Skill> findAll() {
        return repository.findAll();
    }

    public Skill findById(Long id) {
        Optional<Skill> skill = repository.findById(id);
        return skill.orElseThrow(() -> new ObjectNotFoundException("Não foi possivel encontrar este curriculo"));
    }

    public void delete(Long id) {
        Skill skill = findById(id);
        repository.delete(skill);
    }



}
