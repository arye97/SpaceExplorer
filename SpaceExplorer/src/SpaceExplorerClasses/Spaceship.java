package SpaceExplorerClasses;

import java.util.Random;

public class Spaceship {
	
	private String spaceshipName;
	
	private static 	int MaxShieldHealth = 100;
	private static 	int MaxPetrol;
	
	private 		int shieldHealth 	= MaxShieldHealth;
	private 		int petrol			= MaxPetrol;
	
	private	String 		hitByAsteroids 	= "safe trip";
	
	/**
	 * sets the max petrol based on found parts
	 * @param totalParts - the total parts found so far
	 */
	public static void setStartPetrol(int totalParts) {
		MaxPetrol = (totalParts + 1) * 20;
	}
	
	/**
	 * 
	 * @return - the string stating the ship has been struck
	 */
	public String getHitByAsteroids() {
		return hitByAsteroids;
	}

	/**
	 * changes the string of the hit by asteroids
	 * @param hitAsteroids - string "hit by asteroids"
	 */
	public void setHitByAsteroids(String hitAsteroids) {
		hitByAsteroids = hitAsteroids;
	}

	/**
	 * 
	 * @return the max possible shield health
	 */
	public static int getMaxShieldHealth() {
		return MaxShieldHealth;
	}

	/**
	 * sets the max shield health to new int
	 * @param maxShieldHealth - new max shield health
	 */
	public static void setMaxShieldHealth(int maxShieldHealth) {
		MaxShieldHealth = maxShieldHealth;
	}
	
	/**
	 * 
	 * @return - max petrol allowed in spaceship
	 */
	public static int getMaxPetrol() {
		return MaxPetrol;
	}

	/**
	 * 
	 * @param maxPetrol - sets max allowed petrol
	 */
	public static void setMaxPetrol(int maxPetrol) {
		MaxPetrol = maxPetrol;
	}

	/**
	 * gets the name of the spaceship
	 * @return - spaceship name
	 */
	public String getSpaceshipName() {
		return spaceshipName;
	}

	/**
	 * 
	 * @param spaceshipName - changes the spaceship name to spaceshipName
	 */
	public void setSpaceshipName(String spaceshipName) {
		this.spaceshipName = spaceshipName;
	}

	/**
	 * 
	 * @return - current shield health
	 */
	public int getShieldHealth() {
		return shieldHealth;
	}

	/**
	 * sets shield health to new value
	 * @param shieldHealth - new wanted shield health
	 */
	public void setShieldHealth(int shieldHealth) {
		this.shieldHealth = shieldHealth;
	}

	/**
	 * 
	 * @return - the current amount of petrol
	 */
	public int getPetrol() {
		return petrol;
	}

	/**
	 * sets petrol to new amount
	 * @param petrol - new petrol amount
	 */
	public void setPetrol(int petrol) {
		this.petrol = petrol;
	}
	
	/**
	 * increases health of the shields by value
	 * @param value - value to increase shields by
	 */
	public void HealShields(int value) {
		setShieldHealth(getShieldHealth() + value);
		if(getShieldHealth() > getMaxShieldHealth()) {
			setShieldHealth(getMaxShieldHealth());
		}
	}
	
	/**
	 * updates petrol levels 
	 */
	public void updatePetrol() {
		if (petrol > 0) {
		petrol -= 20;
		}
		if (petrol < 0) {
			setPetrol(0);
		}
	}
	
	/**
	 * 
	 * @return - true if there is enough petrol to move to planet
	 * else false
	 */
	public Boolean pilotSpaceship() {
		if((petrol-20) >= 0) {
			updatePetrol();
			
			Random rand = new Random();
			int value = rand.nextInt(5);
			
			if(value == 2) {
				setHitByAsteroids(GoingThroughAsteroids());
			}
			return true;
		}
		return false;
	}
	
	/**
	 * takes spaceship through asteroids
	 * @return - string saying you were hit
	 */
	public String GoingThroughAsteroids() {
		shieldHealth -= (shieldHealth * 0.2);
		return "We were hit by asteroids";
	}
}

