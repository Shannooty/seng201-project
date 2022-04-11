package random_event;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Random;
import inventory.Inventory;

import monsters.Monster;

public class RandomEvent {
	
	
//	private ArrayList<String> randomEvents;
	private static String[] randomEvents = {"MonsterLeaves", "NewMonsterJoins", "MonsterLevelsUp"};
	private static Random randomItem = new Random();
//	private static Random randomItem;
	private ArrayList<Monster> playerTeam = Inventory.getTeam();
	
	
	public static String getRandomEvent() {		
		return randomEvents[(randomItem.nextInt(randomEvents.length))];
	}

	public static void runRandomEvent() {
		String randomEvent = getRandomEvent();
		if (randomEvent == "MonsterLeaves") {
			MonsterLeaves leaves = new MonsterLeaves();
		} else if (randomEvent == "NewMonsterJoins") {
			NewMonsterJoins joins = new NewMonsterJoins();
		} else {
			MonsterLevelsUp levelsUp = new MonsterLevelsUp();
		}		
		
	}

	public ArrayList<Monster> getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(ArrayList<Monster> playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	
	
}
