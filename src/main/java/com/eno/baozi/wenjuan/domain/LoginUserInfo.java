package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class LoginUserInfo implements Serializable {

    @ApiModelProperty(value = "用户角色",notes = "admin为管理员（狱警），editor为学员")
    String role;
    String[] roles;
    @ApiModelProperty(value = "用户介绍")
    String introduction;
    @ApiModelProperty(value = "")
    String avatar;
    @ApiModelProperty(value = "用户名称")
    String name;
    String code;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
