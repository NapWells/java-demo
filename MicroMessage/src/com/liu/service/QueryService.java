package com.liu.service;

import java.util.List;

import com.liu.beans.Message;
import com.liu.dao.MessageDao;
import com.liu.util.Iconst;

public class QueryService {
	public List<Message> queryMessageList(String command,String description){
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
	
	public String queryByCommand(String command){
		MessageDao messageDao = new MessageDao();
		List<Message> listMessage= messageDao.queryMessageList(command, null);
		if(listMessage.size()>0)
			return listMessage.get(0).getContent();
		return Iconst.NO_MATCHING_CONTENT;
	}
}
