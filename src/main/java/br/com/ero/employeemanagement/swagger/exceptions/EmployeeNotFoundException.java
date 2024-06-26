package br.com.ero.employeemanagement.swagger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 123635591137869829L;

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
