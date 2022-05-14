package player;
import java.util.ArrayList;

import purchasable.items.*;
import purchasable.items.food.Food;
import purchasable.monsters.*;


/**
 * The player's inventory of currently owned Monsters and Items
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Inventory {
	
	/**
	 * Attribute ownedItems of type ArrayList<Item>. ArrayList of the items the player owns.
	 */
	private ArrayList<Item> ownedItems = new ArrayList<Item>();
	
	/**
	 * Attribute team of type Team. The players team.
	 */
	private Team team;
	
	
	
	/**
	 * Constructor for the class Inventory. Calls the Team() constructor to initialize the creation of the player's team of Monster, and the addMonster() method to add the given startingMonster to the player's team.
	 * @param startingMonster, type Monster. The user's starting monster.
	 */
	public Inventory(Monster startingMonster) {
		team = new Team();
		addMonster(startingMonster);
	}
	
	/**
	 * Removes the given Item from the player's inventory. Return type void.
	 * @param item, type Item. The item to be removed from the player's inventory.
	 */
	public void removeItem(Item item) {
		ownedItems.remove(item);
	}
	
	/**
	 * Adds the given Item to the player's inventory. Return type void.
	 * @param item, type Item. The item to be added to the player's inventory.
	 */
	public void addItem(Item item) {
		if (item != null) {
			if (!getItems().contains(item)) {
				getItems().add(item);
			}
		}
	}
	
	/**
	 * Removes the given Monster from the player's team. Return type void.
	 * @param monster, type Monster. The Monster to be removed from the player's team.
	 */
	public void removeMonster(Monster monster) {
		team.remove(monster);
	}
	
	/**
	 * Adds the given Monster to the player's team. Return type void.
	 * @param monster, type Monster. The Monster to be added to the player's team.
	 */
	public void addMonster(Monster monster) {
		team.add(monster);
	}
	
	/**
	 * Returns the private variable ownedItems, the Items that the player currently owns.
	 * @return ownedItems, of type ArrayList[Item].
	 */
	public ArrayList<Item> getItems(){
		return ownedItems;
	}
	
	/**
	 * Returns the private variable team, the Monsters that the player currently owns.
	 * @return team, of type ArrayList[Monster]
	 */
	public Team getTeam(){
		return team;
	}
	
	/**
	 * Lets the inventory use an item on a monster. Return type void.
	 * @param item, of type Item. The item to be used.
	 * @param monster, of type Monster. The monster for the item to be used on.
	 */
	public void useItem(Item item, Monster monster) {
		if (item instanceof Food) {
			item.use(monster);
		} else if (item instanceof SpeedPotion) {
			item.use(monster);
		}else {
			Item equipedTool = item.use(monster);
			addItem(equipedTool);
		}
		removeItem(item);
	}
	
	/**
	 * Custom toString method for the inventory. Returns a string of all the player's items, each on their own line.
	 */
	public String toString() {
		String output = "";
		
		for(Item val : getItems()) {
			output += val + "\n";
		}
		return output;
	}
}
