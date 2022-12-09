package com.melck.carrertoolms.services;

import com.melck.carrertoolms.dtos.ResumeDTO;
import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.ResumeRepository;
import com.melck.carrertoolms.repositories.SkillRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Transactional
    public Resume insert(ResumeDTO dto) {
        User user = userService.findById(dto.getUserId());
        Resume resume = new Resume();

        if (dto.getSkillId() != null) {
            Skill skill = skillsService.findById(dto.getSkillId());
        resume.getSkills().add(skill);
        }
        if (!dto.getSkills().isEmpty()) {
            for (Skill s : dto.getSkills() ) {
                skillsService.insert(s);
                resume.getSkills().add(s);
            }
        }
        resume.setUser(user);
        repository.save(resume);
        return resume;
    }

    public List<Resume> findAll() {
        return repository.findAll();
    }

    public Resume findById(Long id) {
        Optional<Resume> resume = repository.findById(id);
        return resume.orElseThrow(() -> new ObjectNotFoundException("Não foi possivel encontrar este curriculo"));
    }
}
