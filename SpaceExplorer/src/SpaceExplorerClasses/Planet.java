package SpaceExplorerClasses;

import java.util.Random;

public class Planet {

	Boolean partFoundHere	= false;
	Boolean searchedToday 	= false;
	
	Spaceship spaceship;
	Inventory inventory;
	Crew	  crew;
	GameEnvironment currentManager;
	
	/**
	 * constructor for planet objects
	 * @param manager - where to pull in planet attributes
	 */
	public Planet(GameEnvironment manager) {
		inventory = manager.getInventory();
		spaceship = manager.getSpaceship();
		crew = manager.getCrew();
		currentManager = manager;
	}
	
	/**
	 * makes a part appear on planet
	 * @param found - part found on planet
	 */
	public void setPartFoundHere(Boolean found) {
		partFoundHere = found;
	}
	
	/**
	 * 
	 * @return - the part found on the planet
	 */
	public Boolean getPartFoundHere() {
		return partFoundHere;
	}
	
	/**
	 * 
	 * @param searched - true if the planet had been searched that day
	 */
	public void setSearchedToday(Boolean searched) {
		searchedToday = searched;
	}
	
	/**
	 * 
	 * @return - true if the planet had been searched that day
	 */
	public Boolean getSearchedToday() {
		return searchedToday;
	}
	
	/**
	 * generates a random object part to be found on the planet
	 * @return - the item found on planet
	 */
	public String SearchForItem() {
		String itemFound = "";
		
		if(spaceship.pilotSpaceship()) {
		Random rand = new Random();
		int value = rand.nextInt(4);
		
		switch(value) {
		case 0:
			itemFound = crew.foundMoney();
			//Money found
			break;
			
		case 1:
			Collectibles item = inventory.RandomItemAction("add");
			itemFound = "Found: " + item.toString();
			//Item Found
			break;
			
		case 2:
			//Nothing happens
			itemFound = "Nothing here";
			break;
			
		case 3:
			partFound();
			currentManager.setScore(currentManager.getScore()+50);
			itemFound = "Found a transporter part!";
			//Spaceship part Found
			break;
		}
		setSearchedToday(true);
		}else {
			itemFound = "Can't search, no petrol";
		}
		
		return itemFound;
	}
	
	/**
	 * this planet has had a part found on it
	 */
	public void partFound() {
		crew.foundPart();
		setPartFoundHere(true);
	}
	
	/**
	 * this planet has not been searched today
	 */
	public void dailyUpdate() {
		setSearchedToday(false);
	}
	
}
