package com.eno.baozi.sentiment.domain;

import java.util.Date;

public class UserInfo {
    private String no;

    private String groupno;

    private String biggroupno;

    private String pwd;

    private String name;

    private Integer level;

    private Integer state;

    private String note;

    private Integer age;

    private Integer sex;

    private String address;

    private String kultur;

    private Date bridewellDate;

    private String imprisonDate;

    private Date imprisonBegin;

    private Date imprisonEnd;

    private String technic;

    private Date technicDate;

    private String kulturbreak;

    private Date kulturbreakDate;

    private Integer prisonState;

    private Date fullDate;

    private String born;

    private String crime;

    private String processLevel;

    private String laborType;

    private String evaluateLevel;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getGroupno() {
        return groupno;
    }

    public void setGroupno(String groupno) {
        this.groupno = groupno == null ? null : groupno.trim();
    }

    public String getBiggroupno() {
        return biggroupno;
    }

    public void setBiggroupno(String biggroupno) {
        this.biggroupno = biggroupno == null ? null : biggroupno.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getKultur() {
        return kultur;
    }

    public void setKultur(String kultur) {
        this.kultur = kultur == null ? null : kultur.trim();
    }

    public Date getBridewellDate() {
        return bridewellDate;
    }

    public void setBridewellDate(Date bridewellDate) {
        this.bridewellDate = bridewellDate;
    }

    public String getImprisonDate() {
        return imprisonDate;
    }

    public void setImprisonDate(String imprisonDate) {
        this.imprisonDate = imprisonDate == null ? null : imprisonDate.trim();
    }

    public Date getImprisonBegin() {
        return imprisonBegin;
    }

    public void setImprisonBegin(Date imprisonBegin) {
        this.imprisonBegin = imprisonBegin;
    }

    public Date getImprisonEnd() {
        return imprisonEnd;
    }

    public void setImprisonEnd(Date imprisonEnd) {
        this.imprisonEnd = imprisonEnd;
    }

    public String getTechnic() {
        return technic;
    }

    public void setTechnic(String technic) {
        this.technic = technic == null ? null : technic.trim();
    }

    public Date getTechnicDate() {
        return technicDate;
    }

    public void setTechnicDate(Date technicDate) {
        this.technicDate = technicDate;
    }

    public String getKulturbreak() {
        return kulturbreak;
    }

    public void setKulturbreak(String kulturbreak) {
        this.kulturbreak = kulturbreak == null ? null : kulturbreak.trim();
    }

    public Date getKulturbreakDate() {
        return kulturbreakDate;
    }

    public void setKulturbreakDate(Date kulturbreakDate) {
        this.kulturbreakDate = kulturbreakDate;
    }

    public Integer getPrisonState() {
        return prisonState;
    }

    public void setPrisonState(Integer prisonState) {
        this.prisonState = prisonState;
    }

    public Date getFullDate() {
        return fullDate;
    }

    public void setFullDate(Date fullDate) {
        this.fullDate = fullDate;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born == null ? null : born.trim();
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime == null ? null : crime.trim();
    }

    public String getProcessLevel() {
        return processLevel;
    }

    public void setProcessLevel(String processLevel) {
        this.processLevel = processLevel == null ? null : processLevel.trim();
    }

    public String getLaborType() {
        return laborType;
    }

    public void setLaborType(String laborType) {
        this.laborType = laborType == null ? null : laborType.trim();
    }

    public String getEvaluateLevel() {
        return evaluateLevel;
    }

    public void setEvaluateLevel(String evaluateLevel) {
        this.evaluateLevel = evaluateLevel == null ? null : evaluateLevel.trim();
    }
}