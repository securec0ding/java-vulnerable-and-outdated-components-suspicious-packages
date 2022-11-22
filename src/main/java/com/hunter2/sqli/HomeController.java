package com.hunter2.sqli;

import com.hunter2.sqli.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String serveHome(Model model) {
        model.addAttribute("employees", Collections.emptyList());
        return "home";
    }

    @GetMapping("/employees")
    public String search(@RequestParam(defaultValue = "") String query, @RequestParam(defaultValue = "name") String order, Model model) {
        model.addAttribute("employees", employeeService.getEmployeesByName(query, new Sort(order)));
        return "home";
    }


}