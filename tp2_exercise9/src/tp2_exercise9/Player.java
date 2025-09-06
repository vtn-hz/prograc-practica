package tp2_exercise9;

public class Player {
	private String name;
	
	private int points;
	
	private int wonCant;
	
	private int loseCant;

	private int drawCant;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
	public void addPoints(int point) {
		this.points += point;
	}
	
	public void addWon() {
		this.wonCant++;
	}
	
	public void addLose() {
		this.loseCant++;
	}
	
	public void addDraw() {
		this.drawCant++;
	}
	
	public int getWonCant() {
		return wonCant;
	}

	public int getLoseCant() {
		return loseCant;
	}

	public int getDrawCant() {
		return drawCant;
	}

}
