package inventory;
import java.util.ArrayList;

import purchasable.items.*;
import purchasable.monsters.*;


/**
 * 
 * @author 
 *
 */
public class Inventory {
	
	/**
	 * Attribute ownedItems of type ArrayList<Item>. ArrayList of the items the player owns.
	 */
	private static ArrayList<Item> ownedItems = new ArrayList<Item>();
	
	/**
	 * Attribute team of type ArrayList<Monster>. ArrayList of the monsters the player has on their team.
	 */
	public static ArrayList<Monster> team = new ArrayList<Monster>();
	
	
	/**
	 * Constructor for the class Inventory. Calls the addMonster() method to add the given startingMonster to the player's inventory.
	 * @param startingMonster, type Monster. The user's starting monster.
	 */
	public Inventory(Monster startingMonster) {
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
		ownedItems.add(item);
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
	public static void addMonster(Monster monster) {
		team.add(monster);
	}
	
	/**
	 * Returns the private variable ownedItems, the Items that the player currently owns.
	 * @return ownedItems, of type ArrayList<Item>.
	 */
	public static ArrayList<Item> getItems(){
		return ownedItems;
	}
	
	/**
	 * Returns the private variable team, the Monsters that the player currently owns.
	 * @return team, or type ArrayList<Monster>
	 */
	public static ArrayList<Monster> getTeam(){
		return team;
	}
}
