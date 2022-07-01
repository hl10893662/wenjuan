package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 *  罪犯查询DTO
 */
public class QueryUserDTO implements Serializable {
    @ApiModelProperty(value = "监狱")
    private String prison;
    @ApiModelProperty(value = "监区")
    private String bigGroup;
    @ApiModelProperty(value = "分监区")
    private String group;
    @ApiModelProperty(value = "编号")
    private String no;
    @ApiModelProperty(value = "名字")
    private String name;

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

    @Override
    public String toString() {
        return "QueryUserDTO{" +
                "prison='" + prison + '\'' +
                ", bigGroup='" + bigGroup + '\'' +
                ", group='" + group + '\'' +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public  boolean isEmpty(){
        if (StringUtils.isEmpty(this.prison)
        && StringUtils.isEmpty(this.group)
                && StringUtils.isEmpty(this.bigGroup)
                ){
            return true;
        }
        return false;
    }
}
