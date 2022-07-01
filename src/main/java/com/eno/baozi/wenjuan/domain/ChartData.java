package com.eno.baozi.wenjuan.domain;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChartData implements Serializable {
    List<String> typeName = new ArrayList<>();
    List<Double> score = new ArrayList<>();

    List<String>  desc = new ArrayList<>();

    public List<String> getTypeName() {
        return typeName;
    }

    public void setTypeName(List<String> typeName) {
        this.typeName = typeName;
    }

    public List<Double> getScore() {
        return score;
    }

    public void setScore(List<Double> score) {
        this.score = score;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public void add(String typeName, double score,String desc){
        this.typeName.add(typeName);
        this.score.add(score);
        this.desc.add(StringUtils.isEmpty(desc)?"":desc);
    }
    public void add(String typeName, double score){
        this.typeName.add(typeName);
        this.score.add(score);
        this.desc.add("");
    }
}
