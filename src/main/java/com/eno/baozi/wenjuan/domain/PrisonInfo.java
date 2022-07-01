package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="监狱信息")
public class PrisonInfo implements Serializable {
    @ApiModelProperty(value="监狱名")
    String prisonName;
    @ApiModelProperty(value="监狱编号")
    String prisonNo;

    public String getPrisonName() {
        return prisonName;
    }

    public void setPrisonName(String prisonName) {
        this.prisonName = prisonName;
    }

    public String getPrisonNo() {
        return prisonNo;
    }

    public void setPrisonNo(String prisonNo) {
        this.prisonNo = prisonNo;
    }
}
