package com.zyt.controller;

import com.zyt.pojo.User;
import com.zyt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser/{username}/{password}")
    public List<User> getUser(@PathVariable("username") String username,
                              @PathVariable("password") String password) {
        return userService.getUserByAccountAndPassword(username,password);
    }

}
