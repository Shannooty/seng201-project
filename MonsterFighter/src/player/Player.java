package player;

//one instance

import exceptions.InsufficientGoldException;
import exceptions.NegativeValueException;
import inventory.Inventory;
import purchasable.monsters.Monster;

/**
 * 
 * @author 
 *
 */
public class Player {
	
	/**
	 * Attribute name, of type String. The player's name.
	 */
	private static String name;
	
	/**
	 * Attribute goldAmount, of type double. The amount of gold the player has. Initialized to 100.
	 */
	private static double goldAmount = 100;
	
	/**
	 * Attribute currentPoints, of type integer. The number of points the player has. Initialized to 0.
	 */
	private int currentPoints = 0;
	
	/**
	 * Attribute inventory, of type Inventory. The player's inventory.
	 */
	private Inventory inventory;
//	private Team team;
	
	
	/**
	 * Constructor for the class Player. Sets the player's name using the setName() method, and adds the player's starting monster to their inventory using the setInventory() method.
	 * @param name, of type String. The player's username.
	 * @param startingMonster, of type Monster. The user's starting Monster.
	 */
	public Player(String name, Monster startingMonster) {
		setName(name);
		setInventory(new Inventory(startingMonster));
	}
	
	/**
	 * Returns the player's username.
	 * @return name, of type String. 
	 */
	public static String getName() {
		return name;
	}
	
	/**
	 * Sets the private variable name to the given newName. Return type void.
	 * @param newName, of type String. The player's new username.
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * Returns the amount of gold the player currently has.
	 * @return goldAmount, of type double. The amount of gold a player has.
	 */
	public static double getGoldAmount() {
		return goldAmount;
	}
	
	
	/**
	 * Adds gold to the player's private variable goldAmount. Return type void.
	 * @param gold, of type double. The amount of gold the player has gained.
	 */
	public static void addGold(double gold) {
		if (gold < 0) {
			throw new NegativeValueException("Cannot add negative gold");
		} else {
			goldAmount += gold;
		}
	}
	
	/**
	 * Removes from the player's private variable goldAmount. If the player does not have enough gold, throws InsufficientGoldException. If the value of the given variable gold is negative, throws NegativeValueException. Return type void.
	 * @param gold, of type double. The amount of gold the player no longer has.
	 */
	public static void removeGold(double gold) {
		
		if (getGoldAmount() < gold) {
			throw new InsufficientGoldException("Insufficient Gold");
		} else if (gold < 0) {
			throw new NegativeValueException("Cannot remove negative gold");
		} else {
			goldAmount -= gold;
		}
	}
	
	/**
	 * Returns the player's current points. 
	 * @return currentPoints, of type integer. 
	 */
	public int getPoints() {
		return currentPoints;
	}
	
	/**
	 * Adds points to the private variable currentPoints. Return type void.
	 * @param points, of type integer. The number of points the player has gained.
	 */
	public void addPoints(int points) {
		currentPoints += points;
	}

	/**
	 * Returns the player's inventory.
	 * @return inventory, of type Inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * Sets the private variable inventory to the value of the given inventory. Return type void.
	 * @param inventory, of type Inventory. The player's current inventory.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

}
