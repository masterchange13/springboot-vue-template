package com.mao.student_job_search_website_own.Dao.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginReturn {
    public Integer id;
    public String userName;
    public String passWord;
    public String nickName;
    public String avatarUrl;
    public String schoolName;
    public String email;
    public String token;


}
