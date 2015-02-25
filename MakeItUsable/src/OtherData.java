import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OtherData {
	
	private int autoTotesMoved;
	private int autoBinsMoved;
	private String esBroken;
	private int points;
	private String gameNotes;
	private String absent;
	private String coopStacked;
	private String didNothing;
	private String takesFromHumanPlayer;
	private String stackedAllThreeAuto;
	private String madeItToAutoZone;
	private String takesFromLandfill;
	private int landfillNoodles;
	private String knockedContainers;
	private String knockedTotes;
	
	
	

	public OtherData(int matchNumber, int teamNumber) throws SQLException{
		 Connection con = DriverManager.getConnection("jdbc:sqlite:" + "E:Host");
		  Statement stat = con.createStatement();
		  ResultSet rs = stat.executeQuery("select * from "+ "AllMatches");
		  
		  while(rs.next()){
			  if(teamNumber == rs.getInt("TeamNumber") && matchNumber == rs.getInt("MatchNumber")){
				 autoTotesMoved = rs.getInt("AutoTotesMoved");
				 autoBinsMoved = rs.getInt("AutoRecyclingContainersMoved");
				 esBroken = rs.getString("EsBroken");
				 points = (rs.getInt("Points"));
		         gameNotes = (rs.getString("GameNotes"));
		         absent = (rs.getString("Absent"));
		         coopStacked = (rs.getString("CoopertitionStacked"));
		         didNothing = (rs.getString("DidNothing"));
		         takesFromHumanPlayer = (rs.getString("TakesFromHumanPlayer"));
		         stackedAllThreeAuto = (rs.getString("StackedAllThreeAutonTotes"));
		         madeItToAutoZone = (rs.getString("MadeItToAutoZone"));
		         takesFromLandfill = (rs.getString("TakesFromLandfill"));
		         landfillNoodles = (rs.getInt("NoodlesPushedToLandFill"));
		         knockedContainers = (rs.getString("PickedUpKnockedOverContainers"));
		         knockedTotes = (rs.getString("PickedUpKnockedOverTotes"));
			  }
		  }
		  rs.close();
		  con.close();
	}
	
	public int getNumberOfAutoTotesMoved(){
		return autoTotesMoved;
	}
	
	public int getNumberOfAutoRecyclingBinsMoved(){
		return autoBinsMoved;
	}
	
	public boolean isBroken(){
		boolean broken;
		broken = (("yes" == esBroken)? true:false);
		return broken;
	}
	
	public int getPoints(){
		return points;
	}
	
	public String getGameNotes(){
		return gameNotes;
	}
	
	public boolean isAbsent(){
		boolean absentB;
		absentB = (("yes" == absent)? true:false);
		return absentB;
	}
	
	public boolean isCoopertitionStacked(){
		boolean coopStackedB;
		coopStackedB = (("yes" == coopStacked)? true:false);
		return coopStackedB;
	}
	
	public boolean isDidNothing(){
		boolean didNothingB;
		didNothingB = (("yes" == didNothing)? true:false);
		return didNothingB;
	}
	
	public boolean isTakesFromHumanPlayer(){
		boolean takesFromHumanPlayerB;
		takesFromHumanPlayerB = (("yes" == takesFromHumanPlayer)? true: false);
		return takesFromHumanPlayerB;
	}
	
	public boolean isStackedAllThreeAutoTotes(){
		boolean stackedAllThreeAutoB;
		stackedAllThreeAutoB = (("yes" == stackedAllThreeAuto)? true: false);
		return stackedAllThreeAutoB;
	}
	
	public boolean isTakesFromLandfill(){
		boolean takesFromLandfillB;
		takesFromLandfillB = (("yes" == takesFromLandfill)? true: false);
		return takesFromLandfillB;
	}
	
	public int getNumberOfLandfillNoodles(){
		return landfillNoodles;
	}
	
	public boolean isPickedUpKnockedOverContainers(){
		boolean knockedContainersB;
		knockedContainersB = (("yes" == knockedContainers)? true: false);
		return knockedContainersB;
	}
	
	public boolean isPickedUpKnockedOverTotes(){
		boolean knockedTotesB;
		knockedTotesB = (("yes" == knockedTotes)? true: false);
		return knockedTotesB;
	}
}
