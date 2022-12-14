package com.melck.carrertoolms.resources;

import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillsService service;

    @PostMapping
    public ResponseEntity<Skill> insert(@RequestBody Skill skill) {
        Skill newSkill = service.insert(skill);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(newSkill.getId()).toUri();
        return ResponseEntity.created(uri).body(newSkill);
    }

    @GetMapping
    public ResponseEntity<List<Skill>> findAll() {
        List<Skill> skills = service.findAll();
        return ResponseEntity.ok().body(skills);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
