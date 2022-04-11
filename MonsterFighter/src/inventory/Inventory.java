package inventory;
import java.util.ArrayList;

import purchasable.items.*;
import purchasable.monsters.*;

public class Inventory {
	
	private static ArrayList<Item> ownedItems = new ArrayList<Item>();
	public static ArrayList<Monster> team = new ArrayList<Monster>();
	
	public Inventory(Monster startingMonster) {
		addMonster(startingMonster);
	}
	
	public void removeItem(Item item) {
		ownedItems.remove(item);
	}
	
	public void addItem(Item item) {
		ownedItems.add(item);
	}
	
	public void removeMonster(Monster monster) {
		team.remove(monster);
	}
	
	public static void addMonster(Monster monster) {
		team.add(monster);
	}
	
	public ArrayList<Item> getItems(){
		return ownedItems;
	}
	
	public static ArrayList<Monster> getTeam(){
		return team;
	}
}
