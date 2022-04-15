package player;

//one instance

import exceptions.InsufficientGoldException;
import exceptions.NegativeValueException;
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
	private String name;
	
	/**
	 * Attribute goldAmount, of type double. The amount of gold the player has. Initialized to 100.
	 */
	private double goldAmount = 100;
	
	/**
	 * Attribute currentPoints, of type integer. The number of points the player has. Initialized to 0.
	 */
	private PlayerScore score;
	
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
		score = new PlayerScore(this);
	}
	
	/**
	 * Returns the player's username.
	 * @return name, of type String. 
	 */
	public String getName() {
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
	public double getGoldAmount() {
		return goldAmount;
	}
	
	
	/**
	 * Adds gold to the player's private variable goldAmount. Return type void.
	 * @param gold, of type double. The amount of gold the player has gained.
	 */
	public void addGold(double gold) {
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
	public void removeGold(double gold) {
		
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
		return getScore().getPoints();
	}
	
	/**
	 * Adds points to the private variable currentPoints. Return type void.
	 * @param points, of type integer. The number of points the player has gained.
	 */
	public void addPoints(int points) {
		if (points < 0) {
			throw new NegativeValueException("Cannot add negative points");
		} else {
			getScore().addPoints(points);
		}
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

	public PlayerScore getScore() {
		return score;
	}
	

}
