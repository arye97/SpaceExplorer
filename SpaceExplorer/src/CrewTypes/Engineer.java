package CrewTypes;

import SpaceExplorerClasses.*;

public class Engineer extends CrewMember{

	private static int ShieldBoost			= 10;
	private static int ShieldRepairBoost	= 20;
	Spaceship spaceship;
	
	public Engineer(String name,GameEnvironment manager) {
		super(name, "Engineer", manager, "/Images/nikola-tesla@64px.png");
		if(getName().equals("")) {
			setName("Nicolas");
		}
		spaceship = manager.getSpaceship();
		}
	
	public void Update() {
		CrewMember.setShieldRepair(CrewMember.getShieldRepair() + ShieldRepairBoost);
		Spaceship.setMaxShieldHealth(Spaceship.getMaxShieldHealth() + ShieldBoost);
		spaceship.setShieldHealth(Spaceship.getMaxShieldHealth());
	}
}