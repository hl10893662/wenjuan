package com.eno.baozi.wenjuan.questionslove.copa;

public class COPAScoreDesc {
    String lowDesc;
    String middleDesc;
    String highDesc;

    COPAScoreDesc(String lowDesc,String middleDesc,String highDesc){
        this.lowDesc = lowDesc;
        this.middleDesc = middleDesc;
        this.highDesc = highDesc;
    }

    public String getLowDesc() {
        return lowDesc;
    }

    public void setLowDesc(String lowDesc) {
        this.lowDesc = lowDesc;
    }

    public String getMiddleDesc() {
        return middleDesc;
    }

    public void setMiddleDesc(String middleDesc) {
        this.middleDesc = middleDesc;
    }

    public String getHighDesc() {
        return highDesc;
    }

    public void setHighDesc(String highDesc) {
        this.highDesc = highDesc;
    }

    //T≤45，属于较低分级；45＜T＜55，属于中等分级；T》=55属于高分级
    public String getDescByScore(long stdScore){
        if (stdScore <= 45){
            return getLowDesc();
        }else if (stdScore <55){
            return getMiddleDesc();
        }else{
            return getHighDesc();
        }
    }
    //T≤45，属于较低分级；45＜T＜55，属于中等分级；T》=55属于高分级
    public String getLevelByScore(long stdScore){
        if (stdScore <= 45){
            return "低分";
        }else if (stdScore <55){
            return "中等";
        }else{
            return "高分";
        }
    }
}
