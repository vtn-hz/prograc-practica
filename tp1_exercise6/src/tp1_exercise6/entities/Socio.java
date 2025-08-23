package tp1_exercise6.entities;

public class Socio implements SocioInterface
{
	
	private final double FIFTY_PERCENT = 50;
	
	private final double TWENTY_PERCENT = 20;
	
	
	private int age; 
	
	public Socio(int age) {
		super();
		this.age = age;
	}

	@Override
	public double getDiscountPercentage() {
		if (this.age >= 65) {
			return this.FIFTY_PERCENT;
		}
		
		
		if (this.age < 18) {
			return this.TWENTY_PERCENT;
		}
		
		return 0;
	}


	
}
