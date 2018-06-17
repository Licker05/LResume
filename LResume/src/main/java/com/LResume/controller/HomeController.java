package com.LResume.controller;

import com.LResume.service.UserService;
import com.LResume.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class HomeController {
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
    @RequestMapping(path={"/register"},method = {RequestMethod.GET,RequestMethod.POST})
    public String register(){
        return "register";
    }
    @RequestMapping(path={"/reg"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("cellphone") String cellphone,
                           @RequestParam("email") String email,
                           HttpServletResponse response){
        Map<String, Object> map = userService.register(username, password,cellphone,email);
        if((int)map.get("RegCode")==1){
            return JSONUtil.getJSONString(1,"注册成功");
        }else{
            return JSONUtil.getJSONString(-1,"注册失败");
        }

    }
}
