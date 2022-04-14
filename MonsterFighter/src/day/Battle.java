package day;

import java.util.ArrayList;
import java.util.Random;

import generators.MonsterGenerator;
import purchasable.monsters.*;

public class Battle {
	
	private double gold;
	private int points;
	private ArrayList<Monster> monstersTofight = new ArrayList<Monster>();
	private ArrayList<Monster> team;
	private int numMonstersToFight;
	private String[][] possibleBattles = new String[][] { {"100", "1000", "3"}, {"150", "1000", "4"}, {"90", "1200", "3"}, {"120", "1200", "4"}, {"160", "1500", "5"} };

	
	
	public Battle(String difficulty) {
		
		String[] battle =  possibleBattles[new Random().nextInt(possibleBattles.length)];		
		gold = Double.parseDouble(battle[0]);
		points = Integer.parseInt(battle[1]);
		numMonstersToFight = Integer.parseInt(battle[2]);
		
		if (difficulty == "Hard") {
			gold += 10;
			points += 30;
			numMonstersToFight += 3;
		} else if (difficulty == "Medium") {
			gold += 20;
			points += 20;
			numMonstersToFight += 2;
		}
		
		for (int i = 0; i < numMonstersToFight; i++) {
			Monster newMonster = MonsterGenerator.newMonster();
			newMonster.setPurchasePrice(70);
			monstersTofight.add(newMonster);
		}
		
//		System.out.println("Gold: "+gold+"\nPoints: "+points+"\nNumMonsters: "+numMonstersToFight+"\nMonsters: "+monstersTofight);
	}
	
	public void attack(Monster playerMonster, Monster gameMonster) {
		
	}
	
	public void removeMonster() {
		
	}
	
	public void updateStatus() {
		
	}
	
	public void startBattle() {
		
	}
	
	public String toString() {
		return "Gold: "+gold+"\nPoints: "+points+"\nNumMonsters: "+numMonstersToFight+"\nMonsters: ";
//		return "Gold: "+gold+"\nPoints: "+points+"\nNumMonsters: "+numMonstersToFight+"\nMonsters: "+monstersTofight;
	}
	
}
