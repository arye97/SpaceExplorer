package SpaceExplorerClasses;
import java.util.ArrayList;
import java.util.Random;

import Articles.*;

public abstract class CrewMember {
	
	private static int MaxHunger			= 100;
	private static int MaxHealth			= 100;
	private static int MaxEnergy			= 100;
	private static int GeneralShieldRepair	= 20;

	private int technicianRepair		= GeneralShieldRepair;
	private int currentHunger 			= 0;
	private int currentEnergy			= MaxEnergy;
	private int currentHealth 			= MaxHealth;
	private String currentName			= "";
	private int actionsLeft				= 2;
	private String tag					= "CrewMember";
	private boolean isPilot				= false;
	private String imagePath			= "";
	
	private int RecoverValue			= 40;
	private boolean sick 				= false;
	private boolean isDead				= false;
	private boolean isPlanetSearcher	= false;
	
	private boolean setVisible			= true;
	
	Inventory inventory;
	Spaceship spaceship;
	Crew	  crew;
	GameEnvironment manager;

	
	/**
	 * 
	 * @param name
	 * @param thisClass
	 * @param currentManager
	 * @param imageString
	 */
	public CrewMember(String name, String thisClass, GameEnvironment currentManager, String imageString) {
		manager = currentManager;
		currentName = name;
		tag 		= thisClass;
		spaceship 	= manager.getSpaceship();
		inventory 	= manager.getInventory();
		imagePath 	= imageString;
		crew		= manager.getCrew();
	}
	
	/**
	 * 
	 * @param isVisible - if the crew member is visible (when they die)
	 */
	public void setMemberVisible(Boolean isVisible) {
		setVisible = isVisible;
	}
	
	/**
	 * 
	 * @return - the visibility of the crew member
	 */
	public Boolean getMemberVisible() {
		return setVisible;
	}
	
	/**
	 * 
	 * @return - the maximum energy allowed of the crew member
	 */
	public static int getMaxEnergy() {
		return MaxEnergy;
	}
	
	/**
	 * 
	 * @param maxEnergy - the new maximum energy to be allowed to the crew member
	 */
	public static void setMaxEnergy(int maxEnergy) {
		MaxEnergy = maxEnergy;
	}
	
	/**
	 * 
	 * @return - the maximum health allowed to the crew member
	 */
	public static int getMaxHealth() {
		return MaxHealth;
	}
	
	/**
	 * 
	 * @param maxHealth - the new max health to be allowed to the crew member
	 */
	public static void setMaxHealth(int maxHealth) {
		MaxHealth = maxHealth;
	}
	
	/**
	 * 
	 * @return - the largest hunger the member can have
	 */
	public static int getMaxHunger() {
		return MaxHunger;
	}

	/**
	 * 
	 * @param maxHunger - the new maximum hunger the member will have
	 */
	public static void setMaxHunger(int maxHunger) {
		MaxHunger = maxHunger;
	}

	/**
	 * 
	 * @return - the current image path for this member
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	/**
	 * 
	 * @param imagePathString - the new image to be assigned to this object
	 */
	public void setImagePath(String imagePathString) {
		imagePath = imagePathString;
	}
	
	/**
	 * Gets the tag of the class to identify what kind of Crew Member this is
	 * @return String tag 
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * isSick can be true or false, true to make the crew member sick, false for not
	 * @param isSick - if the crew member is sick or not
	 */
	public void setSick(Boolean isSick) {
		sick = isSick;
	}
	
	/**
	 * checks if the player is sick 
	 * @return - the true/false value of sick
	 */
	public boolean isSick() {
		return sick;
	}
	
	/**
	 * how hungry the crew member is
	 * @return - the value of the crewmembers currentHunger
	 */
	public int getHunger() {
		return currentHunger;
	}

	/**
	 * sets the member hunger to the new value
	 * @param hunger - the desired hunger for this crew member
	 */
	public void setHunger(int hunger) {
		this.currentHunger = hunger;
	}

	/**
	 * 
	 * @return - the current energy level of the crew member
	 */
	public int getEnergy() {
		return currentEnergy;
	}

	/**
	 * sets the crew member energy level to desired 
	 * @param energy - desired energy level
	 */
	public void setEnergy(int energy) {
		currentEnergy = energy;
	}

	/**
	 * 
	 * @return - the current health of the crew member
	 */
	public int getHealth() {
		return currentHealth;
	}

	/**
	 * 
	 * @param health - wanted crew health
	 */
	public void setHealth(int health) {
		this.currentHealth = health;
	}

	/**
	 * gets crew members name
	 * @return - crew member name
	 */
	public String getName() {
		return currentName;
	}

	/**
	 * set crew members name
	 * @param name - name to be given to the crew member
	 */
	public void setName(String name) {
		this.currentName = name;
	}
	
	/**
	 * get num actions left for crew member
	 * @return - crew members remaining actions
	 */
	public int getActionsLeft() {
		return actionsLeft;
	}
	
	/**
	 * gets the repair value of technician
	 * @return - the technician repair value
	 */
	public int getTechnicianRepair() {
		return technicianRepair;
	}
	
	/**
	 * sets the new value of technician repair
	 * @param technicianRepair - the new value to be assigned for the technician
	 */
	public void setTechnicianRepair(int technicianRepair) {
		this.technicianRepair = technicianRepair;
	}

	/**
	 * sets how much of the shields can be repaired in one go
	 * @param repairValue - the strength of the repair
	 */
	public static void setShieldRepair(int repairValue) {
		GeneralShieldRepair = repairValue;
	}
	
	/**
	 * gets the current value of the shield repair
	 * @return - how much the shields can be repaired in one move
	 */
	public static int getShieldRepair() {
		return GeneralShieldRepair;
	}
	
	/**
	 * sets the technician shield repair value
	 * @param repairValue - how much of the shield a technician can repair
	 */
	public void setTechnicianShieldRepair(int repairValue) {
		technicianRepair = repairValue;
	}
	
	/**
	 * 
	 * @return - the current value of how much a technician can repair
	 */
	public int getTechnicianShieldRepair() {
		return technicianRepair;
	}
	
	/**
	 * 
	 * @return - true if the crew member is a planet searcher, else false
	 */
	public boolean getPlanetSearcher() {
		return isPlanetSearcher;
	}

	/**
	 * makes the crew member a planet searcher or takes it away
	 * @param isPlanetSearcher - true or false
	 */
	public void setPlanetSearcher(boolean isPlanetSearcher) {
		this.isPlanetSearcher = isPlanetSearcher;			
	}

	/**
	 * checks if crew member is a pilot
	 * @return - true if pilot or else false
	 */
	public boolean getPilot() {
		return isPilot;
	}

	/**
	 * gives or takes away crew member pilot status
	 * @param isPilot - true or false
	 */
	public void setPilot(boolean isPilot) {
		this.isPilot = isPilot;
	}

	/**
	 * Methods
	 **/
	
	/**
	 * updates the variables to reflect a days passing in space
	 * increases hunger, decreases health and energy, increases actions
	 */
	public void dailyUpdate() {
		if (currentEnergy > MaxEnergy/2) {
			manager.setScore(manager.getScore() + 10);
		}else if(currentEnergy > MaxEnergy/5) {
			manager.setScore(manager.getScore() + 5);
		}
		
		if (currentHealth > MaxHealth/1.5) {
			manager.setScore(manager.getScore() + 20);
		}else if(currentHealth > MaxHealth/4) {
			manager.setScore(manager.getScore() + 10);
		}else {
			manager.setScore(manager.getScore() + 5);
		}
		
		if (currentHunger < MaxHunger/5) {
			manager.setScore(manager.getScore() + 20);
		}else if(currentHunger < MaxHunger/3) {
			manager.setScore(manager.getScore() + 5);
		}
		
		currentEnergy -= 20;
		currentHunger += 20;
		
		if(isSick()) {
			currentHealth -= 30;
			manager.setScore(manager.getScore() - 5);
		}
		actionsLeft = 2;
		updateActions();
		
		if(isDead) {
			manager.setScore(manager.getScore() - 10);
		}
	}

	
	/**
	 * sets health and energy to maximum possible
	 */
	public void GeneralUpdate() {
		currentHealth = MaxHealth;
		currentEnergy = MaxEnergy;
	}
	
	/**
	 * gives if crew member has any actions left
	 * @return - true or false
	 */
	public boolean haveActionsLeft() {
		return actionsLeft > 0;
	}
	
	/**
	 * allows the crew member to consume food for energy and decreased hunger
	 * @param food - which food object will be consumed
	 */
	public void eatFood(Collectibles food) {
		if(haveActionsLeft()) {
			if(inventory.removeFromInventory(food)) {
				
				setEnergy(getEnergy() + food.getEnergy());
				if (getEnergy() > getMaxEnergy()) {
					setEnergy(getMaxEnergy());
				}
				
				setHunger(getHunger() - food.getEnergy());
				if (getHunger() > getMaxHunger()) {
					setHunger(getMaxHunger());
				}
				updateActions();
			}
		}
	}
	
	/**
	 * allows the crew member to consume medicine for increased health, hunger and decreased energy
	 * @param medicine - the meds that the crew member will consume
	 */
	public void takeMedicine(Collectibles medicine) {
		if (haveActionsLeft()) {
			//Update inventory
			if(inventory.removeFromInventory(medicine)) {
				setHealth(getHealth() + medicine.getEnergy());
				updateActions();
				
				currentHunger += 10;
				currentEnergy -= 10;
			}
		}
	}
	
	/**
	 * cures crew members space plague effects
	 * if and only if the crew member has actions left
	 */
	public void cureSpacePlague() {
		if (haveActionsLeft()) {
			if (sick) {
				inventory.cureSpacePlague();;
				sick = false;
			}
			updateActions();
		}
	}
	
	/**
	 * lets the crew member sleep
	 * increases hunger and increases energy
	 */
	public void sleep() {
		if(haveActionsLeft()) {
			setEnergy(getEnergy() + RecoverValue);
			TookAction();
			updateActions();
			currentHunger += 20;
		}
	}
	
	/**
	 * lets the crew member repair the shields
	 * this repair value is larger than usual
	 * if the player is a technician
	 */
	public void repairShields() {
		if(haveActionsLeft()) {
			if( getTag().equals("Technician")) {
				spaceship.HealShields(technicianRepair);
			}else {
			spaceship.HealShields(GeneralShieldRepair);
			}
			TookAction();
			currentHunger += 10;
			currentEnergy -= 10;
			updateActions();
		}
	}
	
	/**
	 * sets the crew member to be a planet searcher
	 * removes other titles, ie. pilot
	 */
	public void PlanetSearcher() {
		if(!getPlanetSearcher()) {
			setPlanetSearcher(true);
			crew.addPlanetSearcher();
			currentHunger += 10;
			currentEnergy -= 10;
		}
		if(getPilot()) {
			crew.removePilot();
			setPilot(false);
		}
		TookAction();
	}
	
	/**
	 * sets the crew member to be a pilot
	 * removes other titles ie. planetsearcher
	 */
	public void Pilot() {
		if (!getPilot()) {
			setPilot(true);
			crew.addPilot();
		}
		if(getPlanetSearcher()) {
			setPlanetSearcher(false);
			crew.removePlanetSearcher();
		}
		TookAction();
	}
	
	/**
	 * removes all titles from crew member
	 */
	private void updateActions() {
		if(getPilot()) {
			crew.removePilot();
			setPilot(false);
		}
		if(getPlanetSearcher()) {
			crew.removePlanetSearcher();
			setPlanetSearcher(false);
		}
	}
	
	/**
	 * decreases actions remaining to the crew member
	 */
	public void TookAction() {
		actionsLeft--;
	}
	
	/**
	 * gives the crew member space plague
	 */
	public void getSpacePlague() {
		sick = true;
	}	
	
	/**
	 * checks if the crew member is dead
	 * @return - true if dead, false if not
	 */
	public boolean getIsDead() {
		if (currentHealth <= 0) {
			isDead = true;
			setVisible = false;
		}
		return isDead;
	}
	
	/**
	 * accessible by only child classes
	 */
	public abstract void Update();
}