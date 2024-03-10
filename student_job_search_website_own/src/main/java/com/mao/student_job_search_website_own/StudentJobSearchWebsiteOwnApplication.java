package com.mao.student_job_search_website_own;

import lombok.extern.slf4j.Slf4j;
// import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan()
@MapperScan("com.mao.student_job_search_website_own.Mapper")
@SpringBootApplication()
@Slf4j
public class StudentJobSearchWebsiteOwnApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentJobSearchWebsiteOwnApplication.class, args);
    }

}
