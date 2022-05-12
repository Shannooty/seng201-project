package generators.registries;

import java.util.Random;

/**
 * Public enum of all Food types
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public enum AvalibleFoods {
	APPLE, BREAD, MUSHROOM;
	
	private static final AvalibleFoods[] VALUES = AvalibleFoods.values();
	
	/**
	 * Static method that returns a random Food type from the AvalibleFood enum
	 * @return Food type
	 */
	public static AvalibleFoods randomFood() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
