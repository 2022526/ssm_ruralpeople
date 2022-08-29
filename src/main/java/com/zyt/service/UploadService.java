package com.zyt.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    // 处理用户上传头像
    public String uploadFile(MultipartFile file,String user_id) throws IOException;
}
