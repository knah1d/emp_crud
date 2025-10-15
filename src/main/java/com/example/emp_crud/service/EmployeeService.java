package com.example.emp_crud.service;

import com.example.emp_crud.model.Employee;
import com.example.emp_crud.repository.JpaEmployeeRepository;
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
        employee.getEducations().forEach(edu -> edu.setEmployee(employee));
        jpaEmployeeRepository.save(employee);
    }
    @Override
    public Employee updateEmployee(Long id, Employee updatedData) {
        Employee existingEmployee = jpaEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existingEmployee.setName(updatedData.getName());
        existingEmployee.setEmail(updatedData.getEmail());
        existingEmployee.setJobTitle(updatedData.getJobTitle());
        existingEmployee.setDepartment(updatedData.getDepartment());
        existingEmployee.setIsDeleted(updatedData.getIsDeleted());

        if (updatedData.getEducations() != null) {
            existingEmployee.getEducations().clear();
            updatedData.getEducations().forEach(edu -> edu.setEmployee(existingEmployee));
            existingEmployee.getEducations().addAll(updatedData.getEducations());
        }

        return jpaEmployeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        jpaEmployeeRepository.deleteEmployee(id);
    }
}
