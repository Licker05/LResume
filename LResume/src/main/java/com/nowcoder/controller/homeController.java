package com.nowcoder.controller;

import com.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class homeController {
    @Autowired
    UserService userService;
    @RequestMapping(path={"/"},method = {RequestMethod.GET,RequestMethod.POST})
    public String home(){
        return "home";
    }
    @RequestMapping(path={"/login"},method = {RequestMethod.GET,RequestMethod.POST})
    public String login(){
        return "login";
    }
    @RequestMapping(path={"/reg"},method = {RequestMethod.GET,RequestMethod.POST})
    public String register(Model model, @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam(value="rember", defaultValue = "0") int rememberme,
                           HttpServletResponse response){
        return "register";
    }
}
