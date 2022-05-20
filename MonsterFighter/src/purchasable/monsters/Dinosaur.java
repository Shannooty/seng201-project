package purchasable.monsters;

/**
 * Extends Monster. A type of monster that the player can own or buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Dinosaur extends Monster {
	
	/**
	 * Constructor for Dinosaur. Calls the superclass constructor with the name of the Dinosaur, its maximum health, attack amount, and speed.
	 *  Sets the image path, image, heal amount, type purchase price and sell back price for the Dinosaur.
	 */
	public Dinosaur() {
		super("Rexter", 800, 400, 12);
		setImgPath("/images/dinosaur.png");
		setImg();
		setHealAmount(600);
		setMonsterType("dinosaur");
		setPurchasePrice(75);
		setSellPrice(75);
	}
}
