package com.melck.carrertoolms.dtos;

import com.melck.carrertoolms.entities.Resume;
import com.melck.carrertoolms.entities.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {

    private Long id;

    @NotNull
    private Long userId;

    private HashMap<String, String> skills;

    public ResumeDTO(Resume resume) {
        this.id = resume.getId();
        this.userId = resume.getUser().getUserId();
    }
}
