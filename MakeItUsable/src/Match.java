import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Match {
	
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	OtherData otherData;
	int teamNumber;
	int matchNumber;
	
	public Match(int matchNumber, int teamNumber , Statement stat) throws Exception{
		this.teamNumber = teamNumber;
		this.matchNumber = matchNumber;
		for(int i = 0; i < 14; i++){
			stacks.add(new Stack(matchNumber, teamNumber, i, stat));
		}
		otherData = new OtherData(matchNumber, teamNumber, stat);
	}
	
	public ArrayList<Stack> getStacks(){
		return stacks;
	}
	
	public Stack getStack(int stack){
		return stacks.get(stack);
	}
	
	public OtherData getOtherData(){
		return otherData;
	}
	
	public int getMatchNumber(){
		return matchNumber;
	}

}
