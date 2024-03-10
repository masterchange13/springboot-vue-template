package com.mao.student_job_search_website_own.Controller.admin;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.json.JSONUtil;
import com.mao.student_job_search_website_own.Dao.Admin.AdminDao;
import com.mao.student_job_search_website_own.Dao.Admin.AdminLogin;
import com.mao.student_job_search_website_own.Dao.Admin.AdminLoginReturn;
import com.mao.student_job_search_website_own.Dao.DTO.UserSearchDTO;
import com.mao.student_job_search_website_own.Dao.Result.Result;
import com.mao.student_job_search_website_own.Service.AdminService.AdminLoginService;
import com.mao.student_job_search_website_own.Service.AdminService.AdminService;
import com.mao.student_job_search_website_own.constant.JwtClaimsConstant;
import com.mao.student_job_search_website_own.properties.JwtProperties;
import com.mao.student_job_search_website_own.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("adminController")
@RequestMapping("/admin")
@Api(tags = "管理员相关接口")
@Slf4j
public class AdminController {
    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private AdminService adminService;

    private LineCaptcha lineCaptcha;

    // 管理员相关接口
    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result<AdminLoginReturn> login(@RequestBody AdminLogin admin) {
        // 处理登录逻辑
        String username = admin.getUsername();
        String password = admin.getPassword();
        String checkCode = admin.getCheckCode();
        System.out.println(username);
        System.out.println(password);
        System.out.println(checkCode);
        // 进行登录验证
        AdminDao adminDao = adminLoginService.Login(username, password);
        if (checkCode.equals(lineCaptcha.getCode())){
            if(admin.getUsername().equals("admin") && admin.getPassword().equals("123456")){

                //登录成功后，生成jwt令牌
                Map<String, Object> claims = new HashMap<>();
                claims.put(JwtClaimsConstant.EMP_ID, adminDao.getId());
                String token = JwtUtil.createJWT(
                        jwtProperties.getAdminSecretKey(),
                        jwtProperties.getAdminTtl(),
                        claims);

                // return result
                AdminLoginReturn adminLoginReturn = AdminLoginReturn.builder()
                        .id(adminDao.getId())
                        .userName(adminDao.getUsername())
                        .nickName(adminDao.getNickName())
                        .token(token)
                        .avatarUrl(adminDao.getAvatarUrl())
                        .email(adminDao.getEmail())
                        .build();
                return Result.success(adminLoginReturn);
            }
        }

        return Result.error("错误");
    }

    // 验证码
    @ApiOperation("获取验证码")
    @GetMapping("/checkCode")
    public void getCode(HttpServletResponse response) {
        // 随机生成 4 位验证码
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        // 定义图片的显示大小
        lineCaptcha = CaptchaUtil.createLineCaptcha(100, 30);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            // 调用父类的 setGenerator() 方法，设置验证码的类型
            lineCaptcha.setGenerator(randomGenerator);
            // 输出到页面
            lineCaptcha.write(response.getOutputStream());
            // 打印日志
            log.info("生成的验证码:{}", lineCaptcha.getCode());
            // 关闭流
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("搜索用户")
    @PostMapping("/search")
    public Result<List<AdminDao>> searchByName(@RequestBody UserSearchDTO userSearchDTO){
        log.info("正在搜索");
        String userName = userSearchDTO.getUsername();
        log.info("搜索的用户名:{}", userName);
        if (userName == null || userName.equals("")) {
            List<AdminDao> userList = adminService.searchAll();
            log.info("搜索到的用户列表:{}", userList);
            return Result.success(userList);
        }else {
            List<AdminDao> userList = adminService.searchByName(userName);
            log.info("搜索到的用户列表:{}", userList);
            return Result.success(userList);
        }
    }
}
