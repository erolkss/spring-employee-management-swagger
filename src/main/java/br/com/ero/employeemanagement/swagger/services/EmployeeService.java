package br.com.ero.employeemanagement.swagger.services;

import br.com.ero.employeemanagement.swagger.models.Employee;
import br.com.ero.employeemanagement.swagger.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
