package generators;

import java.util.Random;

public abstract class Generator {
	private Random random = new Random();
	
	public Random getRandom() {
		return random;
	}
}
