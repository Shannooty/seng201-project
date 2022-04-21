package day;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;

import generators.MonsterGenerator;
import gui.GameEnvironment;
import gui.ImageCarousel;
import purchasable.monsters.*;

public class Battle {
	
	private double gold;
	private int points;
	private String difficulty;
	private int dayNum;
	private int gameLength;
	private ArrayList<Monster> monstersTofight = new ArrayList<Monster>();
	private ArrayList<Monster> team = new ArrayList<Monster>();
	private int numMonstersToFight;
	private String[][] possibleBattles = new String[][] { {"100", "1000", "1"}, {"150", "1000", "2"}, {"90", "1200", "1"}, {"120", "1200", "2"}, {"160", "1500", "3"} };
	private String imgPath;
	private ImageIcon img;
	private static int id = 0;
    private int instanceId = ++id;
	private GameEnvironment gameEnvironment;


	
	
	public Battle(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		team = gameEnvironment.getPlayer().getInventory().getTeam().getTeam();
		difficulty = gameEnvironment.getGameDifficulty();
		dayNum = gameEnvironment.getDayNumber();
		gameLength = gameEnvironment.getGameLength();
		
		String[] battle =  possibleBattles[new Random().nextInt(possibleBattles.length)];		
		gold = Double.parseDouble(battle[0]);
		points = Integer.parseInt(battle[1]);
		numMonstersToFight = Integer.parseInt(battle[2]);
		
		double gameProgress = (Double.valueOf(dayNum)/Double.valueOf(gameLength));

		
		if (gameProgress > 0.2 && gameProgress < 0.4) {
			numMonstersToFight += 1;
		} else if (gameProgress > 0.4 && gameProgress < 0.6) {
			numMonstersToFight += 2;
		} else if (gameProgress > 0.6 && gameProgress < 0.8) {
			numMonstersToFight += 3;
		} else if (gameProgress > 0.8) {
			numMonstersToFight += 4;
		}
		
		
		if (difficulty == "Hard") {
			gold -= 20;
			points += 100;
//			numMonstersToFight += 2;
		} else if (difficulty == "Medium") {
			gold -= 10;
			points += 50;
//			numMonstersToFight += 1;
		}
		
		for (int i = 0; i < numMonstersToFight; i++) {
			Monster newMonster = MonsterGenerator.newMonster();
			newMonster.setPurchasePrice(0);
			monstersTofight.add(newMonster);
		}
		
		setImgPath("/images/battle.png");
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
		while (playerMonster.getHealth() > 0 && gameMonster.getHealth() > 0) {
			
			//Player attacks
			gameMonster.removeHealth(playerMonster.getAttackAmount());
			
			if (gameMonster.getHealth() > 0) {
				//Game attacks
				playerMonster.removeHealth(gameMonster.getAttackAmount());
			}
		}
		
		Monster winner;
		
		if (playerMonster.getHealth() <= 0) {
			winner = gameMonster;
			playerMonster.setStunnedStatus(true);
		} 
		if (gameMonster.getHealth() <= 0) {
			winner = playerMonster;
			monstersTofight.remove(gameMonster);
		}
		
		
		if (gameMonster.getHealth() > playerMonster.getHealth()) {
			winner = gameMonster;
		} else {
			winner = playerMonster;
		}
		
		return winner;
		
	}
	
	public double getGold() {
		return gold;
	}
	
	public int getPoints() {
		return points;
	}
	
	
	public int getNumMonsters() {
		return numMonstersToFight;
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
