package com.example.PracticaSpringBoot.controller;

import com.example.PracticaSpringBoot.model.Employee;

import com.example.PracticaSpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/employeeOverview")
    public String index(Model model) {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);

        return "employeeOverview";
    }

    @GetMapping(value = "/employeeForm")
    public String getEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @PostMapping(value = "/submitEmployee")
    public String submitEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        employeeRepository.save(employee);
        return "redirect:/employeeOverview";
    }

    @GetMapping(value = "/deleteEmployee")
    public String submitEmployee(@RequestParam("id") int employeeId) {
        employeeRepository.deleteById(employeeId);
        return "redirect:/employeeOverview";
    }

    @GetMapping(value = "/findEmployee")
    @ResponseBody
    public Employee findEmployee(@RequestParam("id") int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

}
