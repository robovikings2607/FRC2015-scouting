import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;


public class ScheduleViewer extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	MatchTable schedule;
	MatchTableModel model = new MatchTableModel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ScheduleViewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel SchedulePanel = new JPanel();
		contentPane.add(SchedulePanel, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		SchedulePanel.add(scrollPane);
		
		schedule = new MatchTable(model);
		scrollPane.setViewportView(schedule);
	}
	


}

