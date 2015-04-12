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
		
		String[] headers = {"Team", "Match", "Scout Name", "Cans Level 1", "Cans Level 2", "Cans Level 3", "Cans Level 4", "Cans Level 5", "Cans Level 6",
				"Totes Level 1", "Totes Level 2", "Totes Level 3", "Totes Level 4", "Totes Level 5", "Totes Level 6", "Total Can Points", "Total Tote Points",
				"Total Noodle Points", "Total Stack Points", "Total Co-op Points", "Total Points Without Fouls", "Total Points", "Points Per Second", "Auto Totes Moved", "Auto Totes Stacked", "Auto Cans Moved", "Auto Robot Moved", "Auto Center Cans",
				"Broken", "Did Nothing", "Stacks Knocked Over", "Absent", "Tipped Over", "Fouls", "Total Foul Points", "Time taken for Coopertition",
				"Totes From Landfill", "Totes From Human", "Noodles Push To Landfill", "Pick Up Knocked Over Totes", "Pick Up Knocked Over Cans", "Containers From Center",
				"Notes", "Coop Totes", "1 Stacks", "2 Stacks", "3 Stacks", "4 Stacks", "5 Stacks", "6 Stacks"};
		
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
					writer.setCell(String.valueOf(match.otherData.getScoutName()), headerList.indexOf("Scout Name"), i);
					
					for (int foo = 1; foo <= 6; foo++){
						writer.setCell(String.valueOf(getTotesAtHeight(foo-1, match)), headerList.indexOf("Totes Level " + foo), i);
						writer.setCell(String.valueOf(getContainersAtHeight(foo, match)), headerList.indexOf("Cans Level " + foo), i);
						
					}
					
					writer.setCell(String.valueOf(getStacks(match)[0]), headerList.indexOf("1 Stacks"), i);
					writer.setCell(String.valueOf(getStacks(match)[1]), headerList.indexOf("2 Stacks"), i);
					writer.setCell(String.valueOf(getStacks(match)[2]), headerList.indexOf("3 Stacks"), i);
					writer.setCell(String.valueOf(getStacks(match)[3]), headerList.indexOf("4 Stacks"), i);
					writer.setCell(String.valueOf(getStacks(match)[4]), headerList.indexOf("5 Stacks"), i);
					writer.setCell(String.valueOf(getStacks(match)[5]), headerList.indexOf("6 Stacks"), i);
					
					
					writer.setCell(String.valueOf(getTotalCanPoints(match)), headerList.indexOf("Total Can Points"), i);
					writer.setCell(String.valueOf(getTotalTotePoints(match)), headerList.indexOf("Total Tote Points"), i);
					writer.setCell(String.valueOf(getTotalNoodlePoints(match)), headerList.indexOf("Total Noodle Points"), i);
					writer.setCell(String.valueOf(getTotalStackPoints(match)), headerList.indexOf("Total Stack Points"), i);
					writer.setCell(String.valueOf(getTotalCoopPoints(match)), headerList.indexOf("Total Co-op Points"), i);
					writer.setCell(String.valueOf(getTotalFoulPoints(match)), headerList.indexOf("Total Foul Points"), i);
					writer.setCell(String.valueOf(getPoints(match)), headerList.indexOf("Total Points Without Fouls"), i);
					writer.setCell(String.valueOf(getTotalPoints(match)), headerList.indexOf("Total Points"), i);
					writer.setCell(String.valueOf(getPointsPerSecond(match)), headerList.indexOf("Points Per Second"), i);
					
					
					writer.setCell(String.valueOf(match.otherData.getNumberOfAutoTotesMoved()), headerList.indexOf("Auto Totes Moved"), i);
					writer.setCell(String.valueOf(match.otherData.getNumberOfAutoRecyclingBinsMoved()), headerList.indexOf("Auto Cans Moved"), i);
					writer.setCell(String.valueOf(match.otherData.isStackedAllThreeAutoTotes()?1:0), headerList.indexOf("Auto Totes Stacked"), i);
					writer.setCell(String.valueOf(match.otherData.isRobotMovedAuto()?1:0), headerList.indexOf("Auto Robot Moved"), i);
					writer.setCell(String.valueOf(match.otherData.autoContainersFromCenter()), headerList.indexOf("Auto Center Cans"), i);
					
					writer.setCell(String.valueOf(match.otherData.isBroken()?1:0), headerList.indexOf("Broken"), i);
					writer.setCell(String.valueOf(match.otherData.isAbsent()?1:0), headerList.indexOf("Absent"), i);
					writer.setCell(String.valueOf(match.otherData.isDidNothing()?1:0), headerList.indexOf("Did Nothing"), i);
					writer.setCell(String.valueOf(match.otherData.getStacksKnockedOver()), headerList.indexOf("Stacks Knocked Over"), i);
					writer.setCell(String.valueOf(match.otherData.isTipped()?1:0), headerList.indexOf("Tipped Over"), i);
					writer.setCell(String.valueOf(match.otherData.getFouls()), headerList.indexOf("Fouls"), i);
					
					writer.setCell(String.valueOf(match.otherData.isTakesFromLandfill()?1:0), headerList.indexOf("Totes From Landfill"), i);
					writer.setCell(String.valueOf(match.otherData.isTakesFromHumanPlayer()?1:0), headerList.indexOf("Totes From Human"), i);
					writer.setCell(String.valueOf(match.otherData.getNumberOfLandfillNoodles()), headerList.indexOf("Noodles Push To Landfill"), i);
					writer.setCell(String.valueOf(match.otherData.isPickedUpKnockedOverTotes()?1:0), headerList.indexOf("Pick Up Knocked Over Totes"), i);
					writer.setCell(String.valueOf(match.otherData.isPickedUpKnockedOverContainers()?1:0), headerList.indexOf("Pick Up Knocked Over Cans"), i);
					writer.setCell(String.valueOf(match.otherData.containersFromCenter()), headerList.indexOf("Containers From Center"), i);
					writer.setCell(String.valueOf(( (match.otherData.getTimerCount() == 0)) ? null:match.otherData.getTimerCount()), headerList.indexOf("Time taken for Coopertition"), i);
					writer.setCell(String.valueOf(match.otherData.getCoopTotes()), headerList.indexOf("Coop Totes"),i);
					
					writer.setCell(String.valueOf(match.otherData.getGameNotes()), headerList.indexOf("Notes"), i);
					
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
	
	private int[] getStacks(Match match){
	int[] stack = new int[6];
	for (Stack s : match.getStacks()){
			switch (s.getNumberOfTotes()){
			case 1: stack[0] += 1;
					break;
			case 2: stack[1] += 1;
					break;
			case 3: stack[2] += 1;
					break;
			case 4: stack[3] += 1;
					break;
			case 5: stack[4] += 1;
					break;
			case 6: stack[5] += 1;
					break;
				
			}
		}
		return stack;
	}

	private int getOneStacks(Match match){
		int t = 0;
		for (Stack s : match.getStacks()){
			if(s.getNumberOfTotes() == 1){
				t +=1;
			}
		}
		return t;
	}
	
	private int getTwoStacks(Match match){
		int t = 0;
		for (Stack s : match.getStacks()){
			if(s.getNumberOfTotes() == 2){
				t +=1;
			}
		}
		return t;
	}
	private int getThreeStacks(Match match){
		int t = 0;
		for (Stack s : match.getStacks()){
			if(s.getNumberOfTotes() == 3){
				t +=1;
			}
		}
		return t;
	}
	private int getFourStacks(Match match){
		int t = 0;
		for (Stack s : match.getStacks()){
			if(s.getNumberOfTotes() == 4){
				t +=1;
			}
		}
		return t;
	}
	private int getFiveStacks(Match match){
		int t = 0;
		for (Stack s : match.getStacks()){
			if(s.getNumberOfTotes() == 5){
				t +=1;
			}
		}
		return t;
	}
	private int getSixStacks(Match match){
		int t = 0;
		for (Stack s : match.getStacks()){
			if(s.getNumberOfTotes() == 6){
				t +=1;
			}
		}
		return t;
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
	
	private int getTotalFoulPoints(Match match){
		int fouls = 0;
		
		return match.getOtherData().getFoulPoints();
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
		return match.getOtherData().getCoopTotes() > 0?40:0;
		
	}
	
	
	
	
	private int getTotalPoints(Match match){
		return getTotalStackPoints(match) + getTotalCoopPoints(match) - getTotalFoulPoints(match);
	}
	
	private int getPoints(Match match){
		return getTotalStackPoints(match) + getTotalCoopPoints(match);
	}
	
	private double getPointsPerSecond(Match match){
		return (double) (getTotalStackPoints(match))/(135.0 - (match.otherData.getTimerCount()));
	}
	
}