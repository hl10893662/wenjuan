package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserLoginInfo implements Serializable {
    @ApiModelProperty(value = "token串" ,notes="直接取编号作为token")
    String token;
    @ApiModelProperty(value = "用户编号")
    String no;
    @ApiModelProperty(value = "用户名")
    String userName;

    @ApiModelProperty(value = "用户角色",notes = "admin为管理员（狱警），editor为学员")
    String role;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
