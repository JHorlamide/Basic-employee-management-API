package com.springBackend.springBootBackend.controllers;

import com.springBackend.springBootBackend.Service.EmployeeService;
import com.springBackend.springBootBackend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*
    * POST: Create new Employee
    * ROUTE: /api/employee
    * */
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


    /*
     * GET: Get all employees
     * ROUTE: /api/employees
     * */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    /*
     * GET: Get employees by ID
     * ROUTE: /api/employees/1
     * */
    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    /*
     * PUT: Get employees by ID
     * ROUTE: /api/employees/1
     * */
    @PutMapping("{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId")  Long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    /*
     * DELETE: Get employees
     * ROUTE: /api/employees/1
     * */
    @DeleteMapping("{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long id){
        //Delete Employee
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
    }
}
