package com.zyt.service.impl;

import com.zyt.mapper.UserMapper;
import com.zyt.pojo.User;
import com.zyt.service.UserService;
import com.zyt.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByAccountAndPassword(String username, String password) {
        // 前台密码进行加密，跟数据库进行对比
        String encryption = MD5Util.MD5(password);

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username)
                .andEqualTo("password",encryption);
        List<User> list = userMapper.selectByExample(example);
        return list;
    }
}
