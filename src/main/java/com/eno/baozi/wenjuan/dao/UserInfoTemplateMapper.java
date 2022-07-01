package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.UserInfoTemplate;

import java.util.List;

public interface UserInfoTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoTemplate record);

    int insertSelective(UserInfoTemplate record);

    UserInfoTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfoTemplate record);

    int updateByPrimaryKey(UserInfoTemplate record);

    List<UserInfoTemplate> selectAll();
}
