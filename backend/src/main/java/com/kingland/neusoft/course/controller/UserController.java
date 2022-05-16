package com.kingland.neusoft.course.controller;

import com.kingland.neusoft.course.mapper.dao.UserModel;
import com.kingland.neusoft.course.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * The user information related rest api controller
 *
 * @author KSC
 */
@RestController
public class UserController {

    private final UserService userService;

    /**
     * Initialize controller with user service bean
     *
     * @param userService service implementation bean
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Api for creating user
     *
     * @param userModel creating user
     * @return created user record
     */
    @PostMapping("/users")
    public UserModel addUser(@RequestBody UserModel userModel) {
        return userService.addUser(userModel);
    }

    /**
     * Api for counting all users exists in the system
     *
     * @return number of users exists in the system
     */
    @GetMapping("/users/count")
    public Map<String, Integer> countUser() {
        Integer userCount = userService.countUser();
        return Map.of("count", userCount);
    }

    /**
     * Api get all users exists in the system
     *
     * @return all user data
     */
    @GetMapping("/users")
    public List<UserModel> getAllUser() {
        return userService.getAllUser();
    }


    /**
     * Api for counting all users exists in the system
     *
     * @return number of users exists in the system
     */
    @GetMapping("/users/{id}")
    public UserModel countUser(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }
}
