import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TeleopPanel extends JPanel {
	public static JTextField textField;
	
	int toteCounter = 1;
	int toteX = 13;
	int toteY = 180;
	int containerCounter = 0;
	
	ArrayList<JToggleButton> buttonList = new ArrayList<JToggleButton>();
	ArrayList<JButton> containerList = new ArrayList<JButton>();
	ArrayList<JToggleButton> noodleList = new ArrayList<JToggleButton>();
	
	

	/**
	 * Create the panel.
	 */
	
	
	public TeleopPanel() {
		
		setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 199, 575, 26);
		add(textField);
		textField.setColumns(10);
		
		
		
		for(int counter = 0; counter <= 48; counter ++){
		
		buttonList.add(new JToggleButton());
		buttonList.get(counter).setBounds(toteX,toteY,50,20);
		buttonList.get(counter).setFocusPainted(false);
		add(buttonList.get(counter));
		toteY -=20;
		buttonList.get(counter).setText(Integer.toString(toteCounter));
		toteCounter+=1;
		if (toteCounter == 7){
		containerList.add(new JButton());
		containerList.get(containerCounter).setBounds(toteX + 10,toteY - 30, 30,50);
		add(containerList.get(containerCounter));
		containerList.get(containerCounter).setBackground(Color.green);
		containerList.get(containerCounter).setMargin(new Insets(1,1,1,1));
		containerList.get(containerCounter).setText("0");
		containerList.get(containerCounter).setFocusPainted(false);
		
		noodleList.add(new JToggleButton());
		noodleList.get(containerCounter).setBounds(toteX + 20,toteY - 55, 10,25);
		add(noodleList.get(containerCounter));
		noodleList.get(containerCounter).setBackground(new Color(255,0,255));
		
		containerCounter +=1;
		toteCounter = 1;
		toteX += 80;
		toteY = 180;
		}
		buttonList.get(counter).setBackground(Color.cyan);
		
		
		}
		
		 
		
		
		
	}
}
