package com.LResume.dao;

import ch.qos.logback.classic.db.names.TableName;
import com.LResume.model.Resumeinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResumeinfoDAO {
//    private int id;
//    private int userid;
//    private String jobtitle;
//    private String name;
//    private String age;
//    private String telephone;
//    private String sex;
//    private String politics;
//    private String intension;
//    private String selfassessment;
    String TABLE_NAME = "Resumeinfo";
    String INSERT_FIELDS = " user_id, jobtitle, name, age , telephone ,sex ,politics ,intension ,selfassessment";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userid},#{jobtitle},#{name},#{age},#{telephone},#{sex},#{politics},#{intension},#{selfassessment})"})
    int addResumeInfo(Resumeinfo info);

    @Update({"update ",TABLE_NAME, " set jobtitle = #{jobtitle},name = #{name}, age = #{age},telephone= #{telephone},sex = #{sex},politics = #{politics},intension = #{intension},selfassessment = #{selfassessment} where user_id=#{userid}"})
    int updateResumeInfo(Resumeinfo info);

    @Select({"select ",SELECT_FIELDS, " from ", TABLE_NAME," where user_id=#{userid}"})
    Resumeinfo selectByUserId(int userid);
}
