import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultRowSorter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;


public class ScheduleViewerFrame {

	ScheduleViewerFrame(){
		
	}
	
	public void openScheduleWindow(String file){
		try{
			ArrayList<List<Object>> z = CSVHandler.readToArray("Schedule.csv");
			
			for(List<Object> x : z){
				System.out.println(x.toString());
			}
			
			ArrayList<List<Object>> rawData;
			rawData = CSVHandler.readToArray("Schedule.csv");
			
			Integer[][] data = new Integer[rawData.size()][rawData.get(0).size()];
			
			for (int i = 0; i < data.length; i++){
				for (int foo = 0; foo < data[0].length; foo++){
					data[i][foo] = Integer.valueOf((String) rawData.get(i).get(foo));
				}
			}
			
			ScheduleViewer frame = new ScheduleViewer();
			
			frame.model.setData(data, new String[] {"Match", "Red 1", "Red 2", "Red 3", "Blue 1", "Blue 2", "Blue 3"});
		    
			frame.schedule.setAutoCreateRowSorter(true);
	        // DefaultRowSorter has the sort() method
	        DefaultRowSorter sorter = ((DefaultRowSorter)frame.schedule.getRowSorter()); 
		    frame.schedule.setRowSorter(sorter);
		    ArrayList list = new ArrayList();
	        list.add( new RowSorter.SortKey(0, SortOrder.ASCENDING) );
	        sorter.setSortKeys(list);
	        sorter.sort();
		    
		    frame.schedule.setRenderer();
			
			frame.schedule.highlightOn(4, 4);
			
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
