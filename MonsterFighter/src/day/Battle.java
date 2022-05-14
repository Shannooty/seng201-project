package day;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import generators.MonsterGenerator;
import gui.GameEnvironment;
import interfaces.HasImage;
import purchasable.monsters.*;

/**
 * Creates a battle for the player to fight. 
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Battle implements HasImage {
	
	/**
	 * Attribute gold, of type double. The amount of gold that a player receives for winning the battle.
	 */
	private double gold;
	
	/**
	 * Attribute points, of type integer. The amount of points that a player receives for winning the battle.
	 */
	private int points;
	
	/**
	 * Attribute difficulty, of type String. The game difficulty, set by the player when setting up the game.
	 */
	private String difficulty;
	
	/**
	 * Attribute dayNum, of type integer. The current day of the game.
	 */
	private int dayNum;
	
	/**
	 * Attribute gameLength, of type integer. The length of the game, set by the player when setting up the game.
	 */
	private int gameLength;
	
	/**
	 * Attribute monstersTofight, of type ArrayList<Monster>. An ArrayList of the monsters associated with the created battle that the player will have to fight.
	 */
	private ArrayList<Monster> monstersTofight = new ArrayList<Monster>();
	
	/**
	 * Attribute randomPlayer, of type Random. A random generator.
	 */
	private Random randomPlayer = new Random();
	
	/**
	 * Attribute randomPlayers, of type String[]. A list of the possible random usernames for the player's opposition.
	 */
	private String[] randomPlayers = {"One", "Two", "Three", "Four", "Nine"};
	
	/**
	 * Attribute gamePlayer, of type String. A username for the player's opposition.
	 */
	private String gamePlayer = randomPlayers[(randomPlayer.nextInt(randomPlayers.length))];
	
	/**
	 * Attribute numMonstersToFight, of type integer. The number of monsters associated with the created battle that the player will have to fight.
	 */
	private int numMonstersToFight;
	
	/**
	 * Attribute possibleBattles, of type String[][]. A list of lists, where each sublist describes a basic battle that can be edited later. sublist[0] is the gold the battle is worth, sublist[1] the points, and sublist[2] the number of monsters to fight.
	 */
	private String[][] possibleBattles = new String[][] { {"100", "1000", "1"}, {"150", "1000", "2"}, {"90", "1200", "1"}, {"120", "1200", "2"}, {"160", "1500", "3"} };
	
	/**
	 * Attribute imgPath, of type String. A string representation of the image used to display the battle.
	 */
	private String imgPath;
	
	/**
	 * Attribute img, of type ImageIcon. The image, built from imgPath, that is used to display the battle to the user.
	 */
	private ImageIcon img;
	
	/**
	 * Attribute id, of type static Integer. The current id number, shared across all instances of the class Battle. Used to create a unique instanceId for each instance of Battle.
	 */
	private static int id = 0;
	
	/**
	 * Attribute instanceId, of type Integer. A unique id for each instance of Battle. Created by adding one to the current value of the attribute id.
	 */
    private int instanceId = ++id;
	
	/**
	 * Constructor for the class Battle. Sets the private variable gameEnvironment, and uses gameEnvironment to set the private variables difficulty, dayNum and gameLength. 
	 * Creates the variable battle, and sets it to a random battle generated from the private variable possibleBattles. The private variables gold, points and numMonstersToFight are set from battle.
	 * Creates the attribute gameProgress, of type double. Value of dayNum divided by gameLength.
	 * Depending on the player's progress through the game, numMonstersToFight increases by 1, 2, 3, or 4. The amount of gold and points a user receives from winning a battle is adjusted according to the difficulty of the game. 
	 * Monsters are generated and added to the ArrayList monstersToFight.
	 * The image associated with the battle is set.
	 * @param gameEnvironment, of type GameEnvironment. A class that has associated variables that are required for Battle.
	 */
	public Battle(GameEnvironment gameEnvironment) {
		difficulty = gameEnvironment.getGameDifficulty();
		dayNum = gameEnvironment.getDayNumber();
		gameLength = gameEnvironment.getGameLength();
		
		String[] battle =  possibleBattles[new Random().nextInt(possibleBattles.length)];		
		gold = Double.parseDouble(battle[0]);
		points = Integer.parseInt(battle[1]);
		numMonstersToFight = Integer.parseInt(battle[2]);
		
		setGameProgress();
		setRewardValues();
		setMonsterTeam();
		
		setImgPath("/images/battle.png");
		setImg();
	}
	
	/**
	 * Sets the reward values based on game difficulty
	 */
	private void setRewardValues() {
		if (difficulty == "Hard") {
			gold -= 20;
			points += 100;

		} else if (difficulty == "Medium") {
			gold -= 10;
			points += 50;
		}
	}
	
	/**
	 * Creates the Monster team to fight
	 */
	private void setMonsterTeam() {
		for (int i = 0; i < numMonstersToFight; i++) {
			Monster newMonster = MonsterGenerator.newMonster();
			newMonster.setPurchasePrice(0);
			monstersTofight.add(newMonster);
		}
	}
	
	/**
	 * Sets the games progress to determine how many monsters there should be to fight
	 */
	private void setGameProgress() {
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
	}
	
	/**
	 * Returns the monsters the player would have to fight.
	 * @return monstersTofight, of type ArrayList[Monster]
	 */
	public ArrayList<Monster> getGameMonsters() {
		return monstersTofight;
	}
	
	/**
	 * Returns the image used to display the battle to the user.
	 * @return img, of type ImageIcon
	 */
	public ImageIcon getImg() {
		return img;
	}
	
	/**
	 * Sets the image used to display the battle to the user. Return type void
	 */
	public void setImg() {
		this.img = new ImageIcon(Monster.class.getResource(imgPath));
	}
	
	/**
	 * Sets the image path used to display the battle to the user. Return type void.
	 * @param imgPath, of type String. A string representation of the image's path.
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	/**
	 * Returns the unique instanceId of the battle.
	 * @return instanceId, of type int.
	 */
    public int getID() {
        return instanceId;
    }
	
	/**
	 * The attack method. Calculates which monster is the startingMonster, and which is the secondMonster. Based on the moster's respective speeds, they attack the other at different speeds until one of them has a Health of zero. The winner from the fight is returned.
	 * @param playerMonster, of type Monster. A monster from the player's team that is currently attacking.
	 * @param gameMonster, of type Monster. A monster from the attribute monstersToFight that is currently attacking.
	 * @return winner, of type Monster
	 */
	public String attack(Monster playerMonster, Monster gameMonster) {
		Monster startingMonster;
		Monster secondMonster;
		if (playerMonster.getSpeed() >= gameMonster.getSpeed()) {
			startingMonster = playerMonster;
			secondMonster = gameMonster;
		} else {
			startingMonster = gameMonster;
			secondMonster = playerMonster;
		}
		
		battleLoop(startingMonster, secondMonster);
		
		String winner;
		
		if (gameMonster.getHealth() <= 0) {
			monstersTofight.remove(gameMonster);
		}
		
		if (gameMonster.getHealth() > playerMonster.getHealth()) {
			winner = "Player " + gamePlayer + gameMonster.toString();
		} else {
			winner = "You: " + playerMonster.toString();
		}
		
		return winner;
		
	}
	
	/**
	 * Main loop to deal with monsters fighting
	 * @param startingMonster Monster that attacks first
	 * @param secondMonster Monster that attacks second
	 */
	private void battleLoop(Monster startingMonster, Monster secondMonster) {
		long starterFrequency = Math.round(Double.valueOf(startingMonster.getSpeed())/Double.valueOf(secondMonster.getSpeed()));
		long secondFrequency = Math.round(Double.valueOf(secondMonster.getSpeed())/Double.valueOf(startingMonster.getSpeed()));
		
		if (starterFrequency == 0) {
			starterFrequency = 1;
		}
		if (secondFrequency == 0) {
			secondFrequency = 1;
		}
		
		boolean fightDone = false;
		
		while (!fightDone) {
			
			for (long i = 0; i < starterFrequency; i++) {
				if (startingMonster.getHealth() > 0 && secondMonster.getHealth() > 0) {
					secondMonster.removeHealth(startingMonster.getAttackAmount());
				}else {
					fightDone = true;
				}
			}
				
			for (long i = 0; i < secondFrequency; i++) {
				if (startingMonster.getHealth() > 0 && secondMonster.getHealth() > 0) {
					startingMonster.removeHealth(secondMonster.getAttackAmount());
				}else {
					fightDone = true;
				}
			}
		}
	}
	
	
	/**
	 * Returns the amount of gold the player receives for winning the battle.
	 * @return gold, of type double.
	 */
	public double getGold() {
		return gold;
	}
	
	/**
	 * Returns the number of points the player receives for winning the battle.
	 * @return points, of type integer.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Returns the number of monsters the player has to fight.
	 * @return numMonstersToFight, of type integer.
	 */
	public int getNumMonsters() {
		return numMonstersToFight;
	}
	
	
	/**
	 * Returns the name of the player's opposition.
	 * @return gamePlayer, of type String.
	 */
	public String getGamePlayer() {
		return gamePlayer;
	}
	
	
	/**
	 * Returns a string representation of the current instance of the class Battle.
	 * @return a string representation of the object.
	 */
	public String toString() {
		
		String monsters = "";
		monsters += monstersTofight.get(0).toString();
		
		
		for (Monster monster : monstersTofight.subList(1, monstersTofight.size())) {
			monsters += monster.toString();
			
		}
		return "Player: "+gamePlayer+"\nGold: "+gold+"\nPoints: "+points+"\nNumber of Monsters: "+numMonstersToFight+"\n\nMonsters: "+monsters+"\n";
	}
	
}
