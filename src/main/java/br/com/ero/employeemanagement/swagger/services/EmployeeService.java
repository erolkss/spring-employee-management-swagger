package br.com.ero.employeemanagement.swagger.services;

import br.com.ero.employeemanagement.swagger.exceptions.DataBaseException;
import br.com.ero.employeemanagement.swagger.exceptions.EmployeeNotFoundException;
import br.com.ero.employeemanagement.swagger.models.Employee;
import br.com.ero.employeemanagement.swagger.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee by id "+id+" was not found."));
    }

    public Employee updateEmployee(@Valid @NotNull Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) throws DataBaseException {
        try {
            Employee existsEmployee = this.employeeRepository
                    .findById(id)
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found.")
                    );
            this.employeeRepository.delete(existsEmployee);
        } catch (DataIntegrityViolationException ex){
            // Handle database-related exception (e.g., unique constraints violation)
            throw new DataBaseException("An error occurred while updating the employee.", ex);
        }
    }
}
