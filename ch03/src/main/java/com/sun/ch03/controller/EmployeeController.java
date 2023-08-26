package com.sun.ch03.controller;

import com.sun.ch03.model.Emploee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class EmployeeController {
    @GetMapping("/showEmployee")
    public String showPvcData(Model model) {

        Emploee emp1=new Emploee("Joy");
        List<Emploee> emps=new ArrayList<>();
        emps.add(emp1);
        model.addAttribute("emps",emps);

        System.out.println("!!!!!!!!!!!!");
        System.out.println("Model attribute 'emps': " + model.getAttribute("emps"));
        System.out.println("!!!!!!!!!!!!");

        return "empView";
    }
}
