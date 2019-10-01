package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import SpaceExplorerClasses.GameEnvironment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;

public class GameOverScreen {

	private JFrame frame;

	GameEnvironment manager;
	/**
	 * Launch the application.
	 */
	
	/**
	 * 
	 * @param incomingManager - initialises the game over screen
	 */
	public GameOverScreen(GameEnvironment incomingManager) {
		manager = incomingManager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGameOverScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 153));
		frame.getContentPane().setLayout(null);
		
		JLabel lblShipName = new JLabel(manager.getShipName());
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblShipName.setHorizontalAlignment(SwingConstants.CENTER);
		lblShipName.setBounds(227, 28, 235, 37);
		frame.getContentPane().add(lblShipName);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days to Complete: " + manager.getCurrentDay() + " / " + manager.getDaysInSpace());
		lblNumberOfDays.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNumberOfDays.setBounds(141, 152, 430, 33);
		frame.getContentPane().add(lblNumberOfDays);
		
		JLabel lblSpaceship = new JLabel("Spaceship");
		lblSpaceship.setIcon(new ImageIcon(GameOverScreen.class.getResource("/Images/MySpaceShip.png")));
		lblSpaceship.setBounds(113, 12, 115, 71);
		frame.getContentPane().add(lblSpaceship);
		
		JLabel lblPiecesFound = new JLabel("Pieces Found: " + manager.getCurrentParts() + " / " + manager.partsToFind());
		lblPiecesFound.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblPiecesFound.setBounds(239, 225, 235, 33);
		frame.getContentPane().add(lblPiecesFound);
		
		JLabel lblSun = new JLabel("");
		lblSun.setIcon(new ImageIcon(GameOverScreen.class.getResource("/Images/sun.png")));
		lblSun.setBounds(591, 134, 71, 71);
		frame.getContentPane().add(lblSun);
		
		JLabel lblScore = new JLabel("Score: " + manager.getScore());
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblScore.setBounds(275, 297, 163, 33);
		frame.getContentPane().add(lblScore);
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}