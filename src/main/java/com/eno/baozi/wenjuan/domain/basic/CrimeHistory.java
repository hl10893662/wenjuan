package com.eno.baozi.wenjuan.domain.basic;

import org.springframework.util.StringUtils;

import java.io.Serializable;

public class CrimeHistory implements Serializable {
    public int order;
    public String name;
    public String imprisonDate;
    public String imprisonStartAndEnd;
    public String address;
    public String commutation;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImprisonDate() {
        return imprisonDate;
    }

    public void setImprisonDate(String imprisonDate) {
        this.imprisonDate = imprisonDate;
    }

    public String getImprisonStartAndEnd() {
        return imprisonStartAndEnd;
    }

    public void setImprisonStartAndEnd(String imprisonStartAndEnd) {
        this.imprisonStartAndEnd = imprisonStartAndEnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommutation() {
        return commutation;
    }

    public void setCommutation(String commutation) {
        this.commutation = commutation;
    }

    public boolean ifEmpty(){
      if (StringUtils.isEmpty(name) || StringUtils.isEmpty(imprisonDate)){
            return true;
      }else{
        return false;
      }
    }
}
