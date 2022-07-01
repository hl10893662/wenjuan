package com.eno.baozi.wenjuan.domain.basic;


import org.springframework.util.StringUtils;

import java.io.Serializable;

public class TransformExperience implements Serializable {
    public PrisonEnv prisonEnv;
    public Social social;
    public Labour labour;
    public Release release;

    public PrisonEnv getPrisonEnv() {
        return prisonEnv;
    }

    public void setPrisonEnv(PrisonEnv prisonEnv) {
        this.prisonEnv = prisonEnv;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public Labour getLabour() {
        return labour;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public void setLabour(Labour labour) {
        this.labour = labour;
    }
    public String convertToString(){
        return this.prisonEnv.convertToString()+","+this.social.convertToString()+","+this.labour.convertToString()+"," +
                this.release.convertToString();
    }

    public static TransformExperience convertToParam(String value){
        TransformExperience transformExperience = new TransformExperience();
        if (!StringUtils.isEmpty(value)){
            String[] strArr = value.split(",");
            transformExperience.setPrisonEnv(PrisonEnv.convertToParam(strArr[0]));
            transformExperience.setSocial(Social.convertToParam(strArr[1]));
            transformExperience.setLabour(Labour.convertToParam(strArr[1]));
            transformExperience.setRelease(Release.convertToParam(strArr[1]));
        }
        return transformExperience;
    }

}
