package generators;

import java.util.Random;

public enum AvalibleMonsters {
	SLIME, ZOMBIE, UNDEADGUARD, SKELETON;
	
	private static final AvalibleMonsters[] VALUES = AvalibleMonsters.values();
	
	public static AvalibleMonsters randomMonster() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
