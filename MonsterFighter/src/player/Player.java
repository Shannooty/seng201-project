package player;

import exceptions.InsufficientGoldException;
import exceptions.NegativeValueException;
import inventory.Inventory;
import monsters.Monster;

public class Player {
	
	
	private static String name;
	private static double goldAmount = 0;
	private int currentPoints = 0;
	private Inventory inventory;
//	private Team team;
	
	
	public Player(String name, Monster startingMonster) {
		setName(name);
		setInventory(new Inventory(startingMonster));
	}
	
	
	public static String getName() {
		return name;
	}
	
	
	public void setName(String newName) {
		name = newName;
	}
	
	public static double getGoldAmount() {
		return goldAmount;
	}
	
	public void addGold(double gold) {
		if (gold < 0) {
			throw new NegativeValueException("Cannot add negative gold");
		} else {
			goldAmount += gold;
		}
	}
	
	public void removeGold(double gold) {
		
		if (getGoldAmount() < gold) {
			throw new InsufficientGoldException("Insufficient Gold");
		} else if (gold < 0) {
			throw new NegativeValueException("Cannot remove negative gold");
		} else {
			goldAmount -= gold;
		}
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
