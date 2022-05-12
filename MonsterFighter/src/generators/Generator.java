package generators;

import java.util.Random;
/**
 * Abstract generator class to provide base methods to other generator classes
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public abstract class Generator {
	private Random random = new Random();
	
	public Random getRandom() {
		return random;
	}
}
