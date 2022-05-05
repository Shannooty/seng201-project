package day;
import java.util.ArrayList;

import shop.Shop;
import gui.GameEnvironment;
import player.Player;
import player.Team;

/**
 * Creates a new Day, which generates the available Battles for the player to fight.
 * @author
 *
 */
public class Day {
	
	/**
	 * Attribute dayNumber, of type integer. The current day number.
	 */
	private int dayNumber;
	
	/**
	 * Attribute todaysShop, of type Shop. The current Shop, and the monsters and items available to buy.
	 */
	private Shop todaysShop;
	
	/**
	 * Attribute todaysBattles, of type ArrayList<Battle>. An ArrayList of the Battles available to fight in the current day.
	 */
	private ArrayList<Battle> todaysBattles = new ArrayList<Battle>();
	
	/**
	 * Attribute difficulty, of type String. The game difficulty, set by the player when setting up the game.
	 */
	private String difficulty;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute team, of type Team. The payer's team of Monsters.
	 */
	private Team team;
	
	/**
	 * Attribute pointsEarnedToday, of type integer. The amount of points the player earned in the current day.
	 */
	private int pointsEarnedToday;
	
	/**
	 * Attribute goldEarnedToday, of type double. The amount of gold the player earned in the current day.
	 */
	private double goldEarnedToday;
	
	/**
	 * Attribute player, of type Player. The current Player.
	 */
	private Player player;
	
	/**
	 * Constructor for the class Day. Sets the private variable gameEnvironment, and uses gameEnvironment to set the private variables player, team and difficulty. 
	 * Sets the private attribute dayNumber using the setter setDayNumber() and gameEnvironment.
	 * Instantiates a new Shop, and calls the method createDailyBattles().
	 * @param gameEnvironment
	 */
	public Day(GameEnvironment gameEnvironment) {
		this.gameEnvironment = gameEnvironment;
		player = gameEnvironment.getPlayer();
		team = player.getInventory().getTeam();
		difficulty = gameEnvironment.getGameDifficulty();		
		setDayNumber(gameEnvironment.getDayNumber());
		
		
		todaysShop = new Shop(3, 5); //parameters could be randomized
		createDailyBattles(5);
	}
	
	/**
	 * Sets the private variable dayNumber. Return type void.
	 * @param dayNum, of type integer. The current day number.
	 */
	private void setDayNumber(int dayNum) {
		dayNumber = dayNum;
	}
	
	/**
	 * Creates the Battles that are available for the day. Return type void.
	 * @param numOfBattles, of type integer. The number of Battles to be instantiated.
	 */
	private void createDailyBattles(int numOfBattles) {
		for (int i = 0; i < numOfBattles; i++) {
			todaysBattles.add(new Battle(gameEnvironment));
		}
	}
	
	/**
	 * Returns the Battles that are available for the current day.
	 * @return todaysBattles, of type ArrayList<Battle>.
	 */
	public ArrayList<Battle> getBattles(){
		return todaysBattles;
	}
	
	/**
	 * Sets the private variable todaysShop. Return type void.
	 * @param shop, of type Shop. The current Shop.
	 */
	public void setTodaysShop(Shop shop) {
		todaysShop = shop;
	}
	
	/**
	 * Returns the current Shop, todaysShop.
	 * @return todaysShop, of type Shop.
	 */
	public Shop getTodaysShop() {
		return todaysShop;
	}
	
	/**
	 * Returns the current day number.
	 * @return dayNumber, of type integer.
	 */
	public int getDayNumber() {
		return dayNumber;
	}
	
//	public void battle() {
////		create instance of Battle
//	}
	
	/**
	 * Removes the given Battle from todaysBattles, so the user cannot fight the same Battle twice. Return type void.
	 * @param battle, of type Battle. The Battle to be removed from todaysBattles.
	 */
	public void removeBattle(Battle battle) {
		todaysBattles.remove(battle);
	}
	
	/**
	 * Sets the amount of gold earned in the current day. Return type void.
	 * @param gold, of type double.
	 */
	public void setGoldEarnedToday(double gold) {
		goldEarnedToday += gold;
		player.addGold(goldEarnedToday);
	}
	
	/**
	 * Returns the amount of gold the player earned in the current day.
	 * @return goldEarnedToday, of type double.
	 */
	public double getGoldEarnedToday() {
		return goldEarnedToday;
	}
	
	/**
	 * Sets the amount of points earned in the current day. Return type void.
	 * @param points, of type integer.
	 */
	public void setPointsEarnedToday(int points) {
		pointsEarnedToday += points;
		player.addPoints(pointsEarnedToday);
	}
	
	/**
	 * Returns the amount of points the player earned in the current day.
	 * @return pointsEarnedToday, of type integer.
	 */
	public int getPointsEarnedToday() {
		return pointsEarnedToday;
	}
	
	

}
