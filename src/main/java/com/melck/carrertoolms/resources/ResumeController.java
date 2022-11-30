package com.melck.carrertoolms.resources;

import com.melck.carrertoolms.dtos.ResumeDTO;
import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeService service;

    @PostMapping
    public ResponseEntity<Resume> insert(@RequestBody ResumeDTO dto) {
        Resume newResume = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newResume.getId()).toUri();
        return ResponseEntity.created(uri).body(newResume);
    }

}
