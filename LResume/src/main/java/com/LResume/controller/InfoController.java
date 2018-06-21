package com.LResume.controller;

import com.LResume.model.User;
import com.LResume.model.UserInfo;
import com.LResume.service.QiniuService;
import com.LResume.service.UserInfoService;
import com.LResume.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Controller
public class InfoController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    QiniuService qiniuService;
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
        userInfoService.updateUser(username,headurl,cellphone,email);
        userInfoService.updateUserInfo(username,nickname,sex,remark);
        return JSONUtil.getJSONString(0, "成功");
    }
    @RequestMapping(path = {"/image"}, method = {RequestMethod.GET})
    @ResponseBody
    public void getImage(@RequestParam("name") String imageName,
                         HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            StreamUtils.copy(new FileInputStream(new
                    File(JSONUtil.IMAGE_DIR + imageName)), response.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(path = {"/uploadImage/"}, method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = qiniuService.saveImage(file);
            if (fileUrl == null) {
                return JSONUtil.getJSONString(1, "上传图片失败");
            }
            System.out.println(fileUrl);
            return JSONUtil.getJSONString(0, fileUrl);
        } catch (Exception e) {
            return JSONUtil.getJSONString(1, "上传失败");
        }
    }
}

