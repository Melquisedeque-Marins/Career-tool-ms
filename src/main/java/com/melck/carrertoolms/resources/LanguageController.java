package com.melck.carrertoolms.resources;

import com.melck.carrertoolms.entities.Language;
import com.melck.carrertoolms.entities.Skill;
import com.melck.carrertoolms.services.LanguageService;
import com.melck.carrertoolms.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService service;

    @PostMapping
    public ResponseEntity<Language> insert(@RequestBody Language language) {
        Language newLanguage = service.insert(language);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(newLanguage.getId()).toUri();
        return ResponseEntity.created(uri).body(newLanguage);
    }

    @GetMapping
    public ResponseEntity<List<Language>> findAll() {
        List<Language> languages = service.findAll();
        return ResponseEntity.ok().body(languages);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
