package com.daodao520.LResume.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping(path={"/"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String reg(){
        return "hello SpringBoot";
    }
}
