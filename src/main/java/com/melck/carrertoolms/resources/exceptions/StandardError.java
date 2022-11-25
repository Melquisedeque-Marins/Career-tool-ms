package com.melck.carrertoolms.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private String path;

}
