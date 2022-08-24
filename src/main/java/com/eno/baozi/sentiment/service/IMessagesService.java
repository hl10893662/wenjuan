package com.eno.baozi.sentiment.service;

import com.eno.baozi.sentiment.domain.Messages;

import java.util.List;

public interface IMessagesService {

    List<Messages> queryMessageListbyForAnalyse(int unitId, int lastId, int pageSize);

    List<Messages> queryMessagesByCriminalNo(String criminalId);

}
