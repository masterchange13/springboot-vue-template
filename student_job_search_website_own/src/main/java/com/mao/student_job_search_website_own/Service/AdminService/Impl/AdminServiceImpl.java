package com.mao.student_job_search_website_own.Service.AdminService.Impl;

import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;
import com.mao.student_job_search_website_own.Mapper.AdminMapper.AdminMapper;
import com.mao.student_job_search_website_own.Service.AdminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    List<AdminDao> adminList = null;

    @Override
    public List<AdminDao> searchByName(String userName) {
        adminList = adminMapper.searchByName(userName);
        return adminList;
    }

    @Override
    public List<AdminDao> searchAll() {
        adminList = adminMapper.searchAll();
        return adminList;
    }
}
