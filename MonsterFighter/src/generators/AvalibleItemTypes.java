package generators;

import java.util.Random;

public enum AvalibleItemTypes {
	ARMOR, WEAPON, FOOD, POTION;
	
private static final AvalibleItemTypes[] VALUES = AvalibleItemTypes.values();
	
	public static AvalibleItemTypes randomItemType() {
		return VALUES[new Random().nextInt(VALUES.length)];
	}
}
