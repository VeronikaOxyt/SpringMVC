package com.oxytoca.mvc.controller;

import com.oxytoca.mvc.employee.Employee;
import com.oxytoca.mvc.management.Director;
import com.oxytoca.mvc.management.Management;
import com.oxytoca.mvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String createDirector(Model model) {
        Management director = new Director();
        model.addAttribute("director", director);
        return "create-director";
    }

    @RequestMapping("/saveDirector")
    public String saveDirector(@ModelAttribute("director") Director director) {
        employeeService.setManagement(director);
        return "redirect:/addNewEmployee";
    }
    @RequestMapping("/allEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        Management management = employeeService.getManagement();
        model.addAttribute("director", management);
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() != 0) {
            employeeService.saveEmployee(employee);
            return "redirect:/allEmployees";
        }
        employeeService.increaseIdCounter();
        employee.setId(employeeService.getIdCounter());
        employeeService.saveEmployee(employee);
        if (employeeService.getAllEmployees().size() >= 3) {
            return "redirect:/allEmployees";
        }
        return "redirect:/addNewEmployee";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/allEmployees";
    }
}
