import java.awt.Color;
import java.awt.Rectangle;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class Redraw extends JPanel {
	static BitMasking bitmasking = new BitMasking();
	
	
	public static void main(String[] blues){
		JFrame frame = new JFrame();
		int[] nums = {2,4,0,1,1,1,0};
		Redraw redraw = new Redraw((long)61503L, nums);
		frame.setBounds(100,100,600,400);
		
		frame.getContentPane().add(redraw);
		
		frame.setVisible(true);
		
		
	}
	
	public Redraw( long toteNumber, int[] containerListForward){
		int x=0;
		int y=320;
		setLayout(null);
		int counter = 0;
		ArrayList<JToggleButton> buttonList = new ArrayList<JToggleButton>();
		ArrayList<JToggleButton> containerList = new ArrayList<JToggleButton>();
		for (boolean stack : bitmasking.decodeStack(toteNumber)){
			
			if(stack == true){
				buttonList.add( new JToggleButton());
				buttonList.get(counter).setBounds(x, y, 50, 20);
				buttonList.get(counter).setFocusPainted(false);
				buttonList.get(counter).setEnabled(false);
				add(buttonList.get(counter));
				counter +=1;
				
			} /*else {
				buttonList.add( new JToggleButton());
				buttonList.get(counter).setBounds(x, y, 50, 20);
				buttonList.get(counter).setBackground(Color.RED);
				buttonList.get(counter).setFocusPainted(false);
				buttonList.get(counter).setEnabled(false);
				add(buttonList.get(counter));
				counter +=1;
			} */
			
			y -= 20;
			
			if(y == 200){
				x += 80;
				y = 320;
			}
		}
		int counter2 = 0;
		int xcoord = 10;
		
		for(int containerCounter = 0; containerCounter < containerListForward.length; containerCounter ++){
			
			
			switch(containerListForward[containerCounter]){
			
			case 0:
				
				break;
			case 1:
				containerList.add( new JToggleButton());
				containerList.get(counter2).setBounds(xcoord, 270, 30, 50);
				containerList.get(counter2).setFocusPainted(false);
				containerList.get(counter2).setEnabled(false);
				add(containerList.get(counter2));
				counter2 += 1;
				break;
					
			case 2:
				containerList.add( new JToggleButton());
				containerList.get(counter2).setBounds(xcoord, 250, 30, 50);
				containerList.get(counter2).setFocusPainted(false);
				containerList.get(counter2).setEnabled(false);
				add(containerList.get(counter2));
				counter2 += 1;
				break;
				
			case 3:
				containerList.add( new JToggleButton());
				containerList.get(counter2).setBounds(xcoord, 230, 30, 50);
				containerList.get(counter2).setFocusPainted(false);
				containerList.get(counter2).setEnabled(false);
				add(containerList.get(counter2));
				counter2 += 1;
				break;
				
			case 4:
				containerList.add( new JToggleButton());
				containerList.get(counter2).setBounds(xcoord, 210, 30, 50);
				containerList.get(counter2).setFocusPainted(false);
				containerList.get(counter2).setEnabled(false);
				add(containerList.get(counter2));
				counter2 += 1;
				break;
				
			case 5:
				containerList.add( new JToggleButton());
				containerList.get(counter2).setBounds(xcoord, 190, 30, 50);
				containerList.get(counter2).setFocusPainted(false);
				containerList.get(counter2).setEnabled(false);
				add(containerList.get(counter2));
				counter2 += 1;
				break;
				
			case 6:
				containerList.add( new JToggleButton());
				containerList.get(counter2).setBounds(xcoord, 170, 30, 50);
				containerList.get(counter2).setFocusPainted(false);
				containerList.get(counter2).setEnabled(false);
				add(containerList.get(counter2));
				counter2 += 1;
				break;
				
			}
			xcoord += 80;
			
			
		}
		
	}

}
