package com.LResume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InfoController {
    @RequestMapping(path = {"/user/info/{userId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model, @PathVariable("userId") int userId) {
        return "info";
    }
}
