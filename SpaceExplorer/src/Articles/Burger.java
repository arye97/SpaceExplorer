package Articles;

import SpaceExplorerClasses.*;

public class Burger extends Collectibles{
	private static int 		PriceToBuy 	= 20;
	private static int 		PriceToSell = 15;
	private static int 		Energy 		= 25;
	private static String	ImagePath 	= "/Images/burger-icon.png";
	
	public Burger() {
		super(PriceToBuy,PriceToSell,Energy, ImagePath);
	}
	
	public String toString() {
		return "burger";
	}
}
