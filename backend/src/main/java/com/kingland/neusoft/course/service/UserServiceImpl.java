package com.kingland.neusoft.course.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kingland.neusoft.course.mapper.UserMapper;
import com.kingland.neusoft.course.mapper.dao.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation class of user service
 *
 * @author KSC
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserModel addUser(UserModel userModel) {
        userMapper.insert(userModel);
        return userModel;
    }

}
