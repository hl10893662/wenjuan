package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;

public class OutlineQuestionSub implements Serializable {
    String questiontype;
    String questionDetail;
    String questionDetail1;

    public String getQuestionDetail1() {
        return questionDetail1;
    }

    public void setQuestionDetail1(String questionDetail1) {
        this.questionDetail1 = questionDetail1;
    }

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }
}
