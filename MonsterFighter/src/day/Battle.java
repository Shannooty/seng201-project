package day;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import generators.MonsterGenerator;
import purchasable.monsters.*;

public class Battle {
	
	private double gold;
	private int points;
	private ArrayList<Monster> monstersTofight = new ArrayList<Monster>();
	private ArrayList<Monster> team = new ArrayList<Monster>();
	private int numMonstersToFight;
	private String[][] possibleBattles = new String[][] { {"100", "1000", "2"}, {"150", "1000", "3"}, {"90", "1200", "2"}, {"120", "1200", "3"}, {"160", "1500", "4"} };
	private String imgPath;
	private ImageIcon img;
	private static int id = 0;
    private int instanceId = ++id;

	
	
	public Battle(String difficulty, ArrayList<Monster> team) {
		this.team = team;
		String[] battle =  possibleBattles[new Random().nextInt(possibleBattles.length)];		
		gold = Double.parseDouble(battle[0]);
		points = Integer.parseInt(battle[1]);
		numMonstersToFight = Integer.parseInt(battle[2]);
		
		if (difficulty == "Hard") {
			gold += 10;
			points += 30;
			numMonstersToFight += 2;
		} else if (difficulty == "Medium") {
			gold += 20;
			points += 20;
			numMonstersToFight += 1;
		}
		
		for (int i = 0; i < numMonstersToFight; i++) {
			Monster newMonster = MonsterGenerator.newMonster();
			newMonster.setPurchasePrice(70);
			monstersTofight.add(newMonster);
		}
		
		setImgPath("/images/skeleton.png");
		setImg();
		
//		System.out.println(getImg());
		
//		System.out.println("Gold: "+gold+"\nPoints: "+points+"\nNumMonsters: "+numMonstersToFight+"\nMonsters: "+monstersTofight);
	}
	
	public ArrayList<Monster> getGameMonsters() {
		return monstersTofight;
	}
	
	
	public ImageIcon getImg() {
		return img;
	}
	
	public void setImg() {
		this.img = new ImageIcon(Monster.class.getResource(imgPath));
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
    public int getID() {
        return instanceId;
    }
	
	
	public Monster attack(Monster playerMonster, Monster gameMonster) {
//		Monster startingMonster;
//		if (playerMonster.getSpeed() >= gameMonster.getSpeed()) {
//			startingMonster = playerMonster;
//		} else {
//			startingMonster = gameMonster;
//		}
//		
		while (playerMonster.getHealth() != 0 && gameMonster.getHealth() != 0) {
			gameMonster.removeHealth(playerMonster.getAttackAmount());
			playerMonster.removeHealth(gameMonster.getAttackAmount());
		}
		
		Monster winner;
		
		if (playerMonster.getHealth() == 0) {
			winner = gameMonster;
			team.remove(playerMonster);
		} else {
			winner = playerMonster;
			monstersTofight.remove(gameMonster);
		}
		
		return winner;
		
	}
	
	public void removeMonster() {
		
	}
	

	
	public void startBattle() {
		
	}
	
	public String toString() {
//		return "Gold: "+gold+"\nPoints: "+points+"\nNumMonsters: "+numMonstersToFight+"\nMonsters: ";
		return "Gold: "+gold+"\nPoints: "+points+"\nNumMonsters: "+numMonstersToFight+"\nMonsters: "+monstersTofight;
	}
	
}
