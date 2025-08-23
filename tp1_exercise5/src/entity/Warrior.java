package entity;

public class Warrior {
	
	private String name ; 
	
	private double health ; 
	
	private double armor ;
	
	private double x, y;
	
	public Warrior(String name, double health, double armor, double x, double y) {
		this.name = name;
		this.health = health;
		this.armor = armor;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void move (double inc_x, double inc_y) {
		this.x += inc_x;
		this.y += inc_y;
	}
	
	public void getDamage (double hit) {
		if (!this.isAlive()) {
			return;
		}
		
		double netHit = this.getMitigatedDamage(hit);
		
		this.wearDownArmor(hit);
		this.updateHealth(netHit);
	} 	
	
	private boolean isAlive () {
		return this.getHealth() > 0;
	}
	
	private void updateHealth (double hit) {
		double currentHealth = this.getHealth();
		if (currentHealth > hit)
			currentHealth = currentHealth - hit;
		else 
			currentHealth = 0;
		this.setHealth(currentHealth);
	}
	
	private double getMitigatedDamage (double hit) {
		double currentArmor = this.getArmor();
		double absorvedHit = hit - currentArmor;
		
		return absorvedHit > 0 ? absorvedHit : 0;
	}  
	
	private void wearDownArmor (double hit) {
		double currentArmor = this.getArmor();
		
		if ( this.isHitFullTanked(hit) ) 
			this.setArmor(currentArmor - hit);
		else 
			this.setArmor(0);
	} 
	
	private boolean isHitFullTanked (double hit) {
		return this.getArmor() > hit; 
	}
	
	public String toString() {
		String name = this.getName();
		double health = this.getHealth();
		double armor = this.getArmor();
		double x = this.getX();
		double y = this.getY();
		
		return name + " [ health: " + health + 
				", armor: " + armor + 
				", x:" + x + ", y:" + y + " ]";
		
	}
}
