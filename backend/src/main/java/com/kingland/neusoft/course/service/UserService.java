package com.kingland.neusoft.course.service;

import com.kingland.neusoft.course.mapper.dao.UserModel;

/**
 * The service provide ability to access the user information
 *
 * @author KSC
 */
public interface UserService {
    /**
     * Create user by specific user object
     *
     * @param userModel the model for creating user
     * @return database record
     */
    UserModel addUser(UserModel userModel);

}
