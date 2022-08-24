package com.eno.baozi.sentiment.service.impl;

import com.eno.baozi.sentiment.dao.MessagesMapper;
import com.eno.baozi.sentiment.domain.Messages;
import com.eno.baozi.sentiment.service.IMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MessagesServiceImpl implements IMessagesService {

    @Autowired
    MessagesMapper messagesMapper;

    @Override
    public List<Messages> queryMessageListbyForAnalyse(int unitId, int lastId, int pageSize) {
//        List<Messages> messagesList = messagesMapper.selectTheDayBeforeById(unitId,lastId,100);
        List<Messages> messagesList = messagesMapper.selectTheDayBeforeForAllById(lastId,500);

        return messagesList;
    }

    @Override
    public List<Messages> queryMessagesByCriminalNo(String criminalNo) {
        List<Messages> messagesList = messagesMapper.queryMessagesByCriminalNo(criminalNo);
        return messagesList;
    }
}
