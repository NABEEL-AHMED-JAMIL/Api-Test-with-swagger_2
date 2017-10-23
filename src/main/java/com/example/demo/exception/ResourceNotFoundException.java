package com.example.demo.exception;

/**
 * Created by Nabeel on 10/17/2017.
 */
/**
 * For HTTP 404 errros
 */
public final class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() { super(); }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
