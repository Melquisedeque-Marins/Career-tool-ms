package com.melck.carrertoolms.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDTO implements Serializable {

    private Long id;

    @NotNull
    private Long userId;

    private Long skillId;

}
