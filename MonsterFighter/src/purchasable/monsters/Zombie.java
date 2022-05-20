package purchasable.monsters;

/**
 * Extends Monster. A type of monster that the player can own or buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Zombie extends Monster {
	
	/**
	 * Constructor for Zombie. Calls the superclass constructor with the name of the Zombie, its maximum health, attack amount, and speed.
	 *  Sets the image path, image, heal amount, type purchase price and sell back price for the Zombie.
	 */
	public Zombie() {
		super("SENG-201 Student", 1000, 200, 30);
		setImgPath("/images/zombie.png");
		setImg();
		setHealAmount(600);
		setMonsterType("zombie");
		setPurchasePrice(75);
		setSellPrice(75);
	}
	
}
