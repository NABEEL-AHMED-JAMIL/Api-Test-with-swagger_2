package com.example.demo.exception;

/**
 * Created by Nabeel on 10/17/2017.
 */
/**
 * for HTTP 400 errors
 */
public final class DataFormatException extends RuntimeException{

    public DataFormatException() {
        super();
    }

    public DataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(Throwable cause) {
        super(cause);
    }

}
