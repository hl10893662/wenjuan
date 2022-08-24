package com.eno.baozi.sentiment.service.impl;

import com.eno.baozi.sentiment.dao.*;
import com.eno.baozi.sentiment.domain.*;
import com.eno.baozi.sentiment.service.IAnalyseSentimentService;
import com.eno.baozi.sentiment.service.IMessagesService;
import com.eno.baozi.sentiment.service.ISentimentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class SentimentServiceImpl implements ISentimentService {
    private  final Logger logger = LoggerFactory.getLogger(SentimentServiceImpl.class);


    @Value("#{T(java.lang.Integer).parseInt('${prison.info.unitId:0}')}")
    int unitId;

    @Autowired
    IAnalyseSentimentService analyseSentimentService;

    @Autowired
    PSentimentResultMapper pSentimentResultMapper;

    @Autowired
    IMessagesService messagesService;

    @Override
    public void analyse() {
        logger.debug("start yq analyse!!!!!!!!!!!!!!!!!!!!!!!");
        boolean flag = true;
        while(flag){
            flag = analyseSentimentService.analyse(unitId);
        }
    }

    @Override
    public List<PSentimentResult> queryKeywordByCriminalNo(String criminalNo) {
        List<PSentimentResult> list = pSentimentResultMapper.queryListByCriminalNo(criminalNo);
        return list;
    }

    @Override
    public List<Messages> queryMessagesByCriminalNo(String criminalNo) {
        return messagesService.queryMessagesByCriminalNo(criminalNo);
    }


}
