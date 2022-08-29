package com.zyt.service.impl;

import com.zyt.constant.Constant;
import com.zyt.mapper.UserMapper;
import com.zyt.pojo.User;
import com.zyt.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String uploadFile(MultipartFile file,String user_id) throws IOException {
        // 文件名
        String name = file.getName();
        // 头像图片名称:图片名+UUID
        name += UUID.randomUUID() + ".jpg";
        // System.out.println(name);
        // 文件保存地址
        String fileUrl = Constant.HEAD_SCULPTURE + name;
        // 保存用户头像
        file.transferTo(new File(fileUrl));

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("id",user_id);
        List<User> user = userMapper.selectByExample(example);
        user.get(0).setHead_sculpture(fileUrl);
        // 更新当前用户信息
        int row = userMapper.updateByPrimaryKey(user.get(0));

        return row > 0 ? "ok" : "fail";
    }
}
