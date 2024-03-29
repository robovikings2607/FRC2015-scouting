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
	private int matchNumber;
	private String autonWeWant;
	private int containersFromCenter;
	private int autoContainersFromCenter;
	private String scoutName;
	private int stacksKnockedOver;
	private int fouls;
	private int timerCount;
	private String unreliableTimer;
	private String tipped;
	private int coopTotes;
	
	
	public OtherData(int matchNumber, int teamNumber, Statement stat) throws SQLException{
		 //Connection con = DriverManager.getConnection("jdbc:sqlite:" + "E:Host");
		 // Statement stat = con.createStatement();
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
		         this.matchNumber = rs.getInt("MatchNumber");
		         autonWeWant =  (rs.getString(43));
		         containersFromCenter = (rs.getInt(44));
				 autoContainersFromCenter = (rs.getInt(45));
				 scoutName = rs.getString(2);
				 stacksKnockedOver = rs.getInt(46);
				tipped = (rs.getString(50));
				coopTotes = (rs.getInt(48));
				fouls = (rs.getInt(49));
				timerCount = (rs.getInt(47));
				 
			  }
		  }
		  rs.close();
		  //con.close();
	}
	
	public int getCoopTotes(){
		return coopTotes;
	}
	
	public int getTimerCount(){
		return timerCount;
	}
	
	public int getFouls(){
		return fouls;
	}
	
	public int getFoulPoints(){
		return (fouls *6);
	}
	
//	public boolean isTimerUnreliable(){
//		boolean b;
//		b = ((unreliableTimer.equals("yes"))? true: false);
//		return b;
//	}
	
	public boolean isTipped(){
		boolean tippedB;
		tippedB = ((tipped.equals("yes"))? true: false);
		return tippedB;
	}
	
	public int getStacksKnockedOver(){
		return stacksKnockedOver;
	}
	
	public String getScoutName(){
		return scoutName;
	}
	
	public int autoContainersFromCenter(){
		return autoContainersFromCenter;
	}
	
	public int containersFromCenter(){
		return containersFromCenter;
	}
	
	public boolean isAutonWeWant(){
		boolean isAutonWeWantB;
		isAutonWeWantB = ((autonWeWant.equals("yes"))? true:false);
		return isAutonWeWantB;
	}

	public int getMatchNumber() {
		return matchNumber;
	}
	
	public int getNumberOfAutoTotesMoved(){
		return autoTotesMoved;
	}
	
	public int getNumberOfAutoRecyclingBinsMoved(){
		return autoBinsMoved;
	}
	
	public boolean isBroken(){
		boolean broken;
		broken = ((esBroken.equals("yes"))? true: false);
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
		absentB = ((absent.equals("yes"))? true:false);
		return absentB;
	}
	
	public boolean isCoopertitionStacked(){
		boolean coopStackedB;
		coopStackedB = ((coopStacked.equals("yes"))? true:false);
		return coopStackedB;
	}
	
	public boolean isDidNothing(){
		boolean didNothingB;
		didNothingB = ((didNothing.equals("yes"))? true:false);
		return didNothingB;
	}
	
	public boolean isTakesFromHumanPlayer(){
		boolean takesFromHumanPlayerB;
		takesFromHumanPlayerB = ((takesFromHumanPlayer.equals("yes"))? true: false);
		return takesFromHumanPlayerB;
	}
	
	public boolean isStackedAllThreeAutoTotes(){
		boolean stackedAllThreeAutoB;
		stackedAllThreeAutoB = ((stackedAllThreeAuto.equals("yes"))? true: false);
		return stackedAllThreeAutoB;
	}
	
	public boolean isTakesFromLandfill(){
		boolean takesFromLandfillB;
		takesFromLandfillB = ((takesFromLandfill.equals("yes"))? true: false);
		return takesFromLandfillB;
	}
	
	public int getNumberOfLandfillNoodles(){
		return landfillNoodles;
	}
	
	public boolean isPickedUpKnockedOverContainers(){
		boolean knockedContainersB;
		knockedContainersB = ((knockedContainers.equals("yes"))? true: false);
		return knockedContainersB;
	}
	
	public boolean isPickedUpKnockedOverTotes(){
		boolean knockedTotesB;
		knockedTotesB = ((knockedTotes.equals("yes"))? true: false);
		return knockedTotesB;
	}
	
	public boolean isRobotMovedAuto(){
		boolean autoB;
		autoB = (madeItToAutoZone.equals("yes") ? true:false);
		return autoB;
	}
}
