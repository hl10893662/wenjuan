package com.eno.baozi.wenjuan.domain;

import java.util.Date;

public class PoliceInfo {
    private Integer id;

    private String name;

    private String trueName;

    private Integer unitId;

    private String password;

    private String prisonName;

    private String bigGroupName;

    private String prisonNo;
    private String bigGroupNo;
    private String groupNo;

    private String groupName;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPrisonName() {
        return prisonName;
    }

    public void setPrisonName(String prisonName) {
        this.prisonName = prisonName;
    }

    public String getBigGroupName() {
        return bigGroupName;
    }

    public void setBigGroupName(String bigGroupName) {
        this.bigGroupName = bigGroupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPrisonNo() {
        return prisonNo;
    }

    public void setPrisonNo(String prisonNo) {
        this.prisonNo = prisonNo;
    }

    public String getBigGroupNo() {
        return bigGroupNo;
    }

    public void setBigGroupNo(String bigGroupNo) {
        this.bigGroupNo = bigGroupNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }
}
