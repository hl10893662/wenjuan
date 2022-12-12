package com.eno.baozi.wenjuan.dao;

import com.eno.baozi.wenjuan.domain.Question;
import com.eno.baozi.wenjuan.domain.QuestionResult;

import java.util.List;

public interface QuestionResultMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(QuestionResult record);

    int insertSelective(QuestionResult record);

    QuestionResult selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(QuestionResult record);

    int updateByPrimaryKey(QuestionResult record);

    QuestionResult selectByCriminalIdAndQuestionNo(String criminalId ,String questionNo);

    List<QuestionResult> selectByTypeAndDate(Integer questionNo, String start, String end);

}
