package com.example.emp_crud.service;

import com.example.emp_crud.model.Employee;
import com.example.emp_crud.repository.JpaEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService implements IEmployeeService {


    private final JpaEmployeeRepository jpaEmployeeRepository;

    public EmployeeService(JpaEmployeeRepository jpaEmployeeRepository) {
        this.jpaEmployeeRepository = jpaEmployeeRepository;
    }

    @Override
    public List<Employee> getEmployee() {
        return jpaEmployeeRepository.findAllActiveEmployees();
    }
    @Override
    public Employee getEmployeeById(Long id) {
        return jpaEmployeeRepository.findById(id).orElse(null);
    }
    @Override
    public void addEmployee(Employee employee) {
        employee.setIsDeleted(0);
        jpaEmployeeRepository.save(employee);
    }
    @Override
    public void updateEmployee(Employee employee) {
        jpaEmployeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(Long id) {
        jpaEmployeeRepository.deleteEmployee(id);
    }
}
