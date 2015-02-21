
import java.awt.Color;


import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.io.BufferedReader;
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
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;



public class GUIScout extends JFrame implements Runnable {
	public GUIScout() {
	}
	
	public final static GUIScout tcpObj = new GUIScout();
	
	private JFrame frame;
	private JTextField txtYourNameHere;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField ipField;
	
	private final int NULL = 0;
	private final static int DISCONNECTED = 1;
	private final static int DISCONNECTING = 2;
	private final static int  BEGIN_CONNECT = 3;
	private final static int CONNECTED = 4;
	
	public ServerSocket hostServer = null;
	public Socket socket = null;
	public BufferedReader in = null;
	public PrintWriter out = null;
	
	private TeleopPanel panel;
	private TeleopPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel lblNotes;
	private JTextArea txtrGeneralNotes;
	private JSpinner spinner;
	private JLabel lblNewLabel_2;
	private JSpinner spinner_1;
	private JLabel lblOfBins;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxEsBroken;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxStackedAllThree;
	private JButton btnSubmit;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblMatch;
	private JLabel IPField;
	private JCheckBox chckbxDidNothing;
	private JComboBox comboBox;
	private JCheckBox chckbxCoopertitionStacked;
	private JButton connectButton;
	private JButton disconnectButton;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnClient;
	private JButton btnNewButton;
	private static int connectionStatus = DISCONNECTED;
	
	
	
	private String hostIP;
	private static boolean flag = true;
	private String name;
	
	private boolean isHost;
	   
	private SQLiteTest sql;

	 private String statusMessages[] = {
	      " Error! Could not connect!", " Disconnected",
	      " Disconnecting...", " Connecting...", " Connected"
	   };
	 
	 public String statusString = statusMessages[connectionStatus];
	 
	 private JTextField txtNotConnected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
					GUIScout window = new GUIScout();
					window.initialize();
					window.frame.setVisible(true);
				
					
		
				 while (flag) {
			         try { // Poll every ~10 ms
			            Thread.sleep(10);
			         }
			         catch (InterruptedException e) {}

			         switch (connectionStatus) {
			         case BEGIN_CONNECT:
			            try {
			               // Try to set up a server if host
			               if (window.isHost) {
			            	   window.hostServer = new ServerSocket(1234);
			            	   window.socket = window.hostServer.accept();
			            	   window.sql.setFileName("hostscout.db");
			               }

			               // If guest, try to connect to the server
			               else {
			            	   window.socket = new Socket(window.hostIP, 1234);
			            	   window.sql.setFileName("clientscout.db");
			               }

			               window.in = new BufferedReader(new 
			                  InputStreamReader(window.socket.getInputStream()));
			               window.out = new PrintWriter(window.socket.getOutputStream(), true);
			               window.changeStatusTS(CONNECTED, true);
			               
			            }
			            // If error, clean up and output an error message
			            catch (IOException e) {
			               window.cleanUp();
			               window.changeStatusTS(DISCONNECTED, false);
			            }
			            
			            break;

			         case CONNECTED:
			        	 
			          /*  try {
			               // Send data
			            	
			               if (toSend.length() != 0) {
			                  out.print(toSend); out.flush();
			                  toSend.setLength(0);
			                  changeStatusTS(NULL, true);
			             
			               }

			               // Receive data
			               if (in.ready()) {
			                  s = in.readLine();
			                  
			                  if ((s != null) &&  (s.length() != 0)) {
			                     // Check if it is the end of a trasmission
			                     if (s.equals(END_CHAT_SESSION)) {
			                        changeStatusTS(DISCONNECTING, true);
			  
			                     }

			                     // Otherwise, receive what text
			                     else {
			                        appendToChatBox(s + "\n");
			                        changeStatusTS(NULL, true);
			                     }
			                  }
			               }
			            }
			            
			            catch (IOException e) {
			               cleanUp();
			               changeStatusTS(DISCONNECTED, false);
			            }
			            */
			         
			            break;

			         case DISCONNECTING:
			            // Tell other chatter to disconnect as well
			            window.out.flush();

			            // Clean up (close all streams/sockets)
			            window.cleanUp();
			            window.changeStatusTS(DISCONNECTED, true);
			            try {
			                window.sql.run();
			              } catch (Exception e) {
			                 
			                }
			            break;
			            

			         default: break; // do nothing
			         }
			         
			      }
			      
			      
			      
			   }
				
	

	/**
	 * Create the application.
	 */
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 858, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Scouteroo!");
		
		sql = new SQLiteTest();
		
		ActionAdapter buttonListener = null;
		
		panel = new TeleopPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setForeground(Color.YELLOW);
		panel.setBounds(376, 95, 456, 221);
		frame.getContentPane().add(panel);
		
		panel_1 = new TeleopPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(376, 382, 456, 221);
		frame.getContentPane().add(panel_1);
		
		txtYourNameHere = new JTextField();
		txtYourNameHere.setBackground(new Color(204, 204, 204));
		txtYourNameHere.setText("Your Name");
		txtYourNameHere.setBounds(49, 13, 106, 20);
		frame.getContentPane().add(txtYourNameHere);
		txtYourNameHere.setColumns(10);
		
		lblNewLabel = new JLabel("Autonomous");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(49, 351, 147, 20);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Teleop Forward");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(397, 351, 218, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		label = new JLabel("Teleop Back");
		label.setFont(new Font("Arial Black", Font.PLAIN, 18));
		label.setBounds(397, 64, 207, 20);
		frame.getContentPane().add(label);
		
		lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNotes.setBounds(49, 64, 93, 17);
		frame.getContentPane().add(lblNotes);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 204, 204));
		textField.setColumns(10);
		textField.setBounds(336, 13, 86, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(204, 204, 204));
		textField_1.setColumns(10);
		textField_1.setBounds(501, 13, 79, 20);
		frame.getContentPane().add(textField_1);
		
		txtrGeneralNotes = new JTextArea();
		txtrGeneralNotes.setBackground(new Color(204, 204, 204));
		txtrGeneralNotes.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrGeneralNotes.setText("General Notes");
		txtrGeneralNotes.setBounds(10, 90, 287, 72);
		frame.getContentPane().add(txtrGeneralNotes);
		
		spinner = new JSpinner();
		spinner.setForeground(new Color(204, 204, 255));
		spinner.setBackground(new Color(204, 204, 204));
		spinner.setBounds(72, 385, 46, 33);
		frame.getContentPane().add(spinner);
		
		lblNewLabel_2 = new JLabel("# of totes \r\n");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 389, 62, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		spinner_1 = new JSpinner();
		spinner_1.setForeground(new Color(204, 204, 255));
		spinner_1.setBackground(new Color(204, 204, 204));
		spinner_1.setBounds(72, 434, 46, 33);
		frame.getContentPane().add(spinner_1);
		
		lblOfBins = new JLabel("# of bins\r\n");
		lblOfBins.setFont(new Font("Arial", Font.BOLD, 11));
		lblOfBins.setBounds(10, 438, 62, 24);
		frame.getContentPane().add(lblOfBins);
		
		chckbxNewCheckBox = new JCheckBox("Absent?");
		chckbxNewCheckBox.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBox.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBox.setBounds(10, 173, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		chckbxEsBroken = new JCheckBox("Es Broken!");
		chckbxEsBroken.setBackground(new Color(204, 204, 204));
		chckbxEsBroken.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxEsBroken.setBounds(10, 199, 97, 23);
		frame.getContentPane().add(chckbxEsBroken);
		
		chckbxNewCheckBox_1 = new JCheckBox("Takes from human player?");
		chckbxNewCheckBox_1.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBox_1.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBox_1.setBounds(10, 225, 186, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Made it to auto zone?");
		chckbxNewCheckBox_2.setBackground(new Color(204, 204, 204));
		chckbxNewCheckBox_2.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxNewCheckBox_2.setBounds(149, 382, 159, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		chckbxStackedAllThree = new JCheckBox("Stacked all three totes?");
		chckbxStackedAllThree.setBackground(new Color(204, 204, 204));
		chckbxStackedAllThree.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxStackedAllThree.setBounds(149, 408, 159, 23);
		frame.getContentPane().add(chckbxStackedAllThree);
		
		btnSubmit = new JButton("Submit!");
		btnSubmit.setBounds(743, 12, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 16, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Team #");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(280, 16, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblMatch = new JLabel("Match #");
		lblMatch.setFont(new Font("Arial", Font.BOLD, 12));
		lblMatch.setBounds(445, 16, 46, 14);
		frame.getContentPane().add(lblMatch);
		
		ipField = new JTextField();
		ipField.setBackground(new Color(204, 204, 204));
		ipField.setBounds(628, 13, 105, 20);
		ipField.setText("localHost");
		hostIP = ipField.getText();
		frame.getContentPane().add(ipField);
		ipField.setColumns(10);
		
		IPField = new JLabel("IP");
		IPField.setFont(new Font("Arial", Font.BOLD, 12));
		IPField.setBounds(606, 16, 23, 14);
		frame.getContentPane().add(IPField);
		
		
		chckbxDidNothing = new JCheckBox("Did nothing?");
		chckbxDidNothing.setBackground(new Color(204, 204, 204));
		chckbxDidNothing.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxDidNothing.setBounds(149, 434, 159, 23);
		frame.getContentPane().add(chckbxDidNothing);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Blue 1", "Blue 2", "Blue 3", "Red 1", "Red 2", "Red 3"}));
		comboBox.setBounds(165, 13, 93, 20);
		frame.getContentPane().add(comboBox);
		
		chckbxCoopertitionStacked = new JCheckBox("Coopertition stacked?");
		chckbxCoopertitionStacked.setBackground(new Color(204, 204, 204));
		chckbxCoopertitionStacked.setFont(new Font("Arial", Font.BOLD, 11));
		chckbxCoopertitionStacked.setBounds(10, 251, 186, 23);
		frame.getContentPane().add(chckbxCoopertitionStacked);
		
		connectButton = new JButton("Connect");
		connectButton.setFont(new Font("Arial", Font.BOLD, 11));
		connectButton.setForeground(Color.BLACK);
		connectButton.setBackground(Color.LIGHT_GRAY);
		connectButton.setBounds(0, 571, 106, 43);
		frame.getContentPane().add(connectButton);
		 connectButton.setMnemonic(KeyEvent.VK_C);
	      connectButton.setActionCommand("connect");
	      connectButton.setEnabled(true);
	      
		
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setFont(new Font("Arial", Font.BOLD, 11));
		disconnectButton.setForeground(Color.BLACK);
		disconnectButton.setBackground(Color.LIGHT_GRAY);
		disconnectButton.setBounds(103, 571, 106, 43);
		frame.getContentPane().add(disconnectButton);
		disconnectButton.setMnemonic(KeyEvent.VK_D);
	      disconnectButton.setActionCommand("disconnect");
	      disconnectButton.setEnabled(true);
		
		txtNotConnected = new JTextField();
		txtNotConnected.setEnabled(true);
		txtNotConnected.setEditable(false);
		txtNotConnected.setFont(new Font("Arial", Font.BOLD, 12));
		txtNotConnected.setBackground(Color.RED);
		txtNotConnected.setText(statusString);
		txtNotConnected.setBounds(205, 571, 161, 43);
		frame.getContentPane().add(txtNotConnected);
		txtNotConnected.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Host\r\n");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(-2, 520, 72, 49);
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setMnemonic(KeyEvent.VK_H);
		rdbtnNewRadioButton.setActionCommand("host");
		
		rdbtnClient = new JRadioButton("Client");
		rdbtnClient.setBackground(Color.LIGHT_GRAY);
		rdbtnClient.setBounds(70, 520, 72, 49);
		frame.getContentPane().add(rdbtnClient);
		rdbtnClient.setMnemonic(KeyEvent.VK_G);
		rdbtnClient.setActionCommand("guest");
		
		btnNewButton = new JButton("Host Menu");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(142, 520, 133, 49);
		frame.getContentPane().add(btnNewButton);
		
		buttonListener = new ActionAdapter() {
            public void actionPerformed(ActionEvent e) {
               if (connectionStatus != DISCONNECTED) {
                  changeStatusNTS(NULL, true);
               }
               else {
                  isHost = e.getActionCommand().equals("host");

                  // Cannot supply host IP if host option is chosen
                  if (isHost) {
                     ipField.setEnabled(true);
                     hostIP = ipField.getText();
                  }
                  else {
                     ipField.setEnabled(true);
                  }
               }
            }
         };
         
         rdbtnNewRadioButton.addActionListener(buttonListener);
         rdbtnClient.addActionListener(buttonListener);
         
         buttonListener = new ActionAdapter() {
             public void actionPerformed(ActionEvent e) {
                // Request a connection initiation
                if (e.getActionCommand().equals("connect")) {
                   changeStatusNTS(BEGIN_CONNECT, true);
                }
                // Disconnect
                else {
                   changeStatusNTS(DISCONNECTING, true);
                   
                }
             }
          };
          connectButton.addActionListener(buttonListener);
          disconnectButton.addActionListener(buttonListener);
          
          txtYourNameHere.addFocusListener(new FocusAdapter() {
              public void focusLost(FocusEvent e) {
                 // should be editable only when disconnected
                 if (connectionStatus != DISCONNECTED) {
                    changeStatusNTS(NULL, true);
                 }
                 else {
                	 name = txtYourNameHere.getText();
                	 sql.setScouterName(name);
                 }
              }  
          }
           );
          
          ipField.addFocusListener(new FocusAdapter() {
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
           });
          
          ButtonGroup hostButtonGroup = new ButtonGroup();
  		hostButtonGroup.add(rdbtnClient);
  		hostButtonGroup.add(rdbtnNewRadioButton);
		
		
	}
	
	 private void cleanUp() {
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
	private void addPopup(Component component, final JPopupMenu popup) {
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
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	 public void run() {
	      switch (connectionStatus) {
	      case DISCONNECTED:
	         connectButton.setEnabled(true);
	         disconnectButton.setEnabled(false);
	         ipField.setEnabled(true);
	         txtNotConnected.setBackground(Color.red);
	         break;

	      case DISCONNECTING:
	         connectButton.setEnabled(false);
	         disconnectButton.setEnabled(false);
	         ipField.setEnabled(false);
	         txtNotConnected.setBackground(Color.orange);
	         break;

	      case CONNECTED:
	         connectButton.setEnabled(false);
	         disconnectButton.setEnabled(true);
	         ipField.setEnabled(false);
	         txtNotConnected.setBackground(Color.green);
	         break;

	      case BEGIN_CONNECT:
	         connectButton.setEnabled(false);
	         disconnectButton.setEnabled(false);
	         ipField.setEnabled(false);
	         txtNotConnected.setBackground(Color.orange);
	         break;
	      }

	      // Make sure that the button/text field states are consistent
	      // with the internal states
	      ipField.setText(hostIP);
	      frame.repaint();
	   }
	 
	 private void changeStatusTS(int newConnectStatus, boolean noError) {
	      // Change state if valid state
	      if (newConnectStatus != NULL) {
	         connectionStatus = newConnectStatus;
	      }

	      // If there is no error, display the appropriate status message
	      if (noError) {
	         txtNotConnected.setText(statusMessages[connectionStatus]);
	      }
	      // Otherwise, display error message
	      else {
	    	  txtNotConnected.setText(statusMessages[NULL]);
	      }

	      // Call the run() routine (Runnable interface) on the
	      // error-handling and GUI-update thread
	      SwingUtilities.invokeLater(tcpObj);
	      
	   }
	 private void changeStatusNTS(int newConnectStatus, boolean noError) {
	      // Change state if valid state
	      if (newConnectStatus != NULL) {
	         connectionStatus = newConnectStatus;
	      }

	      // If there is no error, display the appropriate status message
	      if (noError) {
	    	  txtNotConnected.setText(statusMessages[connectionStatus]);
	      }
	      // Otherwise, display error message
	      else {
	    	  txtNotConnected.setText(statusMessages[NULL]);
	      }

	      // Call the run() routine (Runnable interface) on the
	      // current thread
	      tcpObj.run();
	   }
}
class ActionAdapter implements ActionListener {
	   public void actionPerformed(ActionEvent e) {}
	}