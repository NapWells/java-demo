package com.lhy.client;

import com.google.gson.Gson;
import com.lhy.pojo.Diary;
import com.lhy.service.Service;

public class Main {
	public static void main(String [] args){
		Gson gson = new Gson();
		Service s = new Service();
//		Diary diary = gson.fromJson(s.getStringJson(), Diary.class);
//		System.out.println("ret:"+diary.isRet());
//		System.out.println("errcode"+diary.getErrcode());
//		System.out.println("errmsg:"+diary.getErrmsg());
//		System.out.println("ver:"+diary.getVer());
//		System.out.println("books:"+diary.getData().getBooks());
	}
}
