package tp2_exercise6;

public class Fuel {
	private String type;
	
	private int amount;
	
	final private int maxAmount = 20000;

	public Fuel(String type) {
		super();
		this.type = type;
		this.amount = this.maxAmount;
	}
	
	public void restore () {
		this.amount = this.maxAmount;
	}
	
	public boolean extract (int lts) {
		boolean result = true;
		this.amount -= lts;
		
		if (this.amount < 0) {
			this.amount = 0;
			result = false;
		}
		
		return result;
	} 
	
	public int getAmount () {
		return this.amount;
	}
}
