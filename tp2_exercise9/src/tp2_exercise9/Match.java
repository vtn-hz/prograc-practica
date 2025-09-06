package tp2_exercise9;

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Match {
	private GregorianCalendar date;
	
	private Team winner;
	
	private Team[] teams;
	
	public Match(Team[] teams, GregorianCalendar date) {
		this.date = date;
		this.teams = teams;
		
		this.validateMatch();
	}
	
	private boolean validateMatch() {
		if(!(this.teams[0].hasEnoughPlayers() && this.teams[1].hasEnoughPlayers())) {
			throw new IllegalArgumentException(
					"Uno de los equipos esta incompleto"
			);
		}		
		
	    ArrayList<Player> playersTeam1 = this.teams[0].getPlayers();
	    ArrayList<Player> playersTeam2 = this.teams[1].getPlayers();
	    
	    
	    for (Player p1 : playersTeam1) {
	        if (playersTeam2.contains(p1)) {
	            throw new IllegalArgumentException(
	                "El jugador " + p1.getName() + " está en ambos equipos"
	            );
	        }
	    }

	    return true;
	}
	
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public boolean wasDraw () {
		return this.winner == null;
	}
	
	public void updateTeamsStats () {
		for(Team team: this.teams) {
			team.updateStats( this.winner );
		}
	}
	
	public Team getTeam(int i) {
		return teams[i];
	}
	
	public GregorianCalendar getDate() {
		return this.date;
	}
}
