package com.eno.baozi.sentiment.dao;

import com.eno.baozi.sentiment.domain.PSentimentKeyword;

import java.util.List;

public interface PSentimentKeywordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PSentimentKeyword record);

    int insertSelective(PSentimentKeyword record);

    PSentimentKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PSentimentKeyword record);

    int updateByPrimaryKey(PSentimentKeyword record);

    List<PSentimentKeyword> selectAllKeywords();
}
