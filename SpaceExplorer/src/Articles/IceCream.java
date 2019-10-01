package Articles;

import SpaceExplorerClasses.*;

public class IceCream extends Collectibles{

	private static int 		PriceToBuy 	= 12;
	private static int 		PriceToSell = 5;
	private static int 		Energy		= 13;
	private static String	ImagePath 	= "/Images/icecream-2-icon.png";
	
	public IceCream() {
		super(PriceToBuy,PriceToSell,Energy, ImagePath);
	}
	
	public String toString() {
		return "ice cream";
	}
}
