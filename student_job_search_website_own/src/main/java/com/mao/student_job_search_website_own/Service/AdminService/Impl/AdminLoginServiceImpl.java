package com.mao.student_job_search_website_own.Service.AdminService.Impl;

import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;
import com.mao.student_job_search_website_own.Mapper.AdminMapper.AdminLoginMapper;
import com.mao.student_job_search_website_own.Service.AdminService.AdminLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminLoginMapper adminLoginMapper;

    @Override
    public AdminDao Login(String username, String password) {
        log.info("调用AdminLoginServiceImpl的Login方法");
        AdminDao adminDao = adminLoginMapper.login(username, password);

        // return new AdminDao(1, "admin", "123456", null, null, "admin", "dasd", "das", "dsad");
        return adminDao;
    }
}
