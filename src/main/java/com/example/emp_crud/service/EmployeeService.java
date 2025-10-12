package com.example.emp_crud.application.service;

import com.example.emp_crud.domain.model.Employee;
import com.example.emp_crud.domain.repository.EmployeeRepository;
import com.example.emp_crud.domain.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeUseCase {
    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeUseCase(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    public Employee createEmployee(Employee employee) {
        employeeService.validateEmployee(employee);
        return employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }
}
