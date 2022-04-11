package random_event;
import java.util.Random;

import purchasable.monsters.*;




public class NewMonsterJoins extends RandomEvent {

	
	Random random = new Random();
	
	
	public NewMonsterJoins() {	
		AvalibleMonsters[] monsterList = AvalibleMonsters.values();
		createMonster(monsterList[random.nextInt(monsterList.length)]);
	}
	
	public void createMonster(AvalibleMonsters monsterType) {
		
		Monster newMonster;
		newMonster = getNewMonster(monsterType);
		addMonster(newMonster);
		
	}
	
	public Monster getNewMonster(AvalibleMonsters monsterType) {
		switch(monsterType) {
		case SLIME:
			return new Slime();
		case SKELETON:
			return new Skeleton();
		case UNDEADGUARD:
			return new UndeadGuard();
		case ZOMBIE:
			return new Zombie();
		}
		return null;
	}

	public void addMonster(Monster monster) {
		getPlayerTeam().add(monster);
	}
}
