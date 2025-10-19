package com.example.emp_crud.service;

import com.example.emp_crud.model.Employee;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> getEmployee();
    public Employee getEmployeeById(Long id);
    public void addEmployee(Employee employee);
    public Employee updateEmployee(Long id, Employee employee);
    public void deleteEmployee(Long id);
    public List<Employee> getEmployeeByName(String name);
    public Boolean existsByEmail(String email);
}
