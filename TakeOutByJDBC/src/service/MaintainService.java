package service;

import dao.UserMaintainDao;
import pojo.User;

public class MaintainService {
	public boolean register(String str,String password){
		UserMaintainDao md = new UserMaintainDao();
		return md.register(str, null, null, password);
	}
	
	public boolean updateUser(User user){
		UserMaintainDao md = new UserMaintainDao();
		return md.updateUser(user);
	}
}
