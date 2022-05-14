package purchasable;

import javax.swing.ImageIcon;

import interfaces.HasImage;
import player.Player;
import purchasable.monsters.Monster;

/**
 * The Purchasable class gives other classes the ability to be purchased from the shop and gives additional info to be displayed 
 * in the store.
 * This class implements the HasImage class so it can be displayed visually in the GUI.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */

public abstract class Purchasable implements HasImage {
	
	/**
	 * Attribute name, of type String. The name of the purchasable Item/Monster.
	 */
	private String name;
	
	/**
	 * Attribute purchasePrice, of type double. The amount of gold required to purchase the Item/Monster.
	 */
	private double purchasePrice = 0;
	
	/**
	 * Attribute sellPrice, of type double. The amount of gold the player would receive for selling the Item/Monster.
	 */
	private double sellPrice = 0;
	
	/**
	 * Attribute imgPath, of type String. The path to the image of the Item/Monster.
	 */
	private String imgPath;
	
	/**
	 * Attribute img, of type ImageIcon. The image of the Item/Monster.
	 */
	private ImageIcon img;
	
	/**
	 * Attribute id, of type static Integer. The current id number, shared across all instances of Purchasable. Used to create a unique instanceId for each instance of a class implementing Purchasable.
	 */
	private static int id = 0;
	
	/**
	 * Attribute instanceId, of type Integer. A unique id for each instance of a class implementing Purchasable. Created by adding one to the current value of the attribute id.
	 */
    protected int instanceId = ++id;
    
    
	/**
	 * General constructor for the purchasable class which gives the object a name
	 * @param name, of type String. The name of the object
	 */
	public Purchasable(String name) {
		setName(name);
	}
	
	/**
	 * Sets the name attribute
	 * @param name, of type String. The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the object
	 * @return name, of type String. Type of the object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Allows a player to purchase the object. Functionality to be implemented by subclasses
	 * @param player, of type Player. The player purchasing
	 */
	public abstract void buy(Player player);
	
	/**
	 * Allows a player to sell objects back to the store. Functionality to be implemented by subclasses
	 * @param player, of type Player. The player selling
	 */
	public abstract void sell(Player player);
	
	/**
	 * Gives the purchase price of the object
	 * @return the price to be paid, of type double.
	 */
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	/**
	 * Gives the sell price of the object
	 * @return the sell back price, of type double
	 */
	public double getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Sets the purchase price for buying objects
	 * @param buyPrice, of type double. The value of the object
	 */
	public void setPurchasePrice(double buyPrice) {
		purchasePrice = buyPrice;
	}
	
	/**
	 * Sets the sell price for the object. Should be smaller than the buy price
	 * @param sellPrice, of type double. The price for selling
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
	 * @param imgPath the file path for the image, of type String.
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
