package com.projects.java.bestoftheyear.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("homepage")
    public String home(Model model){
        model.addAttribute("name", "Paolo");
        return "homepage";
    }

}
