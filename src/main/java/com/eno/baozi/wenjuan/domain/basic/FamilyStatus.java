package com.eno.baozi.wenjuan.domain.basic;

import org.springframework.util.StringUtils;

import java.io.Serializable;

public class FamilyStatus implements Serializable {
    public String stage;
    public String name;
    public String relation;
    public String feeling;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public boolean ifEmpty(){
        if (StringUtils.isEmpty(name)){
            return true;
        }
        return false;
    }

}
