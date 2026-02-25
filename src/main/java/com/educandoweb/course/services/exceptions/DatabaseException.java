package com.educandoweb.course.services.exceptions;

public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    //construtor com String
    public DatabaseException(String msg) {
        super(msg);
    }
}
