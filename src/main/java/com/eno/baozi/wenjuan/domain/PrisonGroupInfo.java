package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "分监区信息")
public class PrisonGroupInfo implements Serializable {
    @ApiModelProperty(value="分监区名")
    private String name;
    @ApiModelProperty(value="分监区编号")
    private String no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
