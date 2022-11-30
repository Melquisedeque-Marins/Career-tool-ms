package com.melck.carrertoolms.services;

import com.melck.carrertoolms.dtos.ResumeDTO;
import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.entities.User;
import com.melck.carrertoolms.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repository;

    @Autowired
    private UserService userService;

    public Resume insert(ResumeDTO dto) {
        User user = userService.findById(dto.getUserId());
        Resume resume = new Resume();
        resume.setUser(user);
        repository.save(resume);
        return resume;
    }
}
