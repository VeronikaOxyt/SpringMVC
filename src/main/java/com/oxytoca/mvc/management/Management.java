package com.oxytoca.mvc.management;

import com.oxytoca.mvc.employee.Employee;

import java.util.List;

public interface Management {
    public void setEmployeesStaff(List<Employee> employeesStaff);

    String getFullName();

    String getDepartment();

    public List<Employee> getEmployeesStaff();

    void setFullName(String fullName);

    void setDepartment(String department);

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    void deleteEmployee(int id);
}
