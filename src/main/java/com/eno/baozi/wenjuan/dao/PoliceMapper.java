package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.Police;

public interface PoliceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Police record);

    int insertSelective(Police record);

    Police selectByPrimaryKey(Integer id);

    Police selectByName(String name);

    int updateByPrimaryKeySelective(Police record);

    int updateByPrimaryKey(Police record);
}
