package shop;

import java.util.ArrayList;

import generators.ItemGenerator;
import generators.MonsterGenerator;
import purchasable.items.Item;
import purchasable.monsters.Monster;

/**
 * 
 * @author 
 *
 */
public class Shop {
	
	/**
	 * Attribute availableMonster, of type ArrayList<Monster>. An ArrayList of the Monsters that are available to buy.
	 */
	private ArrayList<Monster> avalibleMonsters = new ArrayList<Monster>();
	
	/**
	 * Attribute availableItems, of type ArrayList<Item>. An ArrayList of Items that are available to buy.
	 */
	private ArrayList<Item> avalibleItems = new ArrayList<Item>();
	
	/**
	 * Attribute numMonsters, of type integer. The number of Monsters that are currently in the Shop.
	 */
	private int numMonsters;
	
	/**
	 * Attribute numItems, of type integer. The number of Items that are currently in the Shop.
	 */
	private int numItems;
	
	
	/**
	 * Constructor for the class Shop. Sets the private variables numMonsters and numItems using methods setNumMonsters() and setNumItems(), passing in the variables given. Also calls addMonsters() and addItems() to add the initial Items and Monsters to the Shop.
	 * @param numMonsters, of type integer. The number of Monsters that need to be initialized for the Shop.
	 * @param numItems, of type integer. The number of Items that need to be initialized for the Shop.
	 */
	public Shop(int numMonsters, int numItems) {
		setNumMonsters(numMonsters);
		setNumItems(numItems);
		addMonsters();
		addItems();
	}
	
	/**
	 * Calls the getNumMonsters() method to get the number of Monsters that should be in the Shop, and used the class MonsterGenerator to create that number of Monsters. Adds them to the Shop. Return type void.
	 */
	public void addMonsters() {
		for (int i = 0; i < getNumMonsters(); i++) {
			Monster newMonster = MonsterGenerator.newMonster();
//			newMonster.setPurchasePrice(70);
			avalibleMonsters.add(newMonster);
		}
	}
	
	public void removeMonster(Monster monster) {
		getAvalibleMonsters().remove(monster);
	}
	
	public void removeItem(Item item) {
		getAvalibleItems().remove(item);
	}
	
	/**
	 * Calls the getNumItems() method to get the number of Items that should be in the Shop, and used the class ItemGenerator to create that number of Items. Adds them to the Shop. Return type void.
	 */
	public void addItems() {
		for (int i = 0; i < getNumItems(); i++) {
			Item newItem = ItemGenerator.newItem();
//			newItem.setPurchasePrice(10);
			avalibleItems.add(newItem);
		}
	}
	
	
	/**
	 * Returns an ArrayList of the available Monsters in the Shop.
	 * @return avalibleMonsters, of type ArrayList<Monster>
	 */
	public ArrayList<Monster> getAvalibleMonsters(){
		return avalibleMonsters;
	}
	
	/**
	 * Returns an ArrayList of the available Items in the Shop.
	 * @return availableItems, of type ArrayList<Item>
	 */
	public ArrayList<Item> getAvalibleItems(){
		return avalibleItems;
	}
	
	/**
	 * Returns the number of Monsters in the Shop.
	 * @return numMonsters, of type integer. The number of Monsters in the Shop.
	 */
	public int getNumMonsters() {
		return numMonsters;
	}

	/**
	 * Sets the private variable numMonsters to the given value. Return type void.
	 * @param numMonsters, or type integer. The number of Monsters in the Shop.
	 */
	public void setNumMonsters(int numMonsters) {
		this.numMonsters = numMonsters;
	}

	/**
	 * Returns the number of Items in the Shop.
	 * @return numItems, of type integer. The number of Items in the Shop.
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * Sets the private variable numItems to the given value. Return type void.
	 * @param numItems, of type integer. The number of Items in the Shop.
	 */
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
}
