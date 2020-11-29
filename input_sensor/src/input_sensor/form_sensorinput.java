package input_sensor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JFormattedTextField;
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

public class form_sensorinput{

	private JFrame frame;
	public JTextField speedfield;
	public JFormattedTextField tflatitude;
	public JFormattedTextField tflongitude;
	public JLabel show_validationtext;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form_sensorinput window = new form_sensorinput();
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
		frame.setBounds(100, 100, 614, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel1.setBackground(Color.BLACK);
		
		JLabel show_validationtext = new JLabel("");
		show_validationtext.setBackground(Color.WHITE);
		show_validationtext.setForeground(Color.RED);
		
		JFormattedTextField tflatitude = new JFormattedTextField();
		tflatitude.setColumns(12);
		/*
		 * tflatitude.addKeyListener(new KeyAdapter() { public void keyPressed(KeyEvent
		 * ke) { String value = tflatitude.getValue().toString(); int key =
		 * ke.getKeyCode(); if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' &&
		 * ke.getKeyChar() == '-' && ke.getKeyChar() == '.') && (ke.getKeyChar() >= '0'
		 * && ke.getKeyChar() <= '9' && ke.getKeyChar() == '.') || (key ==
		 * KeyEvent.VK_BACK_SPACE)) { tflatitude.setEditable(true);
		 * show_validationtext.setText("");
		 * 
		 * } else { tflatitude.setEditable(false);
		 * show_validationtext.setText("* Enter only numeric digits(0-9)and signs"); } }
		 * });
		 */
		
		JFormattedTextField tflongitude = new JFormattedTextField();
		tflongitude.setColumns(12);
		/*
		 * tflongitude.addKeyListener(new KeyAdapter() { public void keyPressed(KeyEvent
		 * ke) { String value = tflongitude.getValue().toString(); int key =
		 * ke.getKeyCode(); if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' &&
		 * ke.getKeyChar() == '-' && ke.getKeyChar() == '.') && (ke.getKeyChar() >= '0'
		 * && ke.getKeyChar() <= '9' && ke.getKeyChar() == '.') || (key ==
		 * KeyEvent.VK_BACK_SPACE)) { tflongitude.setEditable(true);
		 * show_validationtext.setText("");
		 * 
		 * } else { tflongitude.setEditable(false);
		 * show_validationtext.setText("* Enter only numeric digits(0-9) and signs"); }
		 * } });
		 */
		
		
		
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
		
		JLabel latitudelbl = new JLabel("Latitude : ");
		latitudelbl.setForeground(Color.WHITE);
		
		JLabel longitudelbl = new JLabel("Longitude : ");
		longitudelbl.setForeground(Color.WHITE);
		
		JLabel roadtypelbl = new JLabel("Road Type : ");
		roadtypelbl.setForeground(Color.WHITE);
		
		JRadioButton rbsingleway = new JRadioButton("Single carriage way");
		buttonGroup_1.add(rbsingleway);
		rbsingleway.setSelected(true);
		rbsingleway.setForeground(Color.WHITE);
		
		JRadioButton rbdualway = new JRadioButton("Dual carriage way");
		buttonGroup_1.add(rbdualway);
		rbdualway.setForeground(Color.WHITE);
		
		JLabel roadconditionlbl = new JLabel("Road Condition : ");
		roadconditionlbl.setForeground(Color.WHITE);
		
		JRadioButton rbDry = new JRadioButton("Dry");
		buttonGroup_2.add(rbDry);
		rbDry.setSelected(true);
		rbDry.setForeground(Color.WHITE);
		
		JRadioButton rbDamp = new JRadioButton("Wet/Damp");
		buttonGroup_2.add(rbDamp);
		rbDamp.setForeground(Color.WHITE);
		
		JLabel wconditionlbl = new JLabel("Weather Condition : ");
		wconditionlbl.setForeground(Color.WHITE);
		
		JRadioButton rbFine = new JRadioButton("Fine (with no high winds)");
		buttonGroup_3.add(rbFine);
		rbFine.setSelected(true);
		rbFine.setForeground(Color.WHITE);
		
		JRadioButton rbRaining = new JRadioButton("Raining (with no high winds)");
		buttonGroup_3.add(rbRaining);
		rbRaining.setForeground(Color.WHITE);
		
		JButton Submitbtn = new JButton("Submit");
		Submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Recommended speed");
			}
		});
		
		Submitbtn.setBackground(Color.LIGHT_GRAY);
		
		JLabel titlelbl = new JLabel("Speed Recommendation System");
		titlelbl.setForeground(Color.RED);
		
		JRadioButton rbDaylight = new JRadioButton("Daylight");
		buttonGroup.add(rbDaylight);
		rbDaylight.setSelected(true);
		rbDaylight.setForeground(Color.WHITE);
		
		JRadioButton rbDarknessLights = new JRadioButton("Darkness - lights lit");
		buttonGroup.add(rbDarknessLights);
		rbDarknessLights.setForeground(Color.WHITE);
		
		JRadioButton rbDarknessLighting = new JRadioButton("Darkness - lighting unknown");
		buttonGroup.add(rbDarknessLighting);
		rbDarknessLighting.setForeground(Color.WHITE);
		
		
		
		
		
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(195)
					.addComponent(titlelbl, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addComponent(roadconditionlbl, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(rbDry, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(rbDamp, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addComponent(wconditionlbl, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addComponent(rbFine, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(117)
					.addComponent(rbRaining, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(221)
					.addComponent(Submitbtn, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(lightinglbl, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(rbDaylight, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(rbDarknessLights, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(rbDarknessLighting))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(speedlbl, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(speedfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(109)
					.addComponent(show_validationtext, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(roadtypelbl, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addComponent(rbsingleway, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(rbdualway, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addComponent(latitudelbl, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tflatitude, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(83)
							.addComponent(longitudelbl, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tflongitude, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(4)
					.addComponent(titlelbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addComponent(speedlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(speedfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addComponent(lightinglbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addComponent(rbDaylight))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(2)
							.addComponent(rbDarknessLights))
						.addComponent(rbDarknessLighting))
					.addGap(26)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(latitudelbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(tflatitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(longitudelbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(tflongitude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(16)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(4)
							.addComponent(roadtypelbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(3)
							.addComponent(rbsingleway))
						.addComponent(rbdualway))
					.addGap(31)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(2)
							.addComponent(roadconditionlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(rbDry)
						.addComponent(rbDamp))
					.addGap(12)
					.addComponent(wconditionlbl, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(1)
							.addComponent(rbFine))
						.addComponent(rbRaining))
					.addGap(7)
					.addComponent(show_validationtext)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Submitbtn)
					.addGap(24))
		);
		panel1.setLayout(gl_panel1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 608, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
 }

