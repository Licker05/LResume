package com.LResume.service;

import com.LResume.dao.UserDAO;
import com.LResume.dao.UserInfoDAO;
import com.LResume.model.User;
import com.LResume.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserInfoDAO userInfoDAO;

    public void updateUserInfo(String username,String nickname,String sex,String remark){
        UserInfo userInfo=new UserInfo();
        userInfo.setNickname(nickname);
        userInfo.setSex(sex);
        userInfo.setRemark(remark);
        userInfo.setUserId(userDAO.selectByName(username).getId());
        userInfoDAO.updateUserInfo(userInfo);
    }
    public void updateUser(String username,String headurl,String cellphone,String email){
        User user = new User();
        user.setHeadurl(headurl);
        user.setPhone(cellphone);
        user.setEmail(email);
        user.setName(username);
        userDAO.updateUser(user);

    }
}
