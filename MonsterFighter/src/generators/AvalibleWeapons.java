package generators;

import java.util.Random;

public enum AvalibleWeapons {
	SHARPSTICK;
	
private static final AvalibleWeapons[] VALUES = AvalibleWeapons.values();
	
	public static AvalibleWeapons randomArmor() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
