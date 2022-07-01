package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionResultMain implements Serializable {
    String result="";
    PersonalInfo personalInfo;
    Map<String, QuestionResultSub> questionResultDescMap = new HashMap<>();
    HealthShow health;
    GuiltShow guilt;
    List<WorkDetailShow> workDetail;
//    List<SocialDetailShow> socialDetail;
    List<FamilyDetailShow> familyDetail;
    List<GrowupDetailShow> growupDetail;
    String growupOfFamily;
    LifeEventShow lifeEvent;
    PrisonShow prison;

    public String remark1;
    public String remark2;
    public String remark3;
    public String remark4;
    public String remark5;
    public String remark6;
    public String remark7;
    public String remark8;
    public String remark9;
    public String remark10;
    public String remark11;
    public String remark12;
    public String remark13;


    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getGrowupOfFamily() {
        return growupOfFamily;
    }

    public void setGrowupOfFamily(String growupOfFamily) {
        this.growupOfFamily = growupOfFamily;
    }

    public List<GrowupDetailShow> getGrowupDetail() {
        return growupDetail;
    }

    public void setGrowupDetail(List<GrowupDetailShow> growupDetail) {
        this.growupDetail = growupDetail;
    }

    public List<WorkDetailShow> getWorkDetail() {
        return workDetail;
    }

    public void setWorkDetail(List<WorkDetailShow> workDetail) {
        this.workDetail = workDetail;
    }

//    public List<SocialDetailShow> getSocialDetail() {
//        return socialDetail;
//    }
//
//    public void setSocialDetail(List<SocialDetailShow> socialDetail) {
//        this.socialDetail = socialDetail;
//    }

    public List<FamilyDetailShow> getFamilyDetail() {
        return familyDetail;
    }

    public void setFamilyDetail(List<FamilyDetailShow> familyDetail) {
        this.familyDetail = familyDetail;
    }

    public String getResult() {
        return result;
    }


    public GuiltShow getGuilt() {
        return guilt;
    }

    public void setGuilt(GuiltShow guilt) {
        this.guilt = guilt;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public HealthShow getHealth() {
        return health;
    }

    public void setHealth(HealthShow health) {
        this.health = health;
    }

    public LifeEventShow getLifeEvent() {
        return lifeEvent;
    }

    public void setLifeEvent(LifeEventShow lifeEvent) {
        this.lifeEvent = lifeEvent;
    }

    public PrisonShow getPrison() {
        return prison;
    }

    public void setPrison(PrisonShow prison) {
        this.prison = prison;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void addQuestionResultDesc(String questionNo, QuestionResultSub questionResultSub ){
        questionResultDescMap.put(questionNo,questionResultSub);
    }

    public Map<String, QuestionResultSub> getQuestionResultDescMap() {
        return questionResultDescMap;
    }

    public void setQuestionResultDescMap(Map<String, QuestionResultSub> questionResultDescMap) {
        this.questionResultDescMap = questionResultDescMap;
    }
}
