package tp5_exercise1;

public class Ambulance extends Vehicle {

	public Ambulance(String patente, String numeroChasis, String numeromotor) {
		super(patente, numeroChasis, numeromotor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void emitSound() {
		System.out.println("sirena...");
	}
}
