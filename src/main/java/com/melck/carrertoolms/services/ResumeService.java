package com.melck.carrertoolms.services;

import com.melck.carrertoolms.dtos.ResumeDTO;
import com.melck.carrertoolms.entities.*;
import com.melck.carrertoolms.repositories.ResumeRepository;
import com.melck.carrertoolms.repositories.SkillRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repository;

    @Autowired
    private SkillsService skillsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private AuthService authService;

    @Transactional
    public Resume insert(ResumeDTO dto) {
        Resume resume = new Resume();
        resume.setVersion(1L);

        User user = authService.authenticated();

        if (!dto.getSkills().isEmpty()) {
            for (Skill s : dto.getSkills() ) {
                skillsService.insert(s);
                resume.getSkills().add(s);
            }
        }
        if (!dto.getExperiences().isEmpty()) {
            for (Experience e : dto.getExperiences() ) {
                experienceService.insert(e);
                resume.getExperiences().add(e);
            }
        }
        if (!dto.getLanguages().isEmpty()) {
            for (Language l : dto.getLanguages() ) {
                languageService.insert(l);
                resume.getLanguages().add(l);
            }
        }
        resume.setUser(user);
        repository.save(resume);
        return resume;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public List<Resume> findAll() {
        return repository.findAll();
    }

    public Resume findById(Long id) {
        Optional<Resume> resume = repository.findById(id);
        return resume.orElseThrow(() -> new ObjectNotFoundException("Não foi possivel encontrar este curriculo"));
    }
}
