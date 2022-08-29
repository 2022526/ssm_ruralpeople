package com.zyt.controller;

import com.zyt.pojo.Rural;
import com.zyt.service.RuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rural")
@CrossOrigin // 解决跨域
public class RuralController {

    @Autowired
    private RuralService ruralService;

        @GetMapping("/getAllRural")
    public List<Rural> getAllRural() {
        return ruralService.getAllRural();
    }

}
