package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.UserInfoDetail;

public interface UserInfoDetailMapper {
    int deleteByPrimaryKey(String no);

    int insert(UserInfoDetail record);

    int insertSelective(UserInfoDetail record);

    UserInfoDetail selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(UserInfoDetail record);

    int updateByPrimaryKey(UserInfoDetail record);
}