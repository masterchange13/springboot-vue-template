package com.mao.student_job_search_website_own.Service.AdminService;

import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;

public interface AdminLoginService {
    AdminDao Login(String username, String password);
}
