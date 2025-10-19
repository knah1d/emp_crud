package com.example.emp_crud.model;

import java.util.*;

import org.hibernate.annotations.*;

// import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
@SQLDelete(sql = "UPDATE Employee SET IS_DELETED = 1 WHERE empId = ?")
@SQLRestriction("IS_DELETED = 0")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId", unique = true)
    private Long empId;
    @Column(name = "name")  
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "jobTitle")
    private String jobTitle;
    @Column(name = "department")
    private String  department;
    @Column(name = "IS_DELETED")
    private int isDeleted;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations = new ArrayList<>();
}
