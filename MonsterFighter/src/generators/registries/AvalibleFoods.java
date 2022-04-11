package generators.registries;

import java.util.Random;

public enum AvalibleFoods {
	APPLE;
	
	private static final AvalibleFoods[] VALUES = AvalibleFoods.values();
	
	public static AvalibleFoods randomFood() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
