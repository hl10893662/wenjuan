package com.eno.baozi.telephone.service.impl;

import com.eno.baozi.telephone.dao.CalledInfoMapper;
import com.eno.baozi.telephone.service.ICalledInfoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Primary
@Service
public class CalledInfoServiceImpl implements ICalledInfoService {
    @Resource
    CalledInfoMapper calledInfoMapper;
    @Override
    public String querytelephoneNobyName(String userno, String name) {
        return calledInfoMapper.selectTelephoneByName(userno,name);
    }
}
