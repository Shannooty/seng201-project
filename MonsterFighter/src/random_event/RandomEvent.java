package random_event;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Random;

import monsters.Monster;

public class RandomEvent {
	
	
//	private ArrayList<String> randomEvents;
	private String[] randomEvents = {"MonsterLeaves", "NewMonsterJoins", "MonsterLevelsUp"};
	private Random randomItem;
	private ArrayList<Monster> playerTeam;
	
	
	public String getRandomEvent() {
		return randomEvents[(randomItem.nextInt(randomEvents.length))];
	}

	public void runRandomEvent() {
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
