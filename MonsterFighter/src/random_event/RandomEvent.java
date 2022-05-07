package random_event;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import player.Inventory;
import player.Team;
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
//	private String[] randomEvents = {"MonsterLeaves", "NewMonsterJoins", "MonsterLevelsUp"};
	
	
	/**
	 * Attribute randomEventsInt, of type List<Integer>. A list of integers in the range 1 to 20. Used to change the chance of each RandomEvent occurring.
	 */
	private List<Integer> randomEventsInt = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
	
	
	/**
	 * Attribute randomItem, of type Random. A random generator.
	 */
	protected Random randomItem = new Random();
	
	
//	private static Random randomItem;
	
	protected Inventory inventory;
	
	/**
	 * Attribute playerTeam, of type ArrayList<Monster>. Calls the method getTeam() in class Inventory to get the player's team.
	 */
	private Team playerTeam;
	
	
	
	/**
	 * Constructor for the class RandomEvent. Does not require any parameters, returns nothing, and does nothing. Created so RandomEvent's subclasses don't have to try and create an Inventory they don't have.
	 */
	public RandomEvent() {
		
	}
	
	/**
	 * Constructor for the class RandomEvent. Sets the private variable inventory to the give inventory, and sets the private variable playerTeam to the player's current team.
	 * @param inventory, of type Inventory. The player's inventory.
	 */
	public RandomEvent(Inventory inventory) {
		this.inventory = inventory;
		playerTeam = inventory.getTeam();
	}
	
	
	/**
	 * Returns a random item from the list randomEvents, using the random generator randomItem.
	 * @return an item of randomEvents, of type String. A possible event that can occur overnight in the game.
	 */
	public String getRandomEvent() {	
		int randomInt = randomEventsInt.get(randomItem.nextInt(randomEventsInt.size()));
		
		String event;
		
		if (randomInt >= 1 && randomInt <= 3) {
			event = "MonsterLeaves";
		} else if (randomInt >= 4 && randomInt <= 5) {
			event = "NewMonsterJoins";
		} else if (randomInt >= 6 && randomInt <= 11) {
			event = "MonsterLevelsUp";
		} else {
			event = "Nothing";
		}
		
		return event;
//		return randomEvents[(randomItem.nextInt(randomEvents.length))];
	}

	/**
	 * Calls the method getRandomEvent(), and creates an instance of the class depending on the random event the call to getRandomEvent() returns. Return type string.
	 */
	public String runRandomEvent() {
		String randomEvent = getRandomEvent();
		
		
		
//		System.out.println("randomEvent: "+randomEvent+" team size: "+playerTeam.getTeam().size());
		while (((randomEvent == "MonsterLeaves" || randomEvent == "MonsterLevelsUp") && playerTeam.getTeam().size() == 0) || randomEvent == "NewMonsterJoins" &&  playerTeam.getTeam().size() == 4){
			randomEvent = getRandomEvent();
//			System.out.println("WHILE randomEvent: "+randomEvent+" team size: "+playerTeam.getTeam().size());
		}
		
		if (randomEvent == "MonsterLeaves") {
			MonsterLeaves leaves = new MonsterLeaves(getInventory());
		} else if (randomEvent == "NewMonsterJoins") {
			NewMonsterJoins joins = new NewMonsterJoins(getInventory());
		} else if (randomEvent == "MonsterLevelsUp") {
			MonsterLevelsUp levelsUp = new MonsterLevelsUp(getInventory());
		}
		
		return randomEvent;
	}

	/**
	 * Returns the player's team.
	 * @return playerTeam, of type ArrayList<Monster>
	 */
	public Team getPlayerTeam() {
		return playerTeam;
	}

	/**
	 * Sets the private variable playerTeam to the value of the playerTeam given to it. Return type void.
	 * @param playerTeam, of type ArrayList<Monster>. The player's team.
	 */
	public void setPlayerTeam(Team playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	
	public Inventory getInventory() {
		return inventory;
	}
	
	
	
}
