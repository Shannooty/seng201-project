package purchasable.monsters;

/**
 * Extends Monster. A type of monster that the player can own or buy in the shop.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Snake extends Monster {
	
	/**
	 * Constructor for Snake. Calls the superclass constructor with the name of the Snake, its maximum health, attack amount, and speed.
	 *  Sets the image path, image, heal amount, type purchase price and sell back price for the Snake.
	 */
	public Snake() {
		super("Snek", 700, 320, 18);
		setImgPath("/images/snake.png");
		setImg();
		setHealAmount(550);
		setMonsterType("snake");
		setPurchasePrice(65);
		setSellPrice(65);
	}
}
