package tp5_exercise1;

public abstract class Animal implements ISoundEmisor {
	private String name; 
	
	private int lifeExpect;

	public Animal(String name, int lifeExpect) {
		super();
		this.name = name;
		this.lifeExpect = lifeExpect;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifeExpect() {
		return lifeExpect;
	}

	public void setLifeExpect(int lifeExpect) {
		this.lifeExpect = lifeExpect;
	}
}
