package com.example.emp_crud.domain.model;

public class Employee {

    private Long empId;
    private String name;
    private String email;
    private String jobTitle;
    private String  department;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

    public Employee(Long empId, String name, String email, String jobTitle, String department) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.department = department;
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
    }

    // getters and setters

    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

}
