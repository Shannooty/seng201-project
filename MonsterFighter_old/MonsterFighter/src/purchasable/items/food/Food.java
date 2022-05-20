package purchasable.items.food;

import purchasable.items.Item;
import purchasable.monsters.Monster;

/**
 * A type of Item that the player can buy in the Shop.
 * @author Bede Nathan
 * @author Celia Allen
 */
public abstract class Food extends Item {
	
	/**
	 * Attribute healAmount, of type integer. The amount by which the food heals the monster.
	 */
	private int healAmount;
	
	/**
	 * Constructor for the Food class. Calls the superclass constructor
	 * @param itemName, of type String. The name of the item.
	 */
	public Food(String itemName) {
		super(itemName);
	}
	
	/**
	 * Returns the amount buy which the food heals a monster.
	 * @return healAmount, of type integer.
	 */
	public int getHealAmount() {
		return healAmount;
	}
	
	/**
	 * Sets the private attribute healAmount.
	 * @param healAmount, of type integer. The amount by whoch the food heals the monster.
	 */
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
	/**
	 * Lets the player use the food on a monster.
	 */
	@Override
	public Item use(Monster monster) {
		monster.addHealth(getHealAmount());
		return null;
	}

}
