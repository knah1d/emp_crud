package com.example.emp_crud.model;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
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
    @Column(name = "isDeleted")
    private int isDeleted;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations = new ArrayList<>();
}
