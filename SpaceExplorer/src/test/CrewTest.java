package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import CrewTypes.*;
import Articles.*;
import SpaceExplorerClasses.*;


/* Checks that aspects of Crew.java, CrewMember.java and "crewmember" type classes
 * function properly, as well as Collectibles.java 
 */

class CrewTest {
	private Crew testCrew;
	private Engineer newEngineer;
	private GameEnvironment manager;
	private Collectibles burger;
	private Collectibles meds;
	
	@BeforeEach
	public void addMemberTest() {
		//
		testCrew = new Crew();
		manager = new GameEnvironment();
		newEngineer = new Engineer("Jane Doe", manager);
		testCrew.addCrewMember(newEngineer);
		burger = new Collectibles(10, 10, 10, "");
		meds = new Collectibles(20, 5, 40, "");
		//i++;
		assertEquals(1, testCrew.howManyCrewMembers());
		
	}

	@Test
	public void removeMemberTest() {
		//System.out.println(testCrew.howManyCrewMembers());
		if (testCrew.howManyCrewMembers() == 1) {
			testCrew.removeCrewMember(newEngineer);
			assertEquals(0, testCrew.howManyCrewMembers());
		}
	}
	@Test
	public void increaseEngineerHealthTest() {
		int healthIncrease = 20;
		newEngineer.setHealth(10);
		Collectibles meds = new Collectibles(10,10,healthIncrease,"");
		newEngineer.takeMedicine(meds);
		assertEquals(30, newEngineer.getHealth());
	}
	
	@Test
	public void checkForDeathTest() {
		newEngineer.setHealth(0);
		assertEquals(true, newEngineer.getIsDead());
	}
	
	@Test
	public void checkActionsTest() {
		int numActions = newEngineer.getActionsLeft();
		newEngineer.repairShields();
		//makes sure this function takes an action away
		assertEquals(numActions-1, newEngineer.getActionsLeft());
	}
	
	
	//Tests the GameEnvironment
	
	@Test
	public void addToInventoryTest() {
		burger = manager.getInventory().getFoodOnIndex(0);
		meds = manager.getInventory().getMedicineOnIndex(0);
		//GameEnvironment object has been previously created
		manager.addFoodItem(burger);
		manager.addMedicineItem(meds);
	}
	
	@Test
	public void removeFromInventoryTest() {
		addToInventoryTest();
		int totalFood = manager.getInventory().totalFood();
		int totalMeds = manager.getInventory().totalMedicine();
		int total = totalFood + totalMeds;
		int foodAfter = totalFood - 1;
		int medsAfter = totalMeds - 1;
		if (total == 11) {
			manager.removeFoodItem(burger);
			manager.removeMedicineItem(meds);
			totalFood = manager.getInventory().totalFood();
			totalMeds = manager.getInventory().totalMedicine();
			assertEquals(totalFood, foodAfter);
			assertEquals(totalMeds, medsAfter);
		}
	}

	@Test
	public void curePlagueTest() {
		newEngineer.setSick(true);
		if (newEngineer.isSick()) {
			PlagueCure cure = new PlagueCure();
			manager.getInventory().addToInventory(cure);
			newEngineer.cureSpacePlague();
			System.out.println(newEngineer.isSick());
			assertFalse(newEngineer.isSick());
		}
	}
	
	@Test
	public void planetSearcherTest() {
		newEngineer.PlanetSearcher();
		assertTrue(newEngineer.getPlanetSearcher());
	}
	
	@Test
	public void pilotsCheckTest() {
		testCrew.addPilot();
		testCrew.addPilot();
		assertTrue(testCrew.canBePiloted());
	}
	
	
}