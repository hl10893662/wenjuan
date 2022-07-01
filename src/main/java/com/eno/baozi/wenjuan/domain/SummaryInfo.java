package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

@ApiModel(value = "首页")
public class SummaryInfo implements Serializable {

    @ApiModelProperty(value = "监狱")
    private String prison;
    @ApiModelProperty(value = "监区")
    private String bigGroup;
    @ApiModelProperty(value = "分监区")
    private String group;
    @ApiModelProperty(value = "在押人数")
    private int inPrison;
    @ApiModelProperty(value = "建档人数")
    private int established;
    @ApiModelProperty(value = "人格倾向异常情况分布")
    private ChartData personality;

    @ApiModelProperty(value = "自杀危险等级高度及以上分布")
    private ChartData suicide;

    @ApiModelProperty(value = "暴力危险等级高度及以上分布")
    private ChartData violence;

    @ApiModelProperty(value = "逃脱危险等级高度及以上分布")
    private ChartData escape;

    public String getPrison() {
        return prison;
    }

    public void setPrison(String prison) {
        this.prison = prison;
    }

    public String getBigGroup() {
        return bigGroup;
    }

    public void setBigGroup(String bigGroup) {
        this.bigGroup = bigGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getInPrison() {
        return inPrison;
    }

    public void setInPrison(int inPrison) {
        this.inPrison = inPrison;
    }

    public int getEstablished() {
        return established;
    }

    public void setEstablished(int established) {
        this.established = established;
    }

    public ChartData getPersonality() {
        return personality;
    }

    public void setPersonality(ChartData personality) {
        this.personality = personality;
    }

    public ChartData getSuicide() {
        return suicide;
    }

    public void setSuicide(ChartData suicide) {
        this.suicide = suicide;
    }

    public ChartData getViolence() {
        return violence;
    }

    public void setViolence(ChartData violence) {
        this.violence = violence;
    }

    public ChartData getEscape() {
        return escape;
    }

    public void setEscape(ChartData escape) {
        this.escape = escape;
    }
}
