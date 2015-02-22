import java.util.ArrayList;


public class Match {
	
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	OtherData otherData;
	
	public Match(int matchNumber, int teamNumber) throws Exception{
		for(int i = 0; i < 14; i++){
		stacks.add(new Stack(matchNumber, teamNumber, i));
		}
		otherData = new OtherData(matchNumber, teamNumber);
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

}
