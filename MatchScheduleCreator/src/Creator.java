import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultRowSorter;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.frc2834.bluealliance.v1.BlueAlliance;
import org.frc2834.bluealliance.v1.matches.Match;


public class Creator {
	static BlueAlliance b = new BlueAlliance();

	public static void main(String[] args) {
		try {
			ArrayList<List<Integer>> y = getMatchList("2014pahat");
			
			CSVHandler.writeArrayToFile(y);
			
			ScheduleViewerFrame f = new ScheduleViewerFrame();
			
			f.openScheduleWindow("Schedule.csv");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<List<Integer>> getMatchList(String code) throws IOException{
		ArrayList<List<Integer>> table = new ArrayList<List<Integer>>();
		
		List<Match> y = b.getMatchList(code);
		for (Match x : y){
			if (x.getKey().split("_")[1].contains("qm")){
				table.add(Arrays.asList(new Integer[] {Integer.valueOf(x.getKey().split("_")[1].replace("qm", "")),
					Integer.valueOf(x.getAlliances().get("red").getTeams()[0].replace("frc", "")),
					Integer.valueOf(x.getAlliances().get("red").getTeams()[1].replace("frc", "")),
					Integer.valueOf(x.getAlliances().get("red").getTeams()[2].replace("frc", "")),
					Integer.valueOf(x.getAlliances().get("blue").getTeams()[0].replace("frc", "")),
					Integer.valueOf(x.getAlliances().get("blue").getTeams()[1].replace("frc", "")),
					Integer.valueOf(x.getAlliances().get("blue").getTeams()[2].replace("frc", ""))}));
			}
		}
		return table;
		
	}

}
