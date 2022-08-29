package com.zyt.service;

import com.zyt.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    // 通过账号和密码获取用户
    List<User> getUserByAccountAndPassword(String account, String password);
}
