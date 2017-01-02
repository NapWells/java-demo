package service;

import dao.UserQueryDao;
import pojo.User;

public class QueryUserService {
	public User login(String username,String password){
		UserQueryDao uqd = new UserQueryDao();
		return uqd.login(username,username,username, password);
	}
	
}
