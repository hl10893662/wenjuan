package com.eno.baozi.dangerous.report.convert;

public class PersonalityScoreDesc {
    String lowDesc;
    String middleDesc;
    String highDesc;
    int lowScore;
    int middleScore;

    PersonalityScoreDesc(int lowScore,int middleScore,String lowDesc,String middleDesc,String highDesc){
        this.lowScore = lowScore;
        this.middleScore = middleScore;
        this.lowDesc = lowDesc;
        this.middleDesc = middleDesc;
        this.highDesc = highDesc;
    }

    public String getDescByScore(long stdScore){
        if (stdScore <= lowScore){
            return getLowDesc();
        }else if (stdScore <= middleScore){
            return getMiddleDesc();
        }else{
            return getHighDesc();
        }
    }

    public int getLowScore() {
        return lowScore;
    }

    public void setLowScore(int lowScore) {
        this.lowScore = lowScore;
    }

    public int getMiddleScore() {
        return middleScore;
    }

    public void setMiddleScore(int middleScore) {
        this.middleScore = middleScore;
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
}
