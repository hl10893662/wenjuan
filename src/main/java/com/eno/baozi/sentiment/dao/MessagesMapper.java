package com.eno.baozi.sentiment.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.eno.baozi.sentiment.domain.Messages;

import java.util.List;

@DS("yq")
public interface MessagesMapper {
    int insert(Messages record);

    int insertSelective(Messages record);

    List<Messages> selectTheDayBeforeById(int unitId, int lastId, int pageSize);
    List<Messages> selectTheDayBeforeForAllById(int lastId, int pageSize);
    List<Messages> queryMessagesByCriminalNo(String no);
}
