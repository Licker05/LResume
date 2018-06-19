package com.LResume.dao;

import com.LResume.model.LoginTicket;
import com.LResume.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDAO {
    String TABLE_NAME = "user_info";
    String INSET_FIELDS = " user_id, nickname, sex, remark";
    String SELECT_FIELDS = " id, user_id, nickname, sex, remark";
    @Insert({"insert into ", TABLE_NAME, "(", INSET_FIELDS,
            ") values (#{userId},#{nickname},#{sex},#{remark})"})
    int addUserInfo(UserInfo userInfo);
}
