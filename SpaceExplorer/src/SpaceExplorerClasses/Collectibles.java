package SpaceExplorerClasses;

public class Collectibles {
	private int currentPriceToBuy;
	private int currentPriceToSell;
	private int currentEnergy;
	private int quantity;
	private String imagePath;

	/**
	 * 
	 * @param priceToBuy - how much it costs
	 * @param priceToSell - how much it can be sold for
	 * @param energy - how much energy it can give you
	 * @param currentImagePath - what image to use for this object
	 * 
	 */
	
	public Collectibles(int priceToBuy, int priceToSell, int energy, String currentImagePath) {
		currentPriceToBuy 	= priceToBuy;
		currentPriceToSell 	= priceToSell;
		currentEnergy		= energy;
		quantity 			= 1;
		imagePath 			= currentImagePath;
	}
	
	/**
	 * @return - returns a string of length 0
	 */
	public String toString() {
		return "";
	}
	
	/**
	 * 
	 * @return - returns the file path of the set image
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * 
	 * @param imagePath - a new image's file path
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	/**
	 * @return - the current price of this object
	 */
	public int getPriceToBuy() {
		return currentPriceToBuy;
	}
	
	/**
	 * @param priceToBuy - the new price of this object
	 */
	public void setPriceToBuy(int priceToBuy) {
		currentPriceToBuy = priceToBuy;
	}
	
	/**
	 * @return - returns current value of this item if you were to sell
	 */
	public int getPriceToSell() {
		return currentPriceToSell;
	}
	
	/**
	 * @param priceToSell - new value of this item if you were to sell
	 */
	public void setPriceToSell(int priceToSell) {
		currentPriceToSell = priceToSell;
	}
	
	/**
	 * 
	 * @return - the current energy of this object
	 */
	public int getEnergy() {
		return currentEnergy;
	}
	
	/**
	 * 
	 * @param energy - the new desired energy of this object
	 */
	public void setEnergy(int energy) {
		currentEnergy = energy;
	}
	
	/**
	 * 
	 * @return - the quantity of this object available
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * @param newQuantity - sets the desired quantity of this object
	 */
	public void setQuantity(int newQuantity) {
		quantity = newQuantity;
	}
}
