package player;

import inventory.Inventory;
import monsters.Monster;

public class Player {
	
	
	private String name;
	private double goldAmount = 0;
	private int currentPoints = 0;
	private Inventory inventory;
//	private Team team;
	
	
	public Player(String name, Monster startingMonster) {
		setName(name);
		setInventory(new Inventory(startingMonster));
	}
	
	
	public String getName() {
		return name;
	}
	
	
	private void setName(String newName) {
		name = newName;
	}
	
	public double getGoldAmount() {
		return goldAmount;
	}
	
	public void addGold(double gold) {
		goldAmount += gold;
	}
	
	public void removeGold(double gold) {
		goldAmount -= gold;
	}
	
	public int getPoints() {
		return currentPoints;
	}
	
	public void addPoints(int points) {
		currentPoints += points;
	}


	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	

}
