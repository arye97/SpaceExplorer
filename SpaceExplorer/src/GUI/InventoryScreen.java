package GUI;

import java.awt.EventQueue;
import SpaceExplorerClasses.*;
import javax.swing.*;
import javax.swing.JFrame;

import SpaceExplorerClasses.GameEnvironment;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class InventoryScreen {
	
	private JFrame frame;
	private GameEnvironment manager;
	
	private Collectibles burger;
	private Collectibles pizza;
	private Collectibles iceCream;
	private Collectibles strawberry;
	private Collectibles drink;
	private Collectibles chicken;
	
	private Collectibles spacePlagueCure;
	private Collectibles coughMedicine;
	private Collectibles spaceMedicine;
	
	CrewMember crewMember;
	/**
	 * 
	 * @param incomingManager - the gameEnvironment to use
	 * @param member - the current crew member
	 */
	public InventoryScreen(GameEnvironment incomingManager, CrewMember member) {
		manager 	= incomingManager;
		burger 		= manager.getFoodOnIndex(0);
		pizza 		= manager.getFoodOnIndex(1);
		iceCream 	= manager.getFoodOnIndex(2);
		strawberry	= manager.getFoodOnIndex(3);
		drink		= manager.getFoodOnIndex(4);
		chicken		= manager.getFoodOnIndex(5);
		
		spacePlagueCure = manager.getMedicineOnIndex(0);
		coughMedicine	= manager.getMedicineOnIndex(1);
		spaceMedicine	= manager.getMedicineOnIndex(2);
		
		initialize();
		frame.setVisible(true);
		
		crewMember = member;
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeInventoryScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 153));
		frame.setBounds(50, 50, 1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Burger
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurger.setBounds(76, 65, 90, 33);
		frame.getContentPane().add(lblBurger);
		
		JLabel lblBurgerImage = new JLabel("");
		lblBurgerImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(burger.getImagePath())));
		lblBurgerImage.setBounds(54, 103, 128, 128);
		frame.getContentPane().add(lblBurgerImage);
		
		JLabel lblEnergy = new JLabel("Energy:");
		lblEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy.setBounds(220, 153, 64, 25);
		frame.getContentPane().add(lblEnergy);
		
		JLabel lblCurrent = new JLabel("Current:");
		lblCurrent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent.setBounds(220, 177, 72, 25);
		frame.getContentPane().add(lblCurrent);
		
		JLabel lblBurgerEnergy = new JLabel(Integer.toString(burger.getEnergy()));
		lblBurgerEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBurgerEnergy.setBounds(304, 153, 40, 25);
		frame.getContentPane().add(lblBurgerEnergy);
		
		JLabel lblCurrentBurgers = new JLabel(Integer.toString(burger.getQuantity()));
		lblCurrentBurgers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentBurgers.setBounds(304, 178, 40, 22);
		frame.getContentPane().add(lblCurrentBurgers);
		
		JButton btnUseBurger = new JButton("Use");
		btnUseBurger.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.eatFood(burger);
				lblCurrentBurgers.setText(Integer.toString(burger.getQuantity()));
			}
		});
		btnUseBurger.setBackground(new Color(153, 204, 204));
		btnUseBurger.setBounds(220, 126, 98, 25);
		frame.getContentPane().add(btnUseBurger);
		
		
		//Pizza
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizza.setBounds(413, 65, 72, 33);
		frame.getContentPane().add(lblPizza);
		
		JLabel lblPizzaImage = new JLabel("");
		lblPizzaImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(pizza.getImagePath())));
		lblPizzaImage.setBounds(378, 103, 128, 128);
		frame.getContentPane().add(lblPizzaImage);
		
		JLabel lblEnergy1 = new JLabel("Energy:");
		lblEnergy1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy1.setBounds(532, 153, 64, 25);
		frame.getContentPane().add(lblEnergy1);
		
		JLabel lblCurrent1 = new JLabel("Current:");
		lblCurrent1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent1.setBounds(532, 177, 72, 25);
		frame.getContentPane().add(lblCurrent1);
		
		JLabel lblPizzaEnergy = new JLabel(Integer.toString(pizza.getEnergy()));
		lblPizzaEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPizzaEnergy.setBounds(632, 153, 50, 25);
		frame.getContentPane().add(lblPizzaEnergy);
		
		JLabel lblCurrentPizzas = new JLabel(Integer.toString(pizza.getQuantity()));
		lblCurrentPizzas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentPizzas.setBounds(632, 179, 40, 22);
		frame.getContentPane().add(lblCurrentPizzas);
		
		JButton btnUsePizza = new JButton("Use");
		btnUsePizza.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUsePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.eatFood(pizza);
				lblCurrentPizzas.setText(Integer.toString(pizza.getQuantity()));
			}
		});
		btnUsePizza.setBackground(new Color(153, 204, 204));
		btnUsePizza.setBounds(532, 126, 98, 25);
		frame.getContentPane().add(btnUsePizza);
		
		JLabel lblEnergy2 = new JLabel("Energy:");
		lblEnergy2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy2.setBounds(875, 153, 64, 25);
		frame.getContentPane().add(lblEnergy2);
		
		JLabel lblIceCreamImage = new JLabel("");
		lblIceCreamImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(iceCream.getImagePath())));
		lblIceCreamImage.setBounds(707, 103, 128, 128);
		frame.getContentPane().add(lblIceCreamImage);
		
		JLabel lblCurrent2 = new JLabel("Current:");
		lblCurrent2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent2.setBounds(875, 179, 72, 25);
		frame.getContentPane().add(lblCurrent2);
		
		JLabel lblIceCreamEnergy = new JLabel(Integer.toString(iceCream.getEnergy()));
		lblIceCreamEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIceCreamEnergy.setBounds(965, 153, 40, 25);
		frame.getContentPane().add(lblIceCreamEnergy);
		
		JLabel lblIceCream = new JLabel("Ice Cream");
		lblIceCream.setHorizontalAlignment(SwingConstants.CENTER);
		lblIceCream.setBounds(707, 65, 129, 33);
		frame.getContentPane().add(lblIceCream);
		
		JLabel lblCurrentIceCreams = new JLabel(Integer.toString(iceCream.getQuantity()));
		lblCurrentIceCreams.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentIceCreams.setBounds(965, 179, 40, 22);
		frame.getContentPane().add(lblCurrentIceCreams);
		
		JButton btnUseIceCream = new JButton("Use");
		btnUseIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.eatFood(iceCream);
				lblCurrentIceCreams.setText(Integer.toString(iceCream.getQuantity()));
			}
		});
		btnUseIceCream.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseIceCream.setBackground(new Color(153, 204, 204));
		btnUseIceCream.setBounds(875, 126, 98, 25);
		frame.getContentPane().add(btnUseIceCream);
		
		JLabel lblEnergy3 = new JLabel("Energy:");
		lblEnergy3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy3.setBounds(220, 339, 64, 25);
		frame.getContentPane().add(lblEnergy3);
		
		JLabel lblStrawberryImage = new JLabel("");
		lblStrawberryImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(strawberry.getImagePath())));
		lblStrawberryImage.setBounds(54, 289, 128, 128);
		frame.getContentPane().add(lblStrawberryImage);
		
		JLabel lblCurrent3 = new JLabel("Current:");
		lblCurrent3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent3.setBounds(220, 365, 72, 25);
		frame.getContentPane().add(lblCurrent3);
		
		JLabel lblCurrentStrawberries = new JLabel(Integer.toString(strawberry.getQuantity()));
		lblCurrentStrawberries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentStrawberries.setBounds(304, 365, 40, 22);
		frame.getContentPane().add(lblCurrentStrawberries);
		
		JLabel lblStrawberryEnergy = new JLabel(Integer.toString(strawberry.getEnergy()));
		lblStrawberryEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStrawberryEnergy.setBounds(304, 339, 40, 25);
		frame.getContentPane().add(lblStrawberryEnergy);
		
		JLabel lblStrawberry = new JLabel("Strawberry");
		lblStrawberry.setHorizontalAlignment(SwingConstants.CENTER);
		lblStrawberry.setBounds(54, 250, 139, 33);
		frame.getContentPane().add(lblStrawberry);
		
		JButton btnUseStrawberry = new JButton("Use");
		btnUseStrawberry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.eatFood(strawberry);
				lblCurrentStrawberries.setText(Integer.toString(strawberry.getQuantity()));
			}
		});
		btnUseStrawberry.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseStrawberry.setBackground(new Color(153, 204, 204));
		btnUseStrawberry.setBounds(220, 312, 98, 25);
		frame.getContentPane().add(btnUseStrawberry);
		
		JLabel lblEnergy4 = new JLabel("Energy:");
		lblEnergy4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy4.setBounds(538, 339, 64, 25);
		frame.getContentPane().add(lblEnergy4);
		
		JLabel lblDrinkImage = new JLabel("");
		lblDrinkImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(drink.getImagePath())));
		lblDrinkImage.setBounds(378, 289, 128, 128);
		frame.getContentPane().add(lblDrinkImage);
		
		JLabel lblCurrent4 = new JLabel("Current:");
		lblCurrent4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent4.setBounds(538, 365, 72, 25);
		frame.getContentPane().add(lblCurrent4);
		
		JLabel lblCurrentDrinks = new JLabel(Integer.toString(drink.getQuantity()));
		lblCurrentDrinks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentDrinks.setBounds(632, 368, 40, 22);
		frame.getContentPane().add(lblCurrentDrinks);
		
		JLabel lblDrinkEnergy = new JLabel(Integer.toString(drink.getEnergy()));
		lblDrinkEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDrinkEnergy.setBounds(632, 342, 40, 25);
		frame.getContentPane().add(lblDrinkEnergy);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrink.setBounds(413, 250, 64, 33);
		frame.getContentPane().add(lblDrink);
		
		JButton btnUseDrink = new JButton("Use");
		btnUseDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.eatFood(drink);
				lblCurrentDrinks.setText(Integer.toString(drink.getQuantity()));
			}
		});
		btnUseDrink.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseDrink.setBackground(new Color(153, 204, 204));
		btnUseDrink.setBounds(538, 312, 98, 25);
		frame.getContentPane().add(btnUseDrink);
		
		JLabel lblEnergy5 = new JLabel("Energy:");
		lblEnergy5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy5.setBounds(875, 339, 64, 25);
		frame.getContentPane().add(lblEnergy5);
		
		JLabel lblChickenImage = new JLabel("");
		lblChickenImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(chicken.getImagePath())));
		lblChickenImage.setBounds(707, 289, 128, 128);
		frame.getContentPane().add(lblChickenImage);
		
		JLabel lblCurrent5 = new JLabel("Current:");
		lblCurrent5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent5.setBounds(875, 365, 72, 25);
		frame.getContentPane().add(lblCurrent5);
		
		JLabel lblCurrentChickens = new JLabel(Integer.toString(chicken.getQuantity()));
		lblCurrentChickens.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentChickens.setBounds(965, 365, 40, 22);
		frame.getContentPane().add(lblCurrentChickens);
		
		JLabel lblChickenEnergy = new JLabel(Integer.toString(chicken.getEnergy()));
		lblChickenEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChickenEnergy.setBounds(965, 339, 40, 25);
		frame.getContentPane().add(lblChickenEnergy);
		
		JLabel lblChicken = new JLabel("Chicken");
		lblChicken.setHorizontalAlignment(SwingConstants.CENTER);
		lblChicken.setBounds(717, 250, 98, 33);
		frame.getContentPane().add(lblChicken);
		
		JButton btnUseChicken = new JButton("Use");
		btnUseChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.eatFood(chicken);
				lblCurrentChickens.setText(Integer.toString(chicken.getQuantity()));
			}
		});
		btnUseChicken.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseChicken.setBackground(new Color(153, 204, 204));
		btnUseChicken.setBounds(875, 312, 98, 25);
		frame.getContentPane().add(btnUseChicken);
		
		
		
		JLabel lblEnergy6 = new JLabel("Health:");
		lblEnergy6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy6.setBounds(220, 528, 64, 25);
		frame.getContentPane().add(lblEnergy6);
		
		JLabel lblCoughMedicineImage = new JLabel("");
		lblCoughMedicineImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(coughMedicine.getImagePath())));
		lblCoughMedicineImage.setBounds(54, 478, 128, 128);
		frame.getContentPane().add(lblCoughMedicineImage);
		
		JLabel lblCurrent6 = new JLabel("Current:");
		lblCurrent6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent6.setBounds(220, 554, 72, 25);
		frame.getContentPane().add(lblCurrent6);
		
		JLabel lblCurrentCoughMedicine = new JLabel(Integer.toString(coughMedicine.getQuantity()));
		lblCurrentCoughMedicine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentCoughMedicine.setBounds(304, 554, 40, 22);
		frame.getContentPane().add(lblCurrentCoughMedicine);
		
		JLabel lblCoughMedicineEnergy = new JLabel(Integer.toString(coughMedicine.getEnergy()));
		lblCoughMedicineEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoughMedicineEnergy.setBounds(304, 528, 40, 25);
		frame.getContentPane().add(lblCoughMedicineEnergy);
		
		JLabel lblCoughMedicine = new JLabel("Cough Medicine");
		lblCoughMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoughMedicine.setBounds(26, 439, 193, 33);
		frame.getContentPane().add(lblCoughMedicine);
		
		JButton btnUseCoughMedicine = new JButton("Use");
		btnUseCoughMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.takeMedicine(coughMedicine);
				lblCurrentCoughMedicine.setText(Integer.toString(coughMedicine.getQuantity()));
			}
		});
		btnUseCoughMedicine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseCoughMedicine.setBackground(new Color(153, 204, 204));
		btnUseCoughMedicine.setBounds(220, 501, 98, 25);
		frame.getContentPane().add(btnUseCoughMedicine);
		
		
		//Plague
		JLabel lblCurrentSpacePlagueCure = new JLabel(Integer.toString(spacePlagueCure.getQuantity()));
		lblCurrentSpacePlagueCure.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentSpacePlagueCure.setBounds(632, 557, 40, 22);
		frame.getContentPane().add(lblCurrentSpacePlagueCure);
		
		JButton btnUseSpacePlagueCure = new JButton("Use");
		btnUseSpacePlagueCure.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseSpacePlagueCure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crewMember.cureSpacePlague();
				lblCurrentSpacePlagueCure.setText(Integer.toString(spacePlagueCure.getQuantity()));
			}
		});
		btnUseSpacePlagueCure.setBackground(new Color(153, 204, 204));
		btnUseSpacePlagueCure.setBounds(538, 501, 98, 25);
		frame.getContentPane().add(btnUseSpacePlagueCure);
		
		JLabel lblEnergy7 = new JLabel("Health:");
		lblEnergy7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy7.setBounds(538, 528, 64, 25);
		frame.getContentPane().add(lblEnergy7);
		
		JLabel lblSpacePlagueImage = new JLabel("");
		lblSpacePlagueImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(spacePlagueCure.getImagePath())));
		lblSpacePlagueImage.setBounds(384, 478, 128, 128);
		frame.getContentPane().add(lblSpacePlagueImage);
		
		JLabel lblCurrent7 = new JLabel("Current:");
		lblCurrent7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent7.setBounds(538, 554, 72, 25);
		frame.getContentPane().add(lblCurrent7);
		
		JLabel lblSpacePlagueCureEnergy = new JLabel(Integer.toString(spacePlagueCure.getEnergy()));
		lblSpacePlagueCureEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpacePlagueCureEnergy.setBounds(632, 531, 40, 25);
		frame.getContentPane().add(lblSpacePlagueCureEnergy);
		
		JLabel lblSpacePlagueCure = new JLabel("Space Plague Cure");
		lblSpacePlagueCure.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpacePlagueCure.setBounds(344, 439, 228, 33);
		frame.getContentPane().add(lblSpacePlagueCure);
		
		
		//SpaceMedicine
		JLabel lblSpaceMedicine = new JLabel("Fever Medicine");
		lblSpaceMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceMedicine.setBounds(678, 439, 193, 33);
		frame.getContentPane().add(lblSpaceMedicine);
		
		JLabel lblEnergy8 = new JLabel("Health:");
		lblEnergy8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy8.setBounds(875, 528, 64, 25);
		frame.getContentPane().add(lblEnergy8);
		
		JLabel lblSpaceMedicineImage = new JLabel("");
		lblSpaceMedicineImage.setIcon(new ImageIcon(InventoryScreen.class.getResource(spaceMedicine.getImagePath())));
		lblSpaceMedicineImage.setBounds(707, 478, 128, 128);
		frame.getContentPane().add(lblSpaceMedicineImage);
		
		JLabel lblCurrent8 = new JLabel("Current:");
		lblCurrent8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent8.setBounds(875, 554, 72, 25);
		frame.getContentPane().add(lblCurrent8);
		
		JLabel lblCurrentSpaceMedicine = new JLabel(Integer.toString(spaceMedicine.getQuantity()));
		lblCurrentSpaceMedicine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentSpaceMedicine.setBounds(965, 557, 40, 22);
		frame.getContentPane().add(lblCurrentSpaceMedicine);
		
		JLabel lblSpaceMedicineEnergy = new JLabel(Integer.toString(spaceMedicine.getEnergy()));
		lblSpaceMedicineEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpaceMedicineEnergy.setBounds(965, 531, 40, 25);
		frame.getContentPane().add(lblSpaceMedicineEnergy);
		
		JButton btnUseSpaceMedicine = new JButton("Use");
		btnUseSpaceMedicine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUseSpaceMedicine.setBackground(new Color(153, 204, 204));
		btnUseSpaceMedicine.setBounds(875, 501, 98, 25);
		btnUseSpaceMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crewMember.takeMedicine(spaceMedicine);
				lblCurrentSpaceMedicine.setText(Integer.toString(spaceMedicine.getQuantity()));
			}
		});
		frame.getContentPane().add(btnUseSpaceMedicine);
		
		//Extra
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(153, 204, 204));
		separator.setBounds(0, 48, 1048, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setBounds(368, 0, 264, 50);
		frame.getContentPane().add(lblInventory);		
		
		JButton btnGoBack = new JButton("Done");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crewMember.TookAction();
				finishedWindow();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGoBack.setBackground(new Color(153, 204, 204));
		btnGoBack.setBounds(861, 5, 171, 41);
		frame.getContentPane().add(btnGoBack);
	}
}
