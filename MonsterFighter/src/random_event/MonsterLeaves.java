package random_event;
import java.util.Random;

import player.Inventory;
import player.Team;

/**
 * 
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class MonsterLeaves extends RandomEvent {

	/**
	 * Constructor for the class MonsterLeaves. Calls the method removeMonster().
	 */
	public MonsterLeaves(Inventory inventory) {
		super(inventory);
		
		if (getPlayerTeam().size() > 0) {
			removeMonster();
		}
	}
	
	/**
	 * Removes the Monster from the team variable in Inventory. Returns void.
	 */
	public void removeMonster() {
		getPlayerTeam().getTeam().remove(randomItem.nextInt(getPlayerTeam().size()));
	}
	

}
