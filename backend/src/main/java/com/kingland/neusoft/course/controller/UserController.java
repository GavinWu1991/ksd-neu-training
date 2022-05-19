package com.kingland.neusoft.course.controller;

import com.kingland.neusoft.course.mapper.dao.UserModel;
import com.kingland.neusoft.course.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * @return user id
     */
    @GetMapping("/users/{id}")
    public UserModel getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    /**
     * Api for deleting user by id
     *
     * @return id of deleted user
     */
    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasAnyAuthority('role_admin')")
    public ResponseEntity deleteUser(@PathVariable("id") Long userId) {
        if (userService.deleteUser(userId) == 1) {
            // 204
            return ResponseEntity.noContent().build();
        } else {
            // 404
            return ResponseEntity.notFound().build();
        }
    }
}
