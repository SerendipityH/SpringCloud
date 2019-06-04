package com.serendipity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serendipity.pojo.User;
import com.serendipity.service.UserService;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("/consumer")
    public List<User> getUsers() {

        return userService.getUsers();

    }
}
