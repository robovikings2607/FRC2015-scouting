import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;

import org.frc2834.bluealliance.v1.BlueAlliance;
import org.frc2834.bluealliance.v1.matches.Match;


public class Creator {
	static BlueAlliance b = new BlueAlliance();

	public static void main(String[] args) {
		try {
			ArrayList<List<String>> y = getMatchList("2014pahat");

			
			CSVHandler.writeArrayToFile(y);
			
			ArrayList<List<String>> z = CSVHandler.readToArray("Schedule.csv");
			
			for(List<String> x : z){
				System.out.println(x.toString());
			}
			
			ArrayList<List<String>> rawData;
			rawData = CSVHandler.readToArray("Schedule.csv");
			
			String[][] data = new String[rawData.size()][rawData.get(0).size()];
			
			for (int i = 0; i < data.length; i++){
				data[i] = (String[]) rawData.get(i).toArray();
			}
			
			ScheduleViewerTest frame = new ScheduleViewerTest();
			
			frame.model.setData(data, new String[] {"Match", "Red 1", "Red 2", "Red 3", "Blue 1", "Blue 2", "Blue 3"});
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<List<String>> getMatchList(String code) throws IOException{
		ArrayList<List<String>> table = new ArrayList<List<String>>();
		
		List<Match> y = b.getMatchList(code);
		for (Match x : y){
			table.add(Arrays.asList(new String[] {x.getKey().split("_")[1],
				x.getAlliances().get("red").getTeams()[0],
				x.getAlliances().get("red").getTeams()[1],
				x.getAlliances().get("red").getTeams()[2],
				x.getAlliances().get("blue").getTeams()[0],
				x.getAlliances().get("blue").getTeams()[1],
				x.getAlliances().get("blue").getTeams()[2]}));
		}
		return table;
		
	}

}
