package com.zyt.service.impl;

import com.zyt.mapper.RuralMapper;
import com.zyt.pojo.Rural;
import com.zyt.service.RuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RuralServiceImpl implements RuralService {

    @Autowired
    private RuralMapper ruralMapper;

    @Override
    public List<Rural> getAllRural() {
        return ruralMapper.selectAll();
    }
}
