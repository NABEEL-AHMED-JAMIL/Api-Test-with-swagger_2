package com.example.demo.exception;

/**
 * Created by Nabeel on 10/17/2017.
 */
/**
 * For HTTP 401 errros
 */
public final class SyntaxException extends RuntimeException {

    public SyntaxException() {
        super();
    }

    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyntaxException(String message) {
        super(message);
    }

    public SyntaxException(Throwable cause) {
        super(cause);
    }
}
