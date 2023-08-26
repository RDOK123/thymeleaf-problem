package com.sun.ch03.controller;

import com.sun.ch03.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    @GetMapping("/personform")
    public String form(Model model) {
        Person person = new Person(); // 將Person 實體化
        model.addAttribute("person", person);
        return "PersonForm"; // 導至form.html
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", person);
        return "add";
    }
}

//<p th:text="'Name：' + ${person.name}"></p>
//<p th:text="'Password：'+ ${person.password}"></p>
