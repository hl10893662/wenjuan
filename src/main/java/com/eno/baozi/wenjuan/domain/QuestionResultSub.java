package com.eno.baozi.wenjuan.domain;

import java.util.ArrayList;
import java.util.List;

public class QuestionResultSub implements Cloneable{

    String questionNo;
    List<QuestionResultDesc> questionResultDescList;


    List<Double> score = new ArrayList<>();
    List<String> typeName = new ArrayList<>();

    public void put(String typeName1,double score1){
        score.add(score1);
        typeName.add(typeName1);
    }

    public List<QuestionResultDesc> getQuestionResultDescList() {
        return questionResultDescList;
    }

    public void setQuestionResultDescList(List<QuestionResultDesc> questionResultDescList) {
        this.questionResultDescList = questionResultDescList;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public List<Double> getScore() {
        return score;
    }

    public void setScore(List<Double> score) {
        this.score = score;
    }

    public List<String> getTypeName() {
        return typeName;
    }

    public void setTypeName(List<String> typeName) {
        this.typeName = typeName;
    }
}
