package com.example.emp_crud.domain.service;

import com.example.emp_crud.domain.model.Employee;

public class EmployeeService {
    public void validateEmployee(Employee employee) {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        if (employee.getEmail() == null || employee.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Employee email cannot be empty");
        }
        if (employee.getDepartment() == null || employee.getDepartment().isEmpty()) {
            throw new IllegalArgumentException("Employee department cannot be empty");
        }
    }
}
