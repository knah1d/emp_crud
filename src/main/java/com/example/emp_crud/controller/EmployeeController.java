package com.example.emp_crud.controller;

import com.example.emp_crud.service.IEmployeeService;
import com.example.emp_crud.model.Employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployee();
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        if (employeeService.existsByEmail(employee.getEmail())) {
            return ResponseEntity.status(409).body(Map.of("error", "Email already exists"));
        }
        employeeService.addEmployee(employee);
        return ResponseEntity.ok(Map.of("message", "Employee added successfully"));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "Employee deleted successfully";
    }
}
