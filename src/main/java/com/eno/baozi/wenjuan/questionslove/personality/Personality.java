package com.eno.baozi.wenjuan.questionslove.personality;

import com.alibaba.fastjson.JSON;
import com.eno.baozi.wenjuan.domain.QuestionResult;
import com.eno.baozi.wenjuan.domain.QuestionResultDesc;
import com.eno.baozi.wenjuan.domain.QuestionResultSub;
import com.eno.baozi.wenjuan.questionslove.copa.COPA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personality {
    static Map<String,int[]> groups = new HashMap<>();
    static Map<String, PersonalityScoreDesc> descMap = new HashMap<>();
    static int[][] jsbGroup=new int[][]{{9,19,29,},{39,49,59,68},{76},{84,90},{96,101}};
    static Map<String,String> titleMap = new HashMap<>();
    static {

        titleMap.put("P1","反社会人格");
        titleMap.put("P2","偏执性人格");
        titleMap.put("P3","冲动性人格");
        titleMap.put("P4","边缘性人格");
        titleMap.put("P5","抑郁");
        titleMap.put("P6","躁狂");
        titleMap.put("P7","神经质");
        titleMap.put("P8","精神病性");
        titleMap.put("L","说谎量表");
        titleMap.put("JSB","精神病性分类");
        groups.put("P1", new int[]{-1,11,21,31,41,51,61,69,77,85,-91,97,-102});
        groups.put("P2", new int[]{2,12,22,32,42,52,62,70,78,86,92,98,103});
        groups.put("P3", new int[]{3,13,23,33,43,53,63,71,79,87,-93,99,104});
        groups.put("P4", new int[]{4,14,24,34,44,54,64,70,80,88,-94});
        groups.put("P5", new int[]{6,16,26,36,46,56,-65,73,81});
        groups.put("P6", new int[]{7,17,27,37,47,57,66,74,82});
        groups.put("P7", new int[]{8,18,28,38,48,58,67,75,83,89,95,100,105,106,107});
        groups.put("P8", new int[]{9,19,29,39,49,59,68,76,84,90,96,101});
        groups.put("L", new int[]{-15,-10,-15,-20,-25,-30,-35,40,-45,-50,-55,-60});

        descMap.put("P1",new PersonalityScoreDesc(5,9,
                "此人反社会人格倾向不明显。",
                "此人有反社会人格倾向。表现为自私自利，缺乏同情心，对人较冷漠。不能遵守社会道德规范。行为较冲动，自控能力较差。",
                "此人属反社会人格。表现为冷酷无情，自私自利，缺乏起码的爱和同情心，不关心他人。无视社会道德规范。不承担应尽的责任和义务，屡屡违反社会准则。行为冲动，易激惹，缺乏自控能力。"));
        descMap.put("P2",new PersonalityScoreDesc(5,9,
                "此人偏执性人格倾向不明显。",
                "此人有偏执性人格倾向。表现为较敏感多疑，易将他人无意或好意行为当作恶意。对人较警惕或怀有一些敌意。遇到挫折或失败时较容易归咎于周围环境与他人，易与人争执。较容易记仇，对别人的拒绝、轻视、侮辱和伤害耿耿于怀，甚至有报复之心。比较固执，遇事好争辩，听不得反面意见，不易改变其认识和想法。有时会固执地追求不合理的利益和权利。",
                "此人属偏执性人格。表现为敏感多疑，易将他人无意或好意行为当作恶意，对人过分警惕或怀有敌意，遇到挫折或失败时常归咎于周围环境与他人，易与人争执。容易记仇，对别人的拒绝、轻视，侮辱和伤害耿耿于怀，易引起强烈的敌意，常有报复之心。固执己见，自命不凡，感到怀才不遇。遇事好争辩，以为自己才是最正确，听不得反面意见，不相信与自己想法不符的客观证据，很难用说理或事实改变其认识和想法。固执地追求不合理的利益和权利，经年累月纠缠不休。"));
        descMap.put("P3",new PersonalityScoreDesc(6,11,
                "此人冲动性人格倾向不明显。",
                "此人有冲动性人格倾向。表现为情绪不够稳定，较易激惹，也容易与他人发生冲突，可能因为一点小事就产生愤怒情绪和攻击行为，较难自控。人际关系不稳定或紧张，时常导致情感危机，几乎没有持久的朋友。产生冲动情绪时，常伴随攻击行为，也可能自伤、自残甚至自杀。在日常生活和工作中也会表现冲动性，缺乏目的性和条理性，做事虎头蛇尾，很难坚持长时间完成一项工作。",
                "此人属冲动性人格。表现为情绪不稳定，易激惹，易与他人发生冲突，可因一点小事就产生愤怒情绪和攻击行为，难以自控，虽事后懊悔甚至自责，但又会复发，具有明显的一贯性。人际关系不稳定或紧张，时常导致情感危机，几乎没有持久的朋友。产生冲动情绪时，常伴随攻击行为，也可自伤、自残甚至自杀。在日常生活和工作中也会表现冲动性，缺乏目的性和条理性，做事虎头蛇尾，很难坚持长时间完成一项工作。"));
        descMap.put("P4",new PersonalityScoreDesc(4,8,
                "此人边缘性人格倾向不明显。",
                "此人属边缘性人格倾向。主要表现为情绪有些烦躁、人际关系不佳，行为不够稳定，有时有冲动行为。不易适应社会。",
                "此人属边缘性人格。主要表现为情绪烦躁、人际关系不佳，身份认同弥散，行为不稳定，并且伴随多种冲动行为。具有原始防御机制，如分裂、理想化、否认、投射等；很难承受变动和失败，不易适应社会。"));
        descMap.put("P5",new PersonalityScoreDesc(4,7,
                "此人抑郁症状不明显。",
                "此人具有抑郁症状。表现为情绪较低落。郁郁寡欢。感到生活没有多大意义，有可能产生自杀念头甚至自杀行为。思维较缓慢。反应较迟钝，语言减少，注意力较难集中，记忆力减退。常感到无精打采，活动明显减少。还可能有失眠早醒，食欲减退，便秘等症状。",
                "此人属抑郁症患者。表现为情绪低落，郁郁寡欢。感到生活没意义，会产生自杀念头甚至自杀行为。思维缓慢。反应迟钝，联想因难，语言减少，注意力集中困难，记忆力减退。精神运动性迟缓。精力减退，浑身乏力，无精打采，活动明显减少。还可能有失眠早醒，食欲减退，便秘等症状。"));
        descMap.put("P6",new PersonalityScoreDesc(4,7,
                "此人躁狂症状不明显。",
                "此人具有躁狂倾向。表现为情感较高涨或较易激惹。思维较奔逸，思维飘忽不定。 有一定的精神运动性兴奋。",
                "此人属躁狂症患者。表现为情感高涨或易激惹。思维奔逸，思维飘忽不定，联想加速。精神运动性兴奋。"));
        descMap.put("P7",new PersonalityScoreDesc(9,14,
                "此人神经质倾向不明显。",
                "此人具有神经质倾向。表现为易焦虑，情绪不稳定，较易激动。由于受激动情绪的干扰而出现不合理的行为。",
                "此人属神经质。表现为高焦虑、喜怒无常、易于激动。经常忧心忡忡，害怕有事发生。由于受激动情绪的干扰而出现不合理的行为。"));
        descMap.put("P8",new PersonalityScoreDesc(4,8,
                "此人精神病性症状不明显。",
                "此人具有某些精神病性症状，需要进一步诊断。",
                "此人具有明显的精神病性症状。可能有幻觉、妄想、情绪障碍、认知障碍和紧张综合征等一种或多种精神病性症状。"));
        descMap.put("L",new PersonalityScoreDesc(10,9,
                "回答基本诚实可信。",
                "",
                "回答不真实，建议作废。"));


    }
    public static QuestionResultSub buildReport(QuestionResult questionResult){
        QuestionResultSub sub = new QuestionResultSub();
        sub.setQuestionNo("q3");
        List<QuestionResultDesc> descList = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            QuestionResultDesc questionResultDesc = getSubResultDesc(questionResult, "P" + i);
            descList.add(questionResultDesc);
            sub.put(questionResultDesc.getTypeName(),questionResultDesc.getScore());
        }
        descList.add(calcLScore(questionResult));
        sub.setQuestionResultDescList(descList);
        return sub;
    }

    private static QuestionResultDesc calcLScore(QuestionResult questionResult){
        QuestionResultDesc questionResultDesc = new QuestionResultDesc();
        int score = calcScore("L",questionResult);
        if (score< 10){
            questionResultDesc.setDesc(descMap.get("L").getLowDesc());
        }else{
            questionResultDesc.setDesc(descMap.get("L").getHighDesc());
        }
        questionResultDesc.setTypeName(titleMap.get("L"));
        questionResultDesc.setScore(score);
        return questionResultDesc;
    }

    private static int calcScore(String titleName,QuestionResult questionResult){
        String result = questionResult.getResult();
        int[] group = groups.get(titleName);
        int score = 0;
        for (int titleNo : group) {
            if ((result.charAt(Math.abs(titleNo) - 1) == '1' && titleNo > 0)
                    || (result.charAt(Math.abs(titleNo) - 1) == '0' && titleNo < 0)) {
                score++;
            }
        }
        return score;
    }

    private static QuestionResultDesc getSubResultDesc(QuestionResult questionResult, String subName) {
        QuestionResultDesc questionResultDesc = new QuestionResultDesc();
        int score = calcScore(subName,questionResult);
        questionResultDesc.setTypeName(titleMap.get(subName));
        questionResultDesc.setDesc(descMap.get(subName).getDescByScore(score));
        questionResultDesc.setScore(score);
        return questionResultDesc;
    }

    public static void main(String[] args) {
        QuestionResult questionResult = new QuestionResult();
        questionResult.setCriminalId("1");
        questionResult.setCriminalName("baozi");
        questionResult.setQuestionNo("1");
        StringBuffer sb = new StringBuffer();
        for (int i =0 ; i<107; i++){
            sb.append(Math.random()>0.5?1:0);
        }
        questionResult.setResult(sb.toString());
        QuestionResultSub sub = Personality.buildReport(questionResult);
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
