package generators;

import generators.registries.AvalibleMonsters;
import purchasable.monsters.*;

/**
 * MonsterGenerator class that provides the ability to create a random Monster object
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class MonsterGenerator extends Generator {
	
	/**
	 * Returns a new Monster object of a random type
	 * @return The Monster object
	 */
	public static Monster newMonster() {
		AvalibleMonsters monsterType = AvalibleMonsters.randomMonster();
		
		switch (monsterType) {
		case SKELETON:
			return new Skeleton();
		case SLIME:
			return new Slime();
		case UNDEADGUARD:
			return new UndeadGuard();
		case ZOMBIE:
			return new Zombie();
		case DINOSAUR:
			return new Dinosaur();
		case SNAKE:
			return new Snake();
		default:
			return null;
		}
	}
}
