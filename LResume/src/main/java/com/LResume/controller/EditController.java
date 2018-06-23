package com.LResume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class EditController {
    @RequestMapping(path = {"/form"},method = {RequestMethod.GET,RequestMethod.POST})
    public String form(){
        return "form";
    }
    @RequestMapping(path = {"/resumeedit"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String resumeedit(Model model,
                             HttpServletRequest request,
                             HttpServletResponse response){
        System.out.println(request.getParameter("politics"));
//        System.out.println(politics);
//        for(String job:jobstarttime){
//            System.out.println(job);
//        }
        return "123";
    }
}
