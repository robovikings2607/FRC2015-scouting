import java.sql.*;


public class Stack {

	private  Statement stat;
	private int matchNumber;
	private int teamNumber;
	private int columnIndex;
	private int height;
	private int numberOfTotes;
	private int points;
	private int toteNumber;
	private int containerHeight;
	private int noodleNumber;
	private int noodle;
	private boolean[] stack = new boolean[7];
	private boolean[] noodleArray = new boolean[7];
	private BitMasking bitMasking = new BitMasking();
	
	
	
	public Stack(int matchNumber, int teamNumber, int columnIndex, Statement stat) throws Exception{
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
			  if(teamNumber == rs.getInt("TeamNumber") && matchNumber == rs.getInt("MatchNumber")){
				  if (columnIndex < 6){
					  toteNumber = rs.getInt("TotalStackNumberForward");
					  noodleNumber = rs.getInt("NoodleNumberForward");
				  }	  
				  else{
					  toteNumber = rs.getInt("TotalStackNumberBack");
					  noodleNumber = rs.getInt("NoodleNumberBack");
					this.columnIndex = columnIndex - 6;  
				  }
				  
				  containerHeight = rs.getInt(25 + columnIndex);
				  break;
			  }
		  }
		  rs.close();
		  //con.close();
		  
	}
	
	public boolean[] getDecoded(){
		boolean allStacks[] = bitMasking.decodeStack(toteNumber);
		
		
		for(int counter = 0; counter<stack.length;counter++){
		stack[counter] = allStacks[((columnIndex * 6) + counter)]; // wrong
		}
		return stack;
	}
	
	public int getNumberOfTotes(){
		for(int i = 0; i < getDecoded().length; i ++){
			if (getDecoded()[i] == true)
				numberOfTotes += 1;
		}
		
		return numberOfTotes;
	}
	
	public int getPoints(){
		points = (getNumberOfTotes() * 2) + (getContainerHeight() * 4) + (6 * noodle) ;
		return points;
	}
	
	public int getHeight(){
		for(int i = 1; i < getDecoded().length; i ++){
			if (getDecoded()[i] == true)
				height = i + 1;
		}
		if (height > 6)
			height = 0;
		return height;
	}
	
	public int getContainerHeight(){
		return containerHeight;
	}
	
	public int getNoodle(){
		for (int i = 0; i < noodleArray.length; i++){
			noodleArray[i] = (noodleNumber & ((long)Math.pow(2, i))) > 0;
		}
			noodle = (noodleArray[columnIndex]? 1:0);
			
		return noodle;
	}
	
}
