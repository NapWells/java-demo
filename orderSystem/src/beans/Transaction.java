package beans;

import java.util.Date;

public class Transaction {
	private long id;
	private String value;
	private Date createDatetime;
	private Account account;
	private TransactionType transactionType;
	public Transaction(long id, String value, Date createDatetime, Account account, TransactionType transactionType) {
		this.id = id;
		this.value = value;
		this.createDatetime = createDatetime;
		this.account = account;
		this.transactionType = transactionType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", value=" + value + ", createDatetime=" + createDatetime + ", account="
				+ account + ", transactionType=" + transactionType + "]";
	}
	
	
}
