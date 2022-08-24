package com.eno.baozi.sentiment.domain;

import java.util.Date;

public class Messages {
    private Integer id;

    private Date createdAt;

    private Date updatedAt;

    private Integer userId;

    private Integer unitId;

    private Boolean score;

    private Boolean important;

    private Byte replyCount;

    private Date editAt;

    private Integer judgeId;

    private Byte status;

    private Byte quality;

    private Integer evaluatorId;

    private String evaluateLevel;

    private Date suppliedAt;

    private byte[] content;

    private Integer criminalId;


    private String no;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(Integer criminalId) {
        this.criminalId = criminalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Byte getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Byte replyCount) {
        this.replyCount = replyCount;
    }

    public Date getEditAt() {
        return editAt;
    }

    public void setEditAt(Date editAt) {
        this.editAt = editAt;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getQuality() {
        return quality;
    }

    public void setQuality(Byte quality) {
        this.quality = quality;
    }

    public Integer getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public String getEvaluateLevel() {
        return evaluateLevel;
    }

    public void setEvaluateLevel(String evaluateLevel) {
        this.evaluateLevel = evaluateLevel == null ? null : evaluateLevel.trim();
    }

    public Date getSuppliedAt() {
        return suppliedAt;
    }

    public void setSuppliedAt(Date suppliedAt) {
        this.suppliedAt = suppliedAt;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
