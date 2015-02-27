import java.sql.*;


public class Stack {

	private  Statement stat;
	private int matchNumber;
	private int teamNumber;
	private int columnIndex;
	private int height;
	//private int points;
	private int toteNumber;
	private int containerHeight;
	private int noodleNumber;
	private int noodle;
	private BitMasking bitMasking = new BitMasking();
	
	
	
	public Stack(int matchNumber, int teamNumber, int columnIndex, Statement stat) throws Exception{
		toteNumber = 0;
		// sqlite driver

		//Class.forName("org.sqlite.JDBC");
		// database path, if it's new database,
		// it will be created in the project folder
		//Connection con = DriverManager.getConnection("jdbc:sqlite:" + "E:Host");
		//stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from "+ "AllMatches");
		this.matchNumber = matchNumber;
		this.teamNumber = teamNumber;
		this.columnIndex = columnIndex;
		while(rs.next()){
			if(teamNumber == rs.getInt(3) && matchNumber == rs.getInt(1)){
				containerHeight = rs.getInt(25 + columnIndex);

				if (this.columnIndex > 6){
					toteNumber = rs.getInt("TotalStackNumberBack");
					noodleNumber = rs.getInt("NoodleNumberBack");

				} else{
					toteNumber = rs.getInt("TotalStackNumberForward");
					noodleNumber = rs.getInt("NoodleNumberForward");
				}
			}
			
			if (this.columnIndex > 6){
				this.columnIndex -= 7; 
			}
			
			if (this.columnIndex == 7){
				System.err.println(this.columnIndex);
			}
			
			break;
		}
		rs.close();
		//con.close();

	}
	
	public boolean[] getDecoded(){
		if (this.columnIndex == 7){
			System.err.println(this.columnIndex);
		}
		
		boolean[] stack = new boolean[6];
		boolean allStacks[] = bitMasking.decodeStack(toteNumber);
		
		for(int counter = 0; counter < stack.length; counter++){
			try{
				stack[counter] = allStacks[((this.columnIndex * 6) + counter)]; // wrong
			} catch (ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
			}
		}
		return stack;
	}
	
	public int getNumberOfTotes(){
		int numberOfTotes = 0; 
		
		for(int i = 0; i < getDecoded().length; i ++){
			if (getDecoded()[i] == true)
				numberOfTotes += 1;
		}
		
		return numberOfTotes;
	}
	
	public int getPointsForWholeStack(){
		return (getNumberOfTotes() * 2) + (getContainerHeight() * 4) + (6 * getNoodle()) ;
	}
	
	public int getPointsForCan(){
		return (getContainerHeight() * 4) ;
	}
	
	public int getPointsForTotes(){
		return (getNumberOfTotes() * 2);
	}
	
	public int getPointsForNoodle(){
		return (6 * getNoodle()) ;
	}
	
	public int getHeight(){
		for(int i = 1; i < getDecoded().length; i ++){
			if (getDecoded()[i] == true)
				height = i + 1;
		}
		if (height > 6) //Why wrap around?
			height = 0;
		return height;
	}
	
	public int getContainerHeight(){
		return containerHeight;
	}
	
	public int getNoodle(){ 
		boolean[] noodleArray = new boolean[7];
		for (int i = 0; i < noodleArray.length; i++){
			noodleArray[i] = (noodleNumber & ((long)Math.pow(2, i))) > 0;
		}
			noodle = (noodleArray[columnIndex]? 1:0);
			
		return noodle;
	}
	
}
