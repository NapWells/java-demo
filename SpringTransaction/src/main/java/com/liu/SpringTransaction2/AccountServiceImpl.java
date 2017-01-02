package com.liu.SpringTransaction2;


public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void transfer(final String from, final String to, final double money) {

		accountDao.out(from, money);
		accountDao.in(to, money);

	}

}
