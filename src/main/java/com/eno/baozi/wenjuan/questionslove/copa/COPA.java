package com.eno.baozi.wenjuan.questionslove.copa;

import com.alibaba.fastjson.JSON;
import com.eno.baozi.wenjuan.domain.QuestionResult;
import com.eno.baozi.wenjuan.domain.QuestionResultDesc;
import com.eno.baozi.wenjuan.domain.QuestionResultSub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class COPA {
    static Map<String,int[]> groups = new HashMap<>();
    static Map<String, AvgAndStd> avgScore = new HashMap<>();
    static Map<String,COPAScoreDesc> descMap = new HashMap<>();
    static Map<String,COPAScoreSuggest> suggestMap = new HashMap<>();

    static Map<String,String> titleMap = new HashMap<>();
    static {

        titleMap.put("P1","外倾");
        titleMap.put("P2","聪敏");
        titleMap.put("P3","同情");
        titleMap.put("P4","从属");
        titleMap.put("P5","波动");
        titleMap.put("P6","冲动");
        titleMap.put("P7","戒备");
        titleMap.put("P8","自卑");
        titleMap.put("P9","焦虑");
        titleMap.put("P10","暴力倾向");
        titleMap.put("P11","变态心理");
        titleMap.put("P12","犯罪思维");
        titleMap.put("L","说谎指标");
        titleMap.put("S","认真指标");

        groups.put("P1",new int[]{1,17,33,49,65,81,97,110});
        groups.put("P2",new int[]{2,18,34,50,66,82,98,111});
        groups.put("P3",new int[]{4,20,36,52,68,84,100,113});
        groups.put("P4",new int[]{6,22,38,54,70,86,101,114});
        groups.put("P5",new int[]{8,24,40,56,72,88,103,116});
        groups.put("P6",new int[]{10,26,42,58,74,90,105,118});
        groups.put("P7",new int[]{12,28,44,60,76,92,106,119});
        groups.put("P8",new int[]{14,30,46,62,78,94,108,121});
        groups.put("P9",new int[]{16,32,48,64,80,96,109,122});
        groups.put("P10",new int[]{3,11,19,27,35,43,51,59,67,75,83,91});
        groups.put("P11",new int[]{5,13,21,29,37,45,53,61,69,77,85,93});
        groups.put("P12",new int[]{7,15,23,31,39,47,55,63,71,79,87,95});
        groups.put("L",new int[]{9,25,41,57,73,89,104,117});
        groups.put("S",new int[]{99,102,107,112,115,120});

        avgScore.put("P1",new AvgAndStd(5.1285,2.3828));
        avgScore.put("P2",new AvgAndStd(4.3345,2.4344));
        avgScore.put("P3",new AvgAndStd(6.9572,1.4691));
        avgScore.put("P4",new AvgAndStd(2.1710,1.9742));
        avgScore.put("P5",new AvgAndStd(4.1637,2.5371));
        avgScore.put("P6",new AvgAndStd(3.7783,2.2979));
        avgScore.put("P7",new AvgAndStd(3.1612,2.3235));
        avgScore.put("P8",new AvgAndStd(3.0347,2.3788));
        avgScore.put("P9",new AvgAndStd(3.9035,2.3100));
        avgScore.put("P10",new AvgAndStd(3.8228,3.3359));
        avgScore.put("P11",new AvgAndStd(1.5697,1.8542));
        avgScore.put("P12",new AvgAndStd(4.9915,3.1602));
//        avgScore.put("L",new AvgAndStd(,));
//        avgScore.put("S",new AvgAndStd(,));
        descMap.put("P1",new COPAScoreDesc(
                "人格比较趋于内向，偏好安静和独处，不太合群。不爱社交集体活动，不太愿意与别人打交道。人际交往交际能力较差，交际面较窄，朋友较少。与人相处、合作的能力较弱，社会环境适应比较慢。除了亲密朋友之外，对一般人不爱说话，有点冷漠，不太随和。行事比较低调、严谨。",
                "人格无明显的外向或内向特征，介于孤僻和合群之间。对人既不会非常冷漠，也不会格外热情。对与人打交道没有明显的喜爱或厌恶。人际交往交际能力一般，社会环境适应中等。",
                "人格比较趋于外向，比较合群。偏好社交集体活动，喜欢和别人共同工作与娱乐。人际交往交际能力较强，交际面较宽，朋友较多。与人相处、合作的能力较强，社会环境适应较快。有点比较能说会道，对人比较热情和、随和，较为开朗，热心肠。"));
        descMap.put("P2",new COPAScoreDesc(
                "思维略显迟钝，有点和愚笨。平时不太爱动脑子，学习能力和理解能力较差。思维有时有点混乱，缺乏逻辑性。思维不够灵活、反应不够敏捷，效率较低。办事有点死板，效率较低。",
                "介于聪明与愚笨之间。聪明敏锐水平一般。学习能力、和理解能力和逻辑思维能力处于中等水平，思维的灵活性和、逻辑性、敏捷性和创新性均较为一般，效率中等。",
                "思维敏锐，和聪明。凡事特爱动脑子，好钻研。思维灵活而正确，反应敏捷而机警。善于抽象思考，有很高强的学习能力和理解能力。办事有点子，效率高。"));
        descMap.put("P3",new COPAScoreDesc(
                "同情心较差。有点冷酷无情，刚毅。心肠较硬，不轻易被感动，不太能体察别人感情。比较缺乏责任感，正义感和责任心不足，比较自私。不太同情弱者和关心帮助他人，比较不近人情。",
                "同情心水平一般，介于富有同情心和缺乏同情心之间。心肠既不是很硬，也不是很软。体察和关心他人、同情弱者方面表现一般。",
                "同情心较强。心肠比较软，敏感，易受感动，能够体察到别人的情绪感受。感情比较细腻、丰富、脆弱。比较善良友好，有一定较强的正义感和责任心感。比较有时会同情弱者，关心和帮助他人。"));
        descMap.put("P4",new COPAScoreDesc(
                "凡事较自有主见，独立性较强。凡事常有自己的一套主意。不太依赖和受制于他人，也不愿意受社会舆论压力的约束，顾忌较少。不太容易改变或放弃自己的主见。比较独树一帜行事比较有魄力，喜欢发号施令，自视较高，有较强的抱负或野心。不太容易改变或放弃自己的主见。",
                "介于随群附合、依赖与自有主见、独立之间。",
                "随群附合、依赖性较强。比较缺乏主见，依赖性较强独立性较差。，比较依从权威、习俗和传统。即使有了自己的主意，也比较容易受外界影响而改变或放弃。比较容易附合众议，迁就他人。偏好与大家共事，甘愿倾向于受别人指挥。比较温顺，好通融，反抗或进取精神不够。"));
        descMap.put("P5",new COPAScoreDesc(
                "情绪比较稳定和成熟。性情倾向于温和、稳重，比较善于自我控制。面对生活中的各种困难和挫折，比较沉着、冷静。情绪较少受外界环境的影响。情绪反应比较平稳、轻微，且较容易恢复平静。",
                "介于情绪波动和稳定之间。既不是太激动、易变，也不是很稳定、成熟。面对生活中的困难和挫折时，无明显的情绪急躁或沉着冷静特征，行为反应属于一般。",
                "情绪比较波动易变，起伏不定。性情倾向于急躁不安，较易生烦恼。面对现实中的困难和挫折时比较欠沉着、冷静。情绪较容易受外界环境的影响。情绪反应起伏波动较大，不太容易恢复平静。喜悲情绪骤变比较明显。"));
        descMap.put("P6",new COPAScoreDesc(
                "客观现实，冷静理智。为人处事小心翼翼，深思熟虑。容易思前顾后，犹豫不决。遇事很难激动起来，感情淡漠。行事酷爱安排周详，条理性强，细心周致。从不鲁莽从事，有足够耐心。",
                "现实理智与感情用事之间。既不是特别理智，思前顾后，犹豫不决，也不是冲动莽撞、感情用事。",
                "比较感情用事，冲动鲁莽。情绪有些激动，精力比较旺盛、充沛，较有激情。行事前较少思考，比较感情和意气用事，倾向于随心所欲，不计后果。愤怒或烦恼时缺乏抑制，过分追求一时个人快乐。大方爽快，不拘小节。比较粗心大意，忽视细节。"));
        descMap.put("P7",new COPAScoreDesc(
                "戒备心较弱。对人多加信任和依赖，不太喜欢角逐竞争，尔虞我诈。与人比较容易真诚相处，谦逊礼让。对周围世界持较明显的积极和合作态度。为人较随和，坦诚。想法较天真、幼稚，阅历较肤浅，自我保护意识较差，理想主义。",
                "戒备心一般。对人既不是过于信任和依赖，也不是过于猜忌和怀疑。想法介于理想主义和现实主义之间。",
                "戒备心较强。对人多加猜忌和怀疑，疑人疑鬼。对周围世界持比较明显的敌视和排斥态度。一般不太信任他人。为人刚愎自用，固执己见，戒心较重。想法比较复杂、狡猾，阅历较丰富，城府较深，自我保护意识强，现实主义。"));
        descMap.put("P8",new COPAScoreDesc(
                "有较强的自信心，不自卑。对自己的能力和表现有较大的信心，比较相信自己能够取得最后的成功。做事不会轻易动摇和放弃。自我感觉较好，心中比较有数，有较高的优越感。遇事比较安祥、沉着，心中比较有数。众人面前表现大方，坦然自若。",
                "自卑感一般。对自己的能力和表现既不是信心十足，也不是根本没有一点毫无信心。介于自卑和自信之间。",
                "有很强的自卑感，明显缺乏自信心。对自己的能力和表现毫无根本没有一点信心。做事很容易动摇或半途而费。与人相比总是感到自愧不如。众人面前表现很不自然。关键时候很容易紧张退缩，发挥明显失常。"));
        descMap.put("P9",new COPAScoreDesc(
                "焦虑感较弱。对自己的将来或前途较有信心。有一定的安全感，较少患得患失，忧虑抑郁。心境比较舒畅、开朗。",
                "焦虑感一般。介于对前途充满信心与悲观失望之间。",
                "焦虑感很强。通常忧虑抑郁，忧心忡忡。对自己的前途或前途明显缺乏毫无信心，沮丧悲观。明显缺乏安全感，思想包袱很大。焦虑不安，心身疲乏，伴有失眠、恶梦、恐怖等现象，容易出现不够理智的行为，是自伤、自残、自杀的高危人群。"));
        descMap.put("P10",new COPAScoreDesc(
                "暴力倾向较弱。比较安守本分，报复欲较小。不太喜欢刺激和冒险，比较喜欢有秩序的生活方式。为人比较谦逊，不霸道。不太喜欢争强好胜。比较胆小怕事，羞涩退缩，一般不会主动挑起事端。与人冲突时比较能退让求全，留有余地。解决分歧不太倾向于使用暴力。为人慈悲为怀，比较宽宏大量。生活态度倾向于依赖，保守，听天由命，比较缺乏反抗或进取精神。",
                "暴力倾向一般。介于安守本分、宽宏大量和恃强霸道、睚眦必报之间。",
                "暴力倾向较强。不太安守本分，比较恃强霸道，报复欲较大。喜欢刺激和冒险，不太甘于现状。为人有点武断和霸道。比较喜欢寻事挑衅，惹事生非，争强好胜，胆大敢为。与人冲突时轻易不会退让。解决分歧比较崇尚和迷信暴力，解决分歧倾向于使用暴力。气量较小，容易睚眦必报。生活态度比较独立，求变，有一定的反抗精神，不太易屈服。"));
        descMap.put("P11",new COPAScoreDesc(
                "无",
                "有轻微的变态心理倾向。变态心理倾向只表现在以下某一个方面：偷窃癖、虐待狂、性变态、纵火狂、妄想症和幻觉、心理过敏等。",
                "有较强的变态心理倾向。变态心理倾向突出表现在以下几个方面：偷窃癖、虐待狂、性变态、纵火狂、妄想症和幻觉、心理过敏等。"));
        descMap.put("P12",new COPAScoreDesc(
                "犯罪思维程度轻微，牵涉面较窄。犯罪思维模式只表现在以下少数方面：惟利是图，自私自利，侥幸心理，胆大妄为，不择手段，虚假不诚，自律不严等。",
                "犯罪思维程度一般，牵涉面中等。犯罪思维模式突出表现在以下半数方面：惟利是图，自私自利，侥幸心理，胆大妄为，不择手段，虚假不诚，自律不严等。",
                "犯罪思维程度严重，牵涉面较广。犯罪思维模式突出表现在以下大多数方面：惟利是图，自私自利，侥幸心理，胆大妄为，不择手段，虚假不诚，自律不严等。"));
        descMap.put("L",new COPAScoreDesc(
                "回答基本诚实可信。",
                "疑似说谎。",
                "回答不真实，建议作废。"));
        descMap.put("S",new COPAScoreDesc(
                "回答基本认真。",
                "",
                "回答不认真，建议作废。"));

//        suggestMap.put("P1",new COPAScoreSuggest(
//                "加强交流与沟通，平时要注意观察和了解，一旦遭受刺激或挫折，要及时对其进行心理疏导和宣泄，鼓励多参加集体社交活动。",
//                "","注意正确利用人缘好与交际能力强的特点。"
//                ));
//
//        suggestMap.put("P2",new COPAScoreSuggest(
//                "不太胜任较复杂、应变能力要求较高的任务。","","注意正确利用聪明、善于应变的特点。"
//                ));
//        suggestMap.put("P3",new COPAScoreSuggest(
//                "一旦发生事件，后果可能很严重。注意培养同情心和爱心，增强责任感。",
//                "",
//                "注意发挥同情心和责任心强的特点，适合情感教育。"
//                ));
//        suggestMap.put("P4",new COPAScoreSuggest(
//                "可能是非正规团体的首领或意外事件的实施者，注意预防监控。比较固执己见，改造难度较大。",
//                "",
//                "容易受亚文化的影响或左右，多注意开展正面的引导和教育。"
//                ));
//        suggestMap.put("P5",new COPAScoreSuggest(
//                "注意正确利用沉稳的特点。",
//                "",
//                "注意防止因情绪波动易变而可能带来的不良后果。"
//                ));
//        suggestMap.put("P6",new COPAScoreSuggest(
//                "注意正确利用理智、细致的优点。",
//                "",
//                "注意防止因冲动鲁莽、考虑不周而可能带来的不良后果。"
//                ));
//        suggestMap.put("P7",new COPAScoreSuggest(
//                "注意正确利用坦诚幼稚、城府不深的特点。",
//                "",
//                "外在行为表现可能与内心真实想法不一致，城府较深，应多加留心和提防。"
//                ));
//        suggestMap.put("P8",new COPAScoreSuggest(
//                "注意正确利用自信心强的特点。",
//                "",
//                "平时多采取鼓励的方式，注意提防因过于自卑而可能带来的不良后果。"
//                ));
//        suggestMap.put("P9",new COPAScoreSuggest(
//                "",
//                "",
//                "注意提防因过于焦虑而可能带来的自伤、自杀等不良后果，进行适当的心理干预。"
//                ));
//        suggestMap.put("P10",new COPAScoreSuggest(
//                "",
//                "",
//                "可能具有较高的人身危险性，尤其在面临冲突事件或存在潜在隐患时，加强预防监控与矫正力度。"
//                ));
//        suggestMap.put("P11",new COPAScoreSuggest(
//                "",
//                "",
//                "作进一步的心理诊断，注意提防因变态心理而可能带来的不良后果，进行适当的心理干预。"
//                ));
//        suggestMap.put("P12",new COPAScoreSuggest(
//                "",
//                "",
//                "可能具有较深的主观恶性和反社会意识，加强预防监控和矫正力度。"
//                ));


        suggestMap.put("P1",new COPAScoreSuggest(
                "该犯较内向，建议对其加强交流与沟通，平时要注意观察和了解，一旦遭受刺激或挫折，要及时对其进行心理疏导和宣泄，鼓励多参加集体社交活动，可安排改造表现好的老犯或老乡同他交流，培养其主动与警官、同改交流的习惯。",
                "",
                "该犯较为外向，注意正确利用该犯比较外向、合群的特点，多安排其参加集体活动，使其更快得适应监狱环境。"
        ));

        suggestMap.put("P2",new COPAScoreSuggest(
                "该犯自认为自己迟钝，不太胜任较复杂、应变能力要求较高的任务，建议对其观察，如若果真较迟钝，建议民警应耐心引导，同时对其加强劳动技能培训，在生产任务安排上循序渐进，不可操之过急。",
                "",
                "该犯自认为比较聪明，思维灵活，学习能力强，注意正确利用其聪明、善于应变的特点，给予其较复杂的任务，提升其能力，增强其自我效能感。"

        ));
        suggestMap.put("P3",new COPAScoreSuggest(
                "鉴于该犯测试中显示同情心较差，可能不轻易被感动，建议对其进行人文教育，引导其学会站在他人的角度，理解他人，同情他人，关心别人，对其日常看似微不足道的爱心言行，要及时给予鼓励和表扬。。",
                "",
                "注意发挥同情心和责任心强的特点，适合情感教育。"
        ));
        suggestMap.put("P4",new COPAScoreSuggest(
                "该犯戒备心可能较强，对民警和他人不大信任，外在行为表现可能与内心真实想法可能不一致，对其在留心和提防的同时，应多与其沟通交流，满足其合理要求,使其感受到民警的人文关怀，多安排其参加团体互助类活动，培养其对他人的信任感，从而消除其戒备心理。",
                "",
                "该犯从属性强，缺乏主见，容易受亚文化的影响或左右，应对其多注意开展正面的引导和教育，培养其独立思考的习惯，确定其遵纪守法的观念，以免被其他犯人错误的观点所误导。"
        ));
        suggestMap.put("P5",new COPAScoreSuggest(
                "注意正确利用沉稳的特点。",
                "",
                "该犯情绪容易波动，面对困难时易受外界影响，往往急躁烦恼，难以平静，应对该犯加强沟通，引导其把苦恼倾诉，或者多安排其参加集体活动，使其负面情绪得以宣泄，同时教育其学会积极暗示，缓解心理压力，以防范其因情绪波动易变而可能带来的不良后果。"
        ));
        suggestMap.put("P6",new COPAScoreSuggest(
                "注意正确利用理智、细致的优点。",
                "",
                "鉴于该犯比较感情用事，冲动鲁莽，应引导该犯学会使用推迟愤怒、语言暗示、转移注意力、环境转换、描述自身感觉等方法来克制冲动，学会正确处理矛盾的方法，从而防范其该犯因冲动、考虑不周而可能带来的不良后果。"
        ));
        suggestMap.put("P7",new COPAScoreSuggest(
                "注意正确利用坦诚幼稚、城府不深、坦诚幼稚的特点。",
                "",
                "该犯戒备心可能较强，对民警和他人不大信任，外在行为表现可能与内心真实想法可能不一致，对其在留心和提防的同时，应多与其沟通交流，满足其合理要求,使其感受到民警的人文关怀，多安排其参加团体互助类活动，培养其对他人的信任感，从而消除其戒备心理。 "
        ));
        suggestMap.put("P8",new COPAScoreSuggest(
                "该犯对自己的能力较自信，注意正确激励，给予其较复杂的任务，提升其能力，增强其自我效能感。",
                "",
                "该犯自卑感较强，觉得自己比别人差，建议平时多采取鼓励的方式，通过优点分析、自我暗示等方法提高其自信心，注意提防其因过于自卑而逃避改造困难、自暴自弃。"
        ));
        suggestMap.put("P9",new COPAScoreSuggest(
                "",
                "",
                "该犯当下焦虑，对自己的将来或前途缺乏信心，应帮助其掌握精神放松的自我调节方法，识别可能存在的“糟糕至极”等错误认知方式，用他犯的类似经历或自身过去成功经历来打消其焦虑紧张心态，提防其因焦虑而可能带来的自伤自残、自杀等不良后果。"
        ));
        suggestMap.put("P10",new COPAScoreSuggest(
                "",
                "",
                "该犯暴力倾向较高，具有较高的人身危险性，应引导该犯学习忍耐及宽容，正确表达愤怒，在面临冲突事件或存在潜在隐患时，应加强预防监控与矫正力度，如果该犯因暴力发生违规行为，应及时地教育，明确地惩罚以矫正其以暴力解决问题的不良行为方式。"
        ));
        suggestMap.put("P11",new COPAScoreSuggest(
                "",
                "",
                "作进一步的心理诊断，注意提防因变态心理而可能带来的不良后果，进行适当的心理干预。"
        ));
        suggestMap.put("P12",new COPAScoreSuggest(
                "",
                "",
                "该犯的心理测试显示其犯罪思维程度较严重，犯罪思维模式突出表现在以下大多数方面：惟利是图，自私自利，侥幸心理，胆大妄为，不择手段，虚假不诚，自律不严等，即该可能具有较高较深的主观恶性和反社会意识，应对其加强预防监控与矫正力度。"
        ));


    }


    public static QuestionResultSub buildReport(QuestionResult questionResult){
        QuestionResultSub sub = new QuestionResultSub();
        sub.setQuestionNo("q1");
        List<QuestionResultDesc> descList = new ArrayList<>();
        for (int i = 1; i<=12; i++){
            QuestionResultDesc desc = getSubResultDesc(questionResult,"P"+i);
            descList.add(desc);
            sub.put(desc.getTypeName(),desc.getScore());
        }
        descList.add(calcLScore(questionResult));
        descList.add(calcSScore(questionResult));
        sub.setQuestionResultDescList(descList);
        return sub;
    }

    public static Map<String,QuestionResultDesc>  calcIndividualScore(QuestionResult questionResult){
        Map<String,QuestionResultDesc> questionResultDescMap = new HashMap<>();
        for (int i = 1; i<=12; i++){
            QuestionResultDesc desc = getSubResultDesc(questionResult,"P"+i);
            questionResultDescMap.put(i+"",desc);
        }

        questionResultDescMap.put("L",calcLScore(questionResult));
        questionResultDescMap.put("S",calcSScore(questionResult));
        return questionResultDescMap;
    }

    private static QuestionResultDesc calcLScore(QuestionResult questionResult){
        QuestionResultDesc questionResultDesc = new QuestionResultDesc();
        int score = calcScore("L",questionResult);
        questionResultDesc.setScore(score);
        if (score<=3){
            questionResultDesc.setDesc(descMap.get("L").getLowDesc());
        }else if (score ==4){
            questionResultDesc.setDesc(descMap.get("L").getMiddleDesc());
        }else{
            questionResultDesc.setDesc(descMap.get("L").getHighDesc());
        }
        questionResultDesc.setTypeName(titleMap.get("L"));
        return questionResultDesc;
    }

    private static QuestionResultDesc calcSScore(QuestionResult questionResult){
        QuestionResultDesc questionResultDesc = new QuestionResultDesc();
        int score = comparePair(questionResult,30,99)
                +comparePair(questionResult,33,102)
                +comparePair(questionResult,38,107)
                +comparePair(questionResult,42,112)
                +comparePair(questionResult,50,115)
                +comparePair(questionResult,56,120);
        questionResultDesc.setScore(score);
        if (score<=2){
            questionResultDesc.setDesc(descMap.get("S").getLowDesc());
        }else {
            questionResultDesc.setDesc(descMap.get("S").getHighDesc());
        }
        questionResultDesc.setTypeName(titleMap.get("S"));
        return questionResultDesc;
    }

    private static int comparePair(QuestionResult questionResult,int index1,int index2){
        String result = questionResult.getResult();
        if (result.charAt(index1-1) == result.charAt(index2-1)){
            return 1;
        }else{
            return 0;
        }
    }

    private static QuestionResultDesc getSubResultDesc(QuestionResult questionResult, String subName){
        int score = calcScore(subName,questionResult);
        //std
        AvgAndStd avgAndStd = avgScore.get(subName);

        long stdScore =Math.round(50+
                                    10*(
                                            (score-avgAndStd.getAvg())/avgAndStd.getStd()
                                    )
                                );
        COPAScoreDesc scoreDesc = descMap.get(subName);
        QuestionResultDesc questionResultDesc = new QuestionResultDesc();
        questionResultDesc.setDesc(scoreDesc.getDescByScore(stdScore));
        questionResultDesc.setTypeName(titleMap.get(subName));
        questionResultDesc.setScore(stdScore);
        COPAScoreSuggest suggest = suggestMap.get(subName);
        questionResultDesc.setSuggest(suggest.getDescByScore(stdScore));

        questionResultDesc.setScoreAndLevel(stdScore+"("+scoreDesc.getLevelByScore(stdScore)+")");
        return questionResultDesc;
    }

    private static int calcScore(String titleName,QuestionResult questionResult){
        String result = questionResult.getResult();
        int[] group =  groups.get(titleName);
        int score = 0;
        for (int titleNo :group){
            if (result.charAt(titleNo-1) == '1'){
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        QuestionResult questionResult = new QuestionResult();
        questionResult.setCriminalId("1");
        questionResult.setCriminalName("baozi");
        questionResult.setQuestionNo("1");
        StringBuffer sb = new StringBuffer();
        for (int i =0 ; i<122; i++){
            sb.append(Math.random()>0.5?1:0);
        }
        questionResult.setResult(sb.toString());
        QuestionResultSub sub = COPA.buildReport(questionResult);;
        List<QuestionResultDesc> list = sub.getQuestionResultDescList();

        int i=1;
        for(QuestionResultDesc questionResultDesc:list){
            System.out.println(i+"、"+questionResultDesc.getTypeName()+"，得分:"+questionResultDesc.getScore());
//            System.out.println("      "+questionResultDesc.getDesc());
            System.out.println("      "+questionResultDesc.getSuggest());
            i++;
        }

//        String s = JSON.toJSONString(sub);
//        System.out.println("toJsonString()方法：s=" + s);

    }

}
