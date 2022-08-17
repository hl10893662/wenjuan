package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutLineQuestionMain implements Serializable {
    String result="";
    PersonalInfo personalInfo;

    List<OutlineQuestionSub> questionDetailList;

    Map<String, List<String>> questionMap = new HashMap<>();

    public List<OutlineQuestionSub> getQuestionDetailList() {
        return questionDetailList;
    }

    public void setQuestionDetailList(List<OutlineQuestionSub> questionDetailList) {
        this.questionDetailList = questionDetailList;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Map<String, List<String>> getQuestionMap() {
        return questionMap;
    }

    public void setQuestionMap(Map<String, List<String>> questionMap) {
        this.questionMap = questionMap;
    }
}
