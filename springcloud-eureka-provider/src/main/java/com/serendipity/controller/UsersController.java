package com.serendipity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serendipity.pojo.User;

@RestController
public class UsersController {
    
    @RequestMapping("/user")
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "zhangsan", 20));
        list.add(new User(2, "lisi", 10));
        list.add(new User(3, "wangwu", 30));
        return list;

    }
}
