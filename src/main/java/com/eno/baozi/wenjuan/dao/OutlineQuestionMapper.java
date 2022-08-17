package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.OutlineQuestion;

import java.util.List;

public interface OutlineQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OutlineQuestion record);

    int insertSelective(OutlineQuestion record);

    OutlineQuestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OutlineQuestion record);

    int updateByPrimaryKey(OutlineQuestion record);

    List<OutlineQuestion> selectByStatus(int status);

}
