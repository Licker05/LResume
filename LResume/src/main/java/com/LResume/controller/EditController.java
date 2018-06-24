package com.LResume.controller;

import com.LResume.model.HostHolder;
import com.LResume.model.Resumeinfo;
import com.LResume.service.ResumeService;
import com.LResume.service.UserService;
import com.LResume.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EditController {
    @Autowired
    ResumeService resumeService;
    @Autowired
    HostHolder hostHolder;
    @Autowired
    UserService userService;
    @RequestMapping(path = {"/form"},method = {RequestMethod.GET,RequestMethod.POST})
    public String form(){
        return "form";
    }
    @RequestMapping(path = {"/getresume"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getresume(Model model,
                            @RequestParam("username") String username,
                            HttpServletResponse response){
        System.out.println("test");
        Map<String,Object> map = new HashMap<>();
        Resumeinfo resumeinfo =  resumeService.selectByUserId(userService.getUserByName(username).getId());
        map.put("name",resumeinfo.getName());
        map.put("age",resumeinfo.getAge());
        map.put("telephone",resumeinfo.getTelephone());
        map.put("sex",resumeinfo.getSex());
        map.put("politics",resumeinfo.getPolitics());
        map.put("intension",resumeinfo.getIntension());
        map.put("desc",resumeinfo.getSelfassessment());
        System.out.println(JSONUtil.getJSONString(0,map).toString());
        return JSONUtil.getJSONString(0,map);
    }
    @RequestMapping(path = {"/setresume"},method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String resumeedit(Model model,
                             HttpServletRequest request,
                             HttpServletResponse response){
        Resumeinfo resumeinfo = new Resumeinfo();
        resumeinfo.setUserid(hostHolder.getUser().getId());
        resumeinfo.setJobtitle("测试");
        resumeinfo.setName(request.getParameter("name"));
        resumeinfo.setAge(request.getParameter("age"));
        resumeinfo.setTelephone(request.getParameter("cellphone"));
        resumeinfo.setSex(request.getParameter("sex"));
        resumeinfo.setPolitics(request.getParameter("politics"));
        resumeinfo.setIntension(request.getParameter("intension"));
        resumeinfo.setSelfassessment(request.getParameter("desc"));
        if(resumeService.isResumeExit(hostHolder.getUser().getId())==false){
            resumeService.addResumeInfo(resumeinfo);
        }else {
            resumeService.updateResumeInfo(resumeinfo);
        }
        return JSONUtil.getJSONString(0,"提交成功");
    }
}
