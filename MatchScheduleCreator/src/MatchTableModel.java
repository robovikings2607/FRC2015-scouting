import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


public class MatchTableModel extends AbstractTableModel {
	private String[] columnNames = {""};
    private Object[][] data = {{""}}; 
    
    List<Color> rowColours = Arrays.asList(
            Color.RED,
            Color.GREEN,
            Color.CYAN
    );
    
    MatchTableModel(){
    	
    }

    MatchTableModel(Object[][] mData, String[] mColumnNames){
    	columnNames = mColumnNames;
    	data = mData;
    	
    	fireTableStructureChanged();
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        Class returnValue;
        
        if ((c >= 0) && (c < getColumnCount())) {
          returnValue = getValueAt(0, c).getClass();
        } else {
          returnValue = Object.class;
        }
        
        return returnValue;
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    public void setData(Object[][] mData, String[] mColumnNames){
    	columnNames = mColumnNames;
    	data = mData;
    	
    	fireTableStructureChanged();
    }
    
    public void highlightCell(int row, int column){
    	
    }

    public void setRowColour(int row, Color c) {
        rowColours.set(row, c);
        fireTableRowsUpdated(row, row);
    }
    
}
