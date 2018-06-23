package com.LResume.controller;

import com.LResume.dao.UserDAO;
import com.LResume.model.User;
import com.LResume.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SecurityController {
    @Autowired
    UserDAO userDAO;
    @RequestMapping(path = {"/user/updatepage"},method = {RequestMethod.GET,RequestMethod.POST})
    public String form(){
        return "updatepass";
    }
    @RequestMapping(path = {"/user/updatePass"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String updatePass(Model model,
                             @RequestParam("userId") int userId,
                             @RequestParam("oldPass") String oldPass,
                             @RequestParam("newPass") String newPass,
                             HttpServletResponse response){
        User user = userDAO.selectById(userId);
        System.out.println(user.getSalt());
        String salt = user.getSalt();
        if(JSONUtil.MD5(oldPass+salt).equals(user.getPassword())){
            user.setPassword(JSONUtil.MD5(newPass+salt));
            userDAO.updatePassword(user);
            return JSONUtil.getJSONString(0,"修改成功");
        }else{
            return JSONUtil.getJSONString(-1,"旧密码错误");
        }
    }
}
