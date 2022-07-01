package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.Units;

import java.util.List;

public interface UnitsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Units record);

    int insertSelective(Units record);

    Units selectByPrimaryKey(Integer id);
    Units selectPrisonByPrisonId(Integer prisonId);


    int updateByPrimaryKeySelective(Units record);

    int updateByPrimaryKey(Units record);

    List<Units> selectBigGroupListByPrisonId(Integer prisonId);

    List<Units> selectByPid(Integer pId);

    List<Units> selectGroupListByPrisonId(Integer prisonId);
    List<Units> selectGroupListByBigGroupId(Integer bigGroupId);

}
