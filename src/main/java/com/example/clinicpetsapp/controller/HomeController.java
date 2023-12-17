package com.example.clinicpetsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // You can add any model attributes needed for your homepage
        return "home"; // This should be the name of your Thymeleaf template file (e.g., home.html)
    }
}
