package com.eno.baozi.wenjuan.domain;

import java.util.Date;

public class OutlineQuestion {
    private Integer id;

    private Integer templateMainNo;

    private Integer templateSubNo;

    private String division;

    private String divisionName;

    private String groups;

    private String groupsName;

    private String clazz;

    private String clazzName;

    private Integer notInClazz;

    private String preinstallQuestion;

    private String checkQuestion;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String createBy;

    private String updateBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplateMainNo() {
        return templateMainNo;
    }

    public void setTemplateMainNo(Integer templateMainNo) {
        this.templateMainNo = templateMainNo;
    }

    public Integer getTemplateSubNo() {
        return templateSubNo;
    }

    public void setTemplateSubNo(Integer templateSubNo) {
        this.templateSubNo = templateSubNo;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division == null ? null : division.trim();
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName == null ? null : divisionName.trim();
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups == null ? null : groups.trim();
    }

    public String getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName == null ? null : groupsName.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName == null ? null : clazzName.trim();
    }

    public Integer getNotInClazz() {
        return notInClazz;
    }

    public void setNotInClazz(Integer notInClazz) {
        this.notInClazz = notInClazz;
    }

    public String getPreinstallQuestion() {
        return preinstallQuestion;
    }

    public void setPreinstallQuestion(String preinstallQuestion) {
        this.preinstallQuestion = preinstallQuestion == null ? null : preinstallQuestion.trim();
    }

    public String getCheckQuestion() {
        return checkQuestion;
    }

    public void setCheckQuestion(String checkQuestion) {
        this.checkQuestion = checkQuestion == null ? null : checkQuestion.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}