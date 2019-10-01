package SpaceExplorerClasses;
import java.util.ArrayList;
import java.util.Random;

import GUI.*;

public class GameEnvironment {
	
	//Fields
	private Crew currentCrew 				= new Crew();
	private Inventory currentInventory 		= new Inventory(currentCrew);
	private Spaceship currentSpaceship 		= new Spaceship();
	private ArrayList <Planet> planets		= new ArrayList<Planet>(7);
	
	private Boolean gameOver				= false;
	private int daysInSpace					= 3;
	private int currentDay					= 1;
	private int partsMissing				= 2;
	private int score						= 0;
	private String randomEventOfDay			= "";
	private String currentFeedback			= "Search a Planet";
	//Setters and Getters
	
	//Days in Space
	/**
	 * gets the current score of the current game
	 * @return - current score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * updates current game score to provided score
	 * @param newScore - new score for the game
	 */
	public void setScore(int newScore) {
		score = newScore;
	}
	
	/**
	 * gets the random event that occurs that day
	 * @return - random event of the day
	 */
	public String getRandomDayEvent() {
		return randomEventOfDay;
	}
	
	/**
	 * gets the num of current parts the crew has found
	 * @return - int num of amount of parts found
	 */
	public int getCurrentParts() {
		return currentCrew.getCurrentPartsFound();
	}
	
	/**
	 * gets the current feedback for the player to see
	 * @return - the current string message feedback
	 */
	public String getCurrentFeedback() {
		return currentFeedback;
	}

	/**
	 * sets the feedback to a new string
	 * @param currentFeedback - is the new feedback string
	 */
	public void setCurrentFeedback(String currentFeedback) {
		this.currentFeedback = currentFeedback;
	}

	/**
	 * sets the amount of current petrol based on the num of parts found
	 * @param totalParts - num parts found by crew
	 */
	public void StartPetrol(int totalParts) {
		Spaceship.setStartPetrol(totalParts);
		currentSpaceship.setPetrol(Spaceship.getMaxPetrol());
	}
	
	/**
	 * gets if the game has been won
	 * @return - true if game won, else false
	 */
	public Boolean gameWon() {
		if(currentCrew.getCurrentPartsFound() == partsToFind()) {
			gameOver =  true;
		}else {
			gameOver = false;
		}
		return gameOver;
	}
	
	/**
	 * checks if the game is over
	 * @return - true if game is over
	 */
	public Boolean checkGameOver() {
		return gameOver;
	}
	
	/**
	 * gets number of parts left to find
	 * @return - num of parts left to find
	 */
	public int partsToFind() {
		partsMissing = daysInSpace * 2 / 3;
		return partsMissing;
	}
	
	/**
	 * gets the current day
	 * @return - returns current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	
	/**
	 * 
	 * @param newDay - day we want to go to
	 */
	public void setCurrentDay(int newDay) {
		currentDay = newDay;
	}
	
	/**
	 * 
	 * @return - days the crew has been in space
	 */
	public int getDaysInSpace() {
		return daysInSpace;
	}

	/**
	 * 
	 * @param daysInSpace - the amount of days we say they have been in space
	 */
	public void setDaysInSpace(int daysInSpace) {
		this.daysInSpace = daysInSpace;
	}
	
	/**
	 * sets up a new day for the crew to exist in
	 */
	public void NewDay() {
		if (getCurrentDay() + 1 <= getDaysInSpace()) {
			setCurrentDay(getCurrentDay() + 1);
		} else {
			gameOver = true;
			setScore(getScore() - 10);
		}
		currentCrew.dayUpdate();
		randomEventOfDay = RandomEvent();
		//UpdatePetrol
		currentSpaceship.setPetrol(Spaceship.getMaxPetrol());
		
		//Set the Planets back to searchToday false
		for (Planet planet: planets) {
			planet.dailyUpdate();
		}
	}
	
	/**
	 * creates a random event that occurred that day
	 * @return - the random event that has occurred for the day
	 */
	public String RandomEvent() {
		
		String eventString = "";
		Random rand = new Random();
		int value = rand.nextInt(3);
		
		switch(value) {
		case 0:
			eventString = "Nothing happened";
			break;
			
		case 1:
			Collectibles item = currentInventory.RandomItemAction("remove");
			if (item != null) {
				eventString = "Space Pirates stole: " + item.toString();
			}else {
				eventString = "Nothing happened";
			}
			break;
			
		case 2:
			int numberOfSickPeople = rand.nextInt(3);
			int indexVictim1 = rand.nextInt(getCrewSize());
			int indexVictim2 = rand.nextInt(getCrewSize());
			
			String string1 = getMemberOnIndex(indexVictim1).getName() + ", ";
			
			if (!getMemberOnIndex(indexVictim1).isSick()) {
				getMemberOnIndex(indexVictim1).setSick(true);
			}else {
				string1 = "";
			}
			
			String string2 = "";
			if(numberOfSickPeople > 1) {
				if (!getMemberOnIndex(indexVictim2).isSick()) {
					getMemberOnIndex(indexVictim2).getSpacePlague();
					string2 = getMemberOnIndex(indexVictim2).getName() + " ";
				}
			}
			eventString = string1 + string2 + "got the Space Plague.";
			break;
			
		}
		return eventString;
	}
	
	//Inventory and Space Outpost
	/**
	 * gets current spaceoutpost object
	 * @return - spaceoutpost
	 
	public Inventory getSpaceOutpost() {
		return spaceOutpost;
	}
	**/
	/**
	 * gets current inventory object
	 * @return - inventory
	 */
	public Inventory getInventory() {
		return currentInventory;
	}
	
	/**
	 * gets total remaining food
	 * @return - amount of food
	 */
	public int getTotalFood() {
		return currentInventory.totalFood();
	}
	
	/**
	 * gets total medicine remaining
	 * @return - total amount of medicine
	 */
	public int getTotalMedicine() {
		return currentInventory.totalMedicine();
	}
	
	/**
	 * gets price to buy of food at foodlist index
	 * @param index - index of the food existing at that index in food list
	 * @return - price to buy
	 */
	public int getPriceToBuyFood(int index) {
		return currentInventory.getFoodOnIndex(index).getPriceToBuy();
	}
	
	/**
	 * gets price to sell of food at foodlist index
	 * @param index - index of the food existing at that index in food list
	 * @return - price to sell
	 */
	public int getPriceToSellFood(int index) {
		return currentInventory.getFoodOnIndex(index).getPriceToSell();
	}
	
	/**
	 * gets price to buy of medicine at medicinelist index
	 * @param index - index of the medicine existing at that index in medicine list
	 * @return - price to buy
	 */
	public int getPriceToBuyMedicine(int index) {
		return currentInventory.getMedicineOnIndex(index).getPriceToBuy();
	}
	
	/**
	 * gets price to sell of medicine at medicinelist index
	 * @param index - index of the medicine existing at that index in medicine list
	 * @return - price to sell
	 */	
	public int getPriceToSellMedicine(int index) {
		return currentInventory.getMedicineOnIndex(index).getPriceToSell();
	}
	
	/**
	 * gets the food object
	 * @param index - where in the food list we're looking
	 * @return the food object
	 */
	public Collectibles getFoodOnIndex(int index) {
		return currentInventory.getFoodOnIndex(index);
	}
	
	/**
	 * gets the medicine object
	 * @param index - where in the medicine list we're looking
	 * @return the medicine object
	 */	
	public Collectibles getMedicineOnIndex(int index) {
		return currentInventory.getMedicineOnIndex(index);
	}
	
	/**
	 * gets amount of food at index remaining
	 * @param index - where we're looking
	 * @return - the amount remaining at index
	 */
	public int getCounterOfFoodOnIndex(int index) {
		return currentInventory.getFoodOnIndex(index).getQuantity();
	}
	
	/**
	 * gets amount of medicine at index remaining
	 * @param index - where we're looking
	 * @return - the amount remaining at index
	 */
	public int getCounterOfMedicineOnIndex(int index) {
		return currentInventory.getMedicineOnIndex(index).getQuantity();
	}
	
	
	//Spaceship
	
	/**
	 * returns current spaceship
	 * @return - spaceship object
	 */
	public Spaceship getSpaceship() {
		return currentSpaceship;
	}
	
	/**
	 * sets ship name to newName
	 * @param newName - new name to assign to spaceship
	 */
	public void setShipName(String newName) {
		currentSpaceship.setSpaceshipName(newName);
	}
	
	/**
	 * gets the ship name
	 * @return - the ship name
	 */
	public String getShipName() {
		return currentSpaceship.getSpaceshipName();
	}
	
	//Crew
	/**
	 * gets the crew object
	 * @return - the crew object
	 */
	public Crew getCrew() {
		return currentCrew;
	}
	
	/**
	 * 
	 * @return - amount of money the crew has
	 */
	public int getCurrentMoney() {
		return currentCrew.getMoney();
	}
	
	/**
	 * 
	 * @return - how large the crew is
	 */
	public int getCrewSize() {
		return currentCrew.howManyCrewMembers();
	}
	
	/**
	 * 
	 * @return - how large the crew needs to be
	 */
	public int getNeededCrewSize() {
		return currentCrew.getNumberCrewMembersNeeded();
	}
	
	/**
	 * sets the needed size of the crew to value
	 * @param value - how large the crew needs to be now
	 */
	public void setNeededCrewSize(int value) {
		currentCrew.setNumberCrewMembersNeeded(value);
	}
	
	/**
	 * 
	 * @param index - where we're looking for the member in the member list
	 * @return - the crew member that was found
	 */
	public CrewMember getMemberOnIndex(int index) {
		if (index < getCrewSize()) {
			return getCurrentCrew().get(index);
		}
		else {
			return null;
		}
	}
	
	/**
	 * checks if there are enough pilots to fly
	 * @return - true if there are enough pilots
	 */
	public Boolean hasEnoughPilots() {
		return currentCrew.canBePiloted();
	}
	
	/**
	 * 
	 * @return - true if there is at least one assigned planet searcher
	 */
	public Boolean hasPlanetSearcher() {
		return (currentCrew.getPlanetSearcherNumber() > 0);
	}
	
	/**
	 * 
	 * @return - how many assigned planet searchers there are
	 */
	public int searcherNumber() {
		return currentCrew.getPlanetSearcherNumber();
	}
	
	/**
	 * 
	 * @return - the list of crew members
	 */
	public ArrayList<CrewMember> getCurrentCrew() {
		return currentCrew.getCrewMemberList();
	}

	
	//Planets
	/**
	 * makes all planet objects
	 */
	public void makePlanets() {
		for(int i=0; i<7; i++) {
			planets.add(new Planet(this));
		}
	}
	
	/**
	 * 
	 * @return - list of planet objects
	 */
	public ArrayList<Planet> getPlanets(){
		return planets;
	}
	
	/**
	 * 
	 * @param index - where to look for planet
	 * @return - planet found at index
	 */
	public Planet getPlanetOnIndex(int index) {
		if (index < planets.size()) {
			return getPlanets().get(index);
		}
		else {
			return null;
		}
	}
	

	//Update Members of Crew
	/**
	 * 
	 * @param newMember - member to add to crew
	 */
	public void addMember(CrewMember newMember) {
		currentCrew.addCrewMember(newMember);
	}
	
	/**
	 * remove a member from the currentCrew
	 * @param thisMember - member to remove from crew
	 */
	public void removeMember(CrewMember thisMember) {
		currentCrew.removeCrewMember(thisMember);
	}

	
	//Update Current Inventory
	/**
	 * 
	 * @param food - food object to add to inventory
	 */
	public void addFoodItem(Collectibles food) {
		currentInventory.addToInventory(food);
	}
	
	/**
	 * 
	 * @param food - food object to remove to inventory
	 */	
	public void removeFoodItem(Collectibles food) {
		currentInventory.removeFromInventory(food);
	}
	
	/**
	 * 
	 * @param medicine - medicine object to add to inventory
	 */
	public void addMedicineItem(Collectibles medicine) {
		currentInventory.addToInventory(medicine);
	}
	
	/**
	 * 
	 * @param medicine - medicine object to remove to inventory
	 */
	public void removeMedicineItem(Collectibles medicine) {
		currentInventory.removeFromInventory(medicine);
	}

	/**
	 * 
	 * @param object - object to sell from inventory
	 */
	public void sellItem(Collectibles object) {
		currentInventory.SellObject(object);
	}
	
	/**
	 * 
	 * @param object - object to buy from inventory
	 */
	public void buyItem(Collectibles object) {
		currentInventory.BuyObject(object);
	}
	
	//GUI
	
	/**
	 * launches visit planet screen
	 */
	public void launchVisitPlanetsScreen() {
		VisitPlanetsScreen visitPlanetScreen = new VisitPlanetsScreen(this);
	}
	
	/**
	 * 
	 * @param visitPlanetsScreen - closes this specific window
	 */
	public void closeVisitPlanetsScreen(VisitPlanetsScreen visitPlanetsScreen) {
		visitPlanetsScreen.closeWindow();
	}
	
	/**
	 * launches crew selection screen
	 */
	public void launchCrewSelectionScreen() {
		CrewSelectionScreen setupWindow = new CrewSelectionScreen(this);
	}
	
	/**
	 * closes selectionScreen window
	 * @param crewSelectionWindow - window to be closed
	 */
	public void closeCrewSelectionScreen(CrewSelectionScreen crewSelectionWindow) {
		crewSelectionWindow.closeWindow();
		launchStatusScreen();
	}
	
	/**
	 * launches status screen
	 */
	public void launchStatusScreen() {
		StatusScreen statusScreen = new StatusScreen(this);
	}
	
	public void closeStatusScreen(StatusScreen statusScreen) {
		statusScreen.closeWindow();
	}
	
	/**
	 * launches inventory screen
	 * @param crewMember - creates new screen with crewMember 
	 */
	public void launchInventoryScreen(CrewMember crewMember) {
		InventoryScreen inventoryScreen = new InventoryScreen(this, crewMember);
	}
	
	/**
	 * 
	 * @param inventoryScreen - screen to be closed
	 */
	public void closeInventoryScreen(InventoryScreen inventoryScreen) {
		inventoryScreen.closeWindow();
		launchStatusScreen();
	}
	
	/**
	 * launches new outpost screen
	 */
	public void launchSpaceOutpostScreen() {
		SpaceOutpostScreen spaceOutpostScreen = new SpaceOutpostScreen(this);
	}
	
	/**
	 * closes outpost screen
	 * @param spaceOutpostScreen - screen to be closed
	 */
	public void closeSpaceOutpostScreen(SpaceOutpostScreen spaceOutpostScreen) {
		spaceOutpostScreen.closeWindow();
	}
	
	/**
	 * launches game over screen
	 */
	public void launchGameOverScreen() {
		GameOverScreen gameOverScreen = new GameOverScreen(this);
	}
	
	/**
	 * closes game over screen
	 * @param gameOverScreen - window to be closed
	 */
	public void closeGameOverScreen(GameOverScreen gameOverScreen) {
		gameOverScreen.closeWindow();
	}
	
	/**
	 * launches game
	 * @param args - normal parameter for main function
	 */
	public static void main(String[] args) {
		GameEnvironment manager = new GameEnvironment();
		manager.launchCrewSelectionScreen();
	}
}
