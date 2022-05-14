package purchasable.items.armors;

import purchasable.items.Item;
import purchasable.monsters.Monster;

/**
 * A type of Item that the player can buy in the Shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public abstract class Armor extends Item {
	
	/**
	 * Attribute maxHealthIncrease, of type integer. The amount by which the monster's maximum health increases.
	 */
	private int maxHealthIncrease;
	
	/**
	 * Attribute armorIncrease, of type integer. The amount by which the monster's armor increases.
	 */
	private int armorIncrease;
	
	/**
	 * Constructor for the Armor class. Calls the superclass constructor, and sets the private attributes maxHealthIncrease and armorIncrease.
	 * @param name, of type String. The name of the object.
	 * @param healthIncrease, of type integer. The amount by which the armor increases the monster's maximum health.
	 * @param armorAmount, of type integer. The amount by which the monster's armor amount increases.
	 */
	public Armor(String name, int healthIncrease, int armorAmount) {
		super(name);
		maxHealthIncrease = healthIncrease;
		this.armorIncrease = armorAmount;
	}
	
	/**
	 * Returns the amount by which the monster's maximum health increases.
	 * @return maxHealthIncrease, of type integer.
	 */
	public int getHealthIncrease() {
		return maxHealthIncrease;
	}
	
	/**
	 * Returns the amount by which the monster's armor increases.
	 * @return armorIncrease, of type integer.
	 */
	public int getArmorIncrease() {
		return armorIncrease;
	}
	
	/**
	 * Lets the player use the armor on a monster.
	 */
	@Override
	public Item use(Monster monster) {
		Armor oldArmor = monster.addArmor(this);
		return oldArmor;

	}

}
