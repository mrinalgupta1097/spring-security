package com.mrinalgupta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
    @GetMapping("/signin")
    public String signin(){
        return "login.html";
    }
}
