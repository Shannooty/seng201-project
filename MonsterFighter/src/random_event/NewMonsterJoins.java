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
	 * Constructor for class NewMonsterJoins. ______???? and calls the method createMonster().
	 */
	public NewMonsterJoins(Inventory inventory) {
		super(inventory);
		
		if (getPlayerTeam().size() < 4) {
			createMonster();
		}
	}
	
	/**
	 * Creates a new Monster by calling the getNewMonster() method, and adds it to the player's team.
	 * @param monsterType, of type AvailableMonsters. A list(????) of available monsters.
	 */
	public void createMonster() {
		
		Monster newMonster;
		newMonster = MonsterGenerator.newMonster();
		addMonster(newMonster);
		
	}

	/**
	 * Adds the given Monster to the player's Inventory. Return type void.
	 * @param monster, of type Monster. The Monster to be added to the player's Inventory.
	 */
	public void addMonster(Monster monster) {
		getPlayerTeam().add(monster);
	}
}
