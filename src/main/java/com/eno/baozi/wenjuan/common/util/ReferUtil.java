package com.eno.baozi.wenjuan.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReferUtil {
    public static String getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getField(fieldName);
            //设置对象的访问权限，保证对private的属性的访问

            return (String) field.get(object);
        } catch (Exception e) {

            return "";
        }
    }
    public static boolean getFieldBooleanValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getField(fieldName);
            //设置对象的访问权限，保证对private的属性的访问

            return (Boolean) field.get(object);
        } catch (Exception e) {
            return false;
        }
    }

    public static String convertBooleanToString(Object object,String namePre,int filedSize){
        StringBuffer sb  =new StringBuffer();
        for (int i = 1; i<=filedSize; i++){
            sb.append(TyperConvert.boolean2String(ReferUtil.getFieldBooleanValueByFieldName(namePre+i,object)));
        }
        return sb.toString();
    }

    public static String convertStringToString(Object object,String namePre,int filedSize){
        StringBuffer sb  =new StringBuffer();
        for (int i = 1; i<=filedSize; i++){
            sb.append(ReferUtil.getFieldValueByFieldName(namePre+i,object));
        }
        return sb.toString();
    }

    public static void convertStringToParam(Object object, String namePre, int filedSize, String value){
        StringBuffer sb  =new StringBuffer();
        for (int i = 1; i<=filedSize; i++){

            ReferUtil.setFieldValueByFieldName(namePre+i,object,value.substring(i-1,i));
        }
    }

    public static void setFieldValueByFieldName(String fieldName, Object object,Object value) {
        Field name = null;
        try {
            name = object.getClass().getDeclaredField(fieldName);
            name.setAccessible(true);
            name.set(object, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static List removeEmpty(List list)  {
        if (list.size() == 0){
            return list;
        }
        List newList = new ArrayList();
        try{
            Method method = list.get(0).getClass().getDeclaredMethod("ifEmpty");
            for (int i = 0; i<list.size(); i++){
                if ((Boolean) method.invoke(list.get(i))){
                }else{
                    newList.add(list.get(i));
                }
            }
            return newList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
