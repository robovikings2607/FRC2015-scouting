import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;


public class ExcelWriter {
	String filename;
	
	HSSFWorkbook workbook;
	HSSFSheet spreadsheet;
	
	ExcelWriter(String name){
		filename=name;
		
		workbook = new HSSFWorkbook(); 
		spreadsheet = workbook.createSheet("DataByMatch");
	}
	
	public void writeSheet(){
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File("Writesheet.xls"));
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setHeaders(ArrayList<String> headers){
		for (int i = 0; i < headers.size(); i++){
			setCell(headers.get(i), i, 0);
		}
	}
	
	public void setCell(String value, int column, int rowNum){
		HSSFRow row = spreadsheet.getRow(rowNum);
		if (row == null) row = spreadsheet.createRow(rowNum);
		
		Cell cell;
		if (isNumeric(value)){
			cell = row.createCell(column, Cell.CELL_TYPE_NUMERIC);
			
			cell.setCellValue(Double.valueOf(value));
		}
		else{
			cell = row.createCell(column, Cell.CELL_TYPE_STRING);
			
			cell.setCellValue(value);
		}
		
	}
	
	private boolean isNumeric(String s){
		try  
		{  
			double d = Double.parseDouble(s);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

}
