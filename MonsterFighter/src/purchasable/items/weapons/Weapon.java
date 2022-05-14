package purchasable.items.weapons;

import purchasable.items.Item;
import purchasable.monsters.Monster;

/**
 * A type of Item that the player can buy in the Shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public abstract class Weapon extends Item {
	
	/**
	 * Attribute attackIncrease, of type integer. The amount by which the monster's attack amount increases.
	 */
	private int attackIncrease;
	
	/**
	 * Constructor for the Armor class. Calls the superclass constructor, and sets the private attribute attackIncrease.
	 * @param name, of type String. The name of the object.
	 * @param damage, of type integer. The amount by which the monster's attack amount increases.
	 */
	public Weapon(String name, int damage) {
		super(name);
		attackIncrease = damage;
	}
	
	/**
	 * Returns the amount by which the monster's attack amount increases.
	 * @return attackIncrease, of type integer.
	 */
	public int getDamage() {
		return attackIncrease;
	}
	
	/**
	 * Lets the player equip a monster with the weapon.
	 */
	@Override
	public Weapon use(Monster monster) {
		
		Weapon oldWeapon = monster.addWeapon(this);
		return oldWeapon;

	}
	

}
