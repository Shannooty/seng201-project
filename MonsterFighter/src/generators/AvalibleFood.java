package generators;

import java.util.Random;

public enum AvalibleFood {
	APPLE;
	
	private static final AvalibleFood[] VALUES = AvalibleFood.values();
	
	public static AvalibleFood randomFood() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
