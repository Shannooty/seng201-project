package generators.registries;

import java.util.Random;

/**
 * Public enum of all Armor types
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public enum AvalibleArmors {
	FLOWERCROWN, SHIELD, CHAINMAIL;
	
	private static final AvalibleArmors[] VALUES = AvalibleArmors.values();
	
	/**
	 * Static method that returns a random Armor type from the AvalibleArmor enum
	 * @return Armor type
	 */
	public static AvalibleArmors randomArmor() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
