package generators.registries;

import java.util.Random;

public enum AvalibleWeapons {
	SHARPSTICK, SLEDGEHAMMER, KNIFE;
	
private static final AvalibleWeapons[] VALUES = AvalibleWeapons.values();
	
	public static AvalibleWeapons randomWeapon() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
