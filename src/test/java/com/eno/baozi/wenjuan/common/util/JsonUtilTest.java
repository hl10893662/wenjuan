package com.eno.baozi.wenjuan.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.eno.baozi.wenjuan.domain.UserInfoTemplateChoiceDTO;
import org.junit.Test;

import java.util.List;


public class JsonUtilTest {
    @Test
    public void string2StringArr(){
        String jsonStr = "[\"正常\"]";
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        jsonArray.toArray(new String[]{});
    }

    @Test
    public void string2ObjectArr(){
        UserInfoTemplateChoiceDTO[] arr = new UserInfoTemplateChoiceDTO[3];
        for (int i=0; i <3; i ++){
            UserInfoTemplateChoiceDTO dto = new UserInfoTemplateChoiceDTO();
            dto.setValue("极度贫穷"+i);
            dto.setLabel("极度贫穷"+i);
            arr[i]=dto;
        }
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(arr);
        System.out.println(jsonArray.toString());
        String jsonStr = jsonArray.toString();
        List<UserInfoTemplateChoiceDTO> VOlist = JSONArray.parseArray(jsonStr , UserInfoTemplateChoiceDTO.class);

//        JSONArray jsonArray1 = JSON.parseArray(jsonStr);
//        jsonArray.toArray(new UserInfoTemplateChoiceDTO[]{});
//        String jsonStr = "[{\"value\": \"极度贫穷\",\"label\": \"极度贫穷\"},{value: \"贫穷\",\"label\": \"贫穷\"},{value: \"温饱\",\"label\": \"温饱\"},{value: \"小康\",\"label\": \"小康\"},{value: \"富有\",\"label\": \"富有\"},{value: \"极度富有\",\"label\": \"极度富有\"}]";
//        JSONArray jsonArray = JSON.parseArray(jsonStr);
//        jsonArray.toArray(new UserInfoTemplateChoiceDTO[]{});

    }
}
