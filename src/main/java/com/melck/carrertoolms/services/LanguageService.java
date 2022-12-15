package com.melck.carrertoolms.services;

import com.melck.carrertoolms.entities.Language;
import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.repositories.LanguageRepository;
import com.melck.carrertoolms.repositories.SkillRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository repository;

    public Language insert(Language language) {
        return repository.save(language);
    }

    public List<Language> findAll() {
        return repository.findAll();
    }

    public Language findById(Long id) {
        Optional<Language> language = repository.findById(id);
        return language.orElseThrow(() -> new ObjectNotFoundException("Não foi possivel encontrar este curriculo"));
    }

    public void delete(Long id) {
        Language language = findById(id);
        repository.delete(language);
    }
}
