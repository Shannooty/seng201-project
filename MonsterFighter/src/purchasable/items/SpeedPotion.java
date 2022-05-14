package purchasable.items;

import purchasable.monsters.Monster;

/**
 * Extends Item. An item that the player can buy in the Shop.
 * @author inkic
 *
 */
public class SpeedPotion extends Item {
	
	/**
	 * Attribute speedIncrease of type integer. The amount by which the Monster's speed increases.
	 */
	private int speedIncrease = 10;
	
	/**
	 * Constructor for SpeedPotion. Calls the superclass constructor with the name of the SpeedPotion, then sets the purchase price, sell-back price, image path and image for the SpeedPotion.
	 */
	public SpeedPotion() {
		super("Speed Potion");
		setPurchasePrice(13);
		setSellPrice(13);
		setImgPath("/images/speedPotion.png");
		setImg();
	}
	
	/**
	 * Returns the speed increase of the SpeedPotion.
	 * @return speedIncrease, of type integer.
	 */
	public int getSpeedIncrease() {
		return speedIncrease;
	}
	
	/**
	 * Lets the player use the SpeedPotion on a Monster. Adds the speed increase to the Monster's speed.
	 */
	@Override
	public Item use(Monster monster) {
		monster.addSpeed(getSpeedIncrease());
		return null;
	}

}
