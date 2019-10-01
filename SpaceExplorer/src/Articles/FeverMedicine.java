package Articles;

import SpaceExplorerClasses.*;

public class FeverMedicine extends Collectibles{
	private static int 		PriceToBuy 	= 10;
	private static int 		PriceToSell = 5;
	private static int 		Health 		= 15;
	private static String	ImagePath 	= "/Images/capsule-icon.png";
	
	public FeverMedicine() {
		super(PriceToBuy,PriceToSell,Health, ImagePath);
	}
	
	public String toString() {
		return "fever medicine";
	}
}
