package beans;

import java.util.ArrayList;
import java.util.List;

public class Account{
	private long balance;
	private long clientId;
	private List<Transaction> transactions;
	
	public Account(long clientId,long balance) {
		this.balance = balance;
		this.clientId = clientId;
		transactions = new ArrayList<>();
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	
}
