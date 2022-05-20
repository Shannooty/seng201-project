package random_event;

import java.util.ArrayList;

import gui.GameEnvironment;
import player.Inventory;
import purchasable.monsters.Monster;

/**
 * Extends RandomEvent. A random event that can occur overnight.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class MonsterLeaves extends RandomEvent {

	/**
	 * Constructor for the class MonsterLeaves. Calls the method removeMonster().
	 * @param inventory The player Inventory to remove a random Monster
	 */
	public MonsterLeaves(Inventory inventory, GameEnvironment gameManager) {
		super(inventory, gameManager);
		
		if (getPlayerTeam().size() > 0) {
			removeMonster(gameManager);
		}
	}
	
	/**
	 * Removes the Monster from the team variable in Inventory. Returns void.
	 */
	public void removeMonster(GameEnvironment gameManager) {

		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.addAll(getPlayerTeam().getTeam());
		if (gameManager.getStunned() != null) {
			monsters.addAll(gameManager.getStunned());
			monsters.addAll(gameManager.getStunned());
		}
		getPlayerTeam().getTeam().remove(monsters.get(randomItem.nextInt(monsters.size())));
	}

}
