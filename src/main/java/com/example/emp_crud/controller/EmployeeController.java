package com.example.emp_crud.controller;


import com.example.emp_crud.service.EmployeeService;
import com.example.emp_crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added successfully";
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
