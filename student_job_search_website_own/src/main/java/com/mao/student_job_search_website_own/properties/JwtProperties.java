package com.mao.student_job_search_website_own.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mao.jwt")
@Data
public class JwtProperties {

    /**
     * 管理端员工生成jwt令牌相关配置
     */
    private String adminSecretKey = "mao";
    private long adminTtl = 1000000000;
    private String adminTokenName = "Authorization";

    /**
     * 用户端微信用户生成jwt令牌相关配置
     */
    private String userSecretKey = "zyq";
    private long userTtl = 1000000000;
    private String userTokenName = "Authorization";

}
