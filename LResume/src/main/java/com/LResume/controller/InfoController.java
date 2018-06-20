package com.LResume.controller;

import com.LResume.model.User;
import com.LResume.model.UserInfo;
import com.LResume.service.UserInfoService;
import com.LResume.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class InfoController {
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping(path = {"/user/info/{userId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model, @PathVariable("userId") int userId) {
        return "info";
    }

    @RequestMapping(path = {"/inform"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String inform(Model model, @RequestParam("username")String username,
                         @RequestParam("nickname") String nickname,
                         @RequestParam("sex") String sex,
                         @RequestParam("headurl") String headurl,
                         @RequestParam("cellphone")String cellphone,
                         @RequestParam("email") String email,
                         @RequestParam("remark") String remark,
                         HttpServletResponse res){
//        System.out.println("username = "+username);
//        System.out.println("nickname = "+nickname);
//        System.out.println("sex = "+sex);
//        System.out.println("headurl = "+headurl);
//        System.out.println("cellphone = "+cellphone);
//        System.out.println("email = "+email);
//        System.out.println("remark = "+remark);
        userInfoService.updateUser(username,headurl,cellphone,email);
        userInfoService.updateUserInfo(username,nickname,sex,remark);
        return JSONUtil.getJSONString(0, "成功");
    }

}

