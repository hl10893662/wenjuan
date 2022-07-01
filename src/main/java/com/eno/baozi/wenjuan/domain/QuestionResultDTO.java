package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel(value="问卷结果")
public class QuestionResultDTO implements Serializable {
    @ApiModelProperty(value="学员名称")
    String cirminalName;
    @ApiModelProperty(value="学员编号")
    String cirminalNo;
    @ApiModelProperty(value="问卷编号")
    String questionNo;
    @ApiModelProperty(value="答题结果")
    String result;

    public String getCirminalName() {
        return cirminalName;
    }

    public void setCirminalName(String cirminalName) {
        this.cirminalName = cirminalName;
    }

    public String getCirminalNo() {
        return cirminalNo;
    }

    public void setCirminalNo(String cirminalNo) {
        this.cirminalNo = cirminalNo;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
