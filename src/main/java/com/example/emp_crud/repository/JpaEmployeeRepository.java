package com.example.emp_crud.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emp_crud.model.Employee;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    boolean existsByEmail(String email);
}
