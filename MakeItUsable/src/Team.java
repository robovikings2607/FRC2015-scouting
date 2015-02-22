import java.util.ArrayList;


public class Team {
	
	ArrayList<Match> matches = new ArrayList<Match>();
	
	
	public Team(int teamNumber) throws Exception{
		
		for(int i = 0; i < 150; i++){
			matches.add(new Match(i, teamNumber));
		}
	}
	
	public ArrayList<Match> getMatches(){
		return matches;
	}
	
	public Match getMatch(int match){
		return matches.get(match);
	}

}
