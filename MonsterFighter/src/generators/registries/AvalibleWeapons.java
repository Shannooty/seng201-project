package generators.registries;

import java.util.Random;

/**
 * Public enum of all Weapon types
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public enum AvalibleWeapons {
	SHARPSTICK, SLEDGEHAMMER, KNIFE;
	
	private static final AvalibleWeapons[] VALUES = AvalibleWeapons.values();
	
	/**
	 * Static method that returns a random Weapon type from the AvalibleWeapons enum
	 * @return Weapon type
	 */
	public static AvalibleWeapons randomWeapon() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
