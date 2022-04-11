package generators;

import java.util.Random;

public enum AvalibleArmors {
	FLOWERCROWN;
	
	private static final AvalibleArmors[] VALUES = AvalibleArmors.values();
	
	public static AvalibleArmors randomArmor() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}