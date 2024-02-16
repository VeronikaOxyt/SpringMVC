package com.oxytoca.mvc.service;

import com.oxytoca.mvc.employee.Employee;
import com.oxytoca.mvc.management.Management;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEmployeeService implements EmployeeService {
    @Autowired
    private Management management;
    private int idCounter = 0;
    @Override
    public void setManagement(Management management) {
        this.management.setFullName(management.getFullName());
        this.management.setDepartment(management.getDepartment());
    }
    @Override
    public int getIdCounter() {
        return idCounter;
    }
    @Override
    public void increaseIdCounter() {
        idCounter++;
    }

    @Override
    public Management getManagement() {
        return management;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return management.getEmployeesStaff();
    }

    @Override
    public void saveEmployee(Employee employee) {
        management.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return management.getEmployee(id);
    }

    @Override
    public void deleteEmployee(int id) {
        management.deleteEmployee(id);
    }
}
