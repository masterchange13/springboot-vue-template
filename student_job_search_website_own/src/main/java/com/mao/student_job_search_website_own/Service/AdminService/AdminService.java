package com.mao.student_job_search_website_own.Service.AdminService;

import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<AdminDao> searchByName(String userName);

    List<AdminDao> searchAll();
}
