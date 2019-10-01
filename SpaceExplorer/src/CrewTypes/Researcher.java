package CrewTypes;

import java.util.ArrayList;
import SpaceExplorerClasses.*;

public class Researcher extends CrewMember{
	
	private static int EnergyBoost = 20;
	
	public Researcher(String name, GameEnvironment manager) {
		super(name, "Researcher", manager,"/Images/muslim-woman@64px.png");
		if(getName().equals("")) {
			setName("Amanda");
		}
		}
	
	public void Update() {
		CrewMember.setMaxEnergy(CrewMember.getMaxEnergy() + EnergyBoost);
		}
	
}
