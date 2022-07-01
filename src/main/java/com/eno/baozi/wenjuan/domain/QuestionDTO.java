package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value="题目")
public class QuestionDTO  implements Serializable {

    @ApiModelProperty(value = "问卷编号")
    public int questionMainNumber;
    @ApiModelProperty(value = "问卷名称")
    public String questionMainName;

    @ApiModelProperty(value = "问题编号")
    public int questionSubNumber;
    @ApiModelProperty(value = "问题内容")
    public String title;
    @ApiModelProperty(value = "选项列表")
    public List<Choice> choiceList;

    @ApiModelProperty(value = "答案")
    public String answer;

    public int getQuestionMainNumber() {
        return questionMainNumber;
    }

    public void setQuestionMainNumber(int questionMainNumber) {
        this.questionMainNumber = questionMainNumber;
    }

    public int getQuestionSubNumber() {
        return questionSubNumber;
    }

    public void setQuestionSubNumber(int questionSubNumber) {
        this.questionSubNumber = questionSubNumber;
    }

    public List<Choice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Choice> choiceList) {
        this.choiceList = choiceList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionMainName() {
        return questionMainName;
    }

    public void setQuestionMainName(String questionMainName) {
        this.questionMainName = questionMainName;
    }
}
