package com.melck.carrertoolms.dtos;

import com.melck.carrertoolms.entities.Experience;
import com.melck.carrertoolms.entities.Language;
import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.entities.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.language.bm.Languages;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO implements Serializable {

    private Long id;

    private Set<Skill> skills = new HashSet<>();

    private Set<Experience> experiences = new HashSet<>();

    private Set<Language> languages = new HashSet<>();

    public ResumeDTO(Resume resume) {

    }
}
