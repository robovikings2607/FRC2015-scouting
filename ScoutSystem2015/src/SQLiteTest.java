import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class SQLiteTest{
  private static Connection con;
  int teamNumber;
  int pointsScored;
  int matchNumber;
  int stacksMade;
  int[] containerHeightsForward = {0,0,0,0,0,0,0};
  int[] containerHeightsBack = {0,0,0,0,0,0,0};
  int recycleBins;
  int noodles;
  int avgStackHeight;
  public static int landFillNoodles;
  String takesFromHumanPlayer;
  String gameNotes;
  String absent;
  String coopertitionStacked;
  String autoZone;
  String autoTotesStacked;
  String didNothing;
  int autoTotesMoved;
  int autoBinsMoved;
  String colorNumber;
  long totalStackNumber;
  long totalStackNumberBack;
  int totes;
  int avgContainerHeight;
  String esBroken;
  String tableName;
  String tableSwitch;
  String values;
  String takesFromLandFill;
  String knockedOverContainers;
  String knockedOverTotes;
  int noodleNumberForward;
  int noodleNumberBack;
  int counter;
  boolean firstTime = false;
  String tipped;
  int fouls;
  String unreliable;
  int coopTotes;
  
  
  String namedFile = "scoutdb.db";
  String scouterName;
private String knockedContainers;
private String knockedTotes;
private String autonWeWant;
private int containersFromCenter;
private int autoContainersFromCenter;
private int knockedStacks;
public void run() throws Exception {
 
	
  // sqlite driver
  Class.forName("org.sqlite.JDBC");
  // database path, if it's new database,
  // it will be created in the project folder
  con = DriverManager.getConnection("jdbc:sqlite:" + namedFile);
  Statement stat = con.createStatement();

	  
	  if (firstTime){
		  stat.executeUpdate("drop table if exists " + tableName);
		  stat.executeUpdate("create table " + tableName +"(MatchNumber integer,"
		    + "ScoutName varchar(30)," + "TeamNumber INT," + "Points INT," + "TotalStackNumberForward integer," + "TotalStackNumberBack integer," +  
				   "NumberOfTotes INT," +
				  "RecyclingContainers INT," + "AverageContainerHeight INT," + "NoodlesOnTopOfStacks INT," + "GameNotes varchar(30)," +
				   "EsBroken varchar(30)," + "TakesFromHumanPlayer varchar(30)," +"TakesFromLandfill varchar(30)," + "PickedUpKnockedOverContainers varchar(30)," 
				  +  "PickedUpKnockedOverTotes varchar(30)," + "MadeItToAutoZone varchar(30)," + "AutoTotesMoved INT," +
				  "StackedAllThreeAutonTotes varchar(30)," + "AutoRecyclingContainersMoved INT," + "DidNothing varchar(30)," + 
				   "Absent varchar(30)," + "CoopertitionStacked varchar(30)," + "NoodlesPushedToLandFill INT," + "HeightOfContainerInColumnOneForward INT," +
				   "HeightOfContainerInColumnTwoForward INT," + "HeightOfContainerInColumnThreeForward INT," + "HeightOfContainerInColumnFourForward INT," +
				   "HeightOfContainerInColumnFiveForward INT," + "HeightOfContainerInColumnSixForward INT," + "HeightOfContainerInColumnSevenForward INT," +"HeightOfContainerInColumnOneBack INT," +
				   "HeightOfContainerInColumnTwoBack INT," + "HeightOfContainerInColumnThreeBack INT," + "HeightOfContainerInColumnFourBack INT," +
				   "HeightOfContainerInColumnFiveBack INT," + "HeightOfContainerInColumnSixBack INT," + "HeightOfContainerInColumnSevenBack INT," + "NoodleNumberForward INT," + "NoodleNumberBack INT," +
				   "knockedContainers varchar(30)," + "knockedTotes varchar(30)," + "autonWeWant varchar(30)," + "containersFromCenterTeleop INT," + "containersFromCenterAuto INT," + "knockedStacks INT," + "timer INT," + "coopTotes INT," + "fouls INT," + "tipped varchar(30));");
		  firstTime = false;
	  
  } else {
//  stat.executeUpdate("drop table if exists " + tableName);
//  
//  
//  //creating table
//  
//  stat.executeUpdate("create table " + tableName +"(MatchNumber integer,"
//    + "ScoutName varchar(30)," + "TeamNumber INT," + "Points INT," + "TotalStackNumberForward integer," + "TotalStackNumberBack integer," +  
//		   "NumberOfTotes INT," +
//		  "RecyclingContainers INT," + "AverageContainerHeight INT," + "NoodlesOnTopOfStacks INT," + "GameNotes varchar(30)," +
//		   "EsBroken varchar(30)," + "TakesFromHumanPlayer varchar(30)," + "TakesFromLandfill varchar(30)," + "PickedUpKnockedOverContainers varchar(30)," +
//		   "PickedUpKnockedOverTotes varchar(30)," + "MadeItToAutoZone varchar(30)," + "AutoTotesMoved INT," +
//		  "StackedAllThreeAutonTotes varchar(30)," + "AutoRecyclingContainersMoved INT," + "DidNothing varchar(30)," + "Absent varchar(30)," + 
//				   "CoopertitionStacked varchar(30)," + "NoodlesPushedToLandFill INT," + "HeightOfContainerInColumnOneForward INT," +
//				   "HeightOfContainerInColumnTwoForward INT," + "HeightOfContainerInColumnThreeForward INT," + "HeightOfContainerInColumnFourForward INT," +
//				   "HeightOfContainerInColumnFiveForward INT," + "HeightOfContainerInColumnSixForward INT," + "HeightOfContainerInColumnSevenForward INT," +"HeightOfContainerInColumnOneBack INT," +
//				   "HeightOfContainerInColumnTwoBack INT," + "HeightOfContainerInColumnThreeBack INT," + "HeightOfContainerInColumnFourBack INT," +
//				   "HeightOfContainerInColumnFiveBack INT," + "HeightOfContainerInColumnSixBack INT," + "HeightOfContainerInColumnSevenBack INT," + "NoodleNumberForward INT," + "NoodleNumberBack INT," +
//				   "knockedContainers varchar(30)," + "knockedTotes varchar(30)," + "autonWeWant varchar(30)," + "containersFromCenterTeleop INT," + "containersFromCenterAuto INT);");
  }
  // inserting data
  PreparedStatement prep = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
  
  prep.setInt(1, matchNumber);
  prep.setString(2, scouterName);
  prep.setInt(3, teamNumber);
  prep.setInt(4, pointsScored);
  prep.setLong(5, totalStackNumber);
  prep.setLong(6, totalStackNumberBack);
  prep.setInt(7, totes);
  prep.setInt(8, recycleBins);
  prep.setInt(9, avgContainerHeight);
  prep.setInt(10, noodles);
  prep.setString(11, gameNotes);
  prep.setString(12, esBroken);
  prep.setString(13, takesFromHumanPlayer);
  prep.setString(14, takesFromLandFill);
  prep.setString(15, knockedOverContainers);
  prep.setString(16, knockedOverTotes);
  prep.setString(17, autoZone);
  prep.setInt(18, autoTotesMoved);
  prep.setString(19, autoTotesStacked);
  prep.setInt(20, autoBinsMoved);
  prep.setString(21, didNothing);
  prep.setString(22, absent);
  prep.setString(23, coopertitionStacked);
  prep.setInt(24, landFillNoodles);
  prep.setInt(25, containerHeightsForward[0]);
  prep.setInt(26, containerHeightsForward[1]);
  prep.setInt(27, containerHeightsForward[2]);
  prep.setInt(28, containerHeightsForward[3]);
  prep.setInt(29, containerHeightsForward[4]);
  prep.setInt(30, containerHeightsForward[5]);
  prep.setInt(31, containerHeightsForward[6]);
  prep.setInt(32, containerHeightsBack[0]);
  prep.setInt(33, containerHeightsBack[1]);
  prep.setInt(34, containerHeightsBack[2]);
  prep.setInt(35, containerHeightsBack[3]);
  prep.setInt(36, containerHeightsBack[4]);
  prep.setInt(37, containerHeightsBack[5]);
  prep.setInt(38, containerHeightsBack[6]);
  prep.setInt(39, noodleNumberForward);
  prep.setInt(40, noodleNumberBack);
  prep.setString(41, knockedContainers);
  prep.setString(42, knockedTotes);
  prep.setString(43, autonWeWant);
  prep.setInt(44, containersFromCenter);
  prep.setInt(45, autoContainersFromCenter);
  prep.setInt(46, knockedStacks);
  prep.setInt(47, counter);
  //prep.setString(48, unreliable);
  prep.setInt(48, coopTotes);
  prep.setInt(49, fouls);
  prep.setString(50, tipped);
  
  

  prep.execute();

  // getting data
  ResultSet res = stat.executeQuery("select * from " + tableName);
  while (res.next()) {
     System.out.println(res.getString("MatchNumber") + " " + res.getString("Points")
              + " " + res.getString("TeamNumber") );
  }

}



public void createNewTable(){
	firstTime = true;
}


public void setTeamNumber(int TeamNumber){
	teamNumber = TeamNumber;
	
}

public void setPoints (int points){
	pointsScored = points;
}


public void setMatchNumber(int match){
	matchNumber = match;
}

public void setFileName(String fileName){
	namedFile = fileName;
}

public void setScouterName(String name){
	scouterName = name;
}


public void setTotalStackNumber(long totalStackNumber, long totalStackNumberBack){
	this.totalStackNumber = totalStackNumber;
	this.totalStackNumberBack = totalStackNumberBack;
}

public void setCoopertitionStacked(String coopertitionStacked){
	this.coopertitionStacked = coopertitionStacked;
}

public void setNotes(String Notes){
	gameNotes = Notes;
}

public void setAbsent( String Absent){
	absent = Absent;
}


public void setNoodles(int Noodles){
	noodles = Noodles;
}

public void setRecycleBins(int RecycleBins, int containerHeights){
	recycleBins = RecycleBins;
	if (recycleBins != 0){
	avgContainerHeight = (containerHeights/recycleBins);
	} else {
		avgContainerHeight = 0;
	}
}

public void setTotes(int Totes){
	totes = Totes;
}

public void setDidNothing(String didNothing){
	this.didNothing = didNothing;
}

public void setAutoTotesMoved(int autoTotesMoved){
	this.autoTotesMoved = autoTotesMoved;
}

public void setAutoTotesStacked(String autoTotesStacked){
	this.autoTotesStacked = autoTotesStacked;
}

public void setAutoBinsMoved(int autoBinsMoved){
	this.autoBinsMoved = autoBinsMoved;
}

public void setTakesFromHumanPlayer(String takesFromHumanPlayer){
	this.takesFromHumanPlayer = takesFromHumanPlayer;
}

public void setBroken(String esBroken){
	this.esBroken = esBroken;
}

public void setMadeItToAutoZone(String autoZone){
	this.autoZone = autoZone;
}

public void setTableName (String tableName){
	this.tableName = tableName;
}
public void setLandFillNoodles(int noodles){
	landFillNoodles = noodles;
}

public void setTakesFromLandFill(String takesFromLandFill){
	this.takesFromLandFill = takesFromLandFill;
}

public void setPickedUpKnockedOverContainers(String knockedOverContainers){
	this.knockedOverContainers = knockedOverContainers;
}

public void setPickedUpKnockedOverTotes(String knockedOverTotes){
	this.knockedOverTotes = knockedOverTotes;
}

public void setAverageContainerHeight(int avgContainerHeight){
	this.avgContainerHeight = avgContainerHeight;
}

public void setContainerHeights(int[] containerHeightsForward, int[] containerHeightsBack){
	this.containerHeightsForward = containerHeightsForward;
	this.containerHeightsBack = containerHeightsBack;
}
public void setNoodleNumber(int totalNoodles, int totalNoodlesBack){
	noodleNumberForward = totalNoodles;
	noodleNumberBack = totalNoodlesBack;
}

public void setKnockedOverContainers(String knockedContainers){
	this.knockedContainers = knockedContainers;
}

public void setKnockedOverTotes(String knockedTotes){
	this.knockedTotes = knockedTotes;
}

public void setAutonWeWant(String autonWeWant){
	this.autonWeWant = autonWeWant;
}

public void setContainersFromCenter(int containersFromCenter){
	this.containersFromCenter = containersFromCenter;
}

public void setAutoContainersFromCenter(int autoContainersFromCenter){
	this.autoContainersFromCenter = autoContainersFromCenter;
}

public void setKnockedOverStacks(int knockedStacks){
	this.knockedStacks = knockedStacks;
}

public void setCoopertitionTimer(int counter){
	this.counter = counter;
}

public void setTippedOver(String tipped){
	this.tipped = tipped;
}

public void setFouls(int fouls){
	this.fouls = fouls;
}

public void setUnreliableTimer(String unreliable){
	this.unreliable = unreliable;
}

public void setCoopTotes(int coopTotes){
	this.coopTotes = coopTotes;
}

//public void synchronize() throws Exception{
//	 Class.forName("org.sqlite.JDBC");
//     Connection conn = DriverManager.getConnection("jdbc:sqlite:" + "C:ClientSystem"); 
//     Statement stat = conn.createStatement();
//     
//    int startNumber = 0;
//    int endNumber = 150;
//     
//     while (startNumber <= endNumber){
//     ResultSet rs = null;
//		try {
//			rs = stat.executeQuery("select * from "+ "MatchNumber_" + startNumber);
//			
//		} catch (NullPointerException e1) {	
//			
//		}
//		catch (SQLException e1) {	
//			
//		}
//     try {
//			while (rs.next()) {
//			    CopyOfGUIScoutstatic.sql.setMatchNumber(rs.getInt("MatchNumber"));
//			    CopyOfGUIScoutstatic.sql.setFileName(CopyOfGUIScoutstatic.drive + ":" + "Client");
//			    CopyOfGUIScoutstatic.sql.setTableName("MatchNumber_" + rs.getInt("MatchNumber"));
//			    CopyOfGUIScoutstatic.sql.setScouterName(rs.getString("ScoutName")); 
//			    CopyOfGUIScoutstatic.sql.setTeamNumber(rs.getInt("TeamNumber"));
//			    CopyOfGUIScoutstatic.sql.setPoints(rs.getInt("Points"));
//			    CopyOfGUIScoutstatic.sql.setTotalStackNumber(rs.getLong("TotalStackNumberForward"), rs.getLong("TotalStackNumberBack"));
//			    CopyOfGUIScoutstatic.sql.setTotes(rs.getInt("NumberOfTotes"));
//			    CopyOfGUIScoutstatic.sql.setNoodles(rs.getInt("NoodlesOnTopOfStacks"));
//			    CopyOfGUIScoutstatic.sql.setRecycleBins(rs.getInt("RecyclingContainers"), rs.getInt("AverageContainerHeight"));
//			    CopyOfGUIScoutstatic.sql.setNotes(rs.getString("GameNotes"));
//			    CopyOfGUIScoutstatic.sql.setAbsent(rs.getString("Absent"));
//			    CopyOfGUIScoutstatic.sql.setCoopertitionStacked(rs.getString("CoopertitionStacked"));
//			    CopyOfGUIScoutstatic.sql.setDidNothing(rs.getString("DidNothing"));
//			    CopyOfGUIScoutstatic.sql.setTakesFromHumanPlayer(rs.getString("TakesFromHumanPlayer"));
//			    CopyOfGUIScoutstatic.sql.setAutoTotesStacked(rs.getString("StackedAllThreeAutonTotes"));
//			    CopyOfGUIScoutstatic.sql.setAutoTotesMoved(rs.getInt("AutoTotesMoved"));
//			    CopyOfGUIScoutstatic.sql.setAutoBinsMoved(rs.getInt("AutoRecyclingContainersMoved"));
//			    CopyOfGUIScoutstatic.sql.setMadeItToAutoZone(rs.getString("MadeItToAutoZone"));
//			    CopyOfGUIScoutstatic.sql.setBroken(rs.getString("EsBroken"));
//			    CopyOfGUIScoutstatic.sql.setTakesFromLandFill(rs.getString("TakesFromLandfill"));
//			    CopyOfGUIScoutstatic.sql.setLandFillNoodles(rs.getInt("NoodlesPushedToLandFill"));
//			    CopyOfGUIScoutstatic.sql.setPickedUpKnockedOverContainers(rs.getString("PickedUpKnockedOverContainers"));
//			    CopyOfGUIScoutstatic.sql.setPickedUpKnockedOverTotes(rs.getString("PickedUpKnockedOverTotes"));
//			    
//			    for(int counter = 0; counter < containerHeightsForward.length; counter ++){
//			    	containerHeightsForward[counter] = rs.getInt(25 + counter);
//			    	containerHeightsBack[counter] = rs.getInt(32 + counter);
//			    }
//			    
//			    CopyOfGUIScoutstatic.sql.setContainerHeights(containerHeightsForward, containerHeightsBack);
//			    CopyOfGUIScoutstatic.sql.setNoodleNumber(rs.getInt("NoodleNumberForward"), rs.getInt("NoodleNumberBack"));
//			    CopyOfGUIScoutstatic.sql.setKnockedOverContainers(rs.getString(41));
//			    CopyOfGUIScoutstatic.sql.setKnockedOverTotes(rs.getString(42));
//			    CopyOfGUIScoutstatic.sql.setAutonWeWant(rs.getString(43));
//			    CopyOfGUIScoutstatic.sql.setContainersFromCenter(rs.getInt(44));
//			    CopyOfGUIScoutstatic.sql.setAutoContainersFromCenter(rs.getInt(45));
//			    
//			    try {
//			    	CopyOfGUIScoutstatic.sql.run();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			    
//			    
//			}
//		} catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//     
//     startNumber +=1; 
//     try {
//     rs.close();
//     } catch (NullPointerException e3){
//     	
//     }
//     }
//     conn.close();
//     
//
//}

	public  void Synchronize() throws Exception{
		Class.forName("org.sqlite.JDBC"); 
		for (int i = 2; i < CopyOfGUIScoutstatic.getPaths().size(); i ++ ){ 
	        Connection conn = DriverManager.getConnection("jdbc:sqlite://C:/Users/dellagD/Desktop/ClientSystem"); 
	        Statement stat = conn.createStatement();
	        
	        
	        ResultSet rs = null;
			try {
				rs = stat.executeQuery("select * from "+ "Client_Matches");
				
			} catch (NullPointerException e1) {	
				
			}
			catch (SQLException e1) {	
				
			}
	        try {
				while (rs.next()) {
				    CopyOfGUIScoutstatic.sql.setMatchNumber(rs.getInt("MatchNumber"));
				    CopyOfGUIScoutstatic.sql.setFileName(CopyOfGUIScoutstatic.drive + ":" + "ClientMatches");
				    CopyOfGUIScoutstatic.sql.setTableName("Client_Matches");
				    CopyOfGUIScoutstatic.sql.setScouterName(rs.getString("ScoutName")); 
				    CopyOfGUIScoutstatic.sql.setTeamNumber(rs.getInt("TeamNumber"));
				    CopyOfGUIScoutstatic.sql.setPoints(rs.getInt("Points"));
				    CopyOfGUIScoutstatic.sql.setTotalStackNumber(rs.getLong("TotalStackNumberForward"), rs.getLong("TotalStackNumberBack"));
				    CopyOfGUIScoutstatic.sql.setTotes(rs.getInt("NumberOfTotes"));
				    CopyOfGUIScoutstatic.sql.setNoodles(rs.getInt("NoodlesOnTopOfStacks"));
				    CopyOfGUIScoutstatic.sql.setRecycleBins(rs.getInt("RecyclingContainers"), rs.getInt("AverageContainerHeight"));
				    CopyOfGUIScoutstatic.sql.setNotes(rs.getString("GameNotes"));
				    CopyOfGUIScoutstatic.sql.setAbsent(rs.getString("Absent"));
				    CopyOfGUIScoutstatic.sql.setCoopertitionStacked(rs.getString("CoopertitionStacked"));
				    CopyOfGUIScoutstatic.sql.setDidNothing(rs.getString("DidNothing"));
				    CopyOfGUIScoutstatic.sql.setTakesFromHumanPlayer(rs.getString("TakesFromHumanPlayer"));
				    CopyOfGUIScoutstatic.sql.setAutoTotesStacked(rs.getString("StackedAllThreeAutonTotes"));
				    CopyOfGUIScoutstatic.sql.setAutoTotesMoved(rs.getInt("AutoTotesMoved"));
				    CopyOfGUIScoutstatic.sql.setAutoBinsMoved(rs.getInt("AutoRecyclingContainersMoved"));
				    CopyOfGUIScoutstatic.sql.setMadeItToAutoZone(rs.getString("MadeItToAutoZone"));
				    CopyOfGUIScoutstatic.sql.setBroken(rs.getString("EsBroken"));
				    CopyOfGUIScoutstatic.sql.setTakesFromLandFill(rs.getString("TakesFromLandfill"));
				    CopyOfGUIScoutstatic.sql.setLandFillNoodles(rs.getInt("NoodlesPushedToLandFill"));
				    CopyOfGUIScoutstatic.sql.setPickedUpKnockedOverContainers(rs.getString("PickedUpKnockedOverContainers"));
				    CopyOfGUIScoutstatic.sql.setPickedUpKnockedOverTotes(rs.getString("PickedUpKnockedOverTotes"));
				    
				    for(int counter = 0; counter < containerHeightsForward.length; counter ++){
				    	containerHeightsForward[counter] = rs.getInt(25 + counter);
				    	containerHeightsBack[counter] = rs.getInt(32 + counter);
				    }
				    
				    CopyOfGUIScoutstatic.sql.setContainerHeights(containerHeightsForward, containerHeightsBack);
				    CopyOfGUIScoutstatic.sql.setNoodleNumber(rs.getInt("NoodleNumberForward"), rs.getInt("NoodleNumberBack"));
				    CopyOfGUIScoutstatic.sql.setKnockedOverContainers(rs.getString(41));
				    CopyOfGUIScoutstatic.sql.setKnockedOverTotes(rs.getString(42));
				    CopyOfGUIScoutstatic.sql.setAutonWeWant(rs.getString(43));
				    CopyOfGUIScoutstatic.sql.setContainersFromCenter(rs.getInt(44));
				    CopyOfGUIScoutstatic.sql.setAutoContainersFromCenter(rs.getInt(45));
				    CopyOfGUIScoutstatic.sql.setKnockedOverStacks(rs.getInt(46));
				    CopyOfGUIScoutstatic.sql.setTippedOver(rs.getString(50));
				    CopyOfGUIScoutstatic.sql.setUnreliableTimer(rs.getString(48));
				    CopyOfGUIScoutstatic.sql.setFouls(rs.getInt(49));
				    CopyOfGUIScoutstatic.sql.setCoopertitionTimer(rs.getInt(47));
				    
				    try {
				    	CopyOfGUIScoutstatic.sql.run();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    
				}
			
	       
	        
	        rs.close();
	       conn.close();
	        } catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
	        } 
		
	}
	}

  /**
  * @param args
  */
  /*public static void main(String[] args) {
    try {
      new SQLiteTest().run();
    } catch (Exception e) {
       e.printStackTrace();
      }
  } */
 
