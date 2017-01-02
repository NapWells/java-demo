package com.liu.SpringTransaction3;

public interface AccountDao {

	public void out(String from,double money);
	public void in(String to,double money);
}
