package com.springapp.mvc.exception;

/**
 * Created by root on 11/9/15.
 */
public class DatabaseException  extends Exception{

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
