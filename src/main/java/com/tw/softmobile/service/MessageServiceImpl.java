package com.tw.softmobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tw.softmobile.dao.MessageDao;
import com.tw.softmobile.model.Message;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	
	@Transactional
	@Override
	public Message getMessage(Integer messageBookId) {
		return messageDao.getMessage(messageBookId);
	}
	
	
}
