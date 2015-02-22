import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTable;


public class ScheduleViewerTest extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	JTable schedule;
	MyTableModel model = new MyTableModel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ScheduleViewerTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel SchedulePanel = new JPanel();
		contentPane.add(SchedulePanel, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		SchedulePanel.add(scrollPane);
		
		schedule = new JTable(model);
		scrollPane.setViewportView(schedule);
	}

}

class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {""};
    private Object[][] data = {{""}}; 
    
    MyTableModel(){
    	
    }

    MyTableModel(Object[][] mData, String[] mColumnNames){
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
        return getValueAt(0, c).getClass();
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
}
