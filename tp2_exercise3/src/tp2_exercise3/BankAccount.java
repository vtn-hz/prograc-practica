package tp2_exercise3;

public class BankAccount {
	private double money;

	private String holder;

	public BankAccount(String holder) {
		super();
		this.holder = holder;
	}
	
	public void deposit (double money) {
		this.money = money;
	}
	
	public boolean extract (double money) {
		if (this.money < money) {
			return false;
		}
		
		this.money -= money;
		return true;
	}
	
	public double getMoney() {
		return money;
	}

	public String getHolder() {
		return holder;
	}
}
