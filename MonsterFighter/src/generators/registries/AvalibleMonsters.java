package generators.registries;

import java.util.Random;

public enum AvalibleMonsters {
	SLIME, ZOMBIE, UNDEADGUARD, SKELETON, DINOSAUR, SNAKE;
	
	private static final AvalibleMonsters[] VALUES = AvalibleMonsters.values();
	
	public static AvalibleMonsters randomMonster() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
