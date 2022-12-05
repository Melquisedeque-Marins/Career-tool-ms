package com.melck.carrertoolms.services.exceptions;

public class ObjectIsAlreadyInUseException extends RuntimeException{
    public ObjectIsAlreadyInUseException(String message) {
        super(message);
    }

    public ObjectIsAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }
}
