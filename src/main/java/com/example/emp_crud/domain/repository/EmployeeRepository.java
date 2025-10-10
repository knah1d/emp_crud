package com.example.emp_crud.domain.repository;

import com.example.emp_crud.domain.model.Employee;
import java.util.Optional;
public interface EmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
}
