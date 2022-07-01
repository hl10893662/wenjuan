package com.eno.baozi.wenjuan.questionslove.faceproblem;

import com.alibaba.fastjson.JSON;
import com.eno.baozi.wenjuan.domain.QuestionResult;
import com.eno.baozi.wenjuan.domain.QuestionResultDesc;
import com.eno.baozi.wenjuan.domain.QuestionResultSub;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceProblem {
    static Map<String, String> titleMap = new HashMap<>();
    static Map<String, int[]> groups = new HashMap<>();
    static {
        titleMap.put("P1", "解决问题");
        titleMap.put("P2", "自责");
        titleMap.put("P3", "求助");
        titleMap.put("P4", "幻想");
        titleMap.put("P5", "退避");
        titleMap.put("P6", "合理化");
        groups.put("P1", new int[]{1, 2, 3, 5, 8, -19, 29, 31, 40, 46, 51, 55});
        groups.put("P2", new int[]{15, 23, 25, 37, 39, 48, 50, 56, 57, 59});
        groups.put("P3", new int[]{10, 11, 14, -36, -39, -42, 43, 53, 60, 62});
        groups.put("P4", new int[]{4, 12, 17, 21, 22, 26, 28, 41, 45, 49});
        groups.put("P5", new int[]{7, 13, 16, 19, 24, 27, 32, 35, 44, 47});
        groups.put("P6", new int[]{6, 9, 18, 20, 30, 38, 52, 54, 58, 61});

    }

    public static QuestionResultSub buildReport(QuestionResult questionResult) {
        QuestionResultSub sub = new QuestionResultSub();
        sub.setQuestionNo("Q2");
        List<QuestionResultDesc> descList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            QuestionResultDesc questionResultDesc = getSubResultDesc(questionResult, "P" + i);
            descList.add(questionResultDesc);
            sub.put(questionResultDesc.getTypeName(),questionResultDesc.getScore());
        }
        sub.setQuestionResultDescList(descList);
        return sub;
    }

    private static QuestionResultDesc getSubResultDesc(QuestionResult questionResult, String subName) {
        QuestionResultDesc questionResultDesc = new QuestionResultDesc();
        String result = questionResult.getResult();
        int[] group = groups.get(subName);
        int score = 0;
        for (int titleNo : group) {
            if ((result.charAt(Math.abs(titleNo) - 1) == '1' && titleNo > 0)
                    || (result.charAt(Math.abs(titleNo) - 1) == '0' && titleNo < 0)) {
                score++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        questionResultDesc.setScore(Double.parseDouble(df.format(score*1.00/group.length)));
        questionResultDesc.setTypeName(titleMap.get(subName));
        questionResultDesc.setDesc(score + "分");
        return questionResultDesc;
    }

    public static void main(String[] args) {
        QuestionResult questionResult = new QuestionResult();
        questionResult.setCriminalId("1");
        questionResult.setCriminalName("baozi");
        questionResult.setQuestionNo("1");
        StringBuffer sb = new StringBuffer();
        for (int i =0 ; i<62; i++){
            sb.append(Math.random()>0.5?1:0);
        }
        questionResult.setResult(sb.toString());
        QuestionResultSub sub =FaceProblem.buildReport(questionResult);
                List<QuestionResultDesc> list = sub.getQuestionResultDescList();
        int i=1;
        for(QuestionResultDesc questionResultDesc:list){
            System.out.println(i+"、"+questionResultDesc.getTypeName());
            System.out.println("      "+questionResultDesc.getDesc());
            i++;
        }
        String s = JSON.toJSONString(sub);
        System.out.println("toJsonString()方法：s=" + s);
    }
}
