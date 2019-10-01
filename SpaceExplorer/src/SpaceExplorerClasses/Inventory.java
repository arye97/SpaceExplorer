package SpaceExplorerClasses;
import java.util.ArrayList;
import java.util.Random;

import Articles.*;

public class Inventory {
	
	GameEnvironment currentManager;
	
	Crew crew;
	
	private ArrayList<Collectibles> medicineList= new ArrayList<Collectibles>(3);
	PlagueCure plagueCure						= new PlagueCure();
	CoughMedicine coughMedicine					= new CoughMedicine();
	FeverMedicine feverMedicine 				= new FeverMedicine();

	private ArrayList<Collectibles> foodList 	= new ArrayList<Collectibles>(6);

	Burger burger 								= new Burger();
	IceCream iceCream 							= new IceCream();
	Pizza pizza 								= new Pizza();
	Strawberry strawberry 						= new Strawberry();
	Chicken chicken 							= new Chicken();
	Drink drink 								= new Drink(); 
	
	/**
	 * creates new inventory for currentCrew
	 * @param currentCrew - the current crew that is being used
	 */
	public Inventory(Crew currentCrew) {
		crew = currentCrew;
		
		foodList.add(burger);
		foodList.add(pizza);
		foodList.add(iceCream);
		foodList.add(strawberry);
		foodList.add(drink);
		foodList.add(chicken);
		
		medicineList.add(plagueCure);
		medicineList.add(coughMedicine);
		medicineList.add(feverMedicine);
		
	}
	
	/**
	 * adds item to inventory
	 * @param item - to be added to inventory
	 */
	public void addToInventory(Collectibles item) {
		item.setQuantity(item.getQuantity() + 1);
	}
	
	/**
	 * removes item from inventory
	 * @param item - to be removed
	 * @return - true if successfully added
	 */
	public Boolean removeFromInventory(Collectibles item) {
		if (item.getQuantity() > 0) {
			item.setQuantity(item.getQuantity() - 1);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param object - object to be bought
	 */
	public void BuyObject(Collectibles object) {
		if(crew.getMoney() >= object.getPriceToBuy()) {
			addToInventory(object);
			crew.setMoney(crew.getMoney() - object.getPriceToBuy());
		}
	}
	
	/**
	 * 
	 * @param object - to be sold
	 */
	public void SellObject(Collectibles object) {
		if (removeFromInventory(object)) {
			crew.setMoney(crew.getMoney() + object.getPriceToSell());
		}
	}
	
	
	/**Either adds or remove a random item from the inventory according
	 * to what is the desired action. Input accepted is either "add" or "remove"
	 * @param action - the current action of the item (add or remove)
	 * @return - returns the item
	 */
	public Collectibles RandomItemAction(String action) {
		Collectibles item = null;
		
		Random rand = new Random(); 
		int value = rand.nextInt(foodList.size() + medicineList.size());
		
		switch (value) {
			case 0:
				item = burger;
				break;
				
			case 1:
				item = iceCream;
				break;
				
			case 2:
				item = strawberry;
				break;
				
			case 3:
				item = pizza;
				break;
			
			case 4:
				item = chicken;
				break;
				
			case 5:
				item = drink;
				break;
				
			case 6:
				item = plagueCure;
				break;
				
			case 7:
				item = coughMedicine;
				break;
				
			case 8:
				item = feverMedicine;
				break;
			}
		if(action.equals("add")) {
			addToInventory(item);
			return item;
		}
		if(action.equals("remove")) {
			if (removeFromInventory(item)) {
				return item;
			}else {
				return null;
			}
		}
		return item;
		
	}
	
	/**
	 * removes the plague cure from inventory
	 */
	public void cureSpacePlague() {
		removeFromInventory(plagueCure);
	}

	/**
	 * gets total amount of food in the inventory
	 * @return - amount of food in inventory
	 */
	public int totalFood() {
		int foodCounter = 0;
		for ( int i=0; i< foodList.size(); i++) {
			foodCounter += foodList.get(i).getQuantity();
		}
		return foodCounter;
	}
	
	/**
	 * gets total amount of medicine in the inventory
	 * @return - amount of medicine in inventory
	 */
	public int totalMedicine() {
		int medicineCounter = 0;
		for ( int i=0; i< medicineList.size(); i++) {
			medicineCounter += medicineList.get(i).getQuantity();
		}
		return medicineCounter;
	}
	
	/**
	 * finds the food at index in foodList
	 * @param index - where to look in foodList
	 * @return - the food found
	 */
	public Collectibles getFoodOnIndex(int index) {
		return foodList.get(index);
	}

	/**
	 * finds the medicine at index in foodList
	 * @param index - where to look in foodList
	 * @return - the medicine found
	 */
	public Collectibles getMedicineOnIndex(int index) {
		return medicineList.get(index);
	}
}