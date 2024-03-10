package com.mao.student_job_search_website_own.Mapper.AdminMapper;

import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminLoginMapper {
    @Select("select * from admin where username=#{username} and password=#{password}")
    AdminDao login(String username, String password);
}
