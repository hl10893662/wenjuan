package com.eno.baozi.sentiment.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.eno.baozi.sentiment.domain.Criminals;
@DS("yq")
public interface CriminalsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Criminals record);

    int insertSelective(Criminals record);

    Criminals selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Criminals record);

    int updateByPrimaryKeyWithBLOBs(Criminals record);

    int updateByPrimaryKey(Criminals record);
}
