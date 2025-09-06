package tp2_exercise9;

import java.util.ArrayList;


public class Team {
	private ArrayList<Player> players;
	
	public Team() {
		super();
		this.players = new ArrayList<Player>();
	}
	
	public int getPoints () {
		int result = 0;
		for(Player p: this.players) {
			result += p.getPoints();
		}
		
		return result;
	}

	public void addPlayer (Player p) {
		this.players.add(p);
	}
	
	public void removePlayer (Player p) {
		this.players.remove(p);
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public boolean hasEnoughPlayers () {
		return this.players.size() >= 4;
	}
	
	public void updateStats (Team winner) {
		boolean wasDraw = winner == null;
		boolean wasWin  = winner == this;
		
		for(Player p: this.players) {
			if (wasDraw) 
				p.addPoints(1);
			else if (wasWin) {
				p.addPoints(3);
				p.addWon();
			}else
				p.addLose();
			
		}	
	}
	
	
}
