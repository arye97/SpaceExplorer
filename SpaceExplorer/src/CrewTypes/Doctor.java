package CrewTypes;

import java.util.ArrayList;
import SpaceExplorerClasses.*;
	
public class Doctor extends CrewMember{
	
	private static int HealthBoost = 20;
	
	public Doctor(String name, GameEnvironment manager) {
		super(name, "Doctor", manager, "/Images/robot-02@64px.png");
		if(getName().equals("")) {
			setName("Brandon");
			}
		}
	
	public void Update(){
		CrewMember.setMaxHealth(CrewMember.getMaxHealth() + HealthBoost);
		
		}
	
}
