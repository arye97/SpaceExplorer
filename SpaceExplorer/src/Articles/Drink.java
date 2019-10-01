package Articles;

import SpaceExplorerClasses.*;

public class Drink extends Collectibles{
	private static int		PriceToBuy 	= 10;
	private static int 		PriceToSell = 8;
	private static int 		Energy 		= 15;
	private static String 	ImagePath 	= "/Images/drink-icon.png";
	
	public Drink() {
		super(PriceToBuy,PriceToSell,Energy, ImagePath);
	}
	
	public String toString() {
		return "drink";
	}
}
