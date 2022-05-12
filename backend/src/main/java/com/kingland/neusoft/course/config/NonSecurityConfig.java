package com.kingland.neusoft.course.config;

import com.kingland.neusoft.course.mapper.UserMapper;
import com.kingland.neusoft.course.security.ResponsiveAuthenticationFailureHandler;
import com.kingland.neusoft.course.security.ResponsiveAuthenticationSuccessHandler;
import com.kingland.neusoft.course.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author KSC
 */
@Profile("!Security")
@Configuration
@EnableWebSecurity
public class NonSecurityConfig extends WebSecurityConfigurerAdapter {

    public NonSecurityConfig() {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorize ->
                        authorize
                                .anyRequest().permitAll());
    }
}
