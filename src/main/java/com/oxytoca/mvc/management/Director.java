package com.oxytoca.mvc.management;

import com.oxytoca.mvc.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Iterator;
import java.util.List;

@Repository
public class Director implements Management {
    private String fullName;
    private String department;
    List<Employee> employeesStaff;

    public Director() {
    }

    public Director(String fullName, String department) {
        this.fullName = fullName;
        this.department = department;
    }

    @Override
    public String getFullName() {
        return fullName;
    }
    @Override
    public String getDepartment() {
        return department;
    }

    @Override
    public List<Employee> getEmployeesStaff() {
        return employeesStaff;
    }

    @Autowired
    public void setEmployeesStaff(List<Employee> employeesStaff) {
        this.employeesStaff = employeesStaff;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void saveEmployee(Employee employee) {
        for (Employee value : employeesStaff) {
            if (value.getId() == employee.getId()) {
                value.setFullName(employee.getFullName());
                value.setDepartment(employee.getDepartment());
                return;
            }
        }
        employeesStaff.add(employee);
    }

    @Override
        public Employee getEmployee(int id) {
        Employee employee = null;
        for (Employee value : employeesStaff) {
            if (value.getId() == id) {
                employee = value;
            }
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        for (Iterator<Employee> iterator = employeesStaff.iterator(); iterator.hasNext();) {
            Employee employee = iterator.next();
            if(employee.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Director{" +
                "fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
