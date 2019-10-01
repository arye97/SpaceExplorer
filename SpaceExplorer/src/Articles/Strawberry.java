package Articles;

import SpaceExplorerClasses.*;

public class Strawberry extends Collectibles{
	
	private static int 		PriceToBuy	= 5;
	private static int 		PriceToSell = 2;
	private static int 		Energy 		= 5;
	private static String	ImagePath 	= "/Images/strawberry-icon.png";
	
	public Strawberry() {
		super(PriceToBuy,PriceToSell,Energy, ImagePath);
	}
	
	public String toString() {
		return "strawberry";
	}
}
