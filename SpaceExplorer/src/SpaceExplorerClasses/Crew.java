package SpaceExplorerClasses;
import java.util.ArrayList;
import java.util.Random;

public class Crew {
	
	private int NumberCrewMembersNeeded 	= 2;
	private int money 						= 50;
	private int pilotNumber					= 0;
	private int planetSearcherNumber		= 0;

	private ArrayList<CrewMember> members;
	
	private int currentPartsFound			= 0;
	
	/**
	 * creates list of crew from player selected number
	 */
    public Crew() {
        members = new ArrayList<CrewMember>(NumberCrewMembersNeeded);
    }
    
    //Setters and Getters
    /**
     * 
     * @return - the money allotted to the entire crew
     */
    public int getMoney() {
    	return money;
    }
    
    /**
     * 
     * @param addMoney - the new amount of money the crew is to have 
     */
    public void setMoney(int addMoney) {
    	money = addMoney;
    }

    /**
     * 
     * @return - the current number of parts the crew has discovered
     */
	public int getCurrentPartsFound() {
		return currentPartsFound;
	}

	/**
	 * 
	 * @param PartFound - the number of parts found
	 */
	public void setCurrentPartsFound(int PartFound) {
		currentPartsFound = PartFound;
	}

	/**
	 * 
	 * @return - the number of crew members the player wants
	 */
	public int getNumberCrewMembersNeeded() {
		return NumberCrewMembersNeeded;
	}
	
	/**
	 * 
	 * @param value - the number of crew members the player wants
	 */
	public void setNumberCrewMembersNeeded(int value) {
		NumberCrewMembersNeeded = value;
	}

	/**
	 * 
	 * @return - number of crew members that are planet searchers
	 */
	public int getPlanetSearcherNumber() {
		return planetSearcherNumber;
	}

	/**
	 * 
	 * @param planetSearcherCounter - new number of crew members that are planet searchers
	 */
	public void setPlanetSearcherNumber(int planetSearcherCounter) {
		this.planetSearcherNumber = planetSearcherCounter;
	}
	
	/**
	 * 
	 * @return - the number of assigned partners
	 */
	public int getPilotCounter() {
		return pilotNumber;
	}

	/**
	 * 
	 * @param pilotCounter - new number of assigned partners
	 */
	public void setPilotCounter(int pilotCounter) {
		this.pilotNumber = pilotCounter;
	}

	//Methods
	/**
	 * updates each member for the day
	 */
	public void dayUpdate() {
		for(CrewMember member: members) {
			member.dailyUpdate();
		}
	}
	
	/**
	 * 
	 * @param newCrewMember - new member to be added to the crew
	 */
	public void addCrewMember(CrewMember newCrewMember) {
		if(members.size() < getNumberCrewMembersNeeded()) {
			members.add(newCrewMember);
		}else{
			System.out.println("Can't add");
		}
	}
	
	/**
	 * 
	 * @param toRemove - which crew member is to be removed from the crew
	 * @return - true if the crew member was removed, else false
	 */
	public boolean removeCrewMember(CrewMember toRemove) {
		return members.remove(toRemove);
	}
	
	/**
	 * increases number of pilots
	 */
	public void addPilot() {
		if (pilotNumber < NumberCrewMembersNeeded) {
			pilotNumber++;	
		}
	}
	
	/**
	 * decreases the number of pilots
	 */
	public void removePilot() {
		if(pilotNumber > 0) {
			pilotNumber--;
		}
	}
	
	/**
	 * removes a planet searcher status from the crew
	 */
    public void removePlanetSearcher() {
    	if(planetSearcherNumber > 0) {
    	planetSearcherNumber--;
    	}
    }
    
    /**
     * adds a planet searcher status to the crew
     */
    public void addPlanetSearcher() {
    		planetSearcherNumber++;
    }
    
    /**
     * 
     * @return - the size of the crew
     */
	public int howManyCrewMembers() {
		return members.size();
	}
	
	/**
	 * 
	 * @return - the ArrayList of crew members
	 */
	public ArrayList<CrewMember> getCrewMemberList(){
		return members;
	}
	
	/**
	 * 
	 * @return - if the spaceship can be piloted
	 */
	public Boolean canBePiloted() {
		if (getPilotCounter() >= 2) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return - the amount of money found on a planet
	 */
	public String foundMoney() {
		Random rand = new Random();
		int value = rand.nextInt(5);
		int moneyFound = value * 10;
		setMoney(getMoney() + moneyFound);
		return "Found: $" + moneyFound;
	}
	
	/**
	 * increase the number of parts found by the crew
	 */
	public void foundPart() {
		currentPartsFound += 1;
	}
}
