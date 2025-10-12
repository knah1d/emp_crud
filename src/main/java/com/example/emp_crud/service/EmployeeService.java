package com.example.emp_crud.service;

import com.example.emp_crud.model.Employee;
import com.example.emp_crud.repository.JpaEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private JpaEmployeeRepository jpaEmployeeRepository;

    public List<Employee> getEmployee() {
        return jpaEmployeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return jpaEmployeeRepository.findById(id).orElse(null);
    }
    public void addEmployee(Employee employee) {
        jpaEmployeeRepository.save(employee);
    }
    public void updateEmployee(Employee employee) {
        jpaEmployeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        jpaEmployeeRepository.deleteById(id);
    }
}
