package com.melck.carrertoolms.services;

import com.melck.carrertoolms.dtos.ResumeDTO;
import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.ResumeRepository;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repository;

    @Autowired
    private UserService userService;

    public Resume insert(ResumeDTO dto) {
        User user = userService.findById(dto.getUserId());
        Resume resume = new Resume();
        resume.setSkills(dto.getSkills());
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
