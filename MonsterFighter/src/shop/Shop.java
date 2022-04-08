package shop;

import java.util.ArrayList;
import items.Item;
import monsters.Monster;

public class Shop {
	
	private ArrayList<Monster> avalibleMonsters = new ArrayList<Monster>();
	private ArrayList<Item> avalibleItems = new ArrayList<Item>();
	private int numMonsters;
	private int numItems;
	
	public Shop(int numMonsters, int numItems) {
		addMonsters();
		addItems();
	}
	
	private void addMonsters() {
		for (int i = 0; i < getNumMonsters(); i++) {
			Monster newMonster = MonsterGenerator.getMonster();
			avalibleMonsters.add(newMonster);
		}
	}
	
	private void addItems() {
		for (int i = 0; i < getNumItems(); i++) {
			Item newItem = ItemGenerator.getMonster();
			avalibleItems.add(newItem);
		}
	}
	
	public ArrayList<Monster> getAvalibleMonsters(){
		return avalibleMonsters;
	}
	
	public ArrayList<Item> getAvalibleItems(){
		return avalibleItems;
	}
	
	public int getNumMonsters() {
		return numMonsters;
	}

	public void setNumMonsters(int numMonsters) {
		this.numMonsters = numMonsters;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
}
