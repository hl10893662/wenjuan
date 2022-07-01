package com.eno.baozi.dangerous.report.convert;


import com.eno.baozi.dangerous.report.domain.Assess;

import java.util.HashMap;
import java.util.Map;

public class AssessConvert {
    public static Map<String,String>  ASSESS_DESC_DESC = new HashMap<String,String>();
    public static String[] ASSESS_17_DESC = new String[]{"","精神分裂","抑郁","躁狂","双向情感障碍","人格障碍","性心理障碍",
            "创伤后应激障碍","急性应激障碍","精神发育迟滞",""};
    public static String[] ASSESS_20_DESC = new String[]{"","毒品","药品：一般处方药、麻醉类（吗啡、美沙酮等）","安眠药","酒精","赌博","上网",""};
    public static String[] ASSESS_21_DESC = new String[]{"","家庭缺失","单亲家庭","留守型家庭","否"};
    public static String[] ASSESS_22_DESC = new String[]{"","溺爱纵容","漠不关心","严厉粗暴","否"};
    public static String[] ASSESS_40_DESC = new String[]{"","一般违纪","较重违纪","严重违纪","重大违纪","警告、记过或禁闭"};
    public static String[] ASSESS_TITLE = new String[]{"","三类危险史","身心疾病","成瘾行为","家庭环境","生活经历","认罪态度及狱内表现","保护性因子"};

    static {

        ASSESS_DESC_DESC.put("1","过去实施过自杀行为。");
        ASSESS_DESC_DESC.put("2","最近一年内实施过自杀行为。");
        ASSESS_DESC_DESC.put("3","有自杀的念头或想法。");
        ASSESS_DESC_DESC.put("4","曾经制定过自杀计划。");
        ASSESS_DESC_DESC.put("5","重要他人曾经实施过自杀行为。");
        ASSESS_DESC_DESC.put("6","曾经实施过自伤自残行为。");
        ASSESS_DESC_DESC.put("7","曾在押送过程中或监管场所内预谋或实施过脱逃。");
        ASSESS_DESC_DESC.put("8","有流窜作案史。");
        ASSESS_DESC_DESC.put("9","在社会上曾经实施过暴力行为。");
        ASSESS_DESC_DESC.put("10","在社会上实施过严重的暴力行为。");
        ASSESS_DESC_DESC.put("11","有暴力行为相关的劣迹或前科。");
        ASSESS_DESC_DESC.put("12","有过2次及以上同暴力行为相关的劣迹或前科。");
        ASSESS_DESC_DESC.put("13","曾经在监管场所实施过暴力行为。");
        ASSESS_DESC_DESC.put("14","此次犯罪情节恶劣。");
        ASSESS_DESC_DESC.put("15","有特殊经历或技能。");
        ASSESS_DESC_DESC.put("16","四假信息尚待核实。");
        ASSESS_DESC_DESC.put("23","与家人或伴侣的联系缺失。");
        ASSESS_DESC_DESC.put("24","与家人或伴侣的矛盾突出。");
        ASSESS_DESC_DESC.put("25","家人之间存在严重矛盾，影响罪犯的情绪。");
        ASSESS_DESC_DESC.put("26","家人或伴侣发生重大变故。");
        ASSESS_DESC_DESC.put("27","家人不服判决，怂恿罪犯对抗改造。");
        ASSESS_DESC_DESC.put("28","18岁前患有品行障碍。");
        ASSESS_DESC_DESC.put("29","成年后未从事过正当职业。");
        ASSESS_DESC_DESC.put("30","人际交往能力差。");
        ASSESS_DESC_DESC.put("31","几乎没有正常交往的朋友。");
        ASSESS_DESC_DESC.put("32","漠视社会规范。");
        ASSESS_DESC_DESC.put("33","自罪感强烈。");
        ASSESS_DESC_DESC.put("34","自觉刑期漫长，或不适应改造生活，感到绝望。");
        ASSESS_DESC_DESC.put("35","不认罪服判。");
        ASSESS_DESC_DESC.put("36","以不认罪为由，拒绝服从监狱管理。");
        ASSESS_DESC_DESC.put("37","怨视司法机关。");
        ASSESS_DESC_DESC.put("38","有隐瞒余罪的可能。");
        ASSESS_DESC_DESC.put("39","余罪爆发。");
        ASSESS_DESC_DESC.put("41","自认为长期受到其他罪犯欺压。");
        ASSESS_DESC_DESC.put("42","自认为受到监狱或民警个人不公正的对待。");
        ASSESS_DESC_DESC.put("43","狱内人际关系较差。");
        ASSESS_DESC_DESC.put("44","对死亡持排斥的态度。");
        ASSESS_DESC_DESC.put("45","对暴力持排斥的态度。");
        ASSESS_DESC_DESC.put("46","对家人或伴侣负有责任感。");
        ASSESS_DESC_DESC.put("47","对未来生活有期待。");
    }

    public static String covert(Assess assess, String[] descArr){
        String[] arr = assess.getSubject().split("_");
        int index =Integer.parseInt(arr[2]);
        if(descArr.length <index){
            return "";
        }else{
            if("".equals( descArr[index])){
                return assess.getValue();
            }else{
                return descArr[index];
            }
        }
    }
}
