package random_event;

import player.Inventory;
import purchasable.monsters.Monster;

/**
 * Extends RandomEvent. A random event that can occur overnight.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class MonsterLevelsUp extends RandomEvent {
	
	/**
	 * Attribute healthIncrease, of type integer[]. A list of the possible increases in health a monster can have, {10, 5, 8, 15, 30}.
	 */
	private int[] healthIncrease = {10, 5, 8, 15, 30};
	
	/**
	 * Constructor for the MonsterLevelsUp class. Calls the levelUpSetUp() method.
	 */
	public MonsterLevelsUp(Inventory inventory) {
		super(inventory);
		levelUpSetUp();
	}
	
	/**
	 * Selects a random health increase from the private variable healthIncrease, using the random generator random. Selects a random Monster from the player's Inventory. Calls the method heal(), passing in the random health increase, and the random Monster. Return type void.
	 */
	public void levelUpSetUp() {
		int health = healthIncrease[(randomItem.nextInt(healthIncrease.length))];
		Monster monster = getPlayerTeam().getTeam().get(randomItem.nextInt(getPlayerTeam().size()));
		heal(health, monster);
	}
	
	/**
	 * Calls the addMaxHealth() method from the class Monster, passing in the variable health. Return type void.
	 * @param health, of type integer. The amount by which the Monster's maximum health should increase.
	 * @param monster, or type Monster. The Monster whose maximum health will increase.
	 */
	public void heal(int health, Monster monster) {
		monster.addMaxHealth(health);
	}

}
