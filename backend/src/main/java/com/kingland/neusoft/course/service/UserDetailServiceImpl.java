package com.kingland.neusoft.course.service;

import com.kingland.neusoft.course.mapper.UserMapper;
import com.kingland.neusoft.course.mapper.dao.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    public UserDetailServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel dbUser = this.userMapper.selectUserByUsername(username);

        if (dbUser == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Boolean.TRUE.equals(dbUser.getIsAdmin()) ? List.of(new SimpleGrantedAuthority("role_admin")) : Collections.emptyList();
            }

            @Override
            public String getPassword() {
                return dbUser.getPassword();
            }

            @Override
            public String getUsername() {
                return dbUser.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
