package com.LResume.service;

import com.LResume.dao.UserDAO;
import com.LResume.utils.JSONUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import com.LResume.model.User;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public Map<String, Object> register(String username, String password,String cellphone,String email) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msgpwd", "密码不能为空");
            return map;
        }
        if(username.length()<6){
            map.put("msgname","用户名必须大于等于6位");
            return map;
        }
        if(password.length()<6){
            map.put("msgpwd","密码必须大于6位");
            return map;
        }
        User user = userDAO.selectByName(username);

        if (user != null) {
            map.put("msgname", "用户名已经被注册");
            return map;
        }

        // 密码强度
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        String head = String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000));
        user.setHead_url(head);
        user.setPassword(JSONUtil.MD5(password+user.getSalt()));
        user.setPhone(cellphone);
        user.setEmail(email);
        ;

        // 登陆
//        String ticket = addLoginTicket(user.getId());
//        map.put("ticket", ticket);
        if(userDAO.addUser(user)!=0){
            map.put("RegCode",1);
        }else{
            map.put("RegCode",0);
        }
        return map;
    }

}
