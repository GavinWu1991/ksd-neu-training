package com.kingland.neusoft.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry of application
 *
 * @author KSC
 */
@SpringBootApplication
@MapperScan("com.kingland.neusoft.course.mapper")
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

}
