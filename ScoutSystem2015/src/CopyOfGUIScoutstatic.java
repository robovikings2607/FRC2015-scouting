

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Frame;
import java.util.Timer;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.nio.file.*;
import java.util.ArrayList;



public class CopyOfGUIScoutstatic extends JFrame implements Runnable {
	public final static CopyOfGUIScoutstatic tcpObj = new CopyOfGUIScoutstatic();
	public final static ScheduleViewerFrame f = new ScheduleViewerFrame();
	
	public final static Host host = new Host();
	public final static BitMasking bit = new BitMasking();
	
	 static int teamNumber;
	 static int pointsScored;
	  static int matchNumber;
	  static int stacksMade;
	  static int level1Stacks;
	  static int level2Stacks;
	  static int level3Stacks;
	  static int level4Stacks;
	  static int level5Stacks;
	  static int level6Stacks;
	  static int recycleBins;
	   static int noodles;
	   static int avgStackHeight;
	   static String takesFromHumanPlayer;
	   static String gameNotes;
	   static String absent;
	   static String coopertitionStacked;
	   static  String autoZone;
	   static  int autoTotesMoved;
	   static int autoPoints;
	   static int landFillNoodles;
	   static  String didNothing;
	   static  String autoTotesStacked;
	   static  int autoBinsMoved;
	   static String colorNumber;
	   static String esBroken;
	   static String drive;
	   static String tableName;
	   static String takesFromLandFill;

	/*  static int dataNumbers[] = {matchNumber,teamNumber, pointsScored, stacksMade, level1Stacks, level2Stacks, level3Stacks,
		level4Stacks, level5Stacks, level6Stacks, recycleBins, noodles, avgStackHeight, autoTotesMoved, autoBinsMoved };
	
	 static String dataStrgings[] = {colorNumber, gameNotes, absent, takesFromHumanPlayer, coopertitionStacked,autoZone,
		autoTotesStacked, didNothing};
	*/
	
	 static JFrame frame;
	 static JTextField txtYourNameHere;
	 static JTextField textField;
	 static JTextField textField_1;
	 static JTextField ipField;
	 static JTextField timerField;
	 
	
	
//	 final static int NULL = 0;
//	 final static int DISCONNECTED = 1;
//	 final static int DISCONNECTING = 2;
//	 final static int  BEGIN_CONNECT = 3;
//	 final static int CONNECTED = 4;
	
	 static ServerSocket hostServer = null;
	 static Socket socket = null;
	 static BufferedReader in = null;
	 static PrintWriter out = null;
	
	 static boolean buttonFlag = true;
	
	 static TeleopPanel panel;
	 static TeleopPanel panel_1;
	 static JLabel lblNewLabel;
	 static JLabel lblNewLabel_1;
	 static JLabel label;
	 static JLabel lblNotes;
	 static JLabel label_landFillNoodles;
	 static JTextArea txtrGeneralNotes;
	 static JSpinner spinner;
	 static JLabel lblNewLabel_2;
	 static JSpinner spinner_1;
	 static JSpinner spinner_landFillNoodles;
	 static JLabel lblOfBins;
	 static JCheckBox chckbxNewCheckBox;
	 static JCheckBox chckbxEsBroken;
	 static JCheckBox chckbxNewCheckBox_1;
	 static JCheckBox chckbxNewCheckBox_2;
	 static JCheckBox chckbxStackedAllThree;
	 static JButton btnSubmit;
	 static JLabel lblNewLabel_3;
	 static JLabel lblNewLabel_4;
	 static JLabel lblMatch;
	 static JLabel IPField;
	 static JCheckBox chckbxDidNothing;
	 static JComboBox comboBox;
	 static JCheckBox chckbxCoopertitionStacked;
	 static JButton connectButton;
	 static JButton disconnectButton;
	 static JButton timerButton;
	 static JRadioButton rdbtnNewRadioButton;
	 static JRadioButton rdbtnClient;
	 static JButton btnNewButton;
	 static JButton newClientTableButton;
	 static int connectionStatus = 0;
	 static JLabel driveLabel;
	 static JTextField driveField;
	 static JCheckBox chkbxTakesFromLandFill;
	 static JLabel pickedUpKnockedOver;
	 static JCheckBox chkbxknockedOverContainers;
	 static JCheckBox chkbxknockedOverTotes;
	 static JMenuBar toolBar;
	 static JMenuItem matchScheduleButton;
	 static JMenu menu;
	 
	 static String knockedOverContainters;
	 static String knockedOverTotes;
	
	 static int y = 25;
	
	
	 static String hostIP;
	 static boolean flag = true;
	 static String name;
	 static boolean hostButtonSwitch = false;;
	
	 static boolean isHost;
	   
	 static SQLiteTest sql;

	  final static String statusMessages[] = {
	      "Don't Panic", " Sent alright!",
	      "Uh-oh, make sure your drive is in", "Synchronized!", "Synchronizing..."
	   };
	 
	  //final static String statusString = statusMessages[connectionStatus];
	  public static Color statusColors[] = {Color.green, Color.orange, Color.red};
	 
	  static JTextField txtNotConnected;
	 
	 
	  static long columns[] = {0,0,0,0,0,0};
	  static long columnsBack[] = {0,0,0,0,0,0};
      static long btn;
      static long totalTotes;
      static int totes = 0;
      static long totalTotesBack;
      static int totalNoodles;
      static int totalNoodlesBack;
     
      static int containerPoints;
      static int totePoints;
      static int noodlePoints;
      static int totalContainerHeight;
      static int avgContainerHeight;
  
     
      static Color containerColors[] = {Color.green, Color.lightGray, Color.lightGray, Color.lightGray, Color.lightGray, Color.lightGray, Color.lightGray};
      static int containerHeight[] = {0,0,0,0,0,0,0};
      static int containerHeightBack[] = {0,0,0,0,0,0,0};
	private static JSpinner middleContainersSpinner;
	private static int middleContainers;
	private static JLabel middleContainersLabel;
	private static JSpinner knockedOverStacksSpinner;
	private static JLabel knockedOverStacksLabel;
	private static int knockedOverStacks;
	private static JSpinner autoCenterContainersSpinner;
	private static JLabel autoCenterContainersLabel;
	private static int autoCenterContainers;
	private static JButton syncronizeButton;
	private static JTextField driveConnectionField;
	private static AbstractButton checkBoxOurAuton;
	private static String autonWeWant;
	private static ArrayList<String> paths;
	private static JMenuItem newTableButton;
	private static JMenuItem hostButton;
	private static JMenuItem syncButton;
	private static JCheckBox chckbxNewCheckBoxTip;
	private static String tip;
	private static JSpinner spinner_landFouls;
	private static int fouls;
	private static JLabel foulLabel;
	private static Timer timer;
	
	static boolean timerB = false;
    static int counter = 0;
	private static JButton resetButton;
	private static JCheckBox timerBox;
	private static String timerCheck;
	private static JSpinner coopSpinner;
	private static JLabel coopTotesLabel;
	private static int coopTotes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					
					initialize();
					//System.out.println(timerButton.getText());
					//sql = new SQLiteTest();
//					while (true){
//						System.out.println(timerButton.getText());
//						if (timerButton.getText().equals("Stop Timer")){
//						timerField.setText(Integer.toString(counter));	
//							try {
//								Thread.sleep(1000);
//								counter++;
//							} catch (InterruptedException e) {
//
//							}
//		
//						}
//					}
					
					

//				 while (flag) {
//			         try { // Poll every ~10 ms
//			            Thread.sleep(10);
//			         }
//			         catch (InterruptedException e) {}
//
//			         switch (connectionStatus) {
//			         case BEGIN_CONNECT:
//			            try {
//			               // Try to set up a server if host
//			               if (isHost) {
//			            	   hostServer = new ServerSocket(1234);
//			            	   socket = hostServer.accept();
//			            	   sql.setFileName("hostscout.db");
//			               }
//
//			               // If guest, try to connect to the server
//			               else {
//			            	   socket = new Socket(hostIP, 1234);
//			            	   sql.setFileName("clientscout.db");
//			               }
//
//			               in = new BufferedReader(new 
//			                  InputStreamReader(socket.getInputStream()));
//			               out = new PrintWriter(socket.getOutputStream(), true);
//			               changeStatusTS(CONNECTED, true);
//			               
//			            }
//			            // If error, clean up and output an error message
//			            catch (IOException e) {
//			               cleanUp();
//			               changeStatusTS(DISCONNECTED, false);
//			            }
//			            
//			            break;
//
//			         case CONNECTED:
//			        	 
//			          /*  try {
//			               // Send data
//			            	
//			               if (toSend.length() != 0) {
//			                  out.print(toSend); out.flush();
//			                  toSend.setLength(0);
//			                  changeStatusTS(NULL, true);
//			             
//			               }
//
//			               // Receive data
//			               if (in.ready()) {
//			                  s = in.readLine();
//			                  
//			                  if ((s != null) &&  (s.length() != 0)) {
//			                     // Check if it is the end of a trasmission
//			                     if (s.equals(END_CHAT_SESSION)) {
//			                        changeStatusTS(DISCONNECTING, true);
//			  
//			                     }
//
//			                     // Otherwise, receive what text
//			                     else {
//			                        appendToChatBox(s + "\n");
//			                        changeStatusTS(NULL, true);
//			                     }
//			                  }
//			               }
//			            }
//			            
//			            catch (IOException e) {
//			               cleanUp();
//			               changeStatusTS(DISCONNECTED, false);
//			            }
//			            */
//			         
//			            break;
//
//			         case DISCONNECTING:
//			            // Tell other chatter to disconnect as well
//			            out.flush();
//
//			            // Clean up (close all streams/sockets)
//			            cleanUp();
//			            changeStatusTS(DISCONNECTED, true);
//			            try {
//			                sql.run();
//			              } catch (Exception e) {
//			                 
//			                }
//			            break;
//			            
//
//			         default: break; // do nothing
//			         }
//			         
//			      } 
			      
			      
			      
			   }
				
	

	/**
	 * Create the application.
	 */
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	public static void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 975, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Scouteroo!");
		
		
		ActionAdapter buttonListener = null;
		
		toolBar = new JMenuBar();
		toolBar.setBounds(0,0,975, 15);
		toolBar.setBackground(Color.LIGHT_GRAY);
		frame.add(toolBar);
		
		menu = new JMenu("Tools");
		menu.getAccessibleContext().setAccessibleDescription(
		        "Tools await");
		
		
		matchScheduleButton = new JMenuItem("Match Schedule");
		matchScheduleButton.setActionCommand("schedule");
		menu.add(matchScheduleButton);
		matchScheduleButton.setActionCommand("schedule");
		
		hostButton = new JMenuItem("Host Menu");
		hostButton.setActionCommand("host!");
		menu.add(hostButton);
		hostButton.setActionCommand("host!");
		
		
		newTableButton = new JMenuItem("Create New Table");
		newTableButton.setActionCommand("newTable!");
		menu.add(newTableButton);
		newTableButton.setActionCommand("newTable!");
		
		
		syncButton = new JMenuItem("Synchronize");
		syncButton.setActionCommand("sync!");
		menu.add(syncButton);
		syncButton.setActionCommand("sync!");
		
		
		
		
		
		
		 buttonListener = new ActionAdapter(){
       	  public void actionPerformed(ActionEvent e){
       		  if (e.getActionCommand().equals("schedule")){
       			  // add more to this later
       			f.openScheduleWindow("Schedule.csv");
       			  
       		  }
       		  if (e.getActionCommand().equals("newTable!")){
       			sql.createNewTable();
       		  }
       		 if (e.getActionCommand().equals("host!") && colorNumber.equals("Host")){
       			hostButtonSwitch = !hostButtonSwitch;
       			host.setVisible(hostButtonSwitch);
        		  }
       		 if (e.getActionCommand().equals("sync!")){
       			 
       		 }
       	  }
         };
         
         driveConnectionField = new JTextField();
 		driveConnectionField.setEnabled(true);
 		driveConnectionField.setEditable(false);
 		driveConnectionField.setFont(new Font("Arial", Font.BOLD, 12));
 		driveConnectionField.setBackground(Color.RED);
 		driveConnectionField.setText(statusMessages[0]);
 		driveConnectionField.setBounds(0, 515, 200, 20);
 		frame.getContentPane().add(driveConnectionField);
 		driveConnectionField.setColumns(10);
 		driveConnectionField.setVisible(true);
		
		
		matchScheduleButton.addActionListener(buttonListener);
		newTableButton.addActionListener(buttonListener);
		hostButton.addActionListener(buttonListener);
		syncButton.addActionListener(buttonListener);
		
		toolBar.add(menu);
		
		sql = new SQLiteTest();
		
		
		
		panel = new TeleopPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setForeground(Color.YELLOW);
		panel.setBounds(475, 70, 475, 221); //400, 70, 555,221
		frame.getContentPane().add(panel);
		
		panel_1 = new TeleopPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(475, 317, 475, 221);
		frame.getContentPane().add(panel_1);
		
		txtYourNameHere = new JTextField();
		txtYourNameHere.setBackground(new Color(204, 204, 204));
		txtYourNameHere.setText("Your Name");
		txtYourNameHere.setBounds(49, 18, 106, 20);
		frame.getContentPane().add(txtYourNameHere);
		txtYourNameHere.setColumns(10);
		
		lblNewLabel = new JLabel("Autonomous");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(49, 296, 147, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Teleop Forward");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(500, 296, 218, 20); //397
		frame.getContentPane().add(lblNewLabel_1);
		
		label = new JLabel("Teleop Back");
		label.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label.setBounds(500, 49, 207, 20);
		frame.getContentPane().add(label);
		
		lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNotes.setBounds(49, 49, 93, 17);
		frame.getContentPane().add(lblNotes);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 204, 204));
		textField.setColumns(10);
		textField.setBounds(336, 18, 86, 20);
		frame.getContentPane().add(textField);
		textField.setText(Integer.toString(2607));
		teamNumber = 2607;
		textField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
               // should be editable only when disconnected
               teamNumber = Integer.parseInt(textField.getText());
            }  
        }
         );
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setColumns(10);
		textField_1.setBounds(501, 18, 79, 20);
		frame.getContentPane().add(textField_1);
		matchNumber = 1;
		textField_1.setText(Integer.toString(matchNumber));
		 textField_1.addFocusListener(new FocusAdapter() {
             public void focusLost(FocusEvent e) {
                // should be editable only when disconnected
                matchNumber = Integer.parseInt(textField_1.getText());
             }  
         }
          );
		
		
		
		txtrGeneralNotes = new JTextArea();
		txtrGeneralNotes.setBackground(new Color(204, 204, 204));
		txtrGeneralNotes.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrGeneralNotes.setText("General Notes");
		txtrGeneralNotes.setBounds(10, 70, 235, 72);
		frame.getContentPane().add(txtrGeneralNotes);
		gameNotes = "";
		
		txtrGeneralNotes.addFocusListener(new FocusAdapter() {
             public void focusLost(FocusEvent e) {
                // should be editable only when disconnected
                gameNotes = txtrGeneralNotes.getText();
             }  
         }
          );
		
		spinner = new JSpinner();
		spinner.setForeground(new Color(204, 204, 255));
		spinner.setBackground(new Color(204, 204, 204));
		spinner.setBounds(70, 330, 46, 33);
		spinner.setValue(0);
		frame.getContentPane().add(spinner);
		autoTotesMoved = Integer.parseInt(spinner.getValue().toString());
		autoTotesMoved = 0;
		
		spinner.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				autoTotesMoved = Integer.parseInt(spinner.getValue().toString());
				System.out.println("Number of totes moved: " + autoTotesMoved);	
				
			}	
		});
		
		middleContainersSpinner = new JSpinner();
		middleContainersSpinner.setForeground(new Color(204, 204, 255));
		middleContainersSpinner.setBackground(new Color(204, 204, 204));
		middleContainersSpinner.setBounds(70, 210, 46, 33);
		middleContainersSpinner.setValue(0);
		frame.getContentPane().add(middleContainersSpinner);
		middleContainers = Integer.parseInt(middleContainersSpinner.getValue().toString());
		middleContainers = 0;
		
		middleContainersSpinner.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				middleContainers = Integer.parseInt(middleContainersSpinner.getValue().toString());
				System.out.println("Number of totes moved: " + middleContainers);	
				
			}	
		});
		
		middleContainersLabel = new JLabel("<html> Bins<> from step<>");
		middleContainersLabel.setFont(new Font("Arial", Font.BOLD, 11));
		middleContainersLabel.setBounds(10, 205, 60, 43);
		frame.add(middleContainersLabel);
		
		knockedOverStacksSpinner = new JSpinner();
		knockedOverStacksSpinner.setForeground(new Color(204, 204, 255));
		knockedOverStacksSpinner.setBackground(new Color(204, 204, 204));
		knockedOverStacksSpinner.setBounds(200, 160, 46, 33);
		knockedOverStacksSpinner.setValue(0);
		frame.getContentPane().add(knockedOverStacksSpinner);
		knockedOverStacks = Integer.parseInt(knockedOverStacksSpinner.getValue().toString());
		knockedOverStacks = 0;
		
		knockedOverStacksSpinner.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				knockedOverStacks = Integer.parseInt(knockedOverStacksSpinner.getValue().toString());
				System.out.println("Number of stacks knocked over: " + knockedOverStacks);	
				
			}	
		});
		
		knockedOverStacksLabel = new JLabel("<html> Knocked<> over stacks<>");
		knockedOverStacksLabel.setFont(new Font("Arial", Font.BOLD, 11));
		knockedOverStacksLabel.setBounds(140, 155, 60, 43);
		frame.add(knockedOverStacksLabel);
		
		
		spinner_landFillNoodles = new JSpinner();
		spinner_landFillNoodles.setForeground(new Color(204, 204, 255));
		spinner_landFillNoodles.setBackground(new Color(204, 204, 204));
		spinner_landFillNoodles.setBounds(70, 160, 46, 33);
		spinner_landFillNoodles.setValue(0);
		frame.getContentPane().add(spinner_landFillNoodles);
		landFillNoodles = Integer.parseInt(spinner_landFillNoodles.getValue().toString());
		
		spinner_landFillNoodles.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				landFillNoodles = Integer.parseInt(spinner_landFillNoodles.getValue().toString());
				System.out.println("Number of Noodles in Landfill: " + landFillNoodles);	
				
			}	
		});
		
		fouls = 0;
		spinner_landFouls = new JSpinner();
		spinner_landFouls.setForeground(new Color(204, 204, 255));
		spinner_landFouls.setBackground(new Color(204, 204, 204));
		spinner_landFouls.setBounds(200, 210, 46, 33);
		spinner_landFouls.setValue(0);
		frame.getContentPane().add(spinner_landFouls);
		fouls = Integer.parseInt(spinner_landFouls.getValue().toString());
		
		spinner_landFouls.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				fouls = Integer.parseInt(spinner_landFouls.getValue().toString());
					
				
			}	
		});
		
		foulLabel = new JLabel("Fouls");
		foulLabel.setFont(new Font("Arial", Font.BOLD, 11));
		foulLabel.setBounds(140, 205, 70, 40);
		frame.getContentPane().add(foulLabel);
		
		lblNewLabel_2 = new JLabel("<html> Totes moved<> to auto<> ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 327, 70, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		label_landFillNoodles = new JLabel("<html> Landfill<> Noodles<>");
		label_landFillNoodles.setFont(new Font("Arial", Font.BOLD, 11));
		label_landFillNoodles.setBounds(10, 155, 62, 44);
		frame.getContentPane().add(label_landFillNoodles);
		
		spinner_1 = new JSpinner();
		spinner_1.setForeground(new Color(204, 204, 255));
		spinner_1.setBackground(new Color(204, 204, 204));
		spinner_1.setBounds(70, 379, 46, 33);
		frame.getContentPane().add(spinner_1);
		autoBinsMoved = Integer.parseInt(spinner_1.getValue().toString());
		
		spinner_1.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				autoBinsMoved = Integer.parseInt(spinner_1.getValue().toString());
				System.out.println("Number of bins moved: " + autoBinsMoved);	
				
			}	
		});
		
		lblOfBins = new JLabel("<html> Bins moved<> to auto<>");
		lblOfBins.setFont(new Font("Arial", Font.BOLD, 11));
		lblOfBins.setBounds(10, 375, 65, 40);
		frame.getContentPane().add(lblOfBins);
		
		autoCenterContainersSpinner = new JSpinner();
		autoCenterContainersSpinner.setForeground(new Color(204, 204, 255));
		autoCenterContainersSpinner.setBackground(new Color(204, 204, 204));
		autoCenterContainersSpinner.setBounds(70, 425, 46, 33);
		frame.getContentPane().add(autoCenterContainersSpinner);
		autoCenterContainers = Integer.parseInt(autoCenterContainersSpinner.getValue().toString());
		
		autoCenterContainersSpinner.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				autoCenterContainers = Integer.parseInt(autoCenterContainersSpinner.getValue().toString());
				System.out.println("Number of bins moved: " + autoCenterContainers);	
				
			}	
		});
		
		autoCenterContainersLabel = new JLabel("<html> Bins<> from step<>");
		autoCenterContainersLabel.setFont(new Font("Arial", Font.BOLD, 11));
		autoCenterContainersLabel.setBounds(10, 423, 65, 40);
		frame.getContentPane().add(autoCenterContainersLabel);
		
		chckbxNewCheckBox = new JCheckBox("Absent?");
		chckbxNewCheckBox.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBox.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBox.setBounds(250, 70, 100, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.setMnemonic(KeyEvent.VK_G);
		chckbxNewCheckBox.setActionCommand("absent");
		absent = "no";
		
		chckbxNewCheckBoxTip = new JCheckBox("Tipped over?");
		chckbxNewCheckBoxTip.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBoxTip.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBoxTip.setBounds(250, 100, 100, 23);
		frame.getContentPane().add(chckbxNewCheckBoxTip);
		chckbxNewCheckBoxTip.setMnemonic(KeyEvent.VK_G);
		chckbxNewCheckBoxTip.setActionCommand("tip");
		tip = "no";
		
		chckbxEsBroken = new JCheckBox("Es Broken!");
		chckbxEsBroken.setBackground(new Color(204, 204, 204));
		chckbxEsBroken.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxEsBroken.setBounds(250, 130, 100, 23);
		frame.getContentPane().add(chckbxEsBroken);
		chckbxEsBroken.setActionCommand("esBroken");
		esBroken = "no";
		
		chckbxNewCheckBox_1 = new JCheckBox("Takes from human player?");
		chckbxNewCheckBox_1.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBox_1.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBox_1.setBounds(250, 160, 186, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setActionCommand("humanPlayer");
		takesFromHumanPlayer = "no";
		
		chckbxNewCheckBox_2 = new JCheckBox("Made it to auto zone?");
		chckbxNewCheckBox_2.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBox_2.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBox_2.setBounds(149, 330, 159, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setActionCommand("autoZone");
		autoZone = "no";
		
		chckbxStackedAllThree = new JCheckBox("Stacked all three totes?");
		chckbxStackedAllThree.setBackground(new Color(204, 204, 204));
		chckbxStackedAllThree.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxStackedAllThree.setBounds(149, 360, 159, 23);
		frame.getContentPane().add(chckbxStackedAllThree);
		chckbxStackedAllThree.setActionCommand("allThreeTotes");
		autoTotesStacked = "no";
		
		chckbxDidNothing = new JCheckBox("Did nothing?");
		chckbxDidNothing.setBackground(new Color(204, 204, 204));
		chckbxDidNothing.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxDidNothing.setBounds(149, 390, 159, 23);
		frame.getContentPane().add(chckbxDidNothing);
		chckbxDidNothing.setActionCommand("didNothing");
		didNothing = "no";
		
		checkBoxOurAuton = new JCheckBox("Has the Auton we want?");
		checkBoxOurAuton.setBackground(new Color(204, 204, 204));
		checkBoxOurAuton.setFont(new Font("Arial", Font.BOLD, 11));
		checkBoxOurAuton.setBounds(149, 420, 159, 23);
		frame.getContentPane().add(checkBoxOurAuton);
		checkBoxOurAuton.setActionCommand("autonWeWant");
		autonWeWant = "no";
		
		chckbxCoopertitionStacked = new JCheckBox("Put yellow tote on step?");
		chckbxCoopertitionStacked.setBackground(new Color(204, 204, 204));
		chckbxCoopertitionStacked.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxCoopertitionStacked.setBounds(250, 190, 186, 23);
		frame.getContentPane().add(chckbxCoopertitionStacked);
		chckbxCoopertitionStacked.setActionCommand("coop");
		coopertitionStacked = "no";
		autoTotesStacked = "no";
		chckbxCoopertitionStacked.setVisible(false);
		chckbxCoopertitionStacked.setEnabled(false);
		
		chkbxTakesFromLandFill = new JCheckBox("Takes from landfill?");
		chkbxTakesFromLandFill.setBackground(new Color(204, 204, 204));
		chkbxTakesFromLandFill.setFont(new Font("Arial", Font.BOLD, 11));
		chkbxTakesFromLandFill.setBounds(250, 190, 186, 23);
		frame.getContentPane().add(chkbxTakesFromLandFill);
		chkbxTakesFromLandFill.setActionCommand("takesFromLandfill");
		takesFromLandFill = "no";
		
		chkbxknockedOverContainers = new JCheckBox("Bins");
		chkbxknockedOverContainers.setBackground(new Color(204, 204, 204));
		chkbxknockedOverContainers.setFont(new Font("Arial", Font.BOLD, 11));
		chkbxknockedOverContainers.setBounds(375, 130, 90, 23);
		frame.getContentPane().add(chkbxknockedOverContainers);
		chkbxknockedOverContainers.setActionCommand("knockedContainers");
		knockedOverContainters = "no";
		
		chkbxknockedOverTotes = new JCheckBox("Totes");
		chkbxknockedOverTotes.setBackground(new Color(204, 204, 204));
		chkbxknockedOverTotes.setFont(new Font("Arial", Font.BOLD, 11));
		chkbxknockedOverTotes.setBounds(375, 100, 90, 23);
		frame.getContentPane().add(chkbxknockedOverTotes);
		chkbxknockedOverTotes.setActionCommand("knockedTotes");
		knockedOverTotes = "no";
		
		buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {
               // Request a connection initiation
               if (e.getActionCommand().equals("esBroken")) {
                  if (chckbxEsBroken.isSelected())
                	  esBroken = "yes";
                  else
                	  esBroken = "no";
                  System.out.println("Es Broken? "+ esBroken);
               }
               if (e.getActionCommand().equals("humanPlayer")) {
                   if (chckbxNewCheckBox_1.isSelected())
                 	  takesFromHumanPlayer = "yes";
                   else
                 	  takesFromHumanPlayer = "no";
                  System.out.println("Takes From Human Player? " + takesFromHumanPlayer); 
                }
               if (e.getActionCommand().equals("absent")) {
            	   if(chckbxNewCheckBox.isSelected())
            		   absent = "yes";
            	   else
            		   absent = "no"; 
            	   System.out.println("Absent? " + absent); 
               }
               if (e.getActionCommand().equals("autoZone")) {
            	   if(chckbxNewCheckBox_2.isSelected()){
            		   autoZone = "yes";
            	   } else
            		   autoZone = "no";   
            	   System.out.println("Made it to the Auto Zone? " + autoZone); 
               }
               if (e.getActionCommand().equals("allThreeTotes")) {
            	   if(chckbxStackedAllThree.isSelected())
            		   autoTotesStacked = "yes";
            	   else
            		   autoTotesStacked = "no"; 
            	   System.out.println("Stacked all three totes in Auton? " + autoTotesStacked);
               }
               if (e.getActionCommand().equals("didNothing")) {
            	   if(chckbxDidNothing.isSelected())
            		   didNothing = "yes";
            	   else
            		   didNothing  = "no"; 
            	   System.out.println("Did it do nothing during autonomous? " + didNothing);
               }
               if (e.getActionCommand().equals("coop")) {
            	   if(chckbxCoopertitionStacked.isSelected())
            		   coopertitionStacked = "yes";
            	   else
            		   coopertitionStacked = "no";
            	   
               }
               if(e.getActionCommand().equals("takesFromLandfill")){
            	   if(chkbxTakesFromLandFill.isSelected())
            		   takesFromLandFill = "yes";
            	   else
            		   takesFromLandFill = "no";
               }
               if(e.getActionCommand().equals("knockedContainers")){
            	   if(chkbxknockedOverContainers.isSelected())
            		   knockedOverContainters = "yes";
            	   else
            		   knockedOverContainters = "no";
               }
               if(e.getActionCommand().equals("knockedTotes")){
            	   if(chkbxknockedOverTotes.isSelected())
            		   knockedOverTotes = "yes";
            	   else
            		   knockedOverTotes = "no";
               }
               
               if(e.getActionCommand().equals("autonWeWant")){
            	   if(checkBoxOurAuton.isSelected())
            		   autonWeWant = "yes";
            	   else
            		   autonWeWant = "no";
               }
               if (e.getActionCommand().equals("tip")){
            	   if(chckbxNewCheckBoxTip.isSelected())
            		   tip = "yes";
            	   else
            		   tip = "no";
               }
            }
         };
         
         chckbxEsBroken.addActionListener(buttonListener);
         chckbxNewCheckBox_1.addActionListener(buttonListener);
         chckbxNewCheckBox.addActionListener(buttonListener);
         chckbxNewCheckBox_2.addActionListener(buttonListener);
         chckbxStackedAllThree.addActionListener(buttonListener);
         chckbxDidNothing.addActionListener(buttonListener);
         chckbxCoopertitionStacked.addActionListener(buttonListener);
         chkbxTakesFromLandFill.addActionListener(buttonListener);
         chkbxknockedOverContainers.addActionListener(buttonListener);
         chkbxknockedOverTotes.addActionListener(buttonListener);
         chckbxNewCheckBoxTip.addActionListener(buttonListener);
		
		btnSubmit = new JButton("Submit!");
		btnSubmit.setBounds(840, 17, 89, 23);
		btnSubmit.setBackground(Color.lightGray);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.setActionCommand("submit");
		
		driveLabel = new JLabel("Drive");
		driveLabel.setBounds(755, 17, 89, 23);
		frame.getContentPane().add(driveLabel);
		
		driveField = new JTextField();
		driveField.setBounds(795, 17, 20, 23);
		driveField.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(driveField);
		driveField.setText(getPaths().get(getPaths().size()-1));
		
		drive = driveField.getText();
		driveField.addFocusListener(new FocusAdapter() {
             public void focusLost(FocusEvent e) {
                // should be editable only when disconnected
                drive = driveField.getText().toUpperCase();
                System.out.println(drive);
             }  
         }
          );
		
		
		buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {
               
               if (e.getActionCommand().equals("submit")) {
            	   
            	   tableName = "MatchNumber_" + Integer.toString(matchNumber);
            	   
            	   for (int counter = 0;counter< containerHeight.length; counter++){
                 	  if(containerHeight[counter] != 0)
             			  recycleBins+=1;
             		  
                 	  if(containerHeightBack[counter] != 0)
             			  recycleBins+=1;
                 	  }
            	   
            	   containerPoints = (4 *containerHeightBack[0]) + (4 *containerHeightBack[1]) + (4 *containerHeightBack[2]) +
             			  (4 *containerHeightBack[3]) + (4 *containerHeightBack[4]) + (4 *containerHeightBack[5]) + (4 *containerHeightBack[6]) +
             			    (4 *containerHeight[0]) + (4 *containerHeight[1]) + (4 *containerHeight[2])
             			  + (4 *containerHeight[3]) + (4 *containerHeight[4]) + (4 *containerHeight[5]) + (4 *containerHeight[6]);
             	  totalContainerHeight = (containerHeightBack[0]) + (containerHeightBack[1]) + (containerHeightBack[2]) +
             			  (containerHeightBack[3]) + (containerHeightBack[4]) + (containerHeightBack[5]) + (containerHeightBack[6]) +
           			    (containerHeight[0]) + (containerHeight[1]) + (containerHeight[2])
           			  + (containerHeight[3]) + (containerHeight[4]) + (containerHeight[5]) + (containerHeight[6]);
            	   
            	  if (recycleBins != 0)
             	  avgContainerHeight = (totalContainerHeight/recycleBins);
             	  
            	  pointsScored = totePoints + containerPoints + noodlePoints + landFillNoodles;
 
                   sql.setFileName(drive + ":" + "Client");
                  sql.setTableName("Client_Matches");
                 sql.setScouterName(name);
                  sql.setMatchNumber(matchNumber); 
                  sql.setTeamNumber(teamNumber);
                  sql.setTotalStackNumber(totalTotes, totalTotesBack);
                  sql.setPoints(pointsScored);
                  sql.setNoodles(noodles);
                  sql.setRecycleBins(recycleBins, totalContainerHeight);
                  sql.setTotes(totes);
                  sql.setNotes(gameNotes);
                  sql.setAbsent(absent);
                  sql.setCoopertitionStacked(coopertitionStacked);
                  sql.setDidNothing(didNothing);
                  sql.setTakesFromHumanPlayer(takesFromHumanPlayer);
                  sql.setAutoTotesStacked(autoTotesStacked);
                  sql.setMadeItToAutoZone(autoZone);
                  sql.setBroken(esBroken);
                  sql.setAutoTotesMoved(autoTotesMoved);
                  sql.setAutoBinsMoved(autoBinsMoved);
                  sql.setLandFillNoodles(landFillNoodles);
                  sql.setTakesFromLandFill(takesFromLandFill);
                  sql.setPickedUpKnockedOverContainers(knockedOverContainters);
                  sql.setPickedUpKnockedOverTotes(knockedOverTotes);
                  sql.setContainerHeights(containerHeight, containerHeightBack);
                  sql.setNoodleNumber(totalNoodles, totalNoodlesBack);
                  sql.setContainersFromCenter(middleContainers);
                  sql.setAutoContainersFromCenter(autoCenterContainers);
                  sql.setKnockedOverContainers(knockedOverContainters);
                  sql.setKnockedOverStacks(knockedOverStacks);
                  sql.setKnockedOverTotes(knockedOverTotes);
                  sql.setAutonWeWant(autonWeWant);
                  sql.setKnockedOverStacks(knockedOverStacks);
                  sql.setTippedOver(tip);
                  sql.setUnreliableTimer(timerCheck);
                  sql.setFouls(fouls);
                  sql.setCoopertitionTimer(counter);
                  sql.setCoopTotes(coopTotes);
                  
                  
                  System.out.println("Total Points Scored: " + pointsScored);
                  
                  
					try {
						sql.run();	
					} catch (Exception e1) {
						
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
						
					}
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
					
					 sql.setFileName("//C:/Users/dellagD/Desktop/ClientSystem");
	                  sql.setTableName("Client_Matches");
	                 sql.setScouterName(name);
	                  sql.setMatchNumber(matchNumber); 
	                  sql.setTeamNumber(teamNumber);
	                  sql.setTotalStackNumber(totalTotes, totalTotesBack);
	                  sql.setPoints(pointsScored);
	                  sql.setNoodles(noodles);
	                  sql.setRecycleBins(recycleBins, totalContainerHeight);
	                  sql.setTotes(totes);
	                  sql.setNotes(gameNotes);
	                  sql.setAbsent(absent);
	                  sql.setCoopertitionStacked(coopertitionStacked);
	                  sql.setDidNothing(didNothing);
	                  sql.setTakesFromHumanPlayer(takesFromHumanPlayer);
	                  sql.setAutoTotesStacked(autoTotesStacked);
	                  sql.setMadeItToAutoZone(autoZone);
	                  sql.setBroken(esBroken);
	                  sql.setAutoTotesMoved(autoTotesMoved);
	                  sql.setAutoBinsMoved(autoBinsMoved);
	                  sql.setLandFillNoodles(landFillNoodles);
	                  sql.setTakesFromLandFill(takesFromLandFill);
	                  sql.setPickedUpKnockedOverContainers(knockedOverContainters);
	                  sql.setPickedUpKnockedOverTotes(knockedOverTotes);
	                  sql.setContainerHeights(containerHeight, containerHeightBack);
	                  sql.setNoodleNumber(totalNoodles, totalNoodlesBack);
	                  sql.setKnockedOverStacks(knockedOverStacks);
	                  
	                  
	                  
	                  System.out.println("Total Points Scored: " + pointsScored);
	                  
	                  
						try {
							sql.run();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				  	checkPaths();
                  reset();
 
                 
                 
               }
            }
         };
		btnSubmit.addActionListener(buttonListener);
		
		lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Team #");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(280, 21, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblMatch = new JLabel("Match #");
		lblMatch.setFont(new Font("Arial", Font.BOLD, 12));
		lblMatch.setBounds(445, 21, 46, 14);
		frame.getContentPane().add(lblMatch);
		
		
		ipField = new JTextField();
		ipField.setBackground(new Color(204, 204, 204));
		ipField.setBounds(628, 18, 105, 20);
		ipField.setText("localHost");
		hostIP = ipField.getText();
		frame.getContentPane().add(ipField);
		ipField.setColumns(10);
		
		IPField = new JLabel("IP");
		IPField.setFont(new Font("Arial", Font.BOLD, 12));
		IPField.setBounds(606, 21, 23, 14);
		frame.getContentPane().add(IPField);
		
//		btnNewButton = new JButton("Host Menu");
//		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
//		btnNewButton.setForeground(Color.BLACK);
//		btnNewButton.setBackground(Color.LIGHT_GRAY);
//		btnNewButton.setBounds(0, 500, 133, 49);
//		frame.getContentPane().add(btnNewButton);
//		btnNewButton.setActionCommand("I'm the Host");
		
//		newClientTableButton = new JButton("New Table");
//		newClientTableButton.setFont(new Font("Arial", Font.BOLD, 11));
//		newClientTableButton.setForeground(Color.BLACK);
//		newClientTableButton.setBackground(Color.LIGHT_GRAY);
//		newClientTableButton.setBounds(250, 500, 100, 49);
//		frame.getContentPane().add(newClientTableButton);
//		newClientTableButton.setActionCommand("newClientTable");
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Blue 1", "Blue 2", "Blue 3", "Red 1", "Red 2", "Red 3", "Host"}));
		comboBox.setBounds(165, 18, 93, 20);
		frame.getContentPane().add(comboBox);
		colorNumber = "Blue 1";
//		btnNewButton.setEnabled(false);
		comboBox.addItemListener(new ItemListener() {
			 public void itemStateChanged(ItemEvent e) {
				 colorNumber = comboBox.getSelectedItem().toString();
//		         System.out.println(colorNumber);
//		         
//		         if (colorNumber != "Host")
//		        	 btnNewButton.setEnabled(false);
//		         else 
//		        	 btnNewButton.setEnabled(true);
	     }
		}
			 );
		
//		connectButton = new JButton("Connect");
//		connectButton.setFont(new Font("Arial", Font.BOLD, 11));
//		connectButton.setForeground(Color.BLACK);
//		connectButton.setBackground(Color.LIGHT_GRAY);
//		connectButton.setBounds(0, 505, 106, 43);
//		frame.getContentPane().add(connectButton);
//		 connectButton.setMnemonic(KeyEvent.VK_C);
//	      connectButton.setActionCommand("connect");
//	      connectButton.setEnabled(false);
//	      connectButton.setVisible(false);
//	      
//		
//		disconnectButton = new JButton("Disconnect");
//		disconnectButton.setFont(new Font("Arial", Font.BOLD, 11));
//		disconnectButton.setForeground(Color.BLACK);
//		disconnectButton.setBackground(Color.LIGHT_GRAY);
//		disconnectButton.setBounds(103, 505, 106, 43);
//		frame.getContentPane().add(disconnectButton);
//		disconnectButton.setMnemonic(KeyEvent.VK_D);
//	      disconnectButton.setActionCommand("disconnect");
//	      disconnectButton.setEnabled(false);
//	      disconnectButton.setVisible(false);
//		
//		txtNotConnected = new JTextField();
//		txtNotConnected.setEnabled(false);
//		txtNotConnected.setEditable(false);
//		txtNotConnected.setFont(new Font("Arial", Font.BOLD, 12));
//		txtNotConnected.setBackground(Color.RED);
//		txtNotConnected.setText(statusString);
//		txtNotConnected.setBounds(205, 505, 161, 43);
//		frame.getContentPane().add(txtNotConnected);
//		txtNotConnected.setColumns(10);
//		txtNotConnected.setVisible(false);
		
		
//		rdbtnNewRadioButton = new JRadioButton("Host\r\n");
//		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
//		rdbtnNewRadioButton.setBounds(-2, 455, 72, 49);
//		frame.getContentPane().add(rdbtnNewRadioButton);
//		rdbtnNewRadioButton.setMnemonic(KeyEvent.VK_H);
//		rdbtnNewRadioButton.setActionCommand("host");
//		rdbtnNewRadioButton.setEnabled(false);
//		rdbtnNewRadioButton.setVisible(false);
		
		
		
		
//		rdbtnClient = new JRadioButton("Client");
//		rdbtnClient.setBackground(Color.LIGHT_GRAY);
//		rdbtnClient.setBounds(70, 455, 72, 49);
//		frame.getContentPane().add(rdbtnClient);
//		rdbtnClient.setMnemonic(KeyEvent.VK_G);
//		rdbtnClient.setActionCommand("guest");
//		rdbtnClient.setEnabled(false);
//		rdbtnClient.setVisible(false);
		
		pickedUpKnockedOver = new JLabel("<html> Picked up<> knocked over<>");
		pickedUpKnockedOver.setBounds(380, 30, 89, 100);
		frame.getContentPane().add(pickedUpKnockedOver);
		
		
		
//		syncronizeButton = new JButton("Synchronize");
//		syncronizeButton.setFont(new Font("Arial", Font.BOLD, 11));
//		syncronizeButton.setForeground(Color.BLACK);
//		syncronizeButton.setBackground(Color.LIGHT_GRAY);
//		syncronizeButton.setBounds(130, 500, 133, 49);
//		frame.getContentPane().add(syncronizeButton);
//		syncronizeButton.setActionCommand("synchronize");
		
//		buttonListener = new ActionAdapter() {
//            public void actionPerformed(ActionEvent e) {
//              // if (connectionStatus != DISCONNECTED) {
//              //changeStatusNTS(NULL, true);
//              // }
//              // else {
//                  //isHost = e.getActionCommand().equals("host");
//
//                  // Cannot supply host IP if host option is chosen
//                  if (isHost) {
//                     ipField.setEnabled(true);
//                     hostIP = ipField.getText();
//                     btnNewButton.setEnabled(true);
//                     
//                  }
//                  else {
//                     ipField.setEnabled(true);
//                     btnNewButton.setEnabled(false);
//                  }
//                  
//                  if (e.getActionCommand().equals("newClientTable")){
//                	  sql.createNewTable();
//                  }
//               }
//      //      }
//         };
         
//         rdbtnNewRadioButton.addActionListener(buttonListener);
//         rdbtnClient.addActionListener(buttonListener);
//         newClientTableButton.addActionListener(buttonListener);
         
//         buttonListener = new ActionAdapter() {
//             public void actionPerformed(ActionEvent e) {
//                // Request a connection initiation
//                if (e.getActionCommand().equals("connect")) {
//                   //changeStatusNTS(BEGIN_CONNECT, true);
//                   System.out.println("connecting!");
//                }
//                // Disconnect
//                else {
//                  // changeStatusNTS(DISCONNECTING, true);
//                   
//                }
//                
//                if (e.getActionCommand().equals("synchronize")){
//                	try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//                	checkPaths();
//                }
//             }
//          };
          
//          disconnectButton.addActionListener(buttonListener);
//          connectButton.addActionListener(buttonListener);
//          syncronizeButton.addActionListener(buttonListener);
          
//          buttonListener = new ActionAdapter(){
//        	  public void actionPerformed(ActionEvent e){
//        		  if (e.getActionCommand().equals("I'm the Host")){
//        			  // add more to this later
//        			  hostButtonSwitch = !hostButtonSwitch;
//        			  host.setVisible(hostButtonSwitch);
//        			  
//        		  }
//        		  
//        	  }
//          };
//          btnNewButton.addActionListener(buttonListener); 
          
          buttonListener = new ActionAdapter() {
              public void actionPerformed(ActionEvent e) {
                 // Request a connection initiation
            	  
            	  for (int counter = 0; counter <panel.buttonList.size(); counter++ ){
            		  
            		  if (e.getActionCommand().equals(Integer.toString(counter))) {
            			  
            			  btn = counter;
            			  
            			  if ( panel.buttonList.get(counter).isSelected()){
            			  totalTotes = totalTotes | ((long)1<<btn);
            			  totes+=1;
            			  }
            			  else{
            			  totalTotes = totalTotes &~ ((long)1<<btn); 
            			  totes -= 1;
            			  }

            			/* for (int i=0; i <6;i++){
            				  
            				  if (btn > 5)
            					  btn = btn - 6;
            				  
            				  else {
            					   if ( panel.buttonList.get(counter).isSelected())
            						  columns[i] = columns[i] | (1 << btn);
            					  else 
            						  columns[i] = columns[i] &~ (1 << btn);
            					   if ( panel_1.buttonList.get(counter).isSelected())
             						  columnsBack[i] = columnsBack[i] | (1 << btn);
             					  else 
             						  columnsBack[i] = columnsBack[i] &~ (1 << btn);
            					  break;
            				  }  
            			  } */
            			 
            		  }
            		  
            		  if (e.getActionCommand().equals("b" + Integer.toString(counter))){
            			  
            			  btn = counter;
            			  
            			  if ( panel_1.buttonList.get(counter).isSelected()){
                			  totalTotesBack = totalTotesBack | ((long)1<<btn);
                			  totes+=1;
                			  }
                			  else{
                			  totalTotesBack = totalTotesBack &~ ((long)1<<btn); 
                			  totes-=1;
                			  } 
            			  
            			 }
            		  
            		  
            		  
            	  }
            	  System.out.println("Total Totes Forward: " + totalTotes);
        			  System.out.println("Total Totes Back: " + totalTotesBack);
        			  System.out.println("totes: " + totes);
            	  
            	  
        			  totePoints = totes *2;
            		  System.out.println("totePoints: " + totePoints);	
              }
           };
           
          for (int counter = 0; counter < panel.buttonList.size(); counter ++){
          
        	  panel.buttonList.get(counter).addActionListener(buttonListener);
        	  panel.buttonList.get(counter).setActionCommand(Integer.toString(counter));
        	  
        	  panel_1.buttonList.get(counter).addActionListener(buttonListener);
        	  panel_1.buttonList.get(counter).setActionCommand("b" + Integer.toString(counter));
          
      
          
          }
           recycleBins = 0;
          buttonListener = new ActionAdapter() {
              public void actionPerformed(ActionEvent e) {
            	 
            	  for (int counter = 0; counter < containerHeight.length; counter ++){
            		
            		  
            		  if(e.getActionCommand().equals("c" + Integer.toString(counter))){ 
            			  
            			  
            			  containerHeight[counter] +=1;
            			  
            			  if (containerHeight[counter] >= 7)
            				  containerHeight[counter] = 0;
            			  
            			  
            			  
            			  	  panel.containerList.get(counter).setText(Integer.toString(containerHeight[counter]));
            				  panel.containerList.get(counter).setBackground(containerColors[containerHeight[counter]]);  		 
            		  }
            		  
            		  
            		  
            		  
            	  }
            	  for (int counter = 0; counter < containerHeightBack.length; counter ++){
            		  
            		  if(e.getActionCommand().equals("bc" + Integer.toString(counter))){ 
            			  containerHeightBack[counter] +=1;
            			  
            			  if (containerHeightBack[counter] >= 7)
            				  containerHeightBack[counter] = 0;
            			  
            			  	  panel_1.containerList.get(counter).setText(Integer.toString(containerHeightBack[counter]));
            				  panel_1.containerList.get(counter).setBackground(containerColors[containerHeightBack[counter]]);  		 
            		  }
            		  
            		 
            		  
            	  }
            	  
            	  
            	 
            	 
            	  
              }
              };
          
          
              for (int counter = 0; counter < panel.containerList.size(); counter ++){
            	  panel.containerList.get(counter).addActionListener(buttonListener);
            	  panel.containerList.get(counter).setActionCommand("c" + Integer.toString(counter));
            	  
            	  panel_1.containerList.get(counter).addActionListener(buttonListener);
            	  panel_1.containerList.get(counter).setActionCommand("bc" + Integer.toString(counter));
              }
              
              buttonListener = new ActionAdapter() {
                  public void actionPerformed(ActionEvent e) {
                     // Request a connection initiation
                	  
                	  for (int counter = 0; counter < panel.noodleList.size(); counter++ ){
                		  
                		  if (e.getActionCommand().equals("n" + Integer.toString(counter))) {
                			  btn = counter;
                			  
                			  if ( panel.noodleList.get(counter).isSelected()){
                			  totalNoodles = totalNoodles | (1<<btn);
                			  noodles+=1;
                			  noodlePoints += 6;
                			  }
                			  else{
                			  totalNoodles = totalNoodles &~ (1<<btn); 
                			  noodles -= 1;
                			  noodlePoints -= 6;
                			  }
                			  
                		  }
                	  }
                	  for (int counter = 0; counter < panel_1.noodleList.size(); counter++ ){
                		  
                		  if (e.getActionCommand().equals("nb" + Integer.toString(counter))) {
                			  btn = counter;
                			  
                			  if ( panel_1.noodleList.get(counter).isSelected()){
                			  totalNoodlesBack = totalNoodlesBack | (1<<btn);
                			  noodles+=1;
                			  noodlePoints += 6;
                			  }
                			  else{
                			  totalNoodlesBack = totalNoodlesBack &~ (1<<btn); 
                			  noodles -= 1;
                			  noodlePoints -= 6;
                			  }
                			  
                		  }
                	  }
                	  System.out.println("Noodles Number Forward: " + totalNoodles);
                	  System.out.println("Noodles Number Back: " + totalNoodlesBack);
                	  System.out.println("Noodles: " + noodles);
                	  System.out.println("Noodle Points" + noodlePoints);
                		  }
              };
              
              for (int counter = 0; counter < panel.noodleList.size(); counter ++){
            	  panel.noodleList.get(counter).addActionListener(buttonListener);
            	  panel.noodleList.get(counter).setActionCommand("n" + Integer.toString(counter));
            	  
            	  panel_1.noodleList.get(counter).addActionListener(buttonListener);
            	  panel_1.noodleList.get(counter).setActionCommand("nb" + Integer.toString(counter));
              }
          
           
           
          
          txtYourNameHere.addFocusListener(new FocusAdapter() {
              public void focusLost(FocusEvent e) {
                 // should be editable only when disconnected
                // if (connectionStatus != DISCONNECTED) {
                //    changeStatusNTS(NULL, true);
               //  }
               //  else {
                	 name = txtYourNameHere.getText();
                	
//                 }
              }  
              }
           );
          
        /*  ipField.addFocusListener(new FocusAdapter() {
              public void focusLost(FocusEvent e) {
                 ipField.selectAll();
                 // Should be editable only when disconnected
                 if (connectionStatus != DISCONNECTED) {
                    changeStatusNTS(NULL, true);
                 }
                 else {
                    hostIP = ipField.getText();
                 }
              }
           }); */
          
          ButtonGroup hostButtonGroup = new ButtonGroup();
  		hostButtonGroup.add(rdbtnClient);
  		hostButtonGroup.add(rdbtnNewRadioButton);
  		
  		timer = new Timer();
  		
  		timerField = new JTextField();
 		timerField.setEnabled(true);
 		timerField.setEditable(false);
 		timerField.setFont(new Font("Arial", Font.BOLD, 12));
 		timerField.setBackground(Color.lightGray);
 		timerField.setText("0");
 		timerField.setBounds(320, 260, 35, 35);
 		frame.getContentPane().add(timerField);
 		timerField.setColumns(10);
 		timerField.setVisible(true);
  		
  		timerButton = new JButton("Start Timer");
		timerButton.setBounds(150, 260, 150, 35);
		timerButton.setBackground(Color.lightGray);
		frame.getContentPane().add(timerButton);
		timerButton.setActionCommand("timer");
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(370, 260, 75, 35);
		resetButton.setBackground(Color.lightGray);
		frame.getContentPane().add(resetButton);
		resetButton.setActionCommand("reset");
		
		coopSpinner = new JSpinner();
		coopSpinner.setForeground(new Color(204, 204, 255));
		coopSpinner.setBackground(new Color(204, 204, 204));
		coopSpinner.setBounds(70, 260, 46, 33);
		coopSpinner.setBackground(Color.lightGray);
		frame.getContentPane().add(coopSpinner);
		coopTotes = coopTotes = Integer.parseInt(coopSpinner.getValue().toString());
		
		coopSpinner.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent q) {
				coopTotes = Integer.parseInt(coopSpinner.getValue().toString());
				
			}	
		});
		
		coopTotesLabel = new JLabel("<html> Totes<> put on<> step<>");
		coopTotesLabel.setBounds(10, 245, 50, 60);
		frame.getContentPane().add(coopTotesLabel);
		
		
		
		
		timerBox = new JCheckBox("Unreliable Data?");
		timerBox.setBackground(Color.lightGray);
		timerBox.setFont(new Font("Arial", Font.BOLD, 11));
		timerBox.setBounds(320, 260, 130, 35);
		frame.getContentPane().add(timerBox);
		timerBox.setActionCommand("unreliable");
		timerBox.setVisible(false);
		timerBox.setEnabled(false);
		timerCheck = "no";
		
		 buttonListener = new ActionAdapter(){
      	  public void actionPerformed(ActionEvent e){
    		  if (e.getActionCommand().equals("timer")){
    			  timerB = !timerB;
    			  
    			  if (timerB){
      			  timerButton.setText("Stop Timer");
      			  
    			  }
    			  else {
    				  timerButton.setText("Start Timer");
    				  
    			  }
       		  }
    		  
    		  if (e.getActionCommand().equals("reset")){
    			  counter = 0;
    			  timerField.setText("0");
    		  }
    		  
    		  if (e.getActionCommand().equals("unreliable")){
    			  if (timerBox.isSelected())
    				  timerCheck = "yes";
    			  else 
    				  timerCheck = "no";
    		  }
       		  
       	  }
         };
         timerButton.addActionListener(buttonListener);
         resetButton.addActionListener(buttonListener);
         timerBox.addActionListener(buttonListener);
  		
  		checkPaths();
		frame.setVisible(true);
	}
	
	public static void checkPaths(){
		paths = new ArrayList<String>();
		int i = 0;
  		for(Path p:FileSystems.getDefault().getRootDirectories()){
			
			
			paths.add(p.toString().substring(0,1));
			if(paths.get(i).equals("D") || paths.get(i).equals("E") || paths.get(i).equals("F") || paths.get(i).equals("G") || paths.get(i).equals("H")){
				driveConnectionField.setBackground(statusColors[0]);
				driveConnectionField.setText(statusMessages[0]);
			} else {
				driveConnectionField.setBackground(statusColors[2]);
				driveConnectionField.setText(statusMessages[2]);
			}
			i++;
			
		}
  		
	}
	
	 public static void cleanUp() {
	      try {
	         if (hostServer != null) {
	            hostServer.close();
	            hostServer = null;
	         }
	      }
	      catch (IOException e) { hostServer = null; }

	      try {
	         if (socket != null) {
	            socket.close();
	            socket = null;
	         }
	      }
	      catch (IOException e) { socket = null; }

	      try {
	         if (in != null) {
	            in.close();
	            in = null;
	         }
	      }
	      catch (IOException e) { in = null; }

	      if (out != null) {
	         out.close();
	         out = null;
	      }
	   }
	public void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	 public void run() {
//	      switch (connectionStatus) {
//	      case DISCONNECTED:
//	         connectButton.setEnabled(true);
//	         disconnectButton.setEnabled(false);
//	         ipField.setEnabled(true);
//	         txtNotConnected.setBackground(Color.red);
//	         break;
//
//	      case DISCONNECTING:
//	         connectButton.setEnabled(false);
//	         disconnectButton.setEnabled(false);
//	         ipField.setEnabled(false);
//	         txtNotConnected.setBackground(Color.orange);
//	         break;
//
//	      case CONNECTED:
//	         connectButton.setEnabled(false);
//	         disconnectButton.setEnabled(true);
//	         ipField.setEnabled(false);
//	         txtNotConnected.setBackground(Color.green);
//	         break;
//
//	      case BEGIN_CONNECT:
//	         connectButton.setEnabled(false);
//	         disconnectButton.setEnabled(false);
//	         ipField.setEnabled(false);
//	         txtNotConnected.setBackground(Color.orange);
//	         break;
//	      }

	      // Make sure that the button/text field states are consistent
	      // with the internal states
	      ipField.setText(hostIP);
	      frame.repaint();
	   }
	 
//	 public static void changeStatusTS(int newConnectStatus, boolean noError) {
//	      // Change state if valid state
//	      if (newConnectStatus != NULL) {
//	         connectionStatus = newConnectStatus;
//	      }
//
//	      // If there is no error, display the appropriate status message
//	      if (noError) {
//	         txtNotConnected.setText(statusMessages[connectionStatus]);
//	      }
//	      // Otherwise, display error message
//	      else {
//	    	  txtNotConnected.setText(statusMessages[NULL]);
//	      }
//
//	      // Call the run() routine (Runnable interface) on the
//	      // error-handling and GUI-update thread
//	      SwingUtilities.invokeLater(tcpObj);
//	      
//	   }
//	 public static void changeStatusNTS(int newConnectStatus, boolean noError) {
//	      // Change state if valid state
//	      if (newConnectStatus != NULL) {
//	         connectionStatus = newConnectStatus;
//	      }
//
//	      // If there is no error, display the appropriate status message
//	      if (noError) {
//	    	  txtNotConnected.setText(statusMessages[connectionStatus]);
//	      }
//	      // Otherwise, display error message
//	      else {
//	    	  txtNotConnected.setText(statusMessages[NULL]);
//	      }
//
//	      // Call the run() routine (Runnable interface) on the
//	      // current thread
//	      tcpObj.run();
//	   }
	 
	 public static void reset(){
		 
		 /* for (int counter = 0; counter < columns.length; counter++){
			 columns[counter] = 0;
		 } */
		 
		 for (int counter = 0; counter < containerHeight.length; counter++){
			 containerHeight[counter] = 0;
			 containerHeightBack[counter] = 0;
		 }
		 
		 for (int counter = 0; counter < panel.containerList.size(); counter++){
			 panel.containerList.get(counter).setBackground(Color.green);
			 panel_1.containerList.get(counter).setBackground(Color.green);
			 
			 panel.containerList.get(counter).setText(Integer.toString(0));
			 panel_1.containerList.get(counter).setText(Integer.toString(0));
			 
		 }
		 
		 for (int counter = 0; counter < panel.noodleList.size();counter++){
			 panel.noodleList.get(counter).setSelected(false);
			 panel_1.noodleList.get(counter).setSelected(false);
		 }
		 
		 for (int counter = 0; counter < panel.buttonList.size(); counter++){
			 panel.buttonList.get(counter).setSelected(false);
			 panel_1.buttonList.get(counter).setSelected(false);
		 }
		 
		 absent = "no";
		 autoTotesStacked = "no";
		 esBroken = "no";
		 takesFromHumanPlayer = "no";
         autoZone = "no";   
         autoTotesStacked = "no"; 
         didNothing  = "no"; 
         takesFromLandFill = "no";
         knockedOverContainters = "no";
         knockedOverTotes = "no";
         autonWeWant = "no";
         
         chckbxEsBroken.setSelected(false);
         chckbxNewCheckBox_1.setSelected(false);
         chckbxNewCheckBox.setSelected(false);
         chckbxNewCheckBox_2.setSelected(false);
         chckbxStackedAllThree.setSelected(false);
         chckbxCoopertitionStacked.setSelected(false);
         chckbxDidNothing.setSelected(false);
         chkbxTakesFromLandFill.setSelected(false);
         chkbxknockedOverContainers.setSelected(false);
         chkbxknockedOverTotes.setSelected(false);
         checkBoxOurAuton.setSelected(false);
         
         autoTotesMoved = 0;
         autoBinsMoved = 0;
         
         coopertitionStacked = "no";
         spinner.setValue(0);
         spinner_1.setValue(0);
         spinner_landFillNoodles.setValue(0);
         middleContainersSpinner.setValue(0);
         knockedOverStacksSpinner.setValue(0);
         autoCenterContainersSpinner.setValue(0);
         coopSpinner.setValue(0);
         spinner_landFouls.setValue(0);
         
         matchNumber += 1;
         textField.setText("");
         textField_1.setText(Integer.toString(matchNumber));
         
         pointsScored = 0;
         totePoints = 0;
         containerPoints = 0;
         noodlePoints = 0;
         noodles = 0;
         coopTotes =0;
         
         totalContainerHeight = 0;
         totalTotes = 0;
         totalTotesBack = 0;
         totes = 0;
         
         totePoints = 0;
         noodlePoints = 0;
         containerPoints = 0;
         totalNoodles = 0;
         totalNoodlesBack = 0;
         
         txtrGeneralNotes.setText("");
         gameNotes = "";
         
         landFillNoodles = 0;
         avgContainerHeight = 0;
         recycleBins = 0;
         
         totalNoodles = 0;
         totalNoodlesBack =0;
         
         knockedOverStacks = 0;
         middleContainers = 0;
         autoCenterContainers = 0;
         
         fouls = 0;
         counter = 0;
         timerField.setText("0");
         timerCheck = "no";
         timerBox.setSelected(false);
         tip = "no";
         
         chckbxNewCheckBoxTip.setSelected(false);
         
	 }
	 
	 public static ArrayList<String> getPaths(){
		 checkPaths();
		 return paths;
	 }
}
