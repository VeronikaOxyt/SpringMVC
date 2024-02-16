package com.oxytoca.mvc.employee;

public class Employee {
    private String fullName;
    private String department;
    private int id;

    public Employee(String fullName, String department, int id) {
        this.fullName = fullName;
        this.department = department;
        this.id = id;
    }
    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", id='" + id + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
