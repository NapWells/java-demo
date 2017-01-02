package com.liu.SpringTransaction3;


public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void transfer(final String from, final String to, final double money) {

		accountDao.out(from, money);
		int i = 1/0;
		accountDao.in(to, money);

	}

}
