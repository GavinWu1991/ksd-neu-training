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
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author KSC
 */
@Profile("Security")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl(userMapper);
    }

    public SecurityConfig(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorize ->
                        authorize
                                .antMatchers("/login", "/logout").permitAll()
                                .anyRequest().authenticated())
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(new ResponsiveAuthenticationSuccessHandler())
                .failureHandler(new ResponsiveAuthenticationFailureHandler())
                .and()
                .logout().logoutUrl("/logout");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }
}
