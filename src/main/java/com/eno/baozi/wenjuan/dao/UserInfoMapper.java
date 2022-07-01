package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.common.domain.PageRequest;
import com.eno.baozi.wenjuan.domain.QueryUserDTO;
import com.eno.baozi.wenjuan.domain.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String no);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    List<UserInfo> selectPage(QueryUserDTO dto);
}
