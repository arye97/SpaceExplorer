package CrewTypes;

import SpaceExplorerClasses.*;

public class Captain extends CrewMember{	
	Spaceship spaceship;
	private static int PetrolBoost = 20;
	
	public Captain(String name, GameEnvironment manager) {
		super(name, "Captain", manager, "/Images/malcolm-x@64px.png");
		if(getName().equals("")) {
			this.setName("Malcom");
		}
		spaceship = manager.getSpaceship();
	}
	
	public void Update() {
		Spaceship.setMaxPetrol(Spaceship.getMaxPetrol() + PetrolBoost);
		spaceship.setPetrol(Spaceship.getMaxPetrol());
	}
}

