import java.sql.Statement;
import java.util.ArrayList;


public class Team {
	int teamNumber;
	ArrayList<Match> matches = new ArrayList<Match>();
	
	
	public Team(int teamNumber, Statement stat ) throws Exception{
		this.teamNumber = teamNumber;
		
		for(int i = 0; i < 150; i++){
			matches.add(new Match(i, teamNumber, stat));
		}
	}
	
	public ArrayList<Match> getMatches(){
		return matches;
	}
	
	public Match getMatch(int match){
		return matches.get(match);
	}

}
