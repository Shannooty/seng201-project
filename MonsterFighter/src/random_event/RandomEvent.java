package random_event;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Random;
import inventory.Inventory;

import purchasable.monsters.Monster;

/**
 * 
 * @author 
 *
 */
public class RandomEvent {
	
	
//	private ArrayList<String> randomEvents;
	
	/**
	 * Attribute randomEvents, of type String[]. A list of the possible random events, {"MonsterLeaves", "NewMonsterJoins", "MonsterLevelsUp"}.
	 */
	private static String[] randomEvents = {"MonsterLeaves", "NewMonsterJoins", "MonsterLevelsUp"};
	
	/**
	 * Attribute randomItem, of type Random. A random generator.
	 */
	private static Random randomItem = new Random();
	
	
//	private static Random randomItem;
	
	/**
	 * Attribute playerTeam, of type ArrayList<Monster>. Calls the method getTeam() in class Inventory to get the player's team.
	 */
	private ArrayList<Monster> playerTeam = Inventory.getTeam();
	
	
	/**
	 * Returns a random item from the list randomEvents, using the random generator randomItem.
	 * @return an item of randomEvents, of type String. A possible event that can occur overnight in the game.
	 */
	public static String getRandomEvent() {		
		return randomEvents[(randomItem.nextInt(randomEvents.length))];
	}

	/**
	 * Calls the method getRandomEvent(), and creates an instance of the class depending on the random event the call to getRandomEvent() returns. Return type void.
	 */
	public static void runRandomEvent() {
		String randomEvent = getRandomEvent();
		if (randomEvent == "MonsterLeaves") {
			MonsterLeaves leaves = new MonsterLeaves();
		} else if (randomEvent == "NewMonsterJoins") {
			NewMonsterJoins joins = new NewMonsterJoins();
		} else {
			MonsterLevelsUp levelsUp = new MonsterLevelsUp();
		}		
		
	}

	/**
	 * Returns the player's team.
	 * @return playerTeam, of type ArrayList<Monster>
	 */
	public ArrayList<Monster> getPlayerTeam() {
		return playerTeam;
	}

	/**
	 * Sets the private variable playerTeam to the value of the playerTeam given to it. Return type void.
	 * @param playerTeam, of type ArrayList<Monster>. The player's team.
	 */
	public void setPlayerTeam(ArrayList<Monster> playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	
	
}
