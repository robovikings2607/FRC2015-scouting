import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hssf.util.CellRangeAddress;


public class SQLToExcel {
	ArrayList<Team> data;
	ExcelWriter writer;
	ArrayList<String> headerList;
	int rowsPopulated = 0;

	SQLToExcel(String file) throws Exception{
		writer = new ExcelWriter("outToTableau.xls");
		
		Connection con = DriverManager.getConnection("jdbc:sqlite:" + file);
		Statement stat = con.createStatement();
		
		ArrayList<Integer> teamList = getTeamListFromDatabase(stat);
		data = getTeamArrayWithData(teamList, stat);
		
		String[] headers = {"Team", "Match", "Cans Level 1", "Cans Level 2", "Cans Level 3", "Cans Level 4", "Cans Level 5", "Cans Level 6",
				"Totes Level 1", "Totes Level 2", "Totes Level 3", "Totes Level 4", "Totes Level 5", "Totes Level 6", "Total Can Points", "Total Tote Points",
				"Total Noodle Points", "Total Stack Points", "Total Co-op Points", "Total Points"};
		
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
	
	public void writeExcelFile(){
		writer.spreadsheet.setAutoFilter(new CellRangeAddress(0, rowsPopulated, 0, headerList.size()));
		
		writer.writeSheet();
	}
	
	public void populateExcelFile(){
		int i = -1;
		for(Team team : data){
			for(Match match : team.getMatches()){
				if (match.otherData.getMatchNumber() != 0) {
					i++;
					
					writer.setCell(String.valueOf(match.teamNumber), headerList.indexOf("Team"), i);
					writer.setCell(String.valueOf(match.otherData.getMatchNumber()), headerList.indexOf("Match"), i);
					
					for (int foo = 1; foo <= 6; foo++){
						writer.setCell(String.valueOf(getTotesAtHeight(foo-1, match)), headerList.indexOf("Totes Level " + foo), i);
						writer.setCell(String.valueOf(getContainersAtHeight(foo, match)), headerList.indexOf("Cans Level " + foo), i);
					}
					
					writer.setCell(String.valueOf(getTotalCanPoints(match)), headerList.indexOf("Total Can Points"), i);
					writer.setCell(String.valueOf(getTotalTotePoints(match)), headerList.indexOf("Total Tote Points"), i);
					writer.setCell(String.valueOf(getTotalNoodlePoints(match)), headerList.indexOf("Total Noodle Points"), i);
					writer.setCell(String.valueOf(getTotalStackPoints(match)), headerList.indexOf("Total Stack Points"), i);
					writer.setCell(String.valueOf(getTotalCoopPoints(match)), headerList.indexOf("Total Co-op Points"), i);
					writer.setCell(String.valueOf(getTotalPoints(match)), headerList.indexOf("Total Points"), i);
				}
			}
		}
		
		rowsPopulated = i + 1;
	}
	
	//ZERO REFENCED!
	private int getTotesAtHeight(int height, Match match){
		int totes = 0;
		
		for (Stack s : match.getStacks()){
			totes += s.getDecoded()[height]?1:0;
		}
		
		return totes;
	}
	
	private int getContainersAtHeight(int height, Match match){
		int cans = 0;
		
		for (Stack s : match.getStacks()){
			if (s.getContainerHeight() == height){
				cans++;
			}
		}
		
		return cans;
	}
	
	private int getTotalCanPoints(Match match){
		int cans = 0;
		
		for (Stack s : match.getStacks()){
			cans += s.getPointsForCan();
		}
		
		return cans;
	}
	
	private int getTotalTotePoints(Match match){
		int totes = 0;
		
		for (Stack s : match.getStacks()){
			totes += s.getPointsForTotes();
		}
		
		return totes;
	}
	
	private int getTotalNoodlePoints(Match match){
		int noodles = 0;
		
		for (Stack s : match.getStacks()){
			noodles += s.getPointsForNoodle();
		}
		
		return noodles;
	}
	
	private int getTotalStackPoints(Match match){
		return getTotalNoodlePoints(match) + getTotalCanPoints(match) + getTotalTotePoints(match);
	}
	
	private int getTotalCoopPoints(Match match){
		return match.getOtherData().isCoopertitionStacked()?1:0 * 40;
	}
	
	private int getTotalPoints(Match match){
		return getTotalStackPoints(match) + getTotalCoopPoints(match);
	}
	
}
