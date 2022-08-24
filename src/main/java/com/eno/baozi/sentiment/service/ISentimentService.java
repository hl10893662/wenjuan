package com.eno.baozi.sentiment.service;

import com.eno.baozi.sentiment.domain.Messages;
import com.eno.baozi.sentiment.domain.PSentiment;
import com.eno.baozi.sentiment.domain.PSentimentResult;

import java.util.List;

public interface ISentimentService {
    /**
     * 分析新的狱情（用于定时触发）
     */
    void analyse();

    List<PSentimentResult> queryKeywordByCriminalNo(String criminalNo);

    List<Messages> queryMessagesByCriminalNo(String criminalNo);


}
