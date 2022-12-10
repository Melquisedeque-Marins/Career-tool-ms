package com.melck.carrertoolms.resources;

import com.melck.carrertoolms.entities.Experience;
import com.melck.carrertoolms.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    public ResponseEntity<Experience> insert(@RequestBody Experience experience) {
        Experience newExp = service.insert(experience);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newExp.getId()).toUri();
        return ResponseEntity.created(uri).body(newExp);
    }
}
