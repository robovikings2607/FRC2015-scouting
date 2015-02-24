import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class MatchTable extends JTable {
	Color highlight = Color.YELLOW;
	boolean highlightOn = false;
	int highlightX = 0;
	int highlightY = 0;
	
	MatchTable(){
		super();
	}
	
    public MatchTable(int numRows, int numColumns) {
		super(numRows, numColumns);
		// TODO Auto-generated constructor stub
	}

	public MatchTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}

	public MatchTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
		// TODO Auto-generated constructor stub
	}

	public MatchTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		// TODO Auto-generated constructor stub
	}

	public MatchTable(TableModel dm) {
		super(dm);
		// TODO Auto-generated constructor stub
		this.setDefaultRenderer(Object.class, renderer);
	}

	public MatchTable(Vector rowData, Vector columnNames) {
		super(rowData, columnNames);
		// TODO Auto-generated constructor stub
	}
	
	public void highlightOn(int aRow, int aColumn){
		highlightOn = true;
		highlightX = aColumn;
		highlightY = aRow;
	}
	
	public void setRenderer(){
		this.setDefaultRenderer(Object.class, renderer);
	}

	public void highlightOff(){
		highlightOn = false;
	}
	
	public TableCellRenderer renderer = new TableCellRenderer() {

        JLabel label = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            label.setOpaque(true);
            label.setText("" + value);
            Color alternate = UIManager.getColor("Table.alternateRowColor");;
            if (highlightOn && (row == highlightY || column == highlightX) && !(row == highlightY && column == highlightX)) {
            	label.setBackground(highlight);
            } else {
                label.setBackground(Color.WHITE);
            }
            return label;
        }

    };
    
}
