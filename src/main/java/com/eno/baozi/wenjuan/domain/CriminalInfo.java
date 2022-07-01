package com.eno.baozi.wenjuan.domain;

import java.io.Serializable;

public class CriminalInfo implements Serializable {
    String name;
    String no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CriminalInfo{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }
}
