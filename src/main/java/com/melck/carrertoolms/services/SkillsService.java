package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {

    @Autowired
    private SkillRepository repository;

    public Skill insert(Skill skill) {
        return repository.save(skill);
    }

}
