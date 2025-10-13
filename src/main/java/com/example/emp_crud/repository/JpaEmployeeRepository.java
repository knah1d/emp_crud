package com.example.emp_crud.repository;

import com.example.emp_crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.isDeleted = 0")
    List<Employee> findAllActiveEmployees();

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.isDeleted = 1 WHERE e.empId = ?1")
    void deleteEmployee(Long id);
}
