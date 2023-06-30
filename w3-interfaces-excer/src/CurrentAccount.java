
public class CurrentAccount implements Account {
	private double balance;
	private double overDraft;
	
	public CurrentAccount(double balance, double overDraft) {
		this.balance = balance;
		this.overDraft = overDraft;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
		
	}

	@Override
	public void withdraw(double amount) {
		if (balance+overDraft>amount) {
			balance -= amount;
			}
		
	}

	@Override
	public double getBalance() {
		return balance;
	}
	
	public void overDraftLimit(double overDraft) {
		this.overDraft = overDraft;
	}
}
