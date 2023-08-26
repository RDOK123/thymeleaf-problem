package com.sun.ch03.controller;

import com.sun.ch03.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class DemoController {
    @RequestMapping("/handle")
    public String handle(@RequestParam("username") String name){
        System.out.println(name);
        return  "Afinsh";
    }

    @RequestMapping("/obj")
    public String handleObj(User user){
        System.out.println(user);
        return  "BFinsh";
    }

    @RequestMapping("/json")
    public String handleJson(@RequestBody User user){
        System.out.println(user);
        return "Cfinish";
    }

    @RequestMapping("/temp/{name}/{id}")
    public String handleUrl(@PathVariable Map pathMap){
        System.out.println(pathMap);
        return "Dfinish";
    }

    @PostMapping("/file")
    public String handleFile(@RequestPart(name="file")List<MultipartFile> multipartFiles){
        for(MultipartFile multipartFile : multipartFiles){
            System.out.println("file name:"+multipartFile.getOriginalFilename());
            System.out.println("file size: "+multipartFile.getSize());
        }
        return "Efinish";
    }

    @RequestMapping("/header")
    public String handleHeader(@RequestHeader("User-Agent") String userAgent){
        System.out.println(userAgent);
        return "redirect:home";
    }

    @GetMapping("/login")
    public String doLogin(Model model){
        model.addAttribute("msg","plz login");
        return "login";
    }

    @GetMapping("/login2")
    public ModelAndView doLogin2(){
        return  new ModelAndView("login","msg","plz login");
    }

    @RequestMapping("/handle2")
    public HttpEntity<String> handle(){
        HttpHeaders responseHeaders=new HttpHeaders();
        responseHeaders.set("MyResponsHeader","MyValue");
        return new HttpEntity<String>("Hello !",responseHeaders);
    }
}
