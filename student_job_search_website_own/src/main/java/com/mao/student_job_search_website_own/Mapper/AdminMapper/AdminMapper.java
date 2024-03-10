package com.mao.student_job_search_website_own.Mapper.AdminMapper;

import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.swing.*;
import java.util.List;

@Mapper
public interface AdminMapper {

    List<AdminDao> adminList = null;
    @Select("select * from admin where username = #{username}")
    List<AdminDao> searchByName(String username);

    @Select("select * from admin")
    List<AdminDao> searchAll();
}
