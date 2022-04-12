package shop;

import java.util.ArrayList;

import generators.ItemGenerator;
import generators.MonsterGenerator;
import purchasable.items.Item;
import purchasable.monsters.Monster;

public class Shop {
	
	private ArrayList<Monster> avalibleMonsters = new ArrayList<Monster>();
	private ArrayList<Item> avalibleItems = new ArrayList<Item>();
	private int numMonsters;
	private int numItems;
	
	public Shop(int numMonsters, int numItems) {
		setNumMonsters(numMonsters);
		setNumItems(numItems);
		addMonsters();
		addItems();
	}
	
	public void addMonsters() {
		for (int i = 0; i < getNumMonsters(); i++) {
			Monster newMonster = MonsterGenerator.newMonster();
			newMonster.setPurchasePrice(70);
			avalibleMonsters.add(newMonster);
		}
	}
	
	public void addItems() {
		for (int i = 0; i < getNumItems(); i++) {
			Item newItem = ItemGenerator.newItem();
			newItem.setPurchasePrice(10);
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
