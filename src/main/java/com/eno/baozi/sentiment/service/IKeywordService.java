package com.eno.baozi.sentiment.service;

import com.eno.baozi.sentiment.domain.PSentimentKeyword;

import java.util.List;
import java.util.Map;

public interface IKeywordService {
    /**
     *
     */
    boolean addKeyword(String keyword);

    /**
     *
     * @param keywords
     * @return
     */
    boolean addKeywords(List<String> keywords);

    boolean delKeyword(String keyword);

    boolean delKeywords(List<String> keywords);

    List<String> getKeywords();

    Map<String, PSentimentKeyword> getKeywordsMap();
}
