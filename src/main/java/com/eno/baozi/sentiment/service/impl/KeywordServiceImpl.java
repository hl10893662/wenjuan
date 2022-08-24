package com.eno.baozi.sentiment.service.impl;

import com.eno.baozi.sentiment.dao.PSentimentKeywordMapper;
import com.eno.baozi.sentiment.domain.PSentimentKeyword;
import com.eno.baozi.sentiment.service.IKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class KeywordServiceImpl implements IKeywordService {

    @Autowired
    PSentimentKeywordMapper pSentimentKeywordMapper;

    @Override
    public boolean addKeyword(String keyword) {
        return false;
    }

    @Override
    public boolean addKeywords(List<String> keywords) {
        return false;
    }

    @Override
    public boolean delKeyword(String keyword) {
        return false;
    }

    @Override
    public boolean delKeywords(List<String> keywords) {
        return false;
    }

    @Override
    public List<String> getKeywords() {
        List<PSentimentKeyword> keywordList =  pSentimentKeywordMapper.selectAllKeywords();
        List<String> wordList = new ArrayList<>();
        keywordList.stream().forEach(pSentimentKeyword->{

            Arrays.stream(pSentimentKeyword.getKeyword().split(",")).forEach(
                    word -> wordList.add(word));
        });
        return wordList;
    }

    @Override
    public Map<String, PSentimentKeyword> getKeywordsMap() {
        List<PSentimentKeyword> keywordList = pSentimentKeywordMapper.selectAllKeywords();
        Map<String,PSentimentKeyword> map = new HashMap<String,PSentimentKeyword>();
        keywordList.stream().forEach(pSentimentKeyword->{
            Arrays.stream(pSentimentKeyword.getKeyword().split(",")).forEach(
                    word ->  map.put(word,pSentimentKeyword));
           ;
        });
        return map;
    }


}
