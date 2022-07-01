package com.eno.baozi.dangerous.report.convert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TyperConvert {
    public static int boolean2Int(boolean src){
        return src ? 1 : 0;
    }
    public static String boolean2String(boolean src){
        return src ? "1" : "0";
    }

    public static String dateToString(Date date) {
        if (date == null){
            return "";
        }
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        String tiem = sformat.format(date);

        return tiem;
    }
    public static  int getAge(Date birthDay)  {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;//当前日期在生日之前，年龄减一
                }
            }else{
                age--;//当前月份在生日之前，年龄减一
            }
        }
        return age;
    }
}