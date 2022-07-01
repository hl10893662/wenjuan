package com.eno.baozi.wenjuan.common.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ShowConvert {
    public final static String CONN_SYMBOL = "、";
    public static String[] MEDICAL_HISTORY_SHOW = new String[]{"出生时早产","癫痫","脑炎","脑膜炎","脑部外伤","甲状腺机能亢进","中毒","其他"};
    public static String[] RELY_SHOW = new String[]{"毒品","酒精","赌博","上网","药品：一般处方药、麻醉类（吗啡、美沙酮等）、安眠药","其他"};
    public static String[] HEALTH_OTHER_SHOW = new String[]{"亲人中有人精神方面出问题","本人有过精神方面问题","有心理咨询经历"};
    public static String[] SPECIAL_FAMILY_SHOW = new String[]{"子女死亡","父母死亡","父母离婚","子女出生","其他亲人死亡","亲属病重","子女行为不良 ",
            "亲人受刑事处分","子女学习不好","子女就业","妻子怀孕","子女结婚","家人受刑事处分","妻子流产","家庭成员发生纠纷 ","家人外迁"};
    public static String[] SPECIAL_MARRIED_SHOW = new String[]{"妻子死亡","与妻子离婚","夫妻感情破裂","结婚","失恋","开始恋爱","与配偶复婚","夫妻发生严重争执"};
    public static String[] SPECIAL_WORK_SHOW = new String[]{"失业","被刑事处分","发生严重差错或事故","受行政纪律处分","升学或就业受到挫折","得到晋升提拔","被免去职务","退休","工种变动"};
    public static String[] SPECIAL_LIFE_SHOW = new String[]{"得重病或外伤","名誉受损","丢失贵重物品","和上级发生冲突","受到惊吓","睡眠有重大改变","暂去外地"};
    public static String[] SPECIAL_ECONOMIC_SHOW = new String[]{"发生大量借钱或贷款或欠钱","中额借钱或贷款或欠钱","遭受财产损失","小额借钱或贷款或欠钱"};
    public static String[] SPECIAL_SOCIAL_SHOW = new String[]{"好友去世","与好友决裂","与邻居发生纠纷","与同事发生纠纷"};

    public static String[] PRISON_ENV_SHOW = new String[]{"感觉坐牢前后落差太大","担心入监后被人侮辱","担心营养不够会影响身体健康",
            "长期在监控下生活，心理上有着压抑感","心理压力大，总感觉睡眠不足","记不住规范"};

    public static String[] PRISON_SOCIAL_SHOW = new String[]{"不知道如何与民警相处","不知道如何与同改相处","不知道如何维护好亲属关系"};
    public static String[] PRISON_LABOUR_SHOW = new String[]{"担心学不好技术","担心完不成生产指标","承受不了重体力活，累坏身体"};
    public static String[] PRISON_RELEASE_SHOW = new String[]{"担心家庭接纳不了自己","担心找不到工作，遭受社会冷遇和歧视","担心难以适应竞争日益激烈的社会环境belief"};

    public static String[][] GUILT_SHOW = new String[][]{
            {"罪名定性不准确","罪名定性准确"},{"量刑过重","量刑适当","量刑偏轻"},{"未上诉","有上诉"},{"未减刑","有减刑"},{"不申诉","要申诉"}
    };

    public static Map<String,String> FAMILY_CALL_SHOW = new HashMap<>();
    public static String[] LEVEL_SHOW = new String[]{"好","良好","一般","较差","差"};
    public static String[] WORKYEAR_SHOW = new String[]{"1年以下","1-3年","3-5年","5-10年","10年以上"};

    public static String[] OCCUPATION_SHOW = new String[]{"国家公职人员","事业单位人员","国企工作人员","农民","商人","军人","无业","其他"};
    public static String[] DROP_SHOW = new String[]{"无辍学经历","小学时辍学","初中时辍学","高中时辍学","大学时辍学"};
    public static String[] PARENT_HEALTH_SHOW = new String[]{"父母死亡","父母一方死亡","残疾","离婚","犯罪","正常"};
    public static String[] BROTHER_HEALTH_SHOW = new String[]{"死亡","残疾","正常"};
    public static String[] PARENT_BEAT_SHOW = new String[]{"经常受到父母（或照料者打骂）","经常看到父母（或照料者）之间打骂"};
    public static String[] GROWUP_FEELING_SHOW = new String[]{"孤单","遗弃","关心","温暖","快乐"};
    public static String[] GROWUP_TRAINING_SHOW = new String[]{"情感温暖与理解","拒绝与否认","过度干涉与保护","惩罚与严厉"};
    static {
        FAMILY_CALL_SHOW.put("0","父亲（继父）");
        FAMILY_CALL_SHOW.put("1","母亲（继母）");
        FAMILY_CALL_SHOW.put("2","妻子（丈夫）");
        FAMILY_CALL_SHOW.put("3","女友（男友）");
        FAMILY_CALL_SHOW.put("4","爷爷");
        FAMILY_CALL_SHOW.put("5","奶奶");
        FAMILY_CALL_SHOW.put("6","外公");
        FAMILY_CALL_SHOW.put("7","外婆");
        FAMILY_CALL_SHOW.put("8","哥哥");
        FAMILY_CALL_SHOW.put("9","嫂子");
        FAMILY_CALL_SHOW.put("a","弟弟");
        FAMILY_CALL_SHOW.put("b","弟媳");
        FAMILY_CALL_SHOW.put("c","姐姐");
        FAMILY_CALL_SHOW.put("d","姐夫");
        FAMILY_CALL_SHOW.put("e","妹妹");
        FAMILY_CALL_SHOW.put("f","妹夫");
        FAMILY_CALL_SHOW.put("g","姑姑");
        FAMILY_CALL_SHOW.put("h","姑父");
        FAMILY_CALL_SHOW.put("i","舅舅");
        FAMILY_CALL_SHOW.put("j","舅母");
        FAMILY_CALL_SHOW.put("z","其他");
    }
    public static String convertToShow(String valueStr,String[] showArr){
        if (StringUtils.isEmpty(valueStr)){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<Math.min(valueStr.length(),showArr.length); i++){
            if(valueStr.charAt(i) =='1'){
                sb.append(showArr[i]).append(CONN_SYMBOL);
            }
        }
        if(sb.length()>0 ){
            String s = sb.toString();
            if(s.endsWith(CONN_SYMBOL)){
               return s.substring(0,s.length()-1);
            }
            return s;
        }

        return "";
    }

    public static String covertToShowByTypes(String valueStr,String[][] showArr){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<Math.min(valueStr.length(),showArr.length); i++){
                sb.append(showArr[i][Integer.parseInt(valueStr.charAt(i)+"")]).append(CONN_SYMBOL);
        }
        if(sb.length()>0 ){
            String s = sb.toString();
            if(s.endsWith(CONN_SYMBOL)){
                return s.substring(0,s.length()-1);
            }
            return s;
        }
        return "";
    }

    public static String convertStringArr2String(String[] arr){
        StringBuffer sb = new StringBuffer();
        if (arr.length == 0){
            return "";
        }
        for (int i = 0; i<arr.length-1; i++){
            sb.append(arr[i]).append("、");
        }
        sb.append(arr[arr.length-1]);
        return sb.toString();

    }



}
