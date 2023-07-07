package com.example.PracticaSpringBoot.controller;


import com.example.PracticaSpringBoot.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value="/sayHello")
    @ResponseBody
    public String printHello(){
        return "Hello Word";
    }

    //http://localhost:9898/register?name=Popescu&firstname=George
    @GetMapping(value="/register")
    @ResponseBody
    public String printParams(@RequestParam String name, @RequestParam String firstname){
        return "Hello, " + firstname +" "+ name;
    }

    //uk-en variabila de cale, este folosit daca vrei sa ai regiuni diferite de pe glob
    //http://localhost:9898/magazin/ro/products
    @GetMapping(value="/magazin/{location}/products")
    @ResponseBody
    public String printPathVariables(@PathVariable String location){
        return "Showing products for:, " + location;
    }

    @GetMapping(value="/employees")
    @ResponseBody // spune ca va retuna continutul metodei
    public List<Employee> listEmployees(){
        Employee e1= new Employee( "Paula",1, 1500 );
        Employee e2= new Employee("Teodora", 2, 200);
        return List.of(e1, e2);
    }

    //fara  @ResponseBody va returna index.html
    @GetMapping(value="/index")
    public String index(Model model){
        String text="Hello from controller";
        model.addAttribute("greetings", text);

        List<String> carList=List.of("Dacia", "Ford", "Suzuki", "BMW");
        model.addAttribute("someText", carList);

        Employee e1= new Employee( "Paula",1, 1500 );
        Employee e2= new Employee("Teodora", 2, 200);
        List<Employee> employeeList=List.of(e1,e2);
        model.addAttribute("employeeList", employeeList);

        return "index";
    }



}
