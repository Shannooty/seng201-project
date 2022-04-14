package random_event;
import java.util.Random;

import generators.MonsterGenerator;
import generators.registries.AvalibleMonsters;
import player.Inventory;
import purchasable.monsters.*;



/**
 * 
 * @author 
 *
 */
public class NewMonsterJoins extends RandomEvent {

	/**
	 * Attribute random, of type Random. A random generator.
	 */
	Random random = new Random();
	
	/**
	 * Constructor for class NewMonsterJoins. ______???? and calls the method createMonster().
	 */
	public NewMonsterJoins(Inventory inventory) {
		super(inventory);
		AvalibleMonsters[] monsterList = AvalibleMonsters.values();
		createMonster(monsterList[random.nextInt(monsterList.length)]);
	}
	
	/**
	 * Creates a new Monster by calling the getNewMonster() method, and adds it to the player's team.
	 * @param monsterType, of type AvailableMonsters. A list(????) of available monsters.
	 */
	public void createMonster(AvalibleMonsters monsterType) {
		
		Monster newMonster;
		newMonster = MonsterGenerator.newMonster();
		addMonster(newMonster);
		
	}
	
	/**
	 * Creates a new Monster based on the value of the variable monsterType passed to it.
	 * @param monsterType, of type AvailableMonsters. A list(????) of available monsters.
	 * @return a new Monster, or null.
	 */
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

	/**
	 * Adds the given Monster to the player's Inventory. Return type void.
	 * @param monster, of type Monster. The Monster to be added to the player's Inventory.
	 */
	public void addMonster(Monster monster) {
		getPlayerTeam().add(monster);
	}
}
