package com.eno.baozi.sentiment.dao;

import com.eno.baozi.sentiment.domain.CronMark;

public interface CronMarkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CronMark record);

    int insertSelective(CronMark record);

    CronMark selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CronMark record);

    int updateByPrimaryKey(CronMark record);

    CronMark selectByFlag(String flag);

}
