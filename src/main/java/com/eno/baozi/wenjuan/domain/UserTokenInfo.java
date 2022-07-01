package com.eno.baozi.wenjuan.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserTokenInfo  implements Serializable {

    @ApiModelProperty(value = "返回编码")
    int code;
    @ApiModelProperty(value = "登陆结果信息")
    UserLoginInfo data;
    @ApiModelProperty(value = "返回描述")
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserLoginInfo getData() {
        return data;
    }

    public void setData(UserLoginInfo data) {
        this.data = data;
    }
}
