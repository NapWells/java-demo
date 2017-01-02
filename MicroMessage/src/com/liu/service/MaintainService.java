package com.liu.service;

import java.util.ArrayList;
import java.util.List;

import com.liu.dao.MessageDao;

public class MaintainService {
	public boolean deleteOne(String id){
		if(id != null && !"".equals(id.trim())){
			MessageDao dao = new MessageDao();
			return dao.deleteOne(Integer.valueOf(id));
		}
		return false;
	}
	
	public boolean deleteBatch(String[] arr){
		if(arr!=null){
			List<Integer>  deleteList = new ArrayList<>();
			for(String id : arr){
				deleteList.add(Integer.parseInt(id));
			}
			MessageDao dao = new MessageDao();
			return dao.deleteBatch(deleteList);
		}
		return false;
	}
}
