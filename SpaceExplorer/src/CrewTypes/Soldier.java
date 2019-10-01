package CrewTypes;

import SpaceExplorerClasses.*;

public class Soldier extends CrewMember{
	
	private static int ShieldBoost = 20;
	Spaceship spaceship;
	
	public Soldier(String name, GameEnvironment manager) {
		super(name, "Soldier", manager, "/Images/robot-01@64px.png");
		if(getName().equals("")) {
			setName("XR");
		}
		spaceship = manager.getSpaceship();
	}
	
	public void Update() {
		Spaceship.setMaxShieldHealth(Spaceship.getMaxShieldHealth() + ShieldBoost);
		spaceship.setShieldHealth(Spaceship.getMaxShieldHealth());
	}
}
