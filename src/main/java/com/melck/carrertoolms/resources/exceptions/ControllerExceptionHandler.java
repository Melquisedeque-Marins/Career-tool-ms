package com.melck.carrertoolms.resources.exceptions;


import com.melck.carrertoolms.services.exceptions.ForbiddenException;
import com.melck.carrertoolms.services.exceptions.ObjectIsAlreadyInUseException;
import com.melck.carrertoolms.services.exceptions.ObjectNotFoundException;
import com.melck.carrertoolms.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    Instant now = Instant.now();

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(now, HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationException(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError error = new ValidationError(now, HttpStatus.BAD_REQUEST.value(), request.getRequestURI() , "Field validation error - please check the fields above");

        for (FieldError x : e.getBindingResult().getFieldErrors()){
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ObjectIsAlreadyInUseException.class)
    public ResponseEntity<StandardError> objectIsAlreadyException(ObjectIsAlreadyInUseException e, HttpServletRequest request){
        StandardError error = new StandardError(now, HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<OauthCustomError> forbidden(ForbiddenException e, HttpServletRequest request){
        OauthCustomError error = new OauthCustomError("Forbidden", e.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<OauthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request){
        OauthCustomError error = new OauthCustomError("Unauthorized", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
