package com.eno.baozi.wenjuan.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Question {

    public static Map<Integer,String> MAIN_NAME = new HashMap<Integer,String>();
    static {
        MAIN_NAME.put(1,"COPA");
        MAIN_NAME.put(2,"应对");
        MAIN_NAME.put(3,"人格");
    }
    private Integer id;

    private Integer mainNo;

    private Integer subNo;

    private String title;

    private String choice;

    private Integer type;

    private Date createTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice == null ? null : choice.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
