package com.eno.baozi.sentiment.service.impl;

import cn.hutool.dfa.WordTree;
import com.eno.baozi.sentiment.dao.CriminalMessageMapper;
import com.eno.baozi.sentiment.dao.CronMarkMapper;
import com.eno.baozi.sentiment.dao.MessagesMapper;
import com.eno.baozi.sentiment.dao.PSentimentResultMapper;
import com.eno.baozi.sentiment.domain.*;
import com.eno.baozi.sentiment.service.IAnalyseSentimentService;
import com.eno.baozi.sentiment.service.IKeywordService;
import com.eno.baozi.sentiment.service.IMessagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@Primary
public class AnalyseSentimentServiceImpl implements IAnalyseSentimentService {
    private  final Logger logger = LoggerFactory.getLogger(AnalyseSentimentServiceImpl.class);


    @Autowired
    CronMarkMapper cronMarkMapper;

    @Autowired
    IMessagesService messagesService;

    @Autowired
    IKeywordService keywordService;

    @Autowired
    PSentimentResultMapper pSentimentResultMapper;

    @Autowired
    CriminalMessageMapper criminalMessageMapper;

    @Override
    public boolean  analyse(int unitId) {
        CronMark cronMark = cronMarkMapper.selectByFlag("sentiment");
        int lastId = 0;
        if (cronMark != null){
            lastId = Integer.parseInt(cronMark.getFversion());
        }
        //获取新的待处理信息

//        List<Messages> messagesList = messagesService.queryMessageListbyForAnalyse(unitId,lastId,5);
        List<Messages> messagesList = messagesService.queryMessageListbyForAnalyse(unitId,lastId,5);
        if (messagesList == null ||messagesList.size() == 0){
            logger.info("查无内容，直接返回");
            return false;
        }
        //去除重复的狱情记录
        messagesList = messagesList.stream()
                .filter(distinctByKey(Messages::getContent))
                .collect(Collectors.toList());
        logger.debug("去重后，剩余："+messagesList);
        //获取关键字
        List<String> keywords = keywordService.getKeywords();
        Map<String, PSentimentKeyword> keywordMap = keywordService.getKeywordsMap();
        WordTree wordTree  = new WordTree();
        wordTree.addWords(keywords);
        List<PSentimentResult> pSentimentResultList = new ArrayList<>();
        //每一条对应多个犯人、多个关键字
        for (Messages messages : messagesList){
            logger.debug("本次处理狱情id:{}，内容：{}",messages.getId(),new String(messages.getContent()));
            //一条记录可能对应多个人员
//            List<CriminalMessageKey> criminalMessageKeys = criminalMessageMapper.selectByMessageId(messages.getId());
            //过滤关键字
            List<String> matchWords = wordTree.matchAll(new String(messages.getContent()),-1);
            logger.debug("过滤后的关键字:{}",matchWords);
            //去重
            matchWords = matchWords.stream().distinct().collect(Collectors.toList());
            logger.debug("去重后的关键字:{}",matchWords);
            Map<String,Integer> socreMap = new HashMap<String,Integer>();
            Map<String,String> matchKeywordMap = new HashMap<String,String>();

            //根据匹配的值计算分值后写入结果
            for (String matchWord : matchWords){
                PSentimentKeyword pSentimentKeyword = keywordMap.get(matchWord);
                if (pSentimentKeyword != null){
                    //同一个分类只记录一次
                    socreMap.put(pSentimentKeyword.getFullLevelCode(),pSentimentKeyword.getScore());
                    matchKeywordMap.put(pSentimentKeyword.getFullLevelCode(),matchWord);
                }
            }
            //写入
//            for (CriminalMessageKey criminalMessageKey : criminalMessageKeys){
                socreMap.forEach((key, value) -> {
                    PSentimentResult pSentimentResult = new PSentimentResult();
                    pSentimentResult.setFirstLevel(key.split(",")[0]);
                    pSentimentResult.setSecondLevel(key.split(",")[1]);
//                    pSentimentResult.setNo(criminalMessageKey.getCriminalId());
//                    pSentimentResult.setNo(messages.getCriminalId());
                    pSentimentResult.setNo(messages.getNo());
                    pSentimentResult.setCreateTime(new Date());
                    pSentimentResult.setScore(value);
                    pSentimentResult.setInfo("");
                    pSentimentResult.setKeyword(matchKeywordMap.get(key));
                    pSentimentResult.setSentimentDate(messages.getCreatedAt());
                    pSentimentResult.setUpdateTime(new Date());
                    pSentimentResult.setSentimentId(messages.getId());
//                    pSentimentResultMapper.insert(pSentimentResult);
                    pSentimentResultList.add(pSentimentResult);
                });
//            }
        }
        pSentimentResultMapper.batchInsert(pSentimentResultList);
        //更新处理的标志位
        cronMark.setFversion(messagesList.get(messagesList.size()-1).getId().toString());
        cronMarkMapper.updateByPrimaryKey(cronMark);
        return true;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
