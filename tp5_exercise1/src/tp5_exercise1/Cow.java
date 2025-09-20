package tp5_exercise1;

public class Cow extends Animal {

	public Cow(String name, int lifeExpect) {
		super(name, lifeExpect);
	}

	@Override
	public void emitSound() {
		System.out.println("mu...");
	}

}
