package com.LResume.service;

import com.LResume.dao.ResumeinfoDAO;
import com.LResume.model.Resumeinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    ResumeinfoDAO resumeinfoDAO;
    public void addResumeInfo(Resumeinfo resumeinfo){
        resumeinfoDAO.addResumeInfo(resumeinfo);
    }
    public boolean isResumeExit(int userid){
        if(resumeinfoDAO.selectByUserId(userid)==null)
            return false;
        else
            return true;
    }
    public void updateResumeInfo(Resumeinfo resumeinfo) {
        resumeinfoDAO.updateResumeInfo(resumeinfo);
    }
    public Resumeinfo selectByUserId(int userid){
        return resumeinfoDAO.selectByUserId(userid);
    }
}
