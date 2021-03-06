package random_event;

import generators.MonsterGenerator;
import gui.GameEnvironment;
import player.Inventory;
import purchasable.monsters.*;



/**
 * Extends RandomEvent. A random event that can occur overnight.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class NewMonsterJoins extends RandomEvent {

	
	/**
	 * Constructor for class NewMonsterJoins. Calls the superclass constructor, and calls the method createMonster().
	 * @param inventory The players Inventory for the new Monster to be passed into
	 * @param gameManager The GameEnvironment running the application
	 */
	public NewMonsterJoins(Inventory inventory, GameEnvironment gameManager) {
		super(inventory, gameManager);
		
		if (getPlayerTeam().size() < 4) {
			createMonster();
		}
	}
	
	/**
	 * Creates a new Monster by calling the getNewMonster() method, and adds it to the player's team.
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
