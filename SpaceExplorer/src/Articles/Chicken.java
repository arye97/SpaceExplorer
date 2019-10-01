package Articles;

import SpaceExplorerClasses.*;

public class Chicken extends Collectibles {
	private static int 		PriceToBuy 	= 30;
	private static int 		PriceToSell = 20;
	private static int 		Energy		= 45;
	private static String	ImagePath 	= "/Images/chicken-icon.png";
	
	public Chicken() {
		super(PriceToBuy,PriceToSell,Energy, ImagePath);
	}
	
	public String toString() {
		return "chicken";
	}
}
