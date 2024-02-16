package com.oxytoca.mvc.service;

import com.oxytoca.mvc.employee.Employee;
import com.oxytoca.mvc.management.Management;

import java.util.List;

public interface EmployeeService {
    void setManagement(Management management);

    int getIdCounter();

    void increaseIdCounter();

    Management getManagement();

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

}
