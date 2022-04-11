package generators;

import purchasable.monsters.*;

public class MonsterGenerator extends Generator {
	
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
		default:
			return null;
		}
	}
}
