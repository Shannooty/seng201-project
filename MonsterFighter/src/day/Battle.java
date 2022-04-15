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
	private ArrayList<Monster> team;
	private int numMonstersToFight;
	private String[][] possibleBattles = new String[][] { {"100", "1000", "3"}, {"150", "1000", "4"}, {"90", "1200", "3"}, {"120", "1200", "4"}, {"160", "1500", "5"} };
	private String imgPath;
	private ImageIcon img;
	private static int id = 0;
    private int instanceId = ++id;

	
	
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
