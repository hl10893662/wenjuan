package com.eno.baozi.wenjuan.domain.basic;

import org.springframework.util.StringUtils;

import java.io.Serializable;

public class WorkInfo implements Serializable {
    public String stage;
    public String occupation;
    public String feeling;
    public String training;
    public String workyear;

    public String getWorkyear() {
        return workyear;
    }

    public void setWorkyear(String workyear) {
        this.workyear = workyear;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public boolean ifEmpty(){
        if (StringUtils.isEmpty(this.occupation)){
            return true;
        }
        return false;
    }

}
