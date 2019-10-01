package Articles;

import SpaceExplorerClasses.*;

public class PlagueCure extends Collectibles {
	//The Health level is set to 0 because it only cures the space plague, it doesn't give any health back.
	private static int 		PriceToBuy 	= 25;
	private static int 		PriceToSell = 23;
	private static int 		Health 		= 0;
	private static String	ImagePath 	= "/Images/syringe-injection-icon.png";
	
	public PlagueCure() {
		super(PriceToBuy,PriceToSell,Health, ImagePath);
	}
	public String toString() {
		return "plague cure";
	}
}
