package com.example.emp_crud.dto;


public class EmployeeSummary {
    private String department;
    private String email;
    private String jobTitle;
    private String name;

        public EmployeeSummary(String department, String email, String jobTitle, String name) {
        this.department = department;
        this.email = email;
        this.jobTitle = jobTitle;
        this.name = name;
    }

    // getters (and optionally setters)
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
    public String getJobTitle() { return jobTitle; }
    public String getName() { return name; }

}