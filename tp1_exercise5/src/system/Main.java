package system;

import entity.Warrior;

public class Main {

	public static void main(String[] args) {
		Warrior player = new Warrior("pablo", 100, 250, 0, 0);
		
		System.out.println(player);
		player.getDamage(200);
		player.move(10, 10);
		System.out.println(player);
		player.getDamage(100);
		System.out.println(player);
		player.getDamage(999);
		player.move(5, 0);
		System.out.println(player);
	}

}
