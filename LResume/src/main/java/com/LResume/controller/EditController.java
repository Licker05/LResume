package com.LResume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println(request.getParameter("desc"));
        return "123";
    }
}
