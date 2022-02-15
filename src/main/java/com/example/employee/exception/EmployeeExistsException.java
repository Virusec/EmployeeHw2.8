package com.example.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistsException extends RuntimeException{
    public EmployeeExistsException() {
        super("Employee Book already contains this employee.");
    }

    public EmployeeExistsException(String message) {
        super(message);
    }

    public EmployeeExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeExistsException(Throwable cause) {
        super(cause);
    }
}
