package com.eno.baozi.wenjuan.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TyperConvert {

    public static int boolean2Int(boolean src){
        return src ? 1 : 0;
    }
    public static String boolean2String(boolean src){
        return src ? "1" : "0";
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sformat = new SimpleDateFormat("yyyyMMdd");//日期格式
        String time = sformat.format(date);

        return time;
    }

}
