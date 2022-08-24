package com.eno.baozi.sentiment.domain;

import java.util.Date;

public class Units {
    private Integer id;

    private String name;

    private String type;

    private String path;

    private Integer pid;

    private String fullName;

    private String prisonName;

    private String prisonFullName;

    private Integer prisonId;

    private String jgxtName;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getPrisonName() {
        return prisonName;
    }

    public void setPrisonName(String prisonName) {
        this.prisonName = prisonName == null ? null : prisonName.trim();
    }

    public String getPrisonFullName() {
        return prisonFullName;
    }

    public void setPrisonFullName(String prisonFullName) {
        this.prisonFullName = prisonFullName == null ? null : prisonFullName.trim();
    }

    public Integer getPrisonId() {
        return prisonId;
    }

    public void setPrisonId(Integer prisonId) {
        this.prisonId = prisonId;
    }

    public String getJgxtName() {
        return jgxtName;
    }

    public void setJgxtName(String jgxtName) {
        this.jgxtName = jgxtName == null ? null : jgxtName.trim();
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
}