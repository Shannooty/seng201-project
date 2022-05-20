package generators.registries;

import java.util.Random;

/**
 * Public enum of all ItemTypes
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public enum AvalibleItemTypes {
	/**
	 * Armor ItemType
	 */
	ARMOR, 
	/**
	 * Weapon ItemType
	 */
	WEAPON, 
	/**
	 * Food ItemType
	 */
	FOOD, 
	/**
	 * Potion ItemType
	 */
	POTION;
	
private static final AvalibleItemTypes[] VALUES = AvalibleItemTypes.values();
	
	/**
	 * Returns a random ItemType from the AvalibleItemTypes enum
	 * @return ItemType
	 */
	public static AvalibleItemTypes randomItemType() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
