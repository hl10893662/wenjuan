package com.eno.baozi.sentiment.domain;

import java.util.Date;

public class CronMark {
    private Integer id;

    private String flag;

    private Date fstamp;

    private String fversion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getFstamp() {
        return fstamp;
    }

    public void setFstamp(Date fstamp) {
        this.fstamp = fstamp;
    }

    public String getFversion() {
        return fversion;
    }

    public void setFversion(String fversion) {
        this.fversion = fversion == null ? null : fversion.trim();
    }
}