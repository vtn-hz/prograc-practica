package tp5_exercise1;

public class Dog extends Animal {

	public Dog(String name, int lifeExpect) {
		super(name, lifeExpect);
	}

	@Override
	public void emitSound() {
		System.out.println("bark...");
	}

}
