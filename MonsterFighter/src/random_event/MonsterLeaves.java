package random_event;
import java.util.Random;

import player.Inventory;
import player.Team;

/**
 * 
 * @author
 *
 */
public class MonsterLeaves extends RandomEvent {

	/**
	 * Attribute random, of type Random. A random generator.
	 */
	private Random random = new Random();

	/**
	 * Constructor for the class MonsterLeaves. Calls the method removeMonster().
	 */
	public MonsterLeaves(Inventory inventory) {
		super(inventory);
		removeMonster();
	}
	
	/**
	 * Removes the Monster from the team variable in Inventory. Returns void.
	 */
	public void removeMonster() {
		//TODO FIX THIS
		inventory.getTeam().getTeam().remove(random.nextInt(inventory.getTeam().getTeam().size()));
	}
	

}
