package br.com.ero.employeemanagement.swagger.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class DataBaseException extends Throwable {
    public DataBaseException(String message, DataIntegrityViolationException ex) {
        super(message, ex);
    }
}
