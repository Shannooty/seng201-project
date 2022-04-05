package random_event;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	
	
//	private ArrayList<String> randomEvents;
	private String[] randomEvents = {"MonsterLeaves", "NewMonsterJoins", "MonsterLevelsUp"};
	private Random randomItem;
	
	
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
	
	
	
}
