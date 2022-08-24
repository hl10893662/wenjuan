package com.eno.baozi.sentiment.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.eno.baozi.sentiment.domain.CriminalMessageKey;

import java.util.List;
@DS("yq")
public interface CriminalMessageMapper {
    int deleteByPrimaryKey(CriminalMessageKey key);

    int insert(CriminalMessageKey record);

    int insertSelective(CriminalMessageKey record);

    List<CriminalMessageKey> selectByMessageId(int messageId);
}
