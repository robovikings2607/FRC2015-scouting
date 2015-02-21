import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


public class Host extends JFrame {

	private JPanel contentPane;
	private JTextField txtNotConnected;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtScoutName;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel driveLabel;
	private JTextField endField;
	private static JTextField driveField;
	private static JButton newTableButton;
	private static JLabel startLabel;
	private static JLabel endLabel;
	
	private static String drive;
	private static String start;
	private static String end;
	
	static int startNumber = 0;
	static int endNumber =0;
	
	private ServerSocket serverSocket;
	private BufferedReader in;
	private PrintWriter out;
	
	  private int NULL = 0;
	   private int DISCONNECTED = 1;
	   private int DISCONNECTING = 2;
	   private int BEGIN_CONNECT = 3;
	   private int CONNECTED = 4;
	   
	   private String statusMessages[] = {
		      " Error! Could not connect!", " Disconnected",
		      " Disconnecting...", " Connecting...", " Connected"
		   };
	   
	   public static String hostIP = "localHost";
	   private int port = 1234;
	   private int connectionStatus = DISCONNECTED;
	   private boolean isHost = true;
	   private String statusString = statusMessages[connectionStatus];
	   private static JTextField textField_12;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Host frame = new Host();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}*/

	/**
	 * Create the frame.
	 */
	
	public Host(){
		setTitle("Host Menu");
		setBackground(new Color(204, 204, 204));
		initialize();
            
		
	}
	public void initialize() {
		ActionAdapter buttonListener = null;

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBlue = new JLabel("Blue 1");
		lblBlue.setBounds(10, 62, 46, 14);
		contentPane.add(lblBlue);
		
		JLabel lblBlue_1 = new JLabel("Blue 2\r\n");
		lblBlue_1.setBounds(10, 87, 46, 14);
		contentPane.add(lblBlue_1);
		
		JLabel lblBlue_2 = new JLabel("Blue 3");
		lblBlue_2.setBounds(10, 112, 46, 14);
		contentPane.add(lblBlue_2);
		
		JLabel lblNewLabel = new JLabel("Red 1");
		lblNewLabel.setBounds(10, 157, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRed = new JLabel("Red 2");
		lblRed.setBounds(10, 182, 46, 14);
		contentPane.add(lblRed);
		
		JLabel lblRed_1 = new JLabel("Red 3");
		lblRed_1.setBounds(10, 207, 46, 14);
		contentPane.add(lblRed_1);
		
		JCheckBox chckbxSubmitted = new JCheckBox("Submitted");
		chckbxSubmitted.setBackground(new Color(204, 204, 204));
		chckbxSubmitted.setBounds(62, 58, 97, 23);
		contentPane.add(chckbxSubmitted);
		
		JCheckBox checkBox = new JCheckBox("Submitted");
		checkBox.setBackground(new Color(204, 204, 204));
		checkBox.setBounds(62, 83, 97, 23);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Submitted");
		checkBox_1.setBackground(new Color(204, 204, 204));
		checkBox_1.setBounds(62, 108, 97, 23);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Submitted");
		checkBox_2.setBackground(new Color(204, 204, 204));
		checkBox_2.setBounds(62, 153, 97, 23);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Submitted");
		checkBox_3.setBackground(new Color(204, 204, 204));
		checkBox_3.setBounds(62, 182, 97, 23);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Submitted");
		checkBox_4.setBackground(new Color(204, 204, 204));
		checkBox_4.setBounds(62, 207, 97, 23);
		contentPane.add(checkBox_4);
		
		txtNotConnected = new JTextField();
		txtNotConnected.setText("Not Connected");
		txtNotConnected.setBackground(Color.RED);
		txtNotConnected.setBounds(165, 59, 120, 20);
		contentPane.add(txtNotConnected);
		txtNotConnected.setColumns(10);
		
		textField = new JTextField();
		textField.setText("Not Connected");
		textField.setColumns(10);
		textField.setBackground(Color.RED);
		textField.setBounds(165, 84, 120, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Not Connected");
		textField_1.setColumns(10);
		textField_1.setBackground(Color.RED);
		textField_1.setBounds(165, 109, 120, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Not Connected");
		textField_2.setColumns(10);
		textField_2.setBackground(Color.RED);
		textField_2.setBounds(165, 154, 120, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Not Connected");
		textField_3.setColumns(10);
		textField_3.setBackground(Color.RED);
		textField_3.setBounds(165, 179, 120, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Not Connected");
		textField_4.setColumns(10);
		textField_4.setBackground(Color.RED);
		textField_4.setBounds(165, 204, 120, 20);
		contentPane.add(textField_4);
		
		txtScoutName = new JTextField();
		txtScoutName.setBackground(new Color(204, 204, 204));
		txtScoutName.setText("Scout Name");
		txtScoutName.setBounds(338, 59, 86, 20);
		contentPane.add(txtScoutName);
		txtScoutName.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(204, 204, 204));
		textField_5.setText("Scout Name");
		textField_5.setColumns(10);
		textField_5.setBounds(338, 84, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(204, 204, 204));
		textField_6.setText("Scout Name");
		textField_6.setColumns(10);
		textField_6.setBounds(338, 109, 86, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(204, 204, 204));
		textField_7.setText("Scout Name");
		textField_7.setColumns(10);
		textField_7.setBounds(338, 154, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(204, 204, 204));
		textField_8.setText("Scout Name");
		textField_8.setColumns(10);
		textField_8.setBounds(338, 179, 86, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(204, 204, 204));
		textField_9.setText("Scout Name");
		textField_9.setColumns(10);
		textField_9.setBounds(338, 204, 86, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(204, 204, 204));
		textField_10.setBounds(169, 11, 46, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Match");
		lblNewLabel_1.setBounds(113, 14, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Next Match");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setBounds(313, 10, 111, 23);
		contentPane.add(btnNewButton);
		
		newTableButton = new JButton("Create a New Table");
		newTableButton.setBackground(new Color(204, 204, 204));
		newTableButton.setBounds(272, 278, 152, 20);
		contentPane.add(newTableButton);
		newTableButton.setActionCommand("New Table");
		
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(204, 204, 204));
		textField_11.setBounds(272, 248, 152, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(240, 251, 22, 14);
		contentPane.add(lblIp);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(204, 204, 204));
		textField_12.setBounds(50, 275, 86, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		startLabel = new JLabel("From:");
		startLabel.setBounds(10, 275, 45, 14);
		contentPane.add(startLabel);
		
		textField_12.addFocusListener(new FocusAdapter() {
             public void focusLost(FocusEvent e) {
                // should be editable only when disconnected
                start = textField_12.getText();
             }  
         }
          );
		
		driveLabel = new JLabel();
		driveLabel.setText("Drive:");
		driveLabel.setBounds(10, 247, 89, 23);
		contentPane.add(driveLabel);
		
		driveField = new JTextField();
		driveField.setBackground(new Color(204, 204, 204));
		driveField.setBounds(50, 248, 86, 20);
		contentPane.add(driveField);
		
		driveField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
               // should be editable only when disconnected
               drive = driveField.getText();
            }  
        }
         );
		
		endField = new JTextField();
		endField.setBackground(new Color(204, 204, 204));
		endField.setBounds(50, 302, 86, 20);
		contentPane.add(endField);
		
		endLabel = new JLabel("To:");
		endLabel.setBounds(10, 305, 45, 14);
		contentPane.add(endLabel);
		
		endField.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
               // should be editable only when disconnected
               end = endField.getText();
            }  
        }
         );

		JButton Submit = new JButton("Submit!");
		Submit.setBackground(new Color(204, 204, 204));
		Submit.setBounds(272, 308, 152, 20);
		contentPane.add(Submit);
		Submit.setActionCommand("Host Submit");
		buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {
               // Request a connection initiation
               if (e.getActionCommand().equals("Host Submit")) {
            	   try {
					addData();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
               }
               
               if(e.getActionCommand().equals("New Table")){
            	   CopyOfGUIScoutstatic.sql.createNewTable();
               }
               }
		};
		
		Submit.addActionListener(buttonListener);
		newTableButton.addActionListener(buttonListener);
	}
	
	public static void addData() throws Exception{
		 Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + drive + ":" + "Client"); 
	        Statement stat = conn.createStatement();
	        
	        startNumber = Integer.parseInt(start);
	        endNumber = Integer.parseInt(end);
	         
	        while (startNumber <= endNumber){
	        ResultSet rs = stat.executeQuery("select * from "+ "MatchNumber_" + startNumber);
	        while (rs.next()) {
	            CopyOfGUIScoutstatic.sql.setMatchNumber(rs.getInt("MatchNumber"));
	            CopyOfGUIScoutstatic.sql.setFileName("Host");
	            CopyOfGUIScoutstatic.sql.setTableName("AllMatches");
	            CopyOfGUIScoutstatic.sql.setScouterName(rs.getString("ScoutName")); 
	            CopyOfGUIScoutstatic.sql.setTeamNumber(rs.getInt("TeamNumber"));
	            CopyOfGUIScoutstatic.sql.setPoints(rs.getInt("Points"));
	            CopyOfGUIScoutstatic.sql.setTotalStackNumber(rs.getLong("TotalStackNumberForward"), rs.getLong("TotalStackNumberBack"));
	            CopyOfGUIScoutstatic.sql.setTotes(rs.getInt("NumberOfTotes"));
	            CopyOfGUIScoutstatic.sql.setNoodles(rs.getInt("NoodlesOnTopOfStacks"));
	            CopyOfGUIScoutstatic.sql.setRecycleBins(rs.getInt("RecyclingContainers"), rs.getInt("AverageContainerHeight"));
	            CopyOfGUIScoutstatic.sql.setNotes(rs.getString("GameNotes"));
	            CopyOfGUIScoutstatic.sql.setAbsent(rs.getString("Absent"));
	            CopyOfGUIScoutstatic.sql.setCoopertitionStacked(rs.getString("CoopertitionStacked"));
	            CopyOfGUIScoutstatic.sql.setDidNothing(rs.getString("DidNothing"));
	            CopyOfGUIScoutstatic.sql.setTakesFromHumanPlayer(rs.getString("TakesFromHumanPlayer"));
	            CopyOfGUIScoutstatic.sql.setAutoTotesStacked(rs.getString("StackedAllThreeAutonTotes"));
	            CopyOfGUIScoutstatic.sql.setMadeItToAutoZone(rs.getString("MadeItToAutoZone"));
	            CopyOfGUIScoutstatic.sql.setBroken(rs.getString("EsBroken"));
	            CopyOfGUIScoutstatic.sql.setTakesFromLandFill(rs.getString("TakesFromLandfill"));
	            CopyOfGUIScoutstatic.sql.setLandFillNoodles(rs.getInt("NoodlesPushedToLandFill"));
	            CopyOfGUIScoutstatic.sql.setPickedUpKnockedOverContainers(rs.getString("PickedUpKnockedOverContainers"));
	            CopyOfGUIScoutstatic.sql.setPickedUpKnockedOverTotes(rs.getString("PickedUpKnockedOverTotes"));
	            
	            try {
	            	CopyOfGUIScoutstatic.sql.run();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            
	        }
	        
	        startNumber +=1;  
	        rs.close();
	        }
	        conn.close();
	        
	        
	}
}
