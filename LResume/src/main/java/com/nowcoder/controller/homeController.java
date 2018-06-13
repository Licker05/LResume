package com.nowcoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class homeController {
    @RequestMapping(path={"/"},method = {RequestMethod.GET,RequestMethod.POST})
    public String home(){
        return "home";
    }
    @RequestMapping(path={"/login"},method = {RequestMethod.GET,RequestMethod.POST})
    public String login(){
        return "login";
    }
    @RequestMapping(path={"/register"},method = {RequestMethod.GET,RequestMethod.POST})
    public String register(){
        return "register";
    }
}
