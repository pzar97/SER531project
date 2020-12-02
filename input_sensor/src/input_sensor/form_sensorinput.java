package input_sensor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class form_sensorinput extends JFrame{

	//Java Swing Components
	private JFrame frame;
	public JTextField speedfield;
	public JTextField tflocation;
	public JLabel show_validationtext;
	public JRadioButton rbsingleway;
	public JRadioButton rbdualway;
	public JRadioButton rbDry;
	public JRadioButton rbDamp;
	public JRadioButton rbFine;
	public JRadioButton rbRaining;
	public JRadioButton rbDay;
	public JRadioButton rbNightVis;
	public JRadioButton rbDark;
	public JRadioButton rbNightLowVis;
	public JRadioButton rbWindy;
	public JRadioButton rbUnknownlight;
	public JRadioButton rbunknownroadcond;
	public JRadioButton rbunknownweatcond;
	public JRadioButton rbunknownroadtype;
	public JRadioButton rbSnowy;
	public JRadioButton rbFlood;
	
	//grouping the radio buttons
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	
	//to store form data
	String speed, location, roadcond, roadtype, weathercond, lightcond = " ";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		form_sensorinput window = new form_sensorinput();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//form_sensorinput window = new form_sensorinput();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public form_sensorinput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.setBounds(100, 100, 865, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel1.setBackground(Color.BLACK);
		
		//outputs validation text after validating speed and location fields
		JLabel show_validationtext = new JLabel("");
		show_validationtext.setBackground(Color.WHITE);
		show_validationtext.setForeground(Color.RED);
		
		//inputs location value
		JTextField tflocation = new JTextField();
		tflocation.setColumns(20);
		tflocation.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            char c = ke.getKeyChar();
	            int key = ke.getKeyCode();
	            
	            if ((Character.isLetter(c) || Character.isISOControl(c)) || (key == KeyEvent.VK_BACK_SPACE)) {
	            	
	            	String text = String.valueOf(c);
	            	tflocation.setEditable(true);
	            	show_validationtext.setText("");
	               
	            } else {
	            	tflocation.setEditable(false);
	            	show_validationtext.setText("* Enter only letters(A-Z or a-z)");
	            }
	         }
		});
		
		//inputs speed value
		speedfield = new JTextField();
		speedfield.setColumns(10);
		speedfield.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = speedfield.getText();
	            int l = value.length();
	            int key = ke.getKeyCode();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' && l < 3) || (key == KeyEvent.VK_BACK_SPACE)) {
	            	speedfield.setEditable(true);
	            	show_validationtext.setText("");
	               
	            } else {
	            	speedfield.setEditable(false);
	            	show_validationtext.setText("* Enter only numeric digits(0-9)");
	            }
	         }
		});
		
		
		JLabel speedlbl = new JLabel("Speed of the car :");
		speedlbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		speedlbl.setBackground(Color.WHITE);
		speedlbl.setForeground(Color.WHITE);
		
		JLabel lightinglbl = new JLabel("Lighting : ");
		lightinglbl.setForeground(Color.WHITE);
		
		JLabel locationlbl = new JLabel("Location : ");
		locationlbl.setForeground(Color.WHITE);
		
		JLabel roadtypelbl = new JLabel("Road Type : ");
		roadtypelbl.setForeground(Color.WHITE);
		
		//radio buttons for road type
		JRadioButton rbsingleway = new JRadioButton("Single carriage way");
		buttonGroup_1.add(rbsingleway);
		rbsingleway.setSelected(true);
		rbsingleway.setForeground(Color.WHITE);
		
		JRadioButton rbdualway = new JRadioButton("Dual carriage way");
		buttonGroup_1.add(rbdualway);
		rbdualway.setForeground(Color.WHITE);
		
		JRadioButton rbRoundabout = new JRadioButton("Roundabout");
		buttonGroup_1.add(rbRoundabout);
		rbRoundabout.setSelected(true);
		rbRoundabout.setForeground(Color.WHITE);
		
		JRadioButton rbOnewaystreet = new JRadioButton("One way street");
		buttonGroup_1.add(rbOnewaystreet);
		rbOnewaystreet.setSelected(true);
		rbOnewaystreet.setForeground(Color.WHITE);
		
		JRadioButton rbSliproad = new JRadioButton("Slip road");
		buttonGroup_1.add(rbSliproad);
		rbSliproad.setSelected(true);
		rbSliproad.setForeground(Color.WHITE);
		
		JRadioButton rbunknownroadtype = new JRadioButton("Unknown");
		buttonGroup_1.add(rbunknownroadtype);
		rbunknownroadtype.setForeground(Color.WHITE);
		
		JLabel roadconditionlbl = new JLabel("Road Condition : ");
		roadconditionlbl.setForeground(Color.WHITE);
		
		//radio buttons for road condition
		JRadioButton rbDry = new JRadioButton("Dry");
		buttonGroup_2.add(rbDry);
		rbDry.setSelected(true);
		rbDry.setForeground(Color.WHITE);
		
		JRadioButton rbDamp = new JRadioButton("Wet");
		buttonGroup_2.add(rbDamp);
		rbDamp.setForeground(Color.WHITE);
		
		JRadioButton rbSnow = new JRadioButton("Snow");
		buttonGroup_2.add(rbSnow);
		rbSnow.setSelected(true);
		rbSnow.setForeground(Color.WHITE);
		
		JRadioButton rbFrost = new JRadioButton("Ice");
		buttonGroup_2.add(rbFrost);
		rbFrost.setSelected(true);
		rbFrost.setForeground(Color.WHITE);
		
		JRadioButton rbFlood = new JRadioButton("Flood");
		buttonGroup_2.add(rbFlood);
		rbFlood.setSelected(true);
		rbFlood.setForeground(Color.WHITE);
		
		JRadioButton rbunknownroadcond = new JRadioButton("Unknown");
		buttonGroup_2.add(rbunknownroadcond);
		rbunknownroadcond.setForeground(Color.WHITE);
		
		JLabel wconditionlbl = new JLabel("Weather Condition : ");
		wconditionlbl.setForeground(Color.WHITE);
		
		//radio buttons for weather condition
		JRadioButton rbFine = new JRadioButton("Normal");
		buttonGroup_3.add(rbFine);
		rbFine.setSelected(true);
		rbFine.setForeground(Color.WHITE);
		
		JRadioButton rbRaining = new JRadioButton("Rainy");
		buttonGroup_3.add(rbRaining);
		rbRaining.setForeground(Color.WHITE);
		
		JRadioButton rbWindy = new JRadioButton("Windy");
		buttonGroup_3.add(rbWindy);
		rbWindy.setForeground(Color.WHITE);
		
		JRadioButton rbStormy = new JRadioButton("Stormy");
		buttonGroup_3.add(rbStormy);
		rbStormy.setForeground(Color.WHITE);
		
		JRadioButton rbFoggy = new JRadioButton("Foggy");
		buttonGroup_3.add(rbFoggy);
		rbFoggy.setForeground(Color.WHITE);
		
		JRadioButton rbunknownweatcond = new JRadioButton("Unknown");
		buttonGroup_3.add(rbunknownweatcond);
		rbunknownweatcond.setForeground(Color.WHITE);
		
		JRadioButton rbSnowy = new JRadioButton("Snowy");
		buttonGroup_3.add(rbSnowy);
		rbSnowy.setForeground(Color.WHITE);
		
		JLabel titlelbl = new JLabel("Speed Recommendation System");
		titlelbl.setForeground(Color.RED);
		
		//radio buttons for light condition
		
		JRadioButton rbDay = new JRadioButton("Day");
		buttonGroup.add(rbDay);
		rbDay.setSelected(true);
		rbDay.setForeground(Color.WHITE);
		
		JRadioButton rbNightVis = new JRadioButton("Night with visibility");
		buttonGroup.add(rbNightVis);
		rbNightVis.setForeground(Color.WHITE);
		
		JRadioButton rbDark = new JRadioButton("Dark");
		buttonGroup.add(rbDark);
		rbDark.setForeground(Color.WHITE);
		
		JRadioButton rbNightLowVis = new JRadioButton("Night with low visibility");
		buttonGroup.add(rbNightLowVis);
		rbNightLowVis.setForeground(Color.WHITE);
		
		JRadioButton rbUnknownlight = new JRadioButton("Unknown");
		buttonGroup.add(rbUnknownlight);
		rbUnknownlight.setForeground(Color.WHITE);
		
		
		//submit button
		JButton Submitbtn = new JButton("Submit");
		Submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
						//light condition selected
						if(rbDay.isSelected())
						{
							lightcond = "Day";
						}
						else if(rbNightVis.isSelected())
						{
							
							lightcond = "Night with visibility";
						}
						else if(rbDark.isSelected())
						{
							
							lightcond = "Dark";
						}
						else if(rbNightLowVis.isSelected())
						{
							
							lightcond = "Night with low visibility";
						}
						
						else
						{
							
							lightcond = "Unknown";
						}
					
						
						
						//weather condition selected
						if(rbWindy.isSelected())
						{
							weathercond = "Windy";
						}
						else if(rbStormy.isSelected())
						{
							
							weathercond = "Stormy";
						}
						else if(rbFoggy.isSelected())
						{
							
							weathercond = "Foggy";
						}
						else if(rbSnowy.isSelected())
						{
							
							weathercond = "Snowy";
						}
						else if(rbRaining.isSelected())
						{
							weathercond = "Rainy";
						}
						else if(rbFine.isSelected())
						{
							weathercond = "Normal";
						}
						else
						{
							weathercond = "Unknown";
						}
						
						//road condition selected
						if(rbRoundabout.isSelected())
						{
							roadcond = "Roundabout";
						}
						else if(rbOnewaystreet.isSelected())
						{
							
							roadcond = "One way street";
						}
						else if(rbsingleway.isSelected())
						{
							
							roadcond = "Single carriage way";
						}
						else if(rbdualway.isSelected())
						{
							
							roadcond = "Dual carriage way";
						}
						else if(rbSliproad.isSelected())
						{
							roadcond = "Slip road";
						}
						else
						{
							roadcond = "Unknown";
						}
						
						//road type selected
						if(rbDry.isSelected())
						{
							roadtype = "Dry";
						}
						else if(rbDamp.isSelected())
						{
							
							roadtype = "Wet";
						}
						else if(rbFrost.isSelected())
						{
							
							roadtype = "Ice";
						}
						else if(rbSnow.isSelected())
						{
							
							roadtype = "Snow";
						}
						else if(rbFlood.isSelected())
						{
							roadtype = "Flood";
						}
						else
						{
							roadtype = "Unknown";
						}
						
						speed = speedfield.getText();
						location = tflocation.getText();

				/*
				 * System.out.println(lightcond); System.out.println(weathercond);
				 * System.out.println(roadtype); System.out.println(roadcond);
				 * System.out.println(speed); System.out.println(location);
				 */
						
						//recommended speed pop up
						JOptionPane.showMessageDialog(null, "Recommended speed");
						
		}
		});
				
		Submitbtn.setBackground(Color.LIGHT_GRAY);
		
		//grouped every component in the panel
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(speedlbl, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(speedfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
										.addComponent(titlelbl, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel1.createSequentialGroup()
											.addComponent(locationlbl, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tflocation, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(lightinglbl, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(rbDay)
									.addGap(18)
									.addComponent(rbNightVis, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rbDark)
									.addGap(18)
									.addComponent(rbNightLowVis, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rbUnknownlight)))
							.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addContainerGap()
							.addComponent(roadconditionlbl, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbDry, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbDamp, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbSnow, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbFrost, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbFlood, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbunknownroadcond, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(82))
						.addGroup(gl_panel1.createSequentialGroup()
							.addContainerGap()
							.addComponent(roadtypelbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(rbunknownroadtype, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(rbsingleway, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rbdualway, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rbRoundabout)
									.addGap(18)
									.addComponent(rbOnewaystreet, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rbSliproad, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
								.addComponent(Submitbtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel1.createSequentialGroup()
									.addComponent(wconditionlbl, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
										.addComponent(rbSnowy, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel1.createSequentialGroup()
											.addComponent(rbFine, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(rbRaining)
											.addGap(18)
											.addComponent(rbWindy, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(rbStormy, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
									.addGap(8)))
							.addGap(18)
							.addComponent(rbFoggy, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rbunknownweatcond, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(105)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel1.createSequentialGroup()
					.addContainerGap(300, Short.MAX_VALUE)
					.addComponent(show_validationtext, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
					.addGap(186))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(titlelbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel1.createSequentialGroup()
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(3)
									.addComponent(speedlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
									.addComponent(speedfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(locationlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addComponent(tflocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(16)
									.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
										.addComponent(lightinglbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
											.addComponent(rbDay)
											.addComponent(rbNightVis)
											.addComponent(rbDark))))
								.addGroup(gl_panel1.createSequentialGroup()
									.addGap(18)
									.addComponent(rbNightLowVis)))
							.addGap(16))
						.addGroup(Alignment.TRAILING, gl_panel1.createSequentialGroup()
							.addComponent(rbUnknownlight)
							.addGap(18)))
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(roadtypelbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rbsingleway)
						.addComponent(rbdualway)
						.addComponent(rbRoundabout)
						.addComponent(rbOnewaystreet)
						.addComponent(rbSliproad))
					.addGap(18)
					.addComponent(rbunknownroadtype)
					.addGap(24)
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(roadconditionlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rbDry)
						.addComponent(rbDamp)
						.addComponent(rbSnow)
						.addComponent(rbFrost)
						.addComponent(rbFlood)
						.addComponent(rbunknownroadcond))
					.addGap(17)
					.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(wconditionlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rbFine)
						.addComponent(rbRaining)
						.addComponent(rbWindy)
						.addComponent(rbStormy)
						.addComponent(rbFoggy)
						.addComponent(rbunknownweatcond))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rbSnowy)
					.addGap(11)
					.addComponent(show_validationtext)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Submitbtn)
					.addGap(30))
		);
		panel1.setLayout(gl_panel1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
	
		/*
		 * speed = speedfield.getText(); latitude = tflatitude.getValue().toString();
		 * longitude = tflongitude.getValue().toString();
		 */
	
		
		
	}
	

 }

