package br.com.ero.employeemanagement.swagger.controllers;

import br.com.ero.employeemanagement.swagger.exceptions.DataBaseException;
import br.com.ero.employeemanagement.swagger.models.Employee;
import br.com.ero.employeemanagement.swagger.services.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "Employee Management", description = "Operations are related to employee management.")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Add an employee.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created", response = Employee.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody @ApiParam(value = "Employee details", required = true) Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Ger all employees.")
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @ApiOperation(value = "Get employee by Id.")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ApiOperation(value = "Update an employee.")
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an employee by Id.")
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) throws DataBaseException {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @ApiOperation(value = "Calculate Square",
//    notes = "Calculates the square of given number. " + "Example: If you send '3' as input, the response will be '9'.")
//    @GetMapping("/square")
//    public ResponseEntity<Integer> calculateSquare(@RequestParam("number") int number){
//        return null;
//    }
}
