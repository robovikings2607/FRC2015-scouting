import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


public class SQLToExcel {
	ArrayList<Team> data;
	ExcelWriter writer;
	ArrayList<String> headerList;

	SQLToExcel(String file) throws Exception{
		writer = new ExcelWriter("outToTableau.xls");
		
		Connection con = DriverManager.getConnection("jdbc:sqlite:" + file);
		Statement stat = con.createStatement();
		
		ArrayList<Integer> teamList = getTeamListFromDatabase(stat);
		data = getTeamArrayWithData(teamList, stat);
		
		String[] headers = {"Team", "Match", "Cans Level 1", "Cans Level 2", "Cans Level 3", "Cans Level 4", "Cans Level 5", "Cans Level 6",
				"Totes Level 1", "Totes Level 2", "Totes Level 3", "Totes Level 4", "Totes Level 5", "Totes Level 6", "Total Cans", "Total Totes",
				"Total Noodles", "Total Stack Points", "Total Co-op Points", "Total Points"};
		
		headerList = new ArrayList<String>();
		headerList.addAll(Arrays.asList(headers));
		
		writer.setHeaders(headerList);
	}
	
	private ArrayList<Team> getTeamArrayWithData(ArrayList<Integer> teamList, Statement stat) throws Exception {
		ArrayList<Team> teams = new ArrayList<Team>();
		
		for (Integer team : teamList){
			teams.add(new Team(team, stat));
		}
		
		return teams;
	}

	private ArrayList<Integer> getTeamListFromDatabase(Statement stat) throws SQLException {
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
	
	public void populateExcelFile(){
		int i = -1;
		for(Team team : data){
			for(Match match : team.getMatches()){
				i++;
				
				writer.setCell(match.ge, headerList.indexOf("Team"), i);
			}
		}
	}
	
	public void writeExcelFile(){
		writer.writeSheet();
	}
	
}
