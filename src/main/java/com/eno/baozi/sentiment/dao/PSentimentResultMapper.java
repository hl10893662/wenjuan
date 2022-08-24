package com.eno.baozi.sentiment.dao;

import com.eno.baozi.sentiment.domain.PSentimentResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PSentimentResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PSentimentResult record);

    int insertSelective(PSentimentResult record);

    PSentimentResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PSentimentResult record);

    int updateByPrimaryKeyWithBLOBs(PSentimentResult record);

    int updateByPrimaryKey(PSentimentResult record);

    int batchInsert(@Param("resultList") List<PSentimentResult> resultList);

    List<PSentimentResult> queryListByCriminalNo(String no);
}
