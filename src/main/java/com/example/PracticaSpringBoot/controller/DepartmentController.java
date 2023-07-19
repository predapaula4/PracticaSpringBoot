package com.example.PracticaSpringBoot.controller;

import com.example.PracticaSpringBoot.model.Department;
import com.example.PracticaSpringBoot.model.Department;
import com.example.PracticaSpringBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @GetMapping(value = "/departmentOverview")
    public String departmentOverview(Model model) {
        List<Department> departmentList = departmentRepository.findAll();
        model.addAttribute("departmentList", departmentList);

        return "departmentOverview";
    }

}
