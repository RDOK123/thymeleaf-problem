package com.sun.ch03.controller;

import com.sun.ch03.model.Pvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // pvcView.html error
//@RestController
public class PvcController {

    // 這個 @ModelAttribute 方法會在此控制器的任何請求處理方法之前被調用
    @ModelAttribute
    public void setupModelAttributes(Model model) {
        // 這只是一個範例，你可以在這裡設定任何你需要的預設屬性。
        model.addAttribute("message", "Welcome to PVC management!");
    }

    @GetMapping("/pvcForm")
    public String displayForm(Model model) {
        // 因為 @ModelAttribute 方法的設定，當這個方法被調用時 "message" 已經在模型中。
        return "pvcForm";
    }

    @PostMapping("/submitPvc")
    public String submitPvc(@ModelAttribute Pvc pvc, Model model) {

        model.addAttribute("pvcData", pvc);
        return "pvcView";
    }

    @GetMapping("/showPvcData")
    public String showPvcData(Model model) {

        Pvc pvc = new Pvc(10, 100);  // 或其他初始化方式
        model.addAttribute("pvcData", pvc);

        System.out.println("!!!!!!!!!!!!");
        System.out.println("Model attribute 'pvcData': " + model.getAttribute("pvcData"));
        System.out.println("!!!!!!!!!!!!");

        return "pvcView";
    }


}

//<p th:text="${pvcData.size}">RRR</p>