package Articles;

import SpaceExplorerClasses.*;

public class CoughMedicine extends Collectibles{
	private static int 		PriceToBuy 	= 8;
	private static int 		PriceToSell = 7;
	private static int 		Health 		= 8;
	private static String	ImagePath 	= "/Images/medicine-bowl-icon.png";
	
	public CoughMedicine() {
		super(PriceToBuy,PriceToSell,Health, ImagePath);
	}
	
	public String toString() {
		return "cough medicine";
	}
}
