package com.example.ali.gailqms;

public class Department {

    private String deptName;
    private String id;
    private String emailId;
    private String description;

    public Department(){

    }

    public Department(String deptName, String emailId, String description , String id) {
        this.deptName = deptName;
        this.id = id;
        this.emailId = emailId;
        this.description = description;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getId() {
        return id;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getDescription() {
        return description;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
