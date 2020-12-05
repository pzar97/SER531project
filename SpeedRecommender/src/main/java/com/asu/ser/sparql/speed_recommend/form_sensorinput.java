package com.asu.ser.sparql.speed_recommend;

/*
 * 
 * Author: Priyanka Zar
 * Date Created: 29th November 2020
 * 
 * This was written by the aforementioned author, and can be used for 
 * grading purposes by Arizona State University. 
 * Course: SER 531 
 */

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
		/* if you want to recalculate severity using new dataset */
		
		/* uncomment the following */
		// SevCalculator obj = new SevCalculator();
		//obj.calcSeverity();
		
		
		final form_sensorinput window = new form_sensorinput();
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
		frame.setBackground(Color.BLACK);
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.setBounds(100, 100, 865, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel1.setBackground(Color.WHITE);
		
		//outputs validation text after validating speed and location fields
		final JLabel show_validationtext = new JLabel("");
		show_validationtext.setBackground(Color.BLACK);
		show_validationtext.setForeground(Color.RED);
		
		//inputs location value
		final JTextField tflocation = new JTextField();
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
		speedlbl.setForeground(Color.BLACK);
		
		JLabel lightinglbl = new JLabel("Lighting : ");
		lightinglbl.setForeground(Color.BLACK);
		
		JLabel locationlbl = new JLabel("Location : ");
		locationlbl.setForeground(Color.BLACK);
		
		JLabel roadtypelbl = new JLabel("Road Type : ");
		roadtypelbl.setForeground(Color.BLACK);
		
		//radio buttons for road type
		final JRadioButton rbsingleway = new JRadioButton("Single carriage way");
		buttonGroup_1.add(rbsingleway);
		rbsingleway.setSelected(true);
		rbsingleway.setForeground(Color.BLACK);
		
		final JRadioButton rbdualway = new JRadioButton("Dual carriage way");
		buttonGroup_1.add(rbdualway);
		rbdualway.setForeground(Color.BLACK);
		
		final JRadioButton rbRoundabout = new JRadioButton("Roundabout");
		buttonGroup_1.add(rbRoundabout);
		rbRoundabout.setSelected(true);
		rbRoundabout.setForeground(Color.BLACK);
		
		final JRadioButton rbOnewaystreet = new JRadioButton("One way street");
		buttonGroup_1.add(rbOnewaystreet);
		rbOnewaystreet.setSelected(true);
		rbOnewaystreet.setForeground(Color.BLACK);
		
		final JRadioButton rbSliproad = new JRadioButton("Slip road");
		buttonGroup_1.add(rbSliproad);
		rbSliproad.setSelected(true);
		rbSliproad.setForeground(Color.BLACK);
		
		JRadioButton rbunknownroadtype = new JRadioButton("Unknown");
		buttonGroup_1.add(rbunknownroadtype);
		rbunknownroadtype.setForeground(Color.BLACK);
		
		JLabel roadconditionlbl = new JLabel("Road Condition : ");
		roadconditionlbl.setForeground(Color.BLACK);
		
		//radio buttons for road condition
		final JRadioButton rbDry = new JRadioButton("Dry");
		buttonGroup_2.add(rbDry);
		rbDry.setSelected(true);
		rbDry.setForeground(Color.BLACK);
		
		final JRadioButton rbDamp = new JRadioButton("Wet");
		buttonGroup_2.add(rbDamp);
		rbDamp.setForeground(Color.BLACK);
		
		final JRadioButton rbSnow = new JRadioButton("Snow");
		buttonGroup_2.add(rbSnow);
		rbSnow.setSelected(true);
		rbSnow.setForeground(Color.BLACK);
		
		final JRadioButton rbFrost = new JRadioButton("Ice");
		buttonGroup_2.add(rbFrost);
		rbFrost.setSelected(true);
		rbFrost.setForeground(Color.BLACK);
		
		final JRadioButton rbFlood = new JRadioButton("Flood");
		buttonGroup_2.add(rbFlood);
		rbFlood.setSelected(true);
		rbFlood.setForeground(Color.BLACK);
		
		JRadioButton rbunknownroadcond = new JRadioButton("Unknown");
		buttonGroup_2.add(rbunknownroadcond);
		rbunknownroadcond.setForeground(Color.BLACK);
		
		JLabel wconditionlbl = new JLabel("Weather Condition : ");
		wconditionlbl.setForeground(Color.BLACK);
		
		//radio buttons for weather condition
		final JRadioButton rbFine = new JRadioButton("Normal");
		buttonGroup_3.add(rbFine);
		rbFine.setSelected(true);
		rbFine.setForeground(Color.BLACK);
		
		final JRadioButton rbRaining = new JRadioButton("Rainy");
		buttonGroup_3.add(rbRaining);
		rbRaining.setForeground(Color.BLACK);
		
		final JRadioButton rbWindy = new JRadioButton("Windy");
		buttonGroup_3.add(rbWindy);
		rbWindy.setForeground(Color.BLACK);
		
		final JRadioButton rbStormy = new JRadioButton("Stormy");
		buttonGroup_3.add(rbStormy);
		rbStormy.setForeground(Color.BLACK);
		
		final JRadioButton rbFoggy = new JRadioButton("Foggy");
		buttonGroup_3.add(rbFoggy);
		rbFoggy.setForeground(Color.BLACK);
		
		JRadioButton rbunknownweatcond = new JRadioButton("Unknown");
		buttonGroup_3.add(rbunknownweatcond);
		rbunknownweatcond.setForeground(Color.BLACK);
		
		final JRadioButton rbSnowy = new JRadioButton("Snowy");
		buttonGroup_3.add(rbSnowy);
		rbSnowy.setForeground(Color.BLACK);
		
		JLabel titlelbl = new JLabel("Speed Recommendation System");
		titlelbl.setForeground(Color.RED);
		
		//radio buttons for light condition
		
		final JRadioButton rbDay = new JRadioButton("Day");
		buttonGroup.add(rbDay);
		rbDay.setSelected(true);
		rbDay.setForeground(Color.BLACK);
		
		final JRadioButton rbNightVis = new JRadioButton("Night with visibility");
		buttonGroup.add(rbNightVis);
		rbNightVis.setForeground(Color.BLACK);
		
		final JRadioButton rbDark = new JRadioButton("Dark");
		buttonGroup.add(rbDark);
		rbDark.setForeground(Color.BLACK);
		
		final JRadioButton rbNightLowVis = new JRadioButton("Night with low visibility");
		buttonGroup.add(rbNightLowVis);
		rbNightLowVis.setForeground(Color.BLACK);
		
		JRadioButton rbUnknownlight = new JRadioButton("Unknown");
		buttonGroup.add(rbUnknownlight);
		rbUnknownlight.setForeground(Color.BLACK);
		
		
		//submit button
		JButton Submitbtn = new JButton("Submit");
		Submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				form_sensorinput fobj = new form_sensorinput();
						
						//light condition selected
						if(rbDay.isSelected())
						{
							fobj.lightcond = "Day";
						}
						else if(rbNightVis.isSelected())
						{
							
							fobj.lightcond = "Night with visibility";
						}
						else if(rbDark.isSelected())
						{
							
							fobj.lightcond = "Dark";
						}
						else if(rbNightLowVis.isSelected())
						{
							
							fobj.lightcond = "Night with low visibility";
						}
						
						else
						{
							
							fobj.lightcond = "Unknown";
						}
					
						
						
						//weather condition selected
						if(rbWindy.isSelected())
						{
							fobj.weathercond = "Windy";
						}
						else if(rbStormy.isSelected())
						{
							
							fobj.weathercond = "Stormy";
						}
						else if(rbFoggy.isSelected())
						{
							
							fobj.weathercond = "Foggy";
						}
						else if(rbSnowy.isSelected())
						{
							
							fobj.weathercond = "Snowy";
						}
						else if(rbRaining.isSelected())
						{
							fobj.weathercond = "Rainy";
						}
						else if(rbFine.isSelected())
						{
							fobj.weathercond = "Normal";
						}
						else
						{
							fobj.weathercond = "Unknown";
						}
						
						//road condition selected
						if(rbRoundabout.isSelected())
						{
							fobj.roadcond = "Roundabout";
						}
						else if(rbOnewaystreet.isSelected())
						{
							
							fobj.roadcond = "One way street";
						}
						else if(rbsingleway.isSelected())
						{
							
							fobj.roadcond = "Single carriage way";
						}
						else if(rbdualway.isSelected())
						{
							
							fobj.roadcond = "Dual carriage way";
						}
						else if(rbSliproad.isSelected())
						{
							fobj.roadcond = "Slip road";
						}
						else
						{
							fobj.roadcond = "Unknown";
						}
						
						//road type selected
						if(rbDry.isSelected())
						{
							fobj.roadtype = "Dry";
						}
						else if(rbDamp.isSelected())
						{
							
							fobj.roadtype = "Wet";
						}
						else if(rbFrost.isSelected())
						{
							
							fobj.roadtype = "Ice";
						}
						else if(rbSnow.isSelected())
						{
							
							fobj.roadtype = "Snow";
						}
						else if(rbFlood.isSelected())
						{
							fobj.roadtype = "Flood";
						}
						else
						{
							fobj.roadtype = "Unknown";
						}
						
						fobj.speed = speedfield.getText();
						fobj.location = tflocation.getText();

				/*
				 * System.out.println(lightcond); System.out.println(weathercond);
				 * System.out.println(roadtype); System.out.println(roadcond);
				 * System.out.println(speed); System.out.println(location);
				 */
						
						
						//Call function to recommend speed using these values.
						
						Recommender robj = new Recommender();
						float recommendation = (float) robj.getRecommendation(fobj);
						//recommended speed pop up
						JOptionPane.showMessageDialog(null, "Recommended speed   " + (Float.parseFloat(fobj.speed) - (Float.parseFloat(fobj.speed) * recommendation)));
						
						
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

