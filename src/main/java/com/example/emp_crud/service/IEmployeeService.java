package com.example.emp_crud.service;

import com.example.emp_crud.model.Employee;
import java.util.List;

public interface IEmployeeService {
    public List<Employee> getEmployee();
    public Employee getEmployeeById(Long id);
    public void addEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Long id);
}
