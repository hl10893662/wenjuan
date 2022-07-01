package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Choice implements Serializable {
    @ApiModelProperty(value = "编号")
    int value;
    @ApiModelProperty(value = "选项明细")
    String desc;

    public Choice(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
