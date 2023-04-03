package com.eno.baozi.telephone.service.impl;

import com.eno.baozi.telephone.dao.CallLogMapper;
import com.eno.baozi.telephone.service.ICalllogService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Primary
@Service
public class CalllogServiceImpl implements ICalllogService {

    @Resource
    CallLogMapper callLogMapper;
    @Override
    public int queryCalltimesByCalled(String userno, String called) {
        return callLogMapper.selectCallTimesByCalledName(userno,called);
    }
}
