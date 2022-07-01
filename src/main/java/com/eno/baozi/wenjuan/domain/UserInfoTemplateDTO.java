package com.eno.baozi.wenjuan.domain;

import java.util.Date;
import java.util.List;

public class UserInfoTemplateDTO {
    private Integer id;

    private Integer mainNo;

    private Integer subNo;

    private String mainTitle;

    private String title;

    private List<UserInfoTemplateChoiceDTO> choice;

    private Integer type;

    private String choiceName;

    private String valueName;

    private Date createTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMainNo() {
        return mainNo;
    }

    public void setMainNo(Integer mainNo) {
        this.mainNo = mainNo;
    }

    public Integer getSubNo() {
        return subNo;
    }

    public void setSubNo(Integer subNo) {
        this.subNo = subNo;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public List<UserInfoTemplateChoiceDTO> getChoice() {
        return choice;
    }

    public void setChoice(List<UserInfoTemplateChoiceDTO> choice) {
        this.choice = choice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChoiceName() {
        return choiceName;
    }

    public void setChoiceName(String choiceName) {
        this.choiceName = choiceName == null ? null : choiceName.trim();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
