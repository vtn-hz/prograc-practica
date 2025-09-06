package tp2_exercise9;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Tornament {
	private ArrayList<Match> matches = new ArrayList<Match>();
	
	public void addMatch (Match match) {
		this.matches.add(match);
	}
	
	public ArrayList<Match> getMatches () {
		return this.matches;
	}
	
	public Match searchMatch (
			Team t1, Team t2, 
			GregorianCalendar date
	) {
		Match searched = null;
		
		for(Match mt: matches) {
			if (t1 == mt.getTeam(0) && t2 == mt.getTeam(1)) {
				if (mt.getDate().equals(date))
					searched = mt;
			}
		}
		
		return searched;
	}
	
	
	public int countAgainst (
			Player p1, Player p2
	) {
		int count = 0;
		
		for(Match mt: matches) {
			if(mt.getTeam(0).getPlayers().contains(p1)) {
				count += mt.getTeam(1).getPlayers().contains(p2) ? 1 : 0;
			}else if (mt.getTeam(1).getPlayers().contains(p1)) {
				count += mt.getTeam(0).getPlayers().contains(p2) ? 1 : 0;
			}
		}
		
		return count;
	}
	
	
	public int countSameTeam (
			Player p1, Player p2
	) {
		int count = 0;
		
		for(Match mt: matches) {
			if(mt.getTeam(0).getPlayers().contains(p1)) {
				count += mt.getTeam(1).getPlayers().contains(p2) ? 1 : 0;
			}else if (mt.getTeam(1).getPlayers().contains(p1)) {
				count += mt.getTeam(0).getPlayers().contains(p2) ? 1 : 0;
			}
		}
		
		return count;
	}
}
