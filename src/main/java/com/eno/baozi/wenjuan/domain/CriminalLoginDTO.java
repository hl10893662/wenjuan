package com.eno.baozi.wenjuan.domain;

public class CriminalLoginDTO {
    public String username;
    public String password;
    public String no;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CriminalLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", no='" + no + '\'' +
                '}';
    }
}

