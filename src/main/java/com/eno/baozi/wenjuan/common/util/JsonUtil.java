package com.eno.baozi.wenjuan.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.util.StringUtils;

public class JsonUtil {

    public static String[] string2StringArr(String jsonStr){
        if (StringUtils.isEmpty(jsonStr)){
            return new String[]{};
        }
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        return jsonArray.toArray(new String[]{});
    }

    public static Object[] string2ObjectArr(String jsonStr){
        if (StringUtils.isEmpty(jsonStr)){
            return new String[]{};
        }
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        return jsonArray.toArray(new Object[]{});
    }

}
