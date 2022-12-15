package com.melck.carrertoolms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.melck.carrertoolms.enums.LanguageLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_languages")
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String languageName;
    private LanguageLevel level;

    @JsonIgnore
    @ManyToMany(mappedBy = "languages")
    private Set<Resume> Resumes = new HashSet<>();
}
