package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import SpaceExplorerClasses.*;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitPlanetsScreen {

	private JFrame frame;

	private GameEnvironment manager;
	private Spaceship spaceship;
	
	private Planet planet1;
	private Planet planet2;
	private Planet planet3;
	private Planet planet4;
	private Planet planet5;
	private Planet planet6;
	private Planet planet7;
	
	JLabel lblFeedback = new JLabel("");
	JLabel lblAsteroids = new JLabel("");
	JLabel lblDayRandomEvent = new JLabel("");
	
	JProgressBar petrolProgressBar = new JProgressBar();
	JProgressBar shieldProgressBar = new JProgressBar();
	/**
	 * 
	 * @param incomingManager - gameEnvironment to use
	 */
	public VisitPlanetsScreen(GameEnvironment incomingManager) {
		manager = incomingManager;
		spaceship = manager.getSpaceship();
		
		planet1 = manager.getPlanetOnIndex(0);
		planet2 = manager.getPlanetOnIndex(1);
		planet3 = manager.getPlanetOnIndex(2);
		planet4 = manager.getPlanetOnIndex(3);
		planet5 = manager.getPlanetOnIndex(4);
		planet6 = manager.getPlanetOnIndex(5);
		planet7 = manager.getPlanetOnIndex(6);
		manager.getCurrentFeedback();
		
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeVisitPlanetsScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 1090, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPetrol = new JLabel("Petrol");
		lblPetrol.setForeground(Color.WHITE);
		lblPetrol.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPetrol.setBounds(15, 18, 82, 24);
		frame.getContentPane().add(lblPetrol);
		
		
		petrolProgressBar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		petrolProgressBar.setMaximum(Spaceship.getMaxPetrol());
		petrolProgressBar.setValue(spaceship.getPetrol());
		petrolProgressBar.setForeground(new Color(102, 153, 153));
		petrolProgressBar.setStringPainted(true);
		petrolProgressBar.setBackground(new Color(153, 0, 0));
		petrolProgressBar.setBounds(99, 18, 146, 24);
		frame.getContentPane().add(petrolProgressBar);
		
		JLabel lblShield = new JLabel("Shield");
		lblShield.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShield.setForeground(new Color(255, 255, 255));
		lblShield.setBounds(15, 48, 82, 33);
		frame.getContentPane().add(lblShield);
		
		
		shieldProgressBar.setBackground(new Color(153, 0, 0));
		shieldProgressBar.setForeground(new Color(102, 153, 153));
		shieldProgressBar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		shieldProgressBar.setMaximum(Spaceship.getMaxShieldHealth());
		shieldProgressBar.setValue(spaceship.getShieldHealth());
		shieldProgressBar.setStringPainted(true);
		shieldProgressBar.setBounds(99, 57, 146, 24);
		frame.getContentPane().add(shieldProgressBar);
		
		JLabel lblPartsNeeded = new JLabel("Parts Needed: " + Integer.toString(manager.getCurrentParts()) + " / " + Integer.toString(manager.partsToFind()));
		lblPartsNeeded.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartsNeeded.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPartsNeeded.setBackground(new Color(0, 0, 0));
		lblPartsNeeded.setForeground(new Color(255, 255, 255));
		lblPartsNeeded.setBounds(419, 57, 240, 33);
		frame.getContentPane().add(lblPartsNeeded);
		
		JLabel lblcurrentDay = new JLabel(Integer.toString(manager.getCurrentDay()));
		lblcurrentDay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblcurrentDay.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/sun.png")));
		lblcurrentDay.setForeground(Color.WHITE);
		lblcurrentDay.setBounds(48, 98, 114, 64);
		frame.getContentPane().add(lblcurrentDay);
		
		lblDayRandomEvent.setText(manager.getRandomDayEvent());
		lblDayRandomEvent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDayRandomEvent.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayRandomEvent.setBackground(new Color(240, 240, 240));
		lblDayRandomEvent.setForeground(new Color(255, 255, 255));
		lblDayRandomEvent.setBounds(340, 0, 408, 33);
		frame.getContentPane().add(lblDayRandomEvent);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.NewDay();
				lblcurrentDay.setText(Integer.toString(manager.getCurrentDay()));
				lblDayRandomEvent.setText(manager.getRandomDayEvent());
				
				if(manager.checkGameOver()){
					manager.launchGameOverScreen();
					finishedWindow();
				} else {
				manager.launchStatusScreen();
				finishedWindow();
				}
			}
		});
		btnNextDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNextDay.setBackground(new Color(102, 153, 153));
		btnNextDay.setBounds(0, 612, 114, 30);
		frame.getContentPane().add(btnNextDay);
		
		lblFeedback.setText(manager.getCurrentFeedback());
		lblFeedback.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setForeground(new Color(255, 255, 255));
		lblFeedback.setBounds(330, 92, 418, 33);
		frame.getContentPane().add(lblFeedback);
		//frame.setUndecorated(true);
		
		lblAsteroids.setText(spaceship.getHitByAsteroids());
		lblAsteroids.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAsteroids.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsteroids.setForeground(new Color(255, 255, 255));
		lblAsteroids.setBounds(419, 130, 259, 24);
		frame.getContentPane().add(lblAsteroids);
		
		JLabel OutpostInteractible = new JLabel("");
		OutpostInteractible.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				manager.launchSpaceOutpostScreen();
			}
		});
		OutpostInteractible.setBounds(406, 305, 128, 97);
		frame.getContentPane().add(OutpostInteractible);
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchStatusScreen();
				finishedWindow();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGoBack.setBackground(new Color(102, 153, 153));
		btnGoBack.setBounds(0, 575, 114, 30);
		frame.getContentPane().add(btnGoBack);
		
		
		JLabel OutpostImage = new JLabel("");
		OutpostImage.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/storeIcon.png")));
		OutpostImage.setBounds(447, 305, 45, 44);
		frame.getContentPane().add(OutpostImage);
		
		
		JLabel lblSpaceOutpost = new JLabel("Space Outpost");
		lblSpaceOutpost.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceOutpost.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSpaceOutpost.setForeground(new Color(255, 255, 255));
		lblSpaceOutpost.setBounds(396, 353, 151, 33);
		frame.getContentPane().add(lblSpaceOutpost);
		
		if(!planet1.getSearchedToday() && !planet1.getPartFoundHere()) {
		JButton btnSearchPlanet1 = new JButton("Search Planet");
		btnSearchPlanet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setCurrentFeedback(planet1.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet1.setBackground(new Color(102, 153, 153));
		btnSearchPlanet1.setBounds(319, 151, 162, 41);
		frame.getContentPane().add(btnSearchPlanet1);
		}
		
		
		if(!planet2.getSearchedToday()&& !planet2.getPartFoundHere()) {
		JButton btnSearchPlanet2 = new JButton("Search Planet");
		btnSearchPlanet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setCurrentFeedback(planet2.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet2.setBackground(new Color(102, 153, 153));
		btnSearchPlanet2.setBounds(618, 296, 162, 41);
		frame.getContentPane().add(btnSearchPlanet2);
		}
	
		
		if(!planet3.getSearchedToday() && !planet3.getPartFoundHere()) {
		JButton btnSearchPlanet3 = new JButton("Search Planet");
		btnSearchPlanet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setCurrentFeedback(planet3.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet3.setBackground(new Color(102, 153, 153));
		btnSearchPlanet3.setBounds(896, 151, 162, 41);
		frame.getContentPane().add(btnSearchPlanet3);
		}
		
		
		if(!planet4.getSearchedToday() && !planet4.getPartFoundHere()) {
		JButton btnSearchPlanet4 = new JButton("Search Planet");
		btnSearchPlanet4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				manager.setCurrentFeedback(planet4.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet4.setBackground(new Color(102, 153, 153));
		btnSearchPlanet4.setBounds(896, 480, 162, 41);
		frame.getContentPane().add(btnSearchPlanet4);
		}
		
		if(!planet5.getSearchedToday() && !planet5.getPartFoundHere()) {
		JButton btnSearchPlanet5 = new JButton("Search Planet");
		btnSearchPlanet5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setCurrentFeedback(planet5.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet5.setBackground(new Color(102, 153, 153));
		btnSearchPlanet5.setBounds(665, 515, 162, 41);
		frame.getContentPane().add(btnSearchPlanet5);
		}
		
		
		if(!planet6.getSearchedToday() && !planet6.getPartFoundHere()) {
		JButton btnSearchPlanet6 = new JButton("Search Planet");
		btnSearchPlanet6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.setCurrentFeedback(planet6.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet6.setBackground(new Color(102, 153, 153));
		btnSearchPlanet6.setBounds(234, 499, 162, 41);
		frame.getContentPane().add(btnSearchPlanet6);
		}
		
		
		if(!planet7.getSearchedToday() && !planet7.getPartFoundHere()) {
		JButton btnSearchPlanet7 = new JButton("Search Planet");
		btnSearchPlanet7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Also makes it pilot the thing
				manager.setCurrentFeedback(planet7.SearchForItem()); ;
				SearchPlanetUpdate();
			}
		});
		btnSearchPlanet7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchPlanet7.setBackground(new Color(102, 153, 153));
		btnSearchPlanet7.setBounds(0, 296, 162, 41);
		frame.getContentPane().add(btnSearchPlanet7);
		}
		
		
		if(planet1.getPartFoundHere()) {
		JLabel lblPlanet1 = new JLabel("");
		lblPlanet1.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet1.setBounds(196, 128, 130, 71);
		frame.getContentPane().add(lblPlanet1);
		}
		
		if(planet2.getPartFoundHere()) {
		JLabel lblPlanet2 = new JLabel("");
		lblPlanet2.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanet2.setBounds(645, 189, 103, 79);
		frame.getContentPane().add(lblPlanet2);
		}
		
		if(planet3.getPartFoundHere()) {
		JLabel lblPlanet3 = new JLabel("");
		lblPlanet3.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet3.setBounds(927, 38, 115, 79);
		frame.getContentPane().add(lblPlanet3);
		}
		
		if(planet4.getPartFoundHere()) {
		JLabel lblPlanet4 = new JLabel("");
		lblPlanet4.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet4.setBounds(949, 386, 109, 85);
		frame.getContentPane().add(lblPlanet4);
		}
		
		if(planet5.getPartFoundHere()) {
		JLabel lblPlanet5 = new JLabel("");
		lblPlanet5.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet5.setBounds(675, 562, 114, 71);
		frame.getContentPane().add(lblPlanet5);
		}
		
		if(planet6.getPartFoundHere()) {
		JLabel lblPlanet6 = new JLabel("");
		lblPlanet6.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanet6.setBounds(259, 568, 115, 64);
		frame.getContentPane().add(lblPlanet6);
		}
		
		if(planet7.getPartFoundHere()) {
		JLabel lblPlanet7 = new JLabel("");
		lblPlanet7.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/MySpaceShip.png")));
		lblPlanet7.setBounds(0, 353, 106, 79);
		frame.getContentPane().add(lblPlanet7);
		}
		
		JLabel SpaceBackground = new JLabel("");
		SpaceBackground.setBounds(0, 0, 1081, 720);
		frame.getContentPane().add(SpaceBackground);
		SpaceBackground.setIcon(new ImageIcon(VisitPlanetsScreen.class.getResource("/Images/7PlanetsSolarSystem.png")));
	}
	
	public void SearchPlanetUpdate() {
		String hit = spaceship.getHitByAsteroids();
		lblAsteroids.setText(hit);
		lblFeedback.setText(manager.getCurrentFeedback());
		petrolProgressBar.setValue(spaceship.getPetrol());
		shieldProgressBar.setValue(spaceship.getShieldHealth());
		if(manager.gameWon()) {
			manager.launchGameOverScreen();
			finishedWindow();
		}else{
			if(spaceship.getPetrol() > 0) {
			manager.launchVisitPlanetsScreen();
			finishedWindow();
			}
		}
	}
}
