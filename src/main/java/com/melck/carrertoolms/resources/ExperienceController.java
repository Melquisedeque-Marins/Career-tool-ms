package com.melck.carrertoolms.resources;

import com.melck.carrertoolms.entities.Experience;
import com.melck.carrertoolms.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    @Autowired
    private ExperienceService service;

    @PostMapping
    public ResponseEntity<Experience> insert(@RequestBody Experience experience) {
        Experience newExp = service.insert(experience);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newExp.getId()).toUri();
        return ResponseEntity.created(uri).body(newExp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> findById(@PathVariable Long id) {
        Experience exp = service.findById(id);
        return ResponseEntity.ok().body(exp);
    }

    @GetMapping
    public ResponseEntity<List<Experience>> findAll() {
        List<Experience> experiences = service.findAll();
        return ResponseEntity.ok().body(experiences);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
