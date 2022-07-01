package com.eno.baozi.wenjuan.domain.basic;

import org.springframework.util.StringUtils;

public class SocialStatus {
    public String stage;
    public String name;
    public String socialOccupation;
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

    public String getSocialOccupation() {
        return socialOccupation;
    }

    public void setSocialOccupation(String socialOccupation) {
        this.socialOccupation = socialOccupation;
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
