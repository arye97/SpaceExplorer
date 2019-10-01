package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import SpaceExplorerClasses.*;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatusScreen {

	private JFrame frame;
	private GameEnvironment manager;
	
	private JLabel lblWarning = new javax.swing.JLabel();
	private String[] ActionsComboBoxOptions = new String[] {"Be Pilot", "Be Planet Searcher", "Use Item", "Sleep", "Repair Shields"};
	
	private CrewMember crewMember1;
	private CrewMember crewMember2;
	private CrewMember crewMember3;
	private CrewMember crewMember4;
	
	private Boolean needSpaceExplorer = false;
	private int crewSize;
	
	private int indexActionCrewMember1 = 0;
	private int indexActionCrewMember2 = 0;
	private int indexActionCrewMember3 = 0;
	private int indexActionCrewMember4 = 0;
	
	private Boolean setVisible1 = false;
	private Boolean setVisible2 = false;
	private Boolean setVisible3 = false;
	private Boolean setVisible4 = false;
	
	private Spaceship spaceship;
	
	JProgressBar healthProgressBar1 = new JProgressBar();
	JProgressBar energyProgressBar1 = new JProgressBar();
	JProgressBar hungerProgressBar1 = new JProgressBar();
	
	JProgressBar healthProgressBar2 = new JProgressBar();
	JProgressBar energyProgressBar2 = new JProgressBar();
	JProgressBar hungerProgressBar2 = new JProgressBar();
	
	JProgressBar healthProgressBar3 = new JProgressBar();
	JProgressBar energyProgressBar3 = new JProgressBar();
	JProgressBar hungerProgressBar3 = new JProgressBar();
	
	JProgressBar healthProgressBar4 = new JProgressBar();
	JProgressBar energyProgressBar4 = new JProgressBar();
	JProgressBar hungerProgressBar4 = new JProgressBar();
	
	/**
	 * 
	 * @param incomingManager - gameEnvironment to use
	 */
	public StatusScreen(GameEnvironment incomingManager) {
		manager = incomingManager;
		
		spaceship = manager.getSpaceship();
		
		crewMember1 = manager.getMemberOnIndex(0);
		crewMember2 = manager.getMemberOnIndex(1);
		setVisible1 = crewMember1.getMemberVisible();
		setVisible2 = crewMember2.getMemberVisible();
		
		crewSize = manager.getCrewSize();
		if(crewSize > 2) {
			crewMember3 = manager.getMemberOnIndex(2);
			setVisible3 = crewMember3.getMemberVisible();
			if(crewSize > 3) {
				crewMember4 = manager.getMemberOnIndex(3);
				setVisible4 = crewMember4.getMemberVisible();
			}
		}
			
		
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeStatusScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 153));
		frame.setBounds(50, 50, 1080, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		
		//Spaceship
		JLabel lblSpaceshipName = new JLabel(spaceship.getSpaceshipName());
		lblSpaceshipName.setHorizontalAlignment(SwingConstants.LEFT);
		lblSpaceshipName.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblSpaceshipName.setBounds(29, 35, 253, 48);
		frame.getContentPane().add(lblSpaceshipName);
		
		JLabel lblShieldLevel = new JLabel("Shield level:");
		lblShieldLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShieldLevel.setBounds(282, 46, 115, 33);
		frame.getContentPane().add(lblShieldLevel);
		
		JProgressBar shieldProgressBar = new JProgressBar();
		shieldProgressBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shieldProgressBar.setStringPainted(true);
		shieldProgressBar.setForeground(new Color(153, 204, 204));
		shieldProgressBar.setBounds(404, 46, 146, 33);
		shieldProgressBar.setMaximum(Spaceship.getMaxShieldHealth());
		shieldProgressBar.setValue(spaceship.getShieldHealth());
		frame.getContentPane().add(shieldProgressBar);
		
		JLabel maximumShieldLevel = new JLabel(Integer.toString(Spaceship.getMaxShieldHealth()));
		maximumShieldLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		maximumShieldLevel.setBounds(562, 46, 42, 33);
		frame.getContentPane().add(maximumShieldLevel);
		
		JLabel lblPetrol = new JLabel("Petrol:");
		lblPetrol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetrol.setBounds(624, 46, 69, 33);
		frame.getContentPane().add(lblPetrol);
		
		JProgressBar petrolProgressBar = new JProgressBar();
		petrolProgressBar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		petrolProgressBar.setStringPainted(true);
		petrolProgressBar.setForeground(new Color(153, 204, 204));
		petrolProgressBar.setBounds(693, 46, 146, 33);
		petrolProgressBar.setMaximum(Spaceship.getMaxPetrol());
		petrolProgressBar.setValue(spaceship.getPetrol());
		frame.getContentPane().add(petrolProgressBar);
		
		JLabel petrolMaximumLevel = new JLabel(Integer.toString(Spaceship.getMaxPetrol()));
		petrolMaximumLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		petrolMaximumLevel.setBounds(848, 46, 42, 33);
		frame.getContentPane().add(petrolMaximumLevel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(153, 204, 204));
		separator.setBounds(0, 122, 1080, 2);
		frame.getContentPane().add(separator);

		//CrewMember1
		if(setVisible1) {
		JLabel imageCrewMember1 = new JLabel("");
		imageCrewMember1.setIcon(new ImageIcon(StatusScreen.class.getResource(crewMember1.getImagePath())));
		imageCrewMember1.setBounds(43, 234, 128, 128);
		frame.getContentPane().add(imageCrewMember1);
		
		
		healthProgressBar1.setStringPainted(true);
		healthProgressBar1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		healthProgressBar1.setForeground(new Color(153, 204, 204));
		healthProgressBar1.setMaximum(CrewMember.getMaxHealth());
		healthProgressBar1.setValue(crewMember1.getHealth());
		healthProgressBar1.setBounds(328, 219, 135, 33);
		frame.getContentPane().add(healthProgressBar1);
		
		
		energyProgressBar1.setStringPainted(true);
		energyProgressBar1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		energyProgressBar1.setForeground(new Color(153, 204, 204));
		energyProgressBar1.setMaximum(CrewMember.getMaxEnergy());
		energyProgressBar1.setValue(crewMember1.getEnergy());
		energyProgressBar1.setBounds(328, 260, 135, 33);
		frame.getContentPane().add(energyProgressBar1);
		
		
		hungerProgressBar1.setStringPainted(true);
		hungerProgressBar1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hungerProgressBar1.setForeground(new Color(153, 204, 204));
		hungerProgressBar1.setMaximum(CrewMember.getMaxHunger());
		hungerProgressBar1.setValue(crewMember1.getHunger());
		hungerProgressBar1.setBounds(328, 301, 135, 33);
		frame.getContentPane().add(hungerProgressBar1);
		
		JLabel lblActionsLeftCrewMember1 = new JLabel(Integer.toString(crewMember1.getActionsLeft()) + " / 2");
		lblActionsLeftCrewMember1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActionsLeftCrewMember1.setBounds(328, 344, 42, 33);
		frame.getContentPane().add(lblActionsLeftCrewMember1);
		
		JLabel lblCrewMemberType1 = new JLabel(crewMember1.getTag() + ": " + crewMember1.getName());
		lblCrewMemberType1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCrewMemberType1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewMemberType1.setBounds(73, 173, 279, 33);
		frame.getContentPane().add(lblCrewMemberType1);
		
		JLabel lblMaxHealth1 = new JLabel(Integer.toString(CrewMember.getMaxHealth()));
		lblMaxHealth1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxHealth1.setBounds(472, 219, 42, 33);
		frame.getContentPane().add(lblMaxHealth1);
		
		JLabel lblMaxEnergy1 = new JLabel(Integer.toString(CrewMember.getMaxEnergy()));
		lblMaxEnergy1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxEnergy1.setBounds(472, 260, 42, 33);
		frame.getContentPane().add(lblMaxEnergy1);
		
		JLabel lblMaxHunger1 = new JLabel(Integer.toString(CrewMember.getMaxHunger()));
		lblMaxHunger1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxHunger1.setBounds(472, 301, 42, 33);
		frame.getContentPane().add(lblMaxHunger1);
		
		JComboBox cbActionsCrewMember1 = new JComboBox();
		cbActionsCrewMember1.setBackground(new Color(153, 204, 204));
		cbActionsCrewMember1.setModel(new DefaultComboBoxModel(ActionsComboBoxOptions));
		cbActionsCrewMember1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbActionsCrewMember1.setBounds(29, 391, 176, 33);
		cbActionsCrewMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexActionCrewMember1 = cbActionsCrewMember1.getSelectedIndex();
				
			}
		});
		frame.getContentPane().add(cbActionsCrewMember1);
		
		JButton btnTakeActionCrewMember1 = new JButton("Take Action");
		btnTakeActionCrewMember1.setBackground(new Color(153, 204, 204));
		btnTakeActionCrewMember1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTakeActionCrewMember1.setBounds(259, 391, 146, 33);
		btnTakeActionCrewMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				takeAction(crewMember1, ActionsComboBoxOptions[indexActionCrewMember1]);
				updateStatusOfMember(1);
				shieldProgressBar.setValue(spaceship.getShieldHealth());
				lblActionsLeftCrewMember1.setText(Integer.toString(crewMember1.getActionsLeft()) + " / 2");
			}
		});
		frame.getContentPane().add(btnTakeActionCrewMember1);
		
		JLabel lblHunger1 = new JLabel("Hunger:");
		lblHunger1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHunger1.setBounds(215, 301, 96, 33);
		frame.getContentPane().add(lblHunger1);
		
		JLabel lblEnergy1 = new JLabel("Energy:");
		lblEnergy1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnergy1.setBounds(215, 260, 96, 33);
		frame.getContentPane().add(lblEnergy1);
		
		JLabel lblHealth1 = new JLabel("Health:");
		lblHealth1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHealth1.setBounds(215, 219, 96, 33);
		frame.getContentPane().add(lblHealth1);
		
		JLabel lblActionsLeft1 = new JLabel("Actions left:");
		lblActionsLeft1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActionsLeft1.setBounds(215, 344, 106, 33);
		frame.getContentPane().add(lblActionsLeft1);
		
		if (crewSize > 2) {
		imageCrewMember1.setBounds(58, 130, 128, 128);
		lblMaxHunger1.setBounds(487, 197, 42, 33);
		lblMaxEnergy1.setBounds(487, 156, 42, 33);
		lblMaxHealth1.setBounds(487, 115, 42, 33);
		lblCrewMemberType1.setBounds(56, 90, 260, 33);
		lblActionsLeftCrewMember1.setBounds(343, 240, 42, 33);
		btnTakeActionCrewMember1.setBounds(274, 287, 146, 33);
		cbActionsCrewMember1.setBounds(44, 287, 176, 33);
		hungerProgressBar1.setBounds(343, 197, 135, 33);
		energyProgressBar1.setBounds(343, 156, 135, 33);
		healthProgressBar1.setBounds(343, 115, 135, 33);
		lblActionsLeft1.setBounds(230, 240, 106, 33);
		lblHealth1.setBounds(230, 115, 96, 33);
		lblEnergy1.setBounds(230, 156, 96, 33);
		lblHunger1.setBounds(230, 197, 96, 33);
		}
		}
		else {
			JLabel lblCrewMemberType1 = new JLabel(crewMember1.getTag() + ": " + crewMember1.getName() + " Died");
			lblCrewMemberType1.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblCrewMemberType1.setHorizontalAlignment(SwingConstants.LEFT);
			lblCrewMemberType1.setBounds(56, 150, 260, 33);
			frame.getContentPane().add(lblCrewMemberType1);
			
		}
		
		//Crew Member 2
		
		if(setVisible2) {
		
		JLabel lblActionsLeftCrewMember2 = new JLabel(Integer.toString(crewMember2.getActionsLeft()) + " / 2");
		lblActionsLeftCrewMember2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActionsLeftCrewMember2.setBounds(836, 344, 42, 33);
		frame.getContentPane().add(lblActionsLeftCrewMember2);
		
		hungerProgressBar2.setStringPainted(true);
		hungerProgressBar2.setForeground(new Color(153, 204, 204));
		hungerProgressBar2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hungerProgressBar2.setMaximum(CrewMember.getMaxHunger());
		hungerProgressBar2.setValue(crewMember2.getHunger());
		hungerProgressBar2.setBounds(836, 301, 135, 33);
		frame.getContentPane().add(hungerProgressBar2);
		
		energyProgressBar2.setStringPainted(true);
		energyProgressBar2.setForeground(new Color(153, 204, 204));
		energyProgressBar2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		energyProgressBar2.setMaximum(CrewMember.getMaxEnergy());
		energyProgressBar2.setValue(crewMember2.getEnergy());
		energyProgressBar2.setBounds(836, 260, 135, 33);
		frame.getContentPane().add(energyProgressBar2);
		
		healthProgressBar2.setStringPainted(true);
		healthProgressBar2.setForeground(new Color(153, 204, 204));
		healthProgressBar2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		healthProgressBar2.setMaximum(CrewMember.getMaxHealth());
		healthProgressBar2.setValue(crewMember2.getHealth());
		healthProgressBar2.setBounds(836, 219, 135, 33);
		frame.getContentPane().add(healthProgressBar2);
		
		JLabel lblCrewMemberType2 = new JLabel(crewMember2.getTag() + ": " + crewMember2.getName());
		lblCrewMemberType2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCrewMemberType2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrewMemberType2.setBounds(557, 173, 260, 33);
		frame.getContentPane().add(lblCrewMemberType2);
		
		JLabel lblMaxHealth2 = new JLabel(Integer.toString(CrewMember.getMaxHealth()));
		lblMaxHealth2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxHealth2.setBounds(980, 219, 42, 33);
		frame.getContentPane().add(lblMaxHealth2);
		
		JLabel lblMaxEnergy2 = new JLabel(Integer.toString(CrewMember.getMaxEnergy()));
		lblMaxEnergy2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxEnergy2.setBounds(980, 260, 42, 33);
		frame.getContentPane().add(lblMaxEnergy2);
		
		JLabel lblMaxHunger2 = new JLabel(Integer.toString(CrewMember.getMaxHunger()));
		lblMaxHunger2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaxHunger2.setBounds(980, 301, 42, 33);
		frame.getContentPane().add(lblMaxHunger2);
		
		JLabel imageCrewMember2 = new JLabel("");
		imageCrewMember2.setIcon(new ImageIcon(StatusScreen.class.getResource(crewMember2.getImagePath())));
		imageCrewMember2.setBounds(557, 234, 128, 128);
		frame.getContentPane().add(imageCrewMember2);
		
		JComboBox cbActionsCrewMember2 = new JComboBox();
		cbActionsCrewMember2.setModel(new DefaultComboBoxModel(ActionsComboBoxOptions));
		cbActionsCrewMember2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbActionsCrewMember2.setBackground(new Color(153, 204, 204));
		cbActionsCrewMember2.setBounds(549, 391, 176, 33);
		cbActionsCrewMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indexActionCrewMember2 = cbActionsCrewMember2.getSelectedIndex();
			}
		});
		frame.getContentPane().add(cbActionsCrewMember2);
		
		JButton btnTakeActionCrewMember2 = new JButton("Take Action");
		btnTakeActionCrewMember2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTakeActionCrewMember2.setBackground(new Color(153, 204, 204));
		btnTakeActionCrewMember2.setBounds(767, 391, 146, 33);
		btnTakeActionCrewMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				takeAction(crewMember2, ActionsComboBoxOptions[indexActionCrewMember2]);
				updateStatusOfMember(2);
				shieldProgressBar.setValue(spaceship.getShieldHealth());
				lblActionsLeftCrewMember2.setText(Integer.toString(crewMember2.getActionsLeft()) + " / 2");
			}
		});
		frame.getContentPane().add(btnTakeActionCrewMember2);
		JLabel lblActionsLeft2 = new JLabel("Actions left:");
		lblActionsLeft2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActionsLeft2.setBounds(723, 344, 106, 33);
		frame.getContentPane().add(lblActionsLeft2);
		
		JLabel lblHunger2 = new JLabel("Hunger:");
		lblHunger2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHunger2.setBounds(723, 301, 96, 33);
		frame.getContentPane().add(lblHunger2);
		
		JLabel lblEnergy2 = new JLabel("Energy:");
		lblEnergy2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnergy2.setBounds(723, 260, 96, 33);
		frame.getContentPane().add(lblEnergy2);
		
		JLabel lblHealth2 = new JLabel("Health:");
		lblHealth2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHealth2.setBounds(723, 219, 96, 33);
		frame.getContentPane().add(lblHealth2);
		
		
		if(crewSize > 2) {
			imageCrewMember2.setBounds(572, 130, 128, 128);
			lblMaxHunger2.setBounds(997, 197, 42, 33);
			lblMaxEnergy2.setBounds(997, 156, 42, 33);
			lblMaxHealth2.setBounds(997, 115, 42, 33);
			lblCrewMemberType2.setBounds(567, 90, 260, 33);
			healthProgressBar2.setBounds(851, 115, 135, 33);
			energyProgressBar2.setBounds(851, 156, 135, 33);
			hungerProgressBar2.setBounds(851, 197, 135, 33);
			lblActionsLeftCrewMember2.setBounds(851, 240, 42, 33);
			cbActionsCrewMember2.setBounds(564, 287, 176, 33);
			btnTakeActionCrewMember2.setBounds(782, 287, 146, 33);
			lblHealth2.setBounds(738, 115, 96, 33);
			lblEnergy2.setBounds(738, 156, 96, 33);
			lblHunger2.setBounds(738, 197, 96, 33);
			lblActionsLeft2.setBounds(738, 240, 106, 33);
		}
		}
		else {
			JLabel lblCrewMemberType2 = new JLabel(crewMember2.getTag() + ": " + crewMember2.getName() + " Died");
			lblCrewMemberType2.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblCrewMemberType2.setHorizontalAlignment(SwingConstants.LEFT);
			lblCrewMemberType2.setBounds(567, 150, 260, 33);
			frame.getContentPane().add(lblCrewMemberType2);
			
		}
		
	
		//Crew Member 3
		if(setVisible3) {
			JLabel imageCrewMember3 = new JLabel("");
			imageCrewMember3.setIcon(new ImageIcon(StatusScreen.class.getResource(crewMember3.getImagePath())));
			imageCrewMember3.setBounds(308, 372, 128, 128);
			frame.getContentPane().add(imageCrewMember3);
			
			JLabel lblActionsLeftCrewMember3 = new JLabel(Integer.toString(crewMember3.getActionsLeft()) + " / 2");
			lblActionsLeftCrewMember3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblActionsLeftCrewMember3.setBounds(595, 481, 42, 33);
			frame.getContentPane().add(lblActionsLeftCrewMember3);
			
			hungerProgressBar3.setStringPainted(true);
			hungerProgressBar3.setForeground(new Color(153, 204, 204));
			hungerProgressBar3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			hungerProgressBar3.setMaximum(CrewMember.getMaxHunger());
			hungerProgressBar3.setValue(crewMember3.getHunger());
			hungerProgressBar3.setBounds(593, 438, 135, 33);
			frame.getContentPane().add(hungerProgressBar3);
			
			energyProgressBar3.setStringPainted(true);
			energyProgressBar3.setForeground(new Color(153, 204, 204));
			energyProgressBar3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			energyProgressBar3.setMaximum(CrewMember.getMaxEnergy());
			energyProgressBar3.setValue(crewMember3.getEnergy());
			energyProgressBar3.setBounds(593, 397, 135, 33);
			frame.getContentPane().add(energyProgressBar3);
			
			healthProgressBar3.setStringPainted(true);
			healthProgressBar3.setForeground(new Color(153, 204, 204));
			healthProgressBar3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			healthProgressBar3.setMaximum(CrewMember.getMaxHealth());
			healthProgressBar3.setValue(crewMember3.getHealth());
			healthProgressBar3.setBounds(593, 354, 135, 33);
			frame.getContentPane().add(healthProgressBar3);
			
			JLabel lblCrewMemberType3 = new JLabel(crewMember3.getTag() + ": " + crewMember3.getName());
			lblCrewMemberType3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCrewMemberType3.setHorizontalAlignment(SwingConstants.LEFT);
			lblCrewMemberType3.setBounds(307, 324, 260, 33);
			frame.getContentPane().add(lblCrewMemberType3);
			
			JLabel lblMaxHealth3 = new JLabel(Integer.toString(CrewMember.getMaxHealth()));
			lblMaxHealth3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMaxHealth3.setBounds(737, 354, 42, 33);
			frame.getContentPane().add(lblMaxHealth3);
			
			JLabel lblMaxEnergy3 = new JLabel(Integer.toString(CrewMember.getMaxEnergy()));
			lblMaxEnergy3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMaxEnergy3.setBounds(737, 397, 42, 33);
			frame.getContentPane().add(lblMaxEnergy3);
			
			JLabel lblMaxHunger3 = new JLabel(Integer.toString(CrewMember.getMaxHunger()));
			lblMaxHunger3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblMaxHunger3.setBounds(737, 438, 42, 33);
			frame.getContentPane().add(lblMaxHunger3);
			
			JLabel lblHunger3 = new JLabel("Hunger:");
			lblHunger3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHunger3.setBounds(480, 438, 96, 33);
			frame.getContentPane().add(lblHunger3);
			
			JLabel lblEnergy3 = new JLabel("Energy:");
			lblEnergy3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblEnergy3.setBounds(480, 397, 96, 33);
			frame.getContentPane().add(lblEnergy3);
			
			JLabel lblHealth3 = new JLabel("Health:");
			lblHealth3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblHealth3.setBounds(480, 354, 96, 33);
			frame.getContentPane().add(lblHealth3);
			
			JLabel lblActionsLeft3 = new JLabel("Actions left:");
			lblActionsLeft3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblActionsLeft3.setBounds(480, 481, 106, 33);
			frame.getContentPane().add(lblActionsLeft3);
			
			JComboBox cbActionsCrewMember3 = new JComboBox();
			cbActionsCrewMember3.setModel(new DefaultComboBoxModel(ActionsComboBoxOptions));
			cbActionsCrewMember3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			cbActionsCrewMember3.setBackground(new Color(153, 204, 204));
			cbActionsCrewMember3.setBounds(298, 528, 176, 33);
			cbActionsCrewMember3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					indexActionCrewMember3 = cbActionsCrewMember3.getSelectedIndex();
				}
			});
			frame.getContentPane().add(cbActionsCrewMember3);
			
			JButton btnTakeActionCrewMember3 = new JButton("Take Action");
			btnTakeActionCrewMember3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnTakeActionCrewMember3.setBackground(new Color(153, 204, 204));
			btnTakeActionCrewMember3.setBounds(528, 528, 146, 33);
			btnTakeActionCrewMember3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					takeAction(crewMember3, ActionsComboBoxOptions[indexActionCrewMember3]);
					updateStatusOfMember(3);
					shieldProgressBar.setValue(spaceship.getShieldHealth());
					lblActionsLeftCrewMember3.setText(Integer.toString(crewMember3.getActionsLeft()) + " / 2");
				}
			});
			frame.getContentPane().add(btnTakeActionCrewMember3);
			
			
			
			if (crewSize > 3) {
				lblHealth3.setBounds(240, 365, 96, 33);
				lblActionsLeft3.setBounds(240, 492, 106, 33);
				lblEnergy3.setBounds(240, 408, 96, 33);
				lblHunger3.setBounds(240, 449, 96, 33);
				lblMaxHunger3.setBounds(487, 449, 42, 33);
				lblMaxEnergy3.setBounds(487, 408, 42, 33);
				lblMaxHealth3.setBounds(487, 365, 42, 33);
				lblCrewMemberType3.setBounds(62, 334, 260, 33);
				healthProgressBar3.setBounds(343, 365, 135, 33);
				energyProgressBar3.setBounds(343, 408, 135, 33);
				hungerProgressBar3.setBounds(343, 449, 135, 33);
				lblActionsLeftCrewMember3.setBounds(345, 492, 42, 33);
				cbActionsCrewMember3.setBounds(48, 539, 176, 33);
				btnTakeActionCrewMember3.setBounds(278, 539, 146, 33);
				imageCrewMember3.setBounds(58, 383, 128, 128);
			}
		}
		else if(crewSize > 2) {
			JLabel lblCrewMemberType3 = new JLabel(crewMember3.getTag() + ": " + crewMember3.getName() + " Died");
			lblCrewMemberType3.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblCrewMemberType3.setHorizontalAlignment(SwingConstants.LEFT);
			lblCrewMemberType3.setBounds(56, 335, 260, 33);
			frame.getContentPane().add(lblCrewMemberType3);
		}
		
			if (setVisible4) {
				//Crew Member 4
				JLabel lblActionsLeftCrewMember4 = new JLabel(Integer.toString(crewMember4.getActionsLeft())+ " / 2");
				lblActionsLeftCrewMember4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblActionsLeftCrewMember4.setBounds(861, 492, 42, 33);
				frame.getContentPane().add(lblActionsLeftCrewMember4);
				
				hungerProgressBar4.setMaximum(CrewMember.getMaxHunger());
				hungerProgressBar4.setValue(crewMember4.getHunger());
				hungerProgressBar4.setStringPainted(true);
				hungerProgressBar4.setForeground(new Color(153, 204, 204));
				hungerProgressBar4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				hungerProgressBar4.setBounds(851, 449, 125, 33);
				frame.getContentPane().add(hungerProgressBar4);

				energyProgressBar4.setMaximum(CrewMember.getMaxEnergy());
				energyProgressBar4.setValue(crewMember4.getEnergy());
				energyProgressBar4.setStringPainted(true);
				energyProgressBar4.setForeground(new Color(153, 204, 204));
				energyProgressBar4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				energyProgressBar4.setBounds(851, 408, 125, 33);
				frame.getContentPane().add(energyProgressBar4);
				
				healthProgressBar4.setMaximum(CrewMember.getMaxHealth());
				healthProgressBar4.setValue(crewMember4.getHealth());
				healthProgressBar4.setStringPainted(true);
				healthProgressBar4.setForeground(new Color(153, 204, 204));
				healthProgressBar4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				healthProgressBar4.setBounds(851, 365, 125, 33);
				frame.getContentPane().add(healthProgressBar4);
				
				JLabel lblCrewMemberType4 = new JLabel(crewMember4.getTag() + ": " + crewMember4.getName());
				lblCrewMemberType4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblCrewMemberType4.setHorizontalAlignment(SwingConstants.LEFT);
				lblCrewMemberType4.setBounds(564, 334, 260, 33);
				frame.getContentPane().add(lblCrewMemberType4);
				
				JLabel lblMaxHealth4 = new JLabel(Integer.toString(CrewMember.getMaxHealth()));
				lblMaxHealth4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblMaxHealth4.setBounds(997, 365, 42, 33);
				frame.getContentPane().add(lblMaxHealth4);
				
				JLabel lblMaxEnergy4 = new JLabel(Integer.toString(CrewMember.getMaxEnergy()));
				lblMaxEnergy4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblMaxEnergy4.setBounds(997, 408, 42, 33);
				frame.getContentPane().add(lblMaxEnergy4);
				
				JLabel lblMaxHunger4 = new JLabel(Integer.toString(CrewMember.getMaxHunger()));
				lblMaxHunger4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblMaxHunger4.setBounds(997, 449, 42, 33);
				frame.getContentPane().add(lblMaxHunger4);
				
				JLabel imageCrewMember4 = new JLabel("");
				imageCrewMember4.setIcon(new ImageIcon(StatusScreen.class.getResource(crewMember4.getImagePath())));
				imageCrewMember4.setBounds(572, 383, 128, 128);
				frame.getContentPane().add(imageCrewMember4);
				
				JLabel lblActionsLeft4 = new JLabel("Actions left:");
				lblActionsLeft4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblActionsLeft4.setBounds(738, 492, 106, 33);
				frame.getContentPane().add(lblActionsLeft4);
				
				JLabel lblHunger4 = new JLabel("Hunger:");
				lblHunger4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblHunger4.setBounds(738, 449, 96, 33);
				frame.getContentPane().add(lblHunger4);
				
				JLabel lblEnergy4 = new JLabel("Energy:");
				lblEnergy4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblEnergy4.setBounds(738, 408, 96, 33);
				frame.getContentPane().add(lblEnergy4);
				
				JLabel lblHealth4 = new JLabel("Health:");
				lblHealth4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblHealth4.setBounds(738, 365, 96, 33);
				frame.getContentPane().add(lblHealth4);

				JComboBox cbActionsCrewMember4 = new JComboBox();
				cbActionsCrewMember4.setModel(new DefaultComboBoxModel(ActionsComboBoxOptions));
				cbActionsCrewMember4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				cbActionsCrewMember4.setBackground(new Color(153, 204, 204));
				cbActionsCrewMember4.setBounds(562, 539, 176, 33);
				cbActionsCrewMember4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						indexActionCrewMember4 = cbActionsCrewMember4.getSelectedIndex();
					}
				});
				frame.getContentPane().add(cbActionsCrewMember4);
				
				JButton btnTakeActionCrewMember4 = new JButton("Take Action");
				btnTakeActionCrewMember4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnTakeActionCrewMember4.setBackground(new Color(153, 204, 204));
				btnTakeActionCrewMember4.setBounds(792, 539, 146, 33);
				btnTakeActionCrewMember4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						takeAction(crewMember4, ActionsComboBoxOptions[indexActionCrewMember4]);
						updateStatusOfMember(4);
						shieldProgressBar.setValue(spaceship.getShieldHealth());
						lblActionsLeftCrewMember4.setText(Integer.toString(crewMember4.getActionsLeft()) + " / 2");
					}
				});
				frame.getContentPane().add(btnTakeActionCrewMember4);
		}
			else if(crewSize > 3) {
				JLabel lblCrewMemberType4 = new JLabel(crewMember4.getTag() + ": " + crewMember4.getName() + " Died");
				lblCrewMemberType4.setFont(new Font("Tahoma", Font.PLAIN, 22));
				lblCrewMemberType4.setHorizontalAlignment(SwingConstants.LEFT);
				lblCrewMemberType4.setBounds(56, 335, 260, 33);
				frame.getContentPane().add(lblCrewMemberType4);
			}
		
		
		String warning2CrewMembers = "You need 2 Pilots";
		String warning3CrewMembers = "You need 2 Pilots and 1 Planet Searcher";
		lblWarning.setHorizontalAlignment(SwingConstants.LEFT);
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWarning.setBounds(393, 528, 341, 33);
		if (crewSize > 2){
			lblWarning.setText(warning3CrewMembers);
			needSpaceExplorer = true;
		} else {
			lblWarning.setText(warning2CrewMembers);
		}
		frame.getContentPane().add(lblWarning);
		
		
		//Days
		JLabel lblDays = new JLabel(Integer.toString(manager.getCurrentDay()));
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDays.setIcon(new ImageIcon(StatusScreen.class.getResource("/Images/sun.png")));
		lblDays.setBounds(962, 4, 96, 77);
		frame.getContentPane().add(lblDays);
		
		
		JLabel lblDayRandomEvent = new JLabel(manager.getRandomDayEvent());
		lblDayRandomEvent.setHorizontalAlignment(SwingConstants.LEFT);
		lblDayRandomEvent.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDayRandomEvent.setBounds(729, 532, 322, 22);
		frame.getContentPane().add(lblDayRandomEvent);
		
		
		 
		JButton btnPilotMe = new JButton("Pilot Me");
		btnPilotMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.hasEnoughPilots()) {
					if(needSpaceExplorer == false) {
						manager.launchVisitPlanetsScreen();
						manager.setScore(manager.getScore()+20);
						finishedWindow();
					}else if (needSpaceExplorer == true) {
						if(manager.hasPlanetSearcher()) 
						{
							manager.launchVisitPlanetsScreen();
							manager.setScore(manager.getScore()+20);
							finishedWindow();
						}
					}
					
				}
			}
		});
		btnPilotMe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPilotMe.setBackground(new Color(153, 204, 204));
		btnPilotMe.setIcon(new ImageIcon(StatusScreen.class.getResource("/Images/MySpaceShip.png")));
		btnPilotMe.setBounds(395, 554, 253, 67);
		frame.getContentPane().add(btnPilotMe);
		
		
		
		JButton btnGoToNextDay = new JButton("Next Day");
		btnGoToNextDay.setIcon(new ImageIcon(StatusScreen.class.getResource("/Images/sun.png")));
		btnGoToNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.NewDay();
				lblDays.setText(Integer.toString(manager.getCurrentDay()));
				lblDayRandomEvent.setText(manager.getRandomDayEvent());
				updateStatusOfMember(1);
				updateStatusOfMember(2);
				if(crewSize >2) {
					updateStatusOfMember(3);
					if(crewSize>3) {
					updateStatusOfMember(4);
					}
				}
				if(manager.checkGameOver()){
					manager.launchGameOverScreen();
					finishedWindow();
				} else {
				manager.launchStatusScreen();
				finishedWindow();
				}
			}
		});
		btnGoToNextDay.setBackground(new Color(153, 204, 204));
		btnGoToNextDay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGoToNextDay.setBounds(729, 554, 238, 67);
		frame.getContentPane().add(btnGoToNextDay);
		
		
		JButton btnGoToSpaceOutpost = new JButton("Space Outpost");
		btnGoToSpaceOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchSpaceOutpostScreen();
			}
		});
		btnGoToSpaceOutpost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGoToSpaceOutpost.setBackground(new Color(153, 204, 204));
		btnGoToSpaceOutpost.setIcon(new ImageIcon(StatusScreen.class.getResource("/Images/storeIcon.png")));
		btnGoToSpaceOutpost.setBounds(43, 554, 271, 67);
		frame.getContentPane().add(btnGoToSpaceOutpost);
		
		
		if (crewSize > 2) {
			//Spaceship Status
			
			separator.setBounds(0, 74, 1080, 2);
			petrolMaximumLevel.setBounds(924, 22, 42, 33);
			petrolProgressBar.setBounds(776, 22, 146, 33);
			lblPetrol.setBounds(681, 22, 69, 33);
			maximumShieldLevel.setBounds(587, 22, 42, 33);
			shieldProgressBar.setBounds(438, 22, 146, 33);
			lblShieldLevel.setBounds(297, 22, 115, 33);
			lblSpaceshipName.setBounds(45, 11, 253, 48);
			
			
			//Buttons
			lblWarning.setBounds(369, 584, 341, 33);
			lblDayRandomEvent.setBounds(705, 584, 299, 22);
			btnGoToSpaceOutpost.setBounds(44, 613, 271, 67);
			btnGoToNextDay.setBounds(730, 613, 238, 67);
			btnPilotMe.setBounds(396, 613, 253, 67);
			
		}
	}
	
	public void updateStatusOfMember(int member) {
		switch(member) {
		case 0:
			break;
		case 1:
			hungerProgressBar1.setValue(crewMember1.getHunger());
			healthProgressBar1.setValue(crewMember1.getHealth());
			energyProgressBar1.setValue(crewMember1.getEnergy());
			crewMember1.getIsDead();
			setVisible1 = crewMember1.getMemberVisible();
			break;
		case 2:
			hungerProgressBar2.setValue(crewMember2.getHunger());
			healthProgressBar2.setValue(crewMember2.getHealth());
			energyProgressBar2.setValue(crewMember2.getEnergy());
			crewMember2.getIsDead();
			setVisible2 = crewMember2.getMemberVisible();
			break;
		case 3:
			hungerProgressBar3.setValue(crewMember3.getHunger());
			healthProgressBar3.setValue(crewMember3.getHealth());
			energyProgressBar3.setValue(crewMember3.getEnergy());
			crewMember3.getIsDead();
			setVisible3 = crewMember3.getMemberVisible();
			break;
		case 4:
			hungerProgressBar4.setValue(crewMember4.getHunger());
			healthProgressBar4.setValue(crewMember4.getHealth());
			energyProgressBar4.setValue(crewMember4.getEnergy());
			crewMember4.getIsDead();
			setVisible4 = crewMember4.getMemberVisible();
			break;
		}
	}
	
	
	public void takeAction(CrewMember crewMember, String action) {
		
		if(crewMember.haveActionsLeft()) {
			switch(action) {
			
				case "Use Item":
					manager.launchInventoryScreen(crewMember);
					finishedWindow();
					break;
					
				case "Be Pilot":
					crewMember.Pilot();
					break;
					
				case "Be Planet Searcher":
					crewMember.PlanetSearcher();
					break;
					
				case "Sleep":
					crewMember.sleep();
					break;
					
				case "Repair Shields":
					crewMember.repairShields();
					break;
			}
			//System.out.println(manager.getCrew().getPilotCounter());
		}
	}
}