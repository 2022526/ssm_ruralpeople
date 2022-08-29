package com.zyt.controller;

import com.zyt.service.UploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @PostMapping("/uploadFile/{user_id}")
    public String uploadFile(MultipartFile file,
                             @PathVariable("user_id") String user_id) throws IOException {
        return uploadService.uploadFile(file,user_id);
    }
}
