import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVHandler {

	CSVHandler(){
		
	}
	
	public static <T> void writeArrayToFile(ArrayList<List<T>> input) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("Schedule.csv", "UTF-8");
		
		for (List<T> y : input){
			for (Object z : y){
				writer.print(z.toString() + ",");
			}
			writer.print("\n");
		}
		
		writer.close();
	}
	
	public static ArrayList<List<Object>> readToArray(String fileToRead) throws IOException{
		ArrayList<List<Object>> arr = new ArrayList<List<Object>>();
		FileReader lowerReader = new FileReader(fileToRead);
		BufferedReader reader = new BufferedReader(lowerReader);
		
		String s;
		while((s = reader.readLine()) != null){
			List<Object> l = Arrays.asList(s.split(","));
//			for (int i = 0; i < l.size(); i++){
//				l.set(i, l.get(i).replace("frc", ""));
//			}
			arr.add(l);
		}
		
		return arr;
	}
}
