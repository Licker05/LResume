package com.LResume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditController {
    @RequestMapping(path = {"/form"},method = {RequestMethod.GET,RequestMethod.POST})
    public String form(){
        return "form";
    }
}
