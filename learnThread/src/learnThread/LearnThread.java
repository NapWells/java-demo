package learnThread;

public class LearnThread {
	public static void main(String [] args){
		BankAccount account = new BankAccount();
		Thread husband = new  BankThread(account);
		Thread wife = new  BankThread(account);
		husband.start();
		wife.start();
	}
}

class BankAccount{
	private double balance = 1000;
	public synchronized  boolean deposit(double newAdd){
		if(newAdd<=0)
			return false;
		else{
			System.out.println("当前的余额为 "+balance);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance += newAdd;
			System.out.println("新的余额为 "+balance);
			return true;
		}
	}
}

class BankThread extends Thread{
	private BankAccount account;
	
	public BankThread(BankAccount account) {
		this.account = account;
	}

	public void run(){
		account.deposit(200);
	}
}