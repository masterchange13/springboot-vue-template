package com.mao.student_job_search_website_own.Dao.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLogin {
    public String username;
    public String password;
    public String checkCode;
    // 可能需要其他属性来处理登录逻辑
    // ...
}
