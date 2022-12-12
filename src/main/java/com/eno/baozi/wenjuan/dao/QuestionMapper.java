package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.Question;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Date;
import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectByMainNoAndSubNo(int mainNo);

}
