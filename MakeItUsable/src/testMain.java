import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class testMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection con = DriverManager.getConnection("jdbc:sqlite:" + "H:HostLotsOfData");
		Statement stat = con.createStatement();
		
		SQLToExcel ex = new SQLToExcel("H:HostLotsOfData");
		ex.populateExcelFile();
		ex.writeExcelFile();
		
		

		ArrayList<Integer> teamList = getTeamListFromDatabase(stat);

		ArrayList<Team> teams = getTeamArrayWithData(teamList, stat);

		for (Team team : teams){
			System.out.println(team.getMatch(1).getStack(7).getPointsForTotes());
			System.out.println(team.getMatch(1).getStack(7).getPointsForNoodle());
			System.out.println(team.getMatch(1).getStack(7).getPointsForCan());
			System.out.println(team.getMatch(1).getStack(7).getPointsForWholeStack());
		}
	}

	private static ArrayList<Team> getTeamArrayWithData(ArrayList<Integer> teamList, Statement stat) throws Exception {
		ArrayList<Team> teams = new ArrayList<Team>();
		
		for (Integer team : teamList){
			teams.add(new Team(team, stat));
		}
		
		return teams;
	}

	private static ArrayList<Integer> getTeamListFromDatabase(Statement stat) throws SQLException {
		ArrayList<Integer> arr = new ArrayList<Integer>();

		ResultSet rs = stat.executeQuery("select * from "+ "AllMatches");

		while(rs.next()){
			int teamNumber = rs.getInt("TeamNumber");
			
			if (!arr.contains(Integer.valueOf(teamNumber))){
				arr.add(Integer.valueOf(teamNumber));
			}
			
		}
		rs.close();
		
		return arr;
	}

}
