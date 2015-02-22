import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
  boolean firstTime = false;
  
  
  String namedFile = "scoutdb.db";
  String scouterName;
public void run() throws Exception {
 
	
  // sqlite driver
  Class.forName("org.sqlite.JDBC");
  // database path, if it's new database,
  // it will be created in the project folder
  con = DriverManager.getConnection("jdbc:sqlite:" + namedFile);
  Statement stat = con.createStatement();
  if (tableName == "AllMatches"){
	  
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
				   "HeightOfContainerInColumnFiveBack INT," + "HeightOfContainerInColumnSixBack INT," + "HeightOfContainerInColumnSevenBack INT);");
		  firstTime = false;
	  } 
  } else {
  stat.executeUpdate("drop table if exists " + tableName);
  
  
  //creating table
  
  stat.executeUpdate("create table " + tableName +"(MatchNumber integer,"
    + "ScoutName varchar(30)," + "TeamNumber INT," + "Points INT," + "TotalStackNumberForward integer," + "TotalStackNumberBack integer," +  
		   "NumberOfTotes INT," +
		  "RecyclingContainers INT," + "AverageContainerHeight INT," + "NoodlesOnTopOfStacks INT," + "GameNotes varchar(30)," +
		   "EsBroken varchar(30)," + "TakesFromHumanPlayer varchar(30)," + "TakesFromLandfill varchar(30)," + "PickedUpKnockedOverContainers varchar(30)," +
		   "PickedUpKnockedOverTotes varchar(30)," + "MadeItToAutoZone varchar(30)," + "AutoTotesMoved INT," +
		  "StackedAllThreeAutonTotes varchar(30)," + "AutoRecyclingContainersMoved INT," + "DidNothing varchar(30)," + "Absent varchar(30)," + 
				   "CoopertitionStacked varchar(30)," + "NoodlesPushedToLandFill INT," + "HeightOfContainerInColumnOneForward INT," +
				   "HeightOfContainerInColumnTwoForward INT," + "HeightOfContainerInColumnThreeForward INT," + "HeightOfContainerInColumnFourForward INT," +
				   "HeightOfContainerInColumnFiveForward INT," + "HeightOfContainerInColumnSixForward INT," + "HeightOfContainerInColumnSevenForward INT," +"HeightOfContainerInColumnOneBack INT," +
				   "HeightOfContainerInColumnTwoBack INT," + "HeightOfContainerInColumnThreeBack INT," + "HeightOfContainerInColumnFourBack INT," +
				   "HeightOfContainerInColumnFiveBack INT," + "HeightOfContainerInColumnSixBack INT," + "HeightOfContainerInColumnSevenBack INT);");
  }
  // inserting data
  PreparedStatement prep = con.prepareStatement("insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
  
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
 
}