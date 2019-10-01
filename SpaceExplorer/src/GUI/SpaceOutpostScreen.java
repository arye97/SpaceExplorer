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

public class SpaceOutpostScreen {

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
	private Collectibles feverMedicine;
	/**
	 * 
	 * @param incomingManager - gameenvironment to use
	 */
	public SpaceOutpostScreen(GameEnvironment incomingManager) {
		manager 	= incomingManager;
		burger 		= manager.getFoodOnIndex(0);
		pizza 		= manager.getFoodOnIndex(1);
		iceCream 	= manager.getFoodOnIndex(2);
		strawberry	= manager.getFoodOnIndex(3);
		drink		= manager.getFoodOnIndex(4);
		chicken		= manager.getFoodOnIndex(5);
		
		spacePlagueCure = manager.getMedicineOnIndex(0);
		coughMedicine	= manager.getMedicineOnIndex(1);
		feverMedicine	= manager.getMedicineOnIndex(2);
		
		initialize();
		frame.setVisible(true);
		
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeSpaceOutpostScreen(this);
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
		
		JLabel lblCurrentMoney = new JLabel("Current Money:");
		lblCurrentMoney.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCurrentMoney.setBounds(54, 14, 162, 25);
		frame.getContentPane().add(lblCurrentMoney);
		
		JLabel lblMoney = new JLabel(Integer.toString(manager.getCurrentMoney()));
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMoney.setBounds(217, 15, 64, 24);
		frame.getContentPane().add(lblMoney);
		
		
		//Burger
		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblBurger.setBounds(76, 65, 90, 33);
		frame.getContentPane().add(lblBurger);
		
		JLabel lblBurgerImage = new JLabel("");
		lblBurgerImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(burger.getImagePath())));
		lblBurgerImage.setBounds(54, 103, 128, 128);
		frame.getContentPane().add(lblBurgerImage);
		
		JLabel lblEnergy = new JLabel("Energy:");
		lblEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy.setBounds(220, 149, 64, 25);
		frame.getContentPane().add(lblEnergy);
		
		JLabel lblBuyPrice = new JLabel("Buy Price:");
		lblBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice.setBounds(220, 175, 83, 25);
		frame.getContentPane().add(lblBuyPrice);
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		lblSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice.setBounds(220, 200, 83, 25);
		frame.getContentPane().add(lblSellPrice);
		
		JLabel lblCurrent = new JLabel("Current:");
		lblCurrent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent.setBounds(220, 226, 72, 25);
		frame.getContentPane().add(lblCurrent);
		
		JLabel lblBurgerBuyPrice = new JLabel(Integer.toString(burger.getPriceToBuy()));
		lblBurgerBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBurgerBuyPrice.setBounds(304, 175, 40, 25);
		frame.getContentPane().add(lblBurgerBuyPrice);
		
		JLabel lblBurgerEnergy = new JLabel(Integer.toString(burger.getEnergy()));
		lblBurgerEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBurgerEnergy.setBounds(304, 149, 40, 25);
		frame.getContentPane().add(lblBurgerEnergy);
		
		JLabel lblBurgerSellPrice = new JLabel(Integer.toString(burger.getPriceToSell()));
		lblBurgerSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBurgerSellPrice.setBounds(304, 200, 40, 25);
		frame.getContentPane().add(lblBurgerSellPrice);
		
		JLabel lblCurrentBurgers = new JLabel(Integer.toString(burger.getQuantity()));
		lblCurrentBurgers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentBurgers.setBounds(304, 227, 40, 22);
		frame.getContentPane().add(lblCurrentBurgers);
		
		JButton btnBuyBurger = new JButton("Buy");
		btnBuyBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(burger);
				lblCurrentBurgers.setText(Integer.toString(burger.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyBurger.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyBurger.setBackground(new Color(153, 204, 204));
		btnBuyBurger.setBounds(220, 99, 98, 25);
		frame.getContentPane().add(btnBuyBurger);
		
		JButton btnSellBurger = new JButton("Sell");
		btnSellBurger.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(burger);
				lblCurrentBurgers.setText(Integer.toString(burger.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellBurger.setBackground(new Color(153, 204, 204));
		btnSellBurger.setBounds(220, 122, 98, 25);
		frame.getContentPane().add(btnSellBurger);
		
		
		//Pizza
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizza.setBounds(413, 65, 72, 33);
		frame.getContentPane().add(lblPizza);
		
		JLabel lblPizzaImage = new JLabel("");
		lblPizzaImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(pizza.getImagePath())));
		lblPizzaImage.setBounds(378, 103, 128, 128);
		frame.getContentPane().add(lblPizzaImage);
		
		JLabel lblEnergy1 = new JLabel("Energy:");
		lblEnergy1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy1.setBounds(532, 149, 64, 25);
		frame.getContentPane().add(lblEnergy1);
		
		JLabel lblBuyPrice1 = new JLabel("Buy Price:");
		lblBuyPrice1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice1.setBounds(532, 175, 83, 25);
		frame.getContentPane().add(lblBuyPrice1);
		
		JLabel lblSellPrice1 = new JLabel("Sell Price:");
		lblSellPrice1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice1.setBounds(532, 200, 83, 25);
		frame.getContentPane().add(lblSellPrice1);
		
		JLabel lblCurrent1 = new JLabel("Current:");
		lblCurrent1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent1.setBounds(532, 226, 72, 25);
		frame.getContentPane().add(lblCurrent1);
		
		JLabel lblPizzaEnergy = new JLabel(Integer.toString(pizza.getEnergy()));
		lblPizzaEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPizzaEnergy.setBounds(632, 149, 50, 25);
		frame.getContentPane().add(lblPizzaEnergy);
		
		JLabel lblPizzaBuyPrice = new JLabel(Integer.toString(pizza.getPriceToBuy()));
		lblPizzaBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPizzaBuyPrice.setBounds(632, 175, 50, 25);
		frame.getContentPane().add(lblPizzaBuyPrice);
		
		JLabel lblPizzaSellPrice = new JLabel(Integer.toString(pizza.getPriceToSell()));
		lblPizzaSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPizzaSellPrice.setBounds(632, 200, 40, 25);
		frame.getContentPane().add(lblPizzaSellPrice);
		
		JLabel lblCurrentPizzas = new JLabel(Integer.toString(pizza.getQuantity()));
		lblCurrentPizzas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentPizzas.setBounds(632, 228, 40, 22);
		frame.getContentPane().add(lblCurrentPizzas);
		
		JButton btnBuyPizza = new JButton("Buy");
		btnBuyPizza.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(pizza);
				lblCurrentPizzas.setText(Integer.toString(pizza.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyPizza.setBackground(new Color(153, 204, 204));
		btnBuyPizza.setBounds(532, 99, 98, 25);
		frame.getContentPane().add(btnBuyPizza);
		
		JButton btnSellPizza = new JButton("Sell");
		btnSellPizza.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(pizza);
				lblCurrentPizzas.setText(Integer.toString(pizza.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellPizza.setBackground(new Color(153, 204, 204));
		btnSellPizza.setBounds(532, 122, 98, 25);
		frame.getContentPane().add(btnSellPizza);
		
		
		//Ice Cream
		
		JLabel lblSellPrice2 = new JLabel("Sell Price:");
		lblSellPrice2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice2.setBounds(875, 200, 84, 25);
		frame.getContentPane().add(lblSellPrice2);
		
		JLabel lblBuyPrice2 = new JLabel("Buy Price:");
		lblBuyPrice2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice2.setBounds(875, 175, 84, 25);
		frame.getContentPane().add(lblBuyPrice2);
		
		JLabel lblEnergy2 = new JLabel("Energy:");
		lblEnergy2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy2.setBounds(875, 149, 64, 25);
		frame.getContentPane().add(lblEnergy2);
		
		JLabel lblIceCreamImage = new JLabel("");
		lblIceCreamImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(iceCream.getImagePath())));
		lblIceCreamImage.setBounds(707, 103, 128, 128);
		frame.getContentPane().add(lblIceCreamImage);
		
		JLabel lblCurrent2 = new JLabel("Current:");
		lblCurrent2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent2.setBounds(875, 228, 72, 25);
		frame.getContentPane().add(lblCurrent2);
		
		JLabel lblIceCreamSellPrice = new JLabel(Integer.toString(iceCream.getPriceToSell()));
		lblIceCreamSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIceCreamSellPrice.setBounds(965, 200, 40, 25);
		frame.getContentPane().add(lblIceCreamSellPrice);
		
		JLabel lblIceCreamBuyPrice = new JLabel(Integer.toString(iceCream.getPriceToBuy()));
		lblIceCreamBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIceCreamBuyPrice.setBounds(965, 175, 40, 25);
		frame.getContentPane().add(lblIceCreamBuyPrice);
		
		JLabel lblIceCreamEnergy = new JLabel(Integer.toString(iceCream.getEnergy()));
		lblIceCreamEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIceCreamEnergy.setBounds(965, 149, 40, 25);
		frame.getContentPane().add(lblIceCreamEnergy);
		
		JLabel lblIceCream = new JLabel("Ice Cream");
		lblIceCream.setHorizontalAlignment(SwingConstants.CENTER);
		lblIceCream.setBounds(707, 65, 129, 33);
		frame.getContentPane().add(lblIceCream);
		
		JLabel lblCurrentIceCreams = new JLabel(Integer.toString(iceCream.getQuantity()));
		lblCurrentIceCreams.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentIceCreams.setBounds(965, 228, 40, 22);
		frame.getContentPane().add(lblCurrentIceCreams);
		
		JButton btnBuyIceCream = new JButton("Buy");
		btnBuyIceCream.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					manager.buyItem(iceCream);
					lblCurrentIceCreams.setText(Integer.toString(iceCream.getQuantity()));
					lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyIceCream.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyIceCream.setBackground(new Color(153, 204, 204));
		btnBuyIceCream.setBounds(875, 99, 98, 25);
		frame.getContentPane().add(btnBuyIceCream);
		
		JButton btnSellIceCream = new JButton("Sell");
		btnSellIceCream.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(iceCream);
				lblCurrentIceCreams.setText(Integer.toString(iceCream.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellIceCream.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellIceCream.setBackground(new Color(153, 204, 204));
		btnSellIceCream.setBounds(875, 122, 98, 25);
		frame.getContentPane().add(btnSellIceCream);
		
		
		//Strawberry
		
		JLabel lblSellPrice3 = new JLabel("Sell Price:");
		lblSellPrice3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice3.setBounds(220, 392, 83, 25);
		frame.getContentPane().add(lblSellPrice3);
		
		JLabel lblBuyPrice3 = new JLabel("Buy Price:");
		lblBuyPrice3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice3.setBounds(220, 365, 83, 25);
		frame.getContentPane().add(lblBuyPrice3);
		
		JLabel lblEnergy3 = new JLabel("Energy:");
		lblEnergy3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy3.setBounds(220, 339, 64, 25);
		frame.getContentPane().add(lblEnergy3);
		
		JLabel lblStrawberryImage = new JLabel("");
		lblStrawberryImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(strawberry.getImagePath())));
		lblStrawberryImage.setBounds(54, 289, 128, 128);
		frame.getContentPane().add(lblStrawberryImage);
		
		JLabel lblCurrent3 = new JLabel("Current:");
		lblCurrent3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent3.setBounds(220, 418, 72, 25);
		frame.getContentPane().add(lblCurrent3);
		
		JLabel lblCurrentStrawberries = new JLabel(Integer.toString(strawberry.getQuantity()));
		lblCurrentStrawberries.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentStrawberries.setBounds(304, 418, 40, 22);
		frame.getContentPane().add(lblCurrentStrawberries);
		
		JLabel lblStrawberrySellPrice = new JLabel(Integer.toString(strawberry.getPriceToSell()));
		lblStrawberrySellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStrawberrySellPrice.setBounds(304, 390, 40, 25);
		frame.getContentPane().add(lblStrawberrySellPrice);
		
		JLabel lblStrawberryBuyPrice = new JLabel(Integer.toString(strawberry.getPriceToBuy()));
		lblStrawberryBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStrawberryBuyPrice.setBounds(304, 365, 40, 25);
		frame.getContentPane().add(lblStrawberryBuyPrice);
		
		JLabel lblStrawberryEnergy = new JLabel(Integer.toString(strawberry.getEnergy()));
		lblStrawberryEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStrawberryEnergy.setBounds(304, 339, 40, 25);
		frame.getContentPane().add(lblStrawberryEnergy);
		
		JLabel lblStrawberry = new JLabel("Strawberry");
		lblStrawberry.setHorizontalAlignment(SwingConstants.CENTER);
		lblStrawberry.setBounds(54, 250, 139, 33);
		frame.getContentPane().add(lblStrawberry);
		
		JButton btnBuyStrawberry = new JButton("Buy");
		btnBuyStrawberry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(strawberry);
				lblCurrentStrawberries.setText(Integer.toString(strawberry.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyStrawberry.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyStrawberry.setBackground(new Color(153, 204, 204));
		btnBuyStrawberry.setBounds(220, 289, 98, 25);
		frame.getContentPane().add(btnBuyStrawberry);
		
		JButton btnSellStrawberry = new JButton("Sell");
		btnSellStrawberry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(strawberry);
				lblCurrentStrawberries.setText(Integer.toString(strawberry.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellStrawberry.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellStrawberry.setBackground(new Color(153, 204, 204));
		btnSellStrawberry.setBounds(220, 312, 98, 25);
		frame.getContentPane().add(btnSellStrawberry);
		
		
		//Drink
		
		JLabel lblSellPrice4 = new JLabel("Sell Price:");
		lblSellPrice4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice4.setBounds(538, 392, 84, 25);
		frame.getContentPane().add(lblSellPrice4);
		
		JLabel lblBuyPrice4 = new JLabel("Buy Price:");
		lblBuyPrice4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice4.setBounds(538, 365, 84, 25);
		frame.getContentPane().add(lblBuyPrice4);
		
		JLabel lblEnergy4 = new JLabel("Energy:");
		lblEnergy4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy4.setBounds(538, 339, 64, 25);
		frame.getContentPane().add(lblEnergy4);
		
		JLabel lblDrinkImage = new JLabel("");
		lblDrinkImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(drink.getImagePath())));
		lblDrinkImage.setBounds(378, 289, 128, 128);
		frame.getContentPane().add(lblDrinkImage);
		
		JLabel lblCurrent4 = new JLabel("Current:");
		lblCurrent4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent4.setBounds(538, 418, 72, 25);
		frame.getContentPane().add(lblCurrent4);
		
		JLabel lblCurrentDrinks = new JLabel(Integer.toString(drink.getQuantity()));
		lblCurrentDrinks.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentDrinks.setBounds(632, 421, 40, 22);
		frame.getContentPane().add(lblCurrentDrinks);
		
		JLabel lblDrinkSellPrice = new JLabel(Integer.toString(drink.getPriceToSell()));
		lblDrinkSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDrinkSellPrice.setBounds(632, 393, 40, 25);
		frame.getContentPane().add(lblDrinkSellPrice);
		
		JLabel lblDrinkBuyPrice = new JLabel(Integer.toString(drink.getPriceToBuy()));
		lblDrinkBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDrinkBuyPrice.setBounds(632, 368, 40, 25);
		frame.getContentPane().add(lblDrinkBuyPrice);
		
		JLabel lblDrinkEnergy = new JLabel(Integer.toString(drink.getEnergy()));
		lblDrinkEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDrinkEnergy.setBounds(632, 342, 40, 25);
		frame.getContentPane().add(lblDrinkEnergy);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrink.setBounds(413, 250, 64, 33);
		frame.getContentPane().add(lblDrink);
		
		JButton btnBuyDrink = new JButton("Buy");
		btnBuyDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(drink);
				lblCurrentDrinks.setText(Integer.toString(drink.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyDrink.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyDrink.setBackground(new Color(153, 204, 204));
		btnBuyDrink.setBounds(538, 289, 98, 25);
		frame.getContentPane().add(btnBuyDrink);
		
		JButton btnSellDrink = new JButton("Sell");
		btnSellDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(drink);
				lblCurrentDrinks.setText(Integer.toString(drink.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellDrink.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellDrink.setBackground(new Color(153, 204, 204));
		btnSellDrink.setBounds(538, 312, 98, 25);
		frame.getContentPane().add(btnSellDrink);
		
		
		//Chicken
		
		JLabel lblSellPrice5 = new JLabel("Sell Price:");
		lblSellPrice5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice5.setBounds(875, 392, 84, 25);
		frame.getContentPane().add(lblSellPrice5);
		
		JLabel lblBuyPrice5 = new JLabel("Buy Price:");
		lblBuyPrice5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice5.setBounds(875, 365, 84, 25);
		frame.getContentPane().add(lblBuyPrice5);
		
		JLabel lblEnergy5 = new JLabel("Energy:");
		lblEnergy5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy5.setBounds(875, 339, 64, 25);
		frame.getContentPane().add(lblEnergy5);
		
		JLabel lblChickenImage = new JLabel("");
		lblChickenImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(chicken.getImagePath())));
		lblChickenImage.setBounds(707, 289, 128, 128);
		frame.getContentPane().add(lblChickenImage);
		
		JLabel lblCurrent5 = new JLabel("Current:");
		lblCurrent5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent5.setBounds(875, 418, 72, 25);
		frame.getContentPane().add(lblCurrent5);
		
		JLabel lblCurrentChickens = new JLabel(Integer.toString(chicken.getQuantity()));
		lblCurrentChickens.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentChickens.setBounds(965, 418, 40, 22);
		frame.getContentPane().add(lblCurrentChickens);
		
		JLabel lblChickenSellPrice = new JLabel(Integer.toString(chicken.getPriceToSell()));
		lblChickenSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChickenSellPrice.setBounds(965, 390, 40, 25);
		frame.getContentPane().add(lblChickenSellPrice);
		
		JLabel lblChickenBuyPrice = new JLabel(Integer.toString(chicken.getPriceToBuy()));
		lblChickenBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChickenBuyPrice.setBounds(965, 365, 40, 25);
		frame.getContentPane().add(lblChickenBuyPrice);
		
		JLabel lblChickenEnergy = new JLabel(Integer.toString(chicken.getEnergy()));
		lblChickenEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChickenEnergy.setBounds(965, 339, 40, 25);
		frame.getContentPane().add(lblChickenEnergy);
		
		JLabel lblChicken = new JLabel("Chicken");
		lblChicken.setHorizontalAlignment(SwingConstants.CENTER);
		lblChicken.setBounds(717, 250, 98, 33);
		frame.getContentPane().add(lblChicken);
		
		JButton btnBuyChicken = new JButton("Buy");
		btnBuyChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(chicken);
				lblCurrentChickens.setText(Integer.toString(chicken.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyChicken.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyChicken.setBackground(new Color(153, 204, 204));
		btnBuyChicken.setBounds(875, 289, 98, 25);
		frame.getContentPane().add(btnBuyChicken);
		
		JButton btnSellChicken = new JButton("Sell");
		btnSellChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(chicken);
				lblCurrentChickens.setText(Integer.toString(chicken.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellChicken.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellChicken.setBackground(new Color(153, 204, 204));
		btnSellChicken.setBounds(875, 312, 98, 25);
		frame.getContentPane().add(btnSellChicken);
		
		
		//Cough Medicine
		
		JLabel lblSellPrice6 = new JLabel("Sell Price:");
		lblSellPrice6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice6.setBounds(220, 581, 83, 25);
		frame.getContentPane().add(lblSellPrice6);
		
		JLabel lblBuyPrice6 = new JLabel("Buy Price:");
		lblBuyPrice6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice6.setBounds(220, 554, 83, 25);
		frame.getContentPane().add(lblBuyPrice6);
		
		JLabel lblEnergy6 = new JLabel("Health:");
		lblEnergy6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy6.setBounds(220, 528, 64, 25);
		frame.getContentPane().add(lblEnergy6);
		
		JLabel lblCoughMedicineImage = new JLabel("");
		lblCoughMedicineImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(coughMedicine.getImagePath())));
		lblCoughMedicineImage.setBounds(54, 478, 128, 128);
		frame.getContentPane().add(lblCoughMedicineImage);
		
		JLabel lblCurrent6 = new JLabel("Current:");
		lblCurrent6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent6.setBounds(220, 607, 72, 25);
		frame.getContentPane().add(lblCurrent6);
		
		JLabel lblCurrentCoughMedicine = new JLabel(Integer.toString(coughMedicine.getQuantity()));
		lblCurrentCoughMedicine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentCoughMedicine.setBounds(304, 607, 40, 22);
		frame.getContentPane().add(lblCurrentCoughMedicine);
		
		JLabel lblCoughMedicineSellPrice = new JLabel(Integer.toString(coughMedicine.getPriceToSell()));
		lblCoughMedicineSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoughMedicineSellPrice.setBounds(304, 579, 40, 25);
		frame.getContentPane().add(lblCoughMedicineSellPrice);
		
		JLabel lblCoughMedicineBuyPrice = new JLabel(Integer.toString(coughMedicine.getPriceToBuy()));
		lblCoughMedicineBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoughMedicineBuyPrice.setBounds(304, 554, 40, 25);
		frame.getContentPane().add(lblCoughMedicineBuyPrice);
		
		JLabel lblCoughMedicineEnergy = new JLabel(Integer.toString(coughMedicine.getEnergy()));
		lblCoughMedicineEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoughMedicineEnergy.setBounds(304, 528, 40, 25);
		frame.getContentPane().add(lblCoughMedicineEnergy);
		
		JLabel lblCoughMedicine = new JLabel("Cough Medicine");
		lblCoughMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoughMedicine.setBounds(26, 439, 193, 33);
		frame.getContentPane().add(lblCoughMedicine);
		
		JButton btnSellCoughMedicine = new JButton("Sell");
		btnSellCoughMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(coughMedicine);
				lblCurrentCoughMedicine.setText(Integer.toString(coughMedicine.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellCoughMedicine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellCoughMedicine.setBackground(new Color(153, 204, 204));
		btnSellCoughMedicine.setBounds(220, 501, 98, 25);
		frame.getContentPane().add(btnSellCoughMedicine);
		
		JButton btnBuyCoughMedicine = new JButton("Buy");
		btnBuyCoughMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(coughMedicine);
				lblCurrentCoughMedicine.setText(Integer.toString(coughMedicine.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuyCoughMedicine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuyCoughMedicine.setBackground(new Color(153, 204, 204));
		btnBuyCoughMedicine.setBounds(220, 475, 98, 25);
		frame.getContentPane().add(btnBuyCoughMedicine);
		
		
		//Plague
		JLabel lblCurrentSpacePlagueCure = new JLabel(Integer.toString(spacePlagueCure.getQuantity()));
		lblCurrentSpacePlagueCure.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentSpacePlagueCure.setBounds(632, 610, 40, 22);
		frame.getContentPane().add(lblCurrentSpacePlagueCure);
		
		JButton btnSellSpacePlagueCure = new JButton("Sell");
		btnSellSpacePlagueCure.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellSpacePlagueCure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.sellItem(spacePlagueCure);
				lblCurrentSpacePlagueCure.setText(Integer.toString(spacePlagueCure.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellSpacePlagueCure.setBackground(new Color(153, 204, 204));
		btnSellSpacePlagueCure.setBounds(538, 501, 98, 25);
		frame.getContentPane().add(btnSellSpacePlagueCure);
		
		JButton btnBuySpacePlagueCure = new JButton("Buy");
		btnBuySpacePlagueCure.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuySpacePlagueCure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.buyItem(spacePlagueCure);
				lblCurrentSpacePlagueCure.setText(Integer.toString(spacePlagueCure.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuySpacePlagueCure.setBackground(new Color(153, 204, 204));
		btnBuySpacePlagueCure.setBounds(538, 475, 98, 25);
		frame.getContentPane().add(btnBuySpacePlagueCure);
		
		JLabel lblSellPrice7 = new JLabel("Sell Price:");
		lblSellPrice7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice7.setBounds(538, 581, 84, 25);
		frame.getContentPane().add(lblSellPrice7);
		
		JLabel lblBuyPrice7 = new JLabel("Buy Price:");
		lblBuyPrice7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice7.setBounds(538, 554, 84, 25);
		frame.getContentPane().add(lblBuyPrice7);
		
		JLabel lblEnergy7 = new JLabel("Health:");
		lblEnergy7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy7.setBounds(538, 528, 64, 25);
		frame.getContentPane().add(lblEnergy7);
		
		JLabel lblSpacePlagueImage = new JLabel("");
		lblSpacePlagueImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(spacePlagueCure.getImagePath())));
		lblSpacePlagueImage.setBounds(384, 478, 128, 128);
		frame.getContentPane().add(lblSpacePlagueImage);
		
		JLabel lblCurrent7 = new JLabel("Current:");
		lblCurrent7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent7.setBounds(538, 607, 72, 25);
		frame.getContentPane().add(lblCurrent7);
		
		JLabel lblSpacePlagueCureSellPrice = new JLabel(Integer.toString(spacePlagueCure.getPriceToSell()));
		lblSpacePlagueCureSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpacePlagueCureSellPrice.setBounds(632, 582, 40, 25);
		frame.getContentPane().add(lblSpacePlagueCureSellPrice);
		
		JLabel lblSpacePlagueCureBuyPrice = new JLabel(Integer.toString(spacePlagueCure.getPriceToBuy()));
		lblSpacePlagueCureBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpacePlagueCureBuyPrice.setBounds(632, 557, 40, 25);
		frame.getContentPane().add(lblSpacePlagueCureBuyPrice);
		
		JLabel lblSpacePlagueCureEnergy = new JLabel(Integer.toString(spacePlagueCure.getEnergy()));
		lblSpacePlagueCureEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpacePlagueCureEnergy.setBounds(632, 531, 40, 25);
		frame.getContentPane().add(lblSpacePlagueCureEnergy);
		
		JLabel lblSpacePlagueCure = new JLabel("Space Plague Cure");
		lblSpacePlagueCure.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpacePlagueCure.setBounds(344, 439, 228, 33);
		frame.getContentPane().add(lblSpacePlagueCure);
		
		
		//FeverMedicine
		JLabel lblSpaceMedicine = new JLabel("Fever Medicine");
		lblSpaceMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceMedicine.setBounds(678, 439, 193, 33);
		frame.getContentPane().add(lblSpaceMedicine);
		
		JLabel lblSellPrice8 = new JLabel("Sell Price:");
		lblSellPrice8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSellPrice8.setBounds(875, 581, 84, 25);
		frame.getContentPane().add(lblSellPrice8);
		
		JLabel lblBuyPrice8 = new JLabel("Buy Price:");
		lblBuyPrice8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuyPrice8.setBounds(875, 554, 84, 25);
		frame.getContentPane().add(lblBuyPrice8);
		
		JLabel lblEnergy8 = new JLabel("Health:");
		lblEnergy8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnergy8.setBounds(875, 528, 64, 25);
		frame.getContentPane().add(lblEnergy8);
		
		JLabel lblCurrentSpaceMedicine = new JLabel(Integer.toString(feverMedicine.getQuantity()));
		lblCurrentSpaceMedicine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentSpaceMedicine.setBounds(965, 610, 40, 22);
		frame.getContentPane().add(lblCurrentSpaceMedicine);
		
		JButton btnSellSpaceMedicine = new JButton("Sell");
		btnSellSpaceMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.sellItem(feverMedicine);
				lblCurrentSpaceMedicine.setText(Integer.toString(feverMedicine.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnSellSpaceMedicine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSellSpaceMedicine.setBackground(new Color(153, 204, 204));
		btnSellSpaceMedicine.setBounds(875, 501, 98, 25);
		frame.getContentPane().add(btnSellSpaceMedicine);
		
		
		JButton btnBuySpaceMedicine = new JButton("Buy");
		btnBuySpaceMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.buyItem(feverMedicine);
				lblCurrentSpaceMedicine.setText(Integer.toString(feverMedicine.getQuantity()));
				lblMoney.setText(Integer.toString(manager.getCurrentMoney()));
			}
		});
		btnBuySpaceMedicine.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuySpaceMedicine.setBackground(new Color(153, 204, 204));
		btnBuySpaceMedicine.setBounds(875, 475, 98, 25);
		frame.getContentPane().add(btnBuySpaceMedicine);
		
		JLabel lblSpaceMedicineImage = new JLabel("");
		lblSpaceMedicineImage.setIcon(new ImageIcon(SpaceOutpostScreen.class.getResource(feverMedicine.getImagePath())));
		lblSpaceMedicineImage.setBounds(707, 478, 128, 128);
		frame.getContentPane().add(lblSpaceMedicineImage);
		
		JLabel lblCurrent8 = new JLabel("Current:");
		lblCurrent8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrent8.setBounds(875, 607, 72, 25);
		frame.getContentPane().add(lblCurrent8);
		
		
		JLabel lblSpaceMedicineSellPrice = new JLabel(Integer.toString(feverMedicine.getPriceToSell()));
		lblSpaceMedicineSellPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpaceMedicineSellPrice.setBounds(965, 582, 40, 25);
		frame.getContentPane().add(lblSpaceMedicineSellPrice);
		
		JLabel lblSpaceMedicineBuyPrice = new JLabel(Integer.toString(feverMedicine.getPriceToBuy()));
		lblSpaceMedicineBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpaceMedicineBuyPrice.setBounds(965, 557, 40, 25);
		frame.getContentPane().add(lblSpaceMedicineBuyPrice);
		
		JLabel lblSpaceMedicineEnergy = new JLabel(Integer.toString(feverMedicine.getEnergy()));
		lblSpaceMedicineEnergy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSpaceMedicineEnergy.setBounds(965, 531, 40, 25);
		frame.getContentPane().add(lblSpaceMedicineEnergy);
		
		//Extra
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(153, 204, 204));
		separator.setBounds(0, 48, 1048, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblSpaceOutpost = new JLabel("Space Outpost");
		lblSpaceOutpost.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSpaceOutpost.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceOutpost.setBounds(368, 0, 264, 50);
		frame.getContentPane().add(lblSpaceOutpost);		
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnDone.setBackground(new Color(153, 204, 204));
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDone.setBounds(851, 4, 171, 41);
		frame.getContentPane().add(btnDone);
	}
}
