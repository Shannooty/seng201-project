package purchasable;

import javax.swing.ImageIcon;

import interfaces.HasImage;
import player.Player;
import purchasable.monsters.Monster;

/**
 * The Purchasable class gives other classes the ability to be purchased from the shop and gives additional info to be displayed 
 * in the store.
 * This class implements the HasImage class so it can be displayed visually in the GUI.
 * @author Bede Nathan, Celia Allen
 *
 */

public abstract class Purchasable implements HasImage {
	private String name;
	private double purchasePrice = 0;
	private double sellPrice = 0;
	private String discription = "";
	private String imgPath;
	private ImageIcon img;
	private static int id = 0;
    protected int instanceId = ++id;
    
	/**
	 * General constructor for the purchasable class which gives the object a name
	 * @param name the name of the object
	 */
	public Purchasable(String name) {
		setName(name);
	}
	
	/**
	 * Sets the name attribute
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the object
	 * @return name of the object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Allows a player to purchase the object. Functionality to be implemented by subclasses
	 * @param player the player purchasing
	 */
	public abstract void buy(Player player);
	
	/**
	 * Allows a player to sell objects back to the store. Functionality to be implemented by subclasses
	 * @param player the player selling
	 */
	public abstract void sell(Player player);
	
	/**
	 * Gives the purchase price of the object
	 * @return the price to be paid
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Gives the sell price of the object
	 * @return the sell back price
	 */
	public double getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Gives the description of the object
	 * @return the description
	 */
	public String getDiscription() {
		return discription;
	}
	
	/**
	 * Sets the description for the object to be displayed in the GUI
	 * @param discription String description
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	/**
	 * Sets the purchase price for buying objects
	 * @param buyPrice value of the object
	 */
	public void setPurchasePrice(double buyPrice) {
		purchasePrice = buyPrice;
	}
	
	/**
	 * Sets the sell price for the object. Should be smaller than the buy price
	 * @param sellPrice the price for selling
	 */
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	/**
	 * Returns the image to be used in GUI
	 * @return The ImageIcon for the object
	 */
	public ImageIcon getImg() {
		return img;
	}
	
	/**
	 * Creates the ImageIcon for the object
	 */
	public void setImg() {
		this.img = new ImageIcon(Monster.class.getResource(imgPath));
	}
	
	/**
	 * Sets the location of the image to be used
	 * @param imgPath the file path for the image
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	/**
	 * Returns the instanceID for the object
	 * @return ID
	 */
    public int getID() {
        return instanceId;
    }
    
    /**
     * Sets the initialID for the object
     */
    public void setInitialID() {
    	instanceId = 0;
    }
	


}
