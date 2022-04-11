package generators;

import java.util.Random;

public enum AvalibleWeapons {
	SHARPSTICK;
	
private static final AvalibleWeapons[] VALUES = AvalibleWeapons.values();
	
	public static AvalibleWeapons randomWeapon() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}