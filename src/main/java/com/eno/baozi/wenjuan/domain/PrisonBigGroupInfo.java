package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value="监区信息")
public class PrisonBigGroupInfo implements Serializable {
    @ApiModelProperty(value="监区编号")
    private String no;
    @ApiModelProperty(value="监区名")
    private String name;
    @ApiModelProperty(value="分监区列表")
    private List<PrisonGroupInfo> groupInfoList;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PrisonGroupInfo> getGroupInfoList() {
        return groupInfoList;
    }

    public void setGroupInfoList(List<PrisonGroupInfo> groupInfoList) {
        this.groupInfoList = groupInfoList;
    }
}
