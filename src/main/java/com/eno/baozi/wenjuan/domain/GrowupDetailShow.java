package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;

public class GrowupDetailShow  implements Serializable {

    public String stage;
    public String training;
    public String feeling;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }
}
