package com.mao.student_job_search_website_own.Dao.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDao {
    public Integer id;
    public String username;
    public String password;
    public LocalDateTime createTime;
    public LocalDateTime updateTime;
    public String nickName;
    public String avatarUrl;
    public String schoolName;
    public String email;
}
