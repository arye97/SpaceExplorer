package Articles;

import SpaceExplorerClasses.*;

public class Pizza extends Collectibles {
	
	private static int 		PriceToBuy 	= 21;
	private static int 		PriceToSell = 17;
	private static int 		Energy 		= 35;
	private static String	ImagePath 	= "/Images/pizza-icon.png";
	
	public Pizza() {
		super(PriceToBuy,PriceToSell,Energy, ImagePath);
	}
	public String toString() {
		return "pizza";
	}
}
