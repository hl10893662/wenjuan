package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;

public class QuestionResultDesc implements Serializable {

    String typeName;
    double score;
    String desc;
    String suggest;
    String level;

    String scoreAndLevel;

    public String getScoreAndLevel() {
        return scoreAndLevel;
    }

    public void setScoreAndLevel(String scoreAndLevel) {
        this.scoreAndLevel = scoreAndLevel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
