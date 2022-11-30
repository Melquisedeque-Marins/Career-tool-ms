package com.melck.carrertoolms.dtos;

import com.melck.carrertoolms.entities.Resume;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO {

    private Long id;

    @NotNull
    private Long userId;

    public ResumeDTO(Resume resume) {
        this.id = resume.getId();
        this.userId = resume.getUser().getUserId();
    }
}
