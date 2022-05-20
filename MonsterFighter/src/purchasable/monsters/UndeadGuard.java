package purchasable.monsters;

/**
 * Extends Monster. A type of monster that the player can own or buy in the shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class UndeadGuard extends Monster {
	
	/**
	 * Constructor for UndeadGuard. Calls the superclass constructor with the name of the UndeadGuard, its maximum health, attack amount, and speed.
	 *  Sets the image path, image, heal amount, type purchase price and sell back price for the UndeadGuard.
	 */
	public UndeadGuard() {
		super("Royal Guard #7", 1200, 100, 15);
		setImgPath("/images/undeadGuard.png");
		setImg();
		setHealAmount(800);
		addArmorAmount(100);
		setMonsterType("undeadGuard");
		setPurchasePrice(70);
		setSellPrice(60);
	}
	
}
