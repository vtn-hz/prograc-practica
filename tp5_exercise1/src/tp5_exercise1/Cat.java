package tp5_exercise1;

public class Cat extends Animal {

	public Cat(String name, int lifeExpect) {
		super(name, lifeExpect);
	}

	@Override
	public void emitSound() {
		System.out.println("meow...");
	}

}
