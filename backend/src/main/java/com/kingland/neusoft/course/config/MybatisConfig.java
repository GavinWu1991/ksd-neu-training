package com.kingland.neusoft.course.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Configuration for enable mybatis framework
 *
 * @author KSC
 */
@Configuration
@Profile("Mybatis")
@MapperScan("com.kingland.neusoft.course.mapper")
public class MybatisConfig {
}