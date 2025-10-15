package com.example.emp_crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eduId", unique = true)
    private Long id;
    @Column(name = "Name of Degree")  
    private String degree;
    @Column(name = "Board/University")
    private String board;
    @Column(name = "Result")
    private String result;
    @Column(name = "Passing Year")
    private String passingYear;

    @ManyToOne
    @JoinColumn(name = "empId")
    @JsonIgnore
    private Employee employee;

}
