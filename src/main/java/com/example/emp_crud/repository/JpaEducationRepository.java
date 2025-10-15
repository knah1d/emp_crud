package com.example.emp_crud.repository;
import com.example.emp_crud.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEducationRepository extends JpaRepository<Education, Long> {

}
