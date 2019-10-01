package CrewTypes;

import SpaceExplorerClasses.*;

public class Technician extends CrewMember {
	
	private static int BoostRepair = 20;
	
	public Technician(String name,GameEnvironment manager) {
		super(name, "Technician", manager, "/Images/girl-in-ballcap@64px.png");
		if(getName().equals("")) {
			setName("Maria");
			}
		}
	
	public void Update() {
		this.setTechnicianRepair(this.getTechnicianRepair()+ BoostRepair);
	}
}
