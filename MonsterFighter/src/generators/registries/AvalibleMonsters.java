package generators.registries;

import java.util.Random;

/**
 * Public enum of all Monster types
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public enum AvalibleMonsters {
	SLIME, ZOMBIE, UNDEADGUARD, SKELETON, DINOSAUR, SNAKE;
	
	private static final AvalibleMonsters[] VALUES = AvalibleMonsters.values();
	
	/**
	 * Static method that returns a random Monster type from the AvalibleMonster enum
	 * @return Monster type
	 */
	public static AvalibleMonsters randomMonster() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
