package generators.registries;

import java.util.Random;

public enum AvalibleArmors {
	FLOWERCROWN, SHIELD;
	
	private static final AvalibleArmors[] VALUES = AvalibleArmors.values();
	
	public static AvalibleArmors randomArmor() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
