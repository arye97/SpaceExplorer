package GUI;
import java.awt.EventQueue;

import SpaceExplorerClasses.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import CrewTypes.Captain;
import CrewTypes.Doctor;
import CrewTypes.Engineer;
import CrewTypes.Researcher;
import CrewTypes.Soldier;
import CrewTypes.Technician;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CrewSelectionScreen {

	private JFrame frame;
	private GameEnvironment manager;
	
	private JTextField textNameShipField;
	private JTextField txtNameDoctor;
	private JTextField txtNameEngineer;
	private JTextField txtNameResearcher;
	private JTextField txtNameCaptain;
	private JTextField txtNameTechnician;
	private JTextField txtNameSoldier;
	
	private JLabel jLabel1 = new javax.swing.JLabel("Crew Member");
	private JLabel jLabel2 = new javax.swing.JLabel("Crew Member");
	private JLabel jLabel3 = new javax.swing.JLabel("Crew Member");
	private JLabel jLabel4 = new javax.swing.JLabel("Crew Member");
	
	private JButton btnX1 = new JButton("x");
	private JButton btnX2 = new JButton("x");
	private JButton btnX3 = new JButton("x");
	private JButton btnX4 = new JButton("x");
	
	private JLabel lblWarning = new javax.swing.JLabel();
	private String[] daysComboBoxOptions = new String[] {"3", "4", "5", "6", "7", "8", "9", "10"};
	private String[] crewComboBoxOptions = new String[] {"2", "3", "4"};
	/**
	 * Launch the application.
	 */
	
	/**
	 * 
	 * @param incomingManager - is the current gameEnvironment object
	 */
	public CrewSelectionScreen(GameEnvironment incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeCrewSelectionScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 153));
		frame.setBounds(50, 50, 1080,720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setUndecorated(true);
		
		JLabel lblWelcomeToSpace = new JLabel("WELCOME TO SPACE EXPLORER");
		lblWelcomeToSpace.setForeground(new Color(0, 0, 0));
		lblWelcomeToSpace.setBackground(new Color(255, 255, 255));
		lblWelcomeToSpace.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcomeToSpace.setBounds(318, 28, 443, 33);
		frame.getContentPane().add(lblWelcomeToSpace);
		
		textNameShipField = new JTextField("My Spaceship");
		textNameShipField.setForeground(new Color(0, 0, 0));
		textNameShipField.setBackground(new Color(153, 204, 204));
		textNameShipField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNameShipField.setBounds(341, 90, 183, 31);
		frame.getContentPane().add(textNameShipField);
		textNameShipField.setColumns(10);
		
		JLabel lblNumberOfDays = new JLabel("Select number of days to play:");
		lblNumberOfDays.setBackground(new Color(0, 0, 0));
		lblNumberOfDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumberOfDays.setBounds(564, 89, 260, 33);
		frame.getContentPane().add(lblNumberOfDays);
		
		JComboBox DaysInSpace = new JComboBox();
		DaysInSpace.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DaysInSpace.setBackground(new Color(153, 204, 204));
		DaysInSpace.setModel(new DefaultComboBoxModel(daysComboBoxOptions));
		DaysInSpace.setMaximumRowCount(10);
		DaysInSpace.setBounds(822, 87, 52, 39);
		DaysInSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = DaysInSpace.getSelectedIndex();
				manager.setDaysInSpace(Integer.valueOf(daysComboBoxOptions[index]));
			}
		});
		frame.getContentPane().add(DaysInSpace);
		
		JLabel lblSelectNumberOfCrew = new JLabel("Select number of members on your crew:");
		lblSelectNumberOfCrew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectNumberOfCrew.setBounds(125, 136, 349, 33);
		frame.getContentPane().add(lblSelectNumberOfCrew);
		
		JComboBox sizeOfCrew = new JComboBox();
		sizeOfCrew.setBackground(new Color(153, 204, 204));
		sizeOfCrew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sizeOfCrew.setModel(new DefaultComboBoxModel(crewComboBoxOptions));
		sizeOfCrew.setBounds(472, 133, 52, 39);
		sizeOfCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = sizeOfCrew.getSelectedIndex();
				manager.setNeededCrewSize(Integer.valueOf(crewComboBoxOptions[index]));
				if (manager.getNeededCrewSize() == 2) {
					jLabel3.setVisible(false);
					btnX3.setVisible(false);
					jLabel4.setVisible(false);
					btnX4.setVisible(false);
				}
				if (manager.getNeededCrewSize() == 3) {
					jLabel3.setVisible(true);
					btnX3.setVisible(true);
					jLabel4.setVisible(false);
					btnX4.setVisible(false);
					
				}else if (manager.getNeededCrewSize()==4) {
					jLabel3.setVisible(true);
					btnX3.setVisible(true);
					jLabel4.setVisible(true);
					btnX4.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(sizeOfCrew);
		
		JLabel lblSelectCrew = new JLabel("Please select your crew now:");
		lblSelectCrew.setBackground(new Color(0, 0, 0));
		lblSelectCrew.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSelectCrew.setBounds(385, 184, 260, 33);
		frame.getContentPane().add(lblSelectCrew);
		
		JLabel lblNameYourShip = new JLabel("Please name your ship:");
		lblNameYourShip.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNameYourShip.setBounds(125, 90, 204, 33);
		frame.getContentPane().add(lblNameYourShip);
		
		
		//Images for the crew
		JLabel DoctorImage = new JLabel("");
		DoctorImage.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/Images/robot-02@64px.png")));
		DoctorImage.setBounds(26, 220, 128, 128);
		frame.getContentPane().add(DoctorImage);
		
		JLabel EngineerImage = new JLabel("");
		EngineerImage.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/Images/nikola-tesla@64px.png")));
		EngineerImage.setBounds(201, 220, 128, 128);
		frame.getContentPane().add(EngineerImage);
		
		JLabel ResearcherImage = new JLabel("");
		ResearcherImage.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/Images/muslim-woman@64px.png")));
		ResearcherImage.setBounds(371, 220, 128, 128);
		frame.getContentPane().add(ResearcherImage);
		
		JLabel SoldierImage = new JLabel("");
		SoldierImage.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/Images/robot-01@64px.png")));
		SoldierImage.setBounds(894, 220, 128, 128);
		frame.getContentPane().add(SoldierImage);
		
		JLabel TechnicianImage = new JLabel("");
		TechnicianImage.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/Images/girl-in-ballcap@64px.png")));
		TechnicianImage.setBounds(721, 220, 128, 128);
		frame.getContentPane().add(TechnicianImage);
		
		JLabel lblCaptainImage = new JLabel("");
		lblCaptainImage.setIcon(new ImageIcon(CrewSelectionScreen.class.getResource("/Images/malcolm-x@64px.png")));
		lblCaptainImage.setBounds(546, 220, 128, 128);
		frame.getContentPane().add(lblCaptainImage);
		
		
		//Name Text
		JTextPane txtpnDoctorText = new JTextPane();
		txtpnDoctorText.setBackground(new Color(102, 153, 153));
		txtpnDoctorText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnDoctorText.setText("Gives extra health to all the crew");
		txtpnDoctorText.setEditable(false);
		txtpnDoctorText.setBounds(26, 352, 128, 66);
		frame.getContentPane().add(txtpnDoctorText);
		
		JTextPane txtpnEngineertext = new JTextPane();
		txtpnEngineertext.setEditable(false);
		txtpnEngineertext.setBackground(new Color(102, 153, 153));
		txtpnEngineertext.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnEngineertext.setText("Shields get +5 and gets repaired faster");
		txtpnEngineertext.setBounds(194, 352, 135, 66);
		frame.getContentPane().add(txtpnEngineertext);
		
		JTextPane txtpnResearchertext = new JTextPane();
		txtpnResearchertext.setEditable(false);
		txtpnResearchertext.setBackground(new Color(102, 153, 153));
		txtpnResearchertext.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnResearchertext.setText("Gives more energy to all the crew");
		txtpnResearchertext.setBounds(371, 352, 139, 66);
		frame.getContentPane().add(txtpnResearchertext);
		
		JTextPane txtpnCaptainText = new JTextPane();
		txtpnCaptainText.setEditable(false);
		txtpnCaptainText.setBackground(new Color(102, 153, 153));
		txtpnCaptainText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnCaptainText.setText("Ship has more petrol to travel");
		txtpnCaptainText.setBounds(546, 352, 138, 66);
		frame.getContentPane().add(txtpnCaptainText);
		
		JTextPane txtpnTechnicianText = new JTextPane();
		txtpnTechnicianText.setEditable(false);
		txtpnTechnicianText.setBackground(new Color(102, 153, 153));
		txtpnTechnicianText.setText("Repairs shields much faster");
		txtpnTechnicianText.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnTechnicianText.setBounds(721, 352, 138, 58);
		frame.getContentPane().add(txtpnTechnicianText);
		
		JTextPane txtpnSoldiertext = new JTextPane();
		txtpnSoldiertext.setEditable(false);
		txtpnSoldiertext.setBackground(new Color(102, 153, 153));
		txtpnSoldiertext.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnSoldiertext.setText("Shields have 10+ of protection");
		txtpnSoldiertext.setBounds(895, 352, 148, 69);
		frame.getContentPane().add(txtpnSoldiertext);
			
		txtNameDoctor = new JTextField();
		txtNameDoctor.setBackground(new Color(153, 204, 204));
		txtNameDoctor.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNameDoctor.setBounds(26, 427, 124, 27);
		frame.getContentPane().add(txtNameDoctor);
		txtNameDoctor.setColumns(10);
		
		txtNameEngineer = new JTextField();
		txtNameEngineer.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNameEngineer.setBackground(new Color(153, 204, 204));
		txtNameEngineer.setBounds(193, 427, 128, 27);
		frame.getContentPane().add(txtNameEngineer);
		txtNameEngineer.setColumns(10);
		
		txtNameResearcher = new JTextField();
		txtNameResearcher.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNameResearcher.setBackground(new Color(153, 204, 204));
		txtNameResearcher.setBounds(371, 427, 128, 27);
		frame.getContentPane().add(txtNameResearcher);
		txtNameResearcher.setColumns(10);
		
		txtNameCaptain = new JTextField();
		txtNameCaptain.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNameCaptain.setBackground(new Color(153, 204, 204));
		txtNameCaptain.setBounds(546, 427, 128, 27);
		frame.getContentPane().add(txtNameCaptain);
		txtNameCaptain.setColumns(10);
		
		txtNameTechnician = new JTextField();
		txtNameTechnician.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNameTechnician.setBackground(new Color(153, 204, 204));
		txtNameTechnician.setBounds(721, 427, 128, 27);
		frame.getContentPane().add(txtNameTechnician);
		txtNameTechnician.setColumns(10);
		
		txtNameSoldier = new JTextField();
		txtNameSoldier.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNameSoldier.setBackground(new Color(153, 204, 204));
		txtNameSoldier.setBounds(894, 427, 128, 27);
		frame.getContentPane().add(txtNameSoldier);
		txtNameSoldier.setColumns(10);
		
		JButton btnSelect = new JButton("Doctor");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor doctor = new Doctor(txtNameDoctor.getText(), manager);
				manager.addMember(doctor);

				UpdateLabels();
			}
		});
		btnSelect.setBackground(new Color(153, 204, 204));
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSelect.setBounds(26, 460, 124, 41);
		frame.getContentPane().add(btnSelect);
		
		JButton btnEngineer = new JButton("Engineer");
		btnEngineer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Engineer engineer= new Engineer(txtNameEngineer.getText(), manager);
				manager.addMember(engineer);

				UpdateLabels();
			}
		});
		btnEngineer.setBackground(new Color(153, 204, 204));
		btnEngineer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEngineer.setBounds(194, 460, 128, 41);
		frame.getContentPane().add(btnEngineer);
		
		JButton btnCaptain = new JButton("Captain");
		btnCaptain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Captain captain = new Captain(txtNameCaptain.getText(), manager);
				manager.addMember(captain);

				UpdateLabels();
			}
		});
		btnCaptain.setBackground(new Color(153, 204, 204));
		btnCaptain.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCaptain.setBounds(546, 460, 128, 41);
		frame.getContentPane().add(btnCaptain);
		
		JButton btnResearcher = new JButton("Researcher");
		btnResearcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Researcher researcher = new Researcher(txtNameResearcher.getText(), manager);
				manager.addMember(researcher);
				
				UpdateLabels();
			}
		});
		btnResearcher.setBackground(new Color(153, 204, 204));
		btnResearcher.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnResearcher.setBounds(371, 460, 128, 41);
		frame.getContentPane().add(btnResearcher);
		
		
		JButton btnTechnician = new JButton("Technician");
		btnTechnician.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Technician technician = new Technician(txtNameTechnician.getText(), manager);
				manager.addMember(technician);
				
				UpdateLabels();
			}
		});
		btnTechnician.setBackground(new Color(153, 204, 204));
		btnTechnician.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTechnician.setBounds(721, 460, 128, 41);
		frame.getContentPane().add(btnTechnician);
		
		JButton btnSoldier = new JButton("Soldier");
		btnSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Soldier soldier = new Soldier(txtNameSoldier.getText(), manager);
				manager.addMember(soldier);
			
				UpdateLabels();
			}
		});
		btnSoldier.setBackground(new Color(153, 204, 204));
		btnSoldier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSoldier.setBounds(894, 460, 128, 41);
		frame.getContentPane().add(btnSoldier);
		
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jLabel1.setBounds(85, 554, 234, 33);
		frame.getContentPane().add(jLabel1);
		
		
		
		btnX1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.getCrewSize()>0) {
					manager.removeMember(manager.getCurrentCrew().remove(0));
					UpdateLabels();
				}
			}
		});
		btnX1.setBackground(new Color(204, 204, 204));
		btnX1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnX1.setBounds(26, 554, 50, 33);
		frame.getContentPane().add(btnX1);
		
				
		jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jLabel3.setBounds(85, 598, 238, 33);
		frame.getContentPane().add(jLabel3);
		jLabel3.setVisible(false);
		
		
		btnX3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.getCrewSize()>0) {
					manager.removeMember(manager.getCurrentCrew().remove(2));
					UpdateLabels();
				}
			}
		});
		btnX3.setBackground(new Color(204, 204, 204));
		btnX3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnX3.setBounds(26, 598, 50, 33);
		frame.getContentPane().add(btnX3);
		btnX3.setVisible(false);
		
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jLabel2.setBounds(437, 554, 234, 33);
		frame.getContentPane().add(jLabel2);
		
		
		
		btnX2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.getCrewSize()>0) {
					manager.removeMember(manager.getCurrentCrew().remove(1));
					UpdateLabels();
				}
			}
		});
		btnX2.setBackground(new Color(204, 204, 204));
		btnX2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnX2.setBounds(371, 553, 50, 34);
		frame.getContentPane().add(btnX2);
		
		
		jLabel4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jLabel4.setBounds(437, 598, 234, 33);
		frame.getContentPane().add(jLabel4);
		jLabel4.setVisible(false);
		
		btnX4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.getCrewSize()>0) {
					manager.removeMember(manager.getCurrentCrew().remove(3));
					UpdateLabels();
				}
			}
		});
		btnX4.setBackground(new Color(204, 204, 204));
		btnX4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnX4.setBounds(371, 599, 50, 33);
		frame.getContentPane().add(btnX4);
		btnX4.setVisible(false);
		
		JLabel lblCurrentCrew = new JLabel("Current crew:");
		lblCurrentCrew.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentCrew.setBounds(26, 508, 115, 33);
		frame.getContentPane().add(lblCurrentCrew);
		
		lblWarning.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWarning.setBounds(677, 598, 334, 33);
		frame.getContentPane().add(lblWarning);
		lblWarning.setVisible(false);
		
		JButton btnNextPage = new JButton("Done!");
		btnNextPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNextPage.setBackground(new Color(153, 204, 204));
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				manager.setShipName(textNameShipField.getText());
				
				if (isReadyToStartGame()) {
					
					manager.makePlanets();
					
					int totalParts = manager.partsToFind();
					manager.StartPetrol(totalParts);
					
					for(int i=0; i < manager.getCrewSize(); i++) {
						manager.getMemberOnIndex(i).Update();
					}
					for(int i=0; i < manager.getCrewSize(); i++) {
						manager.getMemberOnIndex(i).GeneralUpdate();
					}
					finishedWindow();
					closeWindow();
				}
			}
		});
		btnNextPage.setBounds(782, 554, 124, 45);
		frame.getContentPane().add(btnNextPage);
	}
	
	private boolean isReadyToStartGame() {
		boolean isReady = true;
		lblWarning.setText("");
		if (manager.getShipName().equals("")) {
			lblWarning.setText(lblWarning.getText() + "Name your spaceship!");
			isReady = false;
		}
		if (manager.getCrewSize() < manager.getNeededCrewSize()) {
			lblWarning.setText(lblWarning.getText() + " Select your crew members!");
			isReady = false;
		}
		lblWarning.setVisible(true);
		return isReady;
	}
	
	private void UpdateLabels() {
		for (int i=0; i < manager.getNeededCrewSize(); i++) {
			
			CrewMember member = manager.getMemberOnIndex(i);
			if (i==0) {
				jLabel1.setText(labelInformation(member));
				frame.getContentPane().add(jLabel1);
			}
			else if (i==1) {
				jLabel2.setText(labelInformation(member));
				frame.getContentPane().add(jLabel2);
			}
			else if (i==2) {
				jLabel3.setText(labelInformation(member));
				frame.getContentPane().add(jLabel3);
			}
			else if(i==3) {
				jLabel4.setText(labelInformation(member));
				frame.getContentPane().add(jLabel4);
			}
		}
	}
	
	private String labelInformation(CrewMember member) {
		if (member != null) {
			return member.getTag() + ": " + member.getName();
		}else {
			return "";
		}
	}
}