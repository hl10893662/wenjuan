package com.eno.baozi.wenjuan.common.util;

import org.springframework.util.StringUtils;

public class NameConvert {
    public static String bigGroupFullName2Name(String fullName){
        if (StringUtils.isEmpty(fullName)){
            return "";
        }
        String name = "";
        if (fullName.indexOf("监狱") != -1){
            name = fullName.substring(fullName.indexOf("监狱")+2);
        }else{
            return fullName;
        }
        return name;
    }

    public static String groupFullName2Name(String fullName){
        if (StringUtils.isEmpty(fullName)){
            return "";
        }
        String temp = bigGroupFullName2Name(fullName);
        String name = "";
        if (temp.indexOf("监区") != -1){
            name = fullName.substring(fullName.indexOf("监区")+2);
        }else{
            return temp;
        }
        return name;
    }
}
