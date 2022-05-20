package gui;

import java.util.ArrayList;
import java.util.stream.Collectors;

import day.Battle;
import day.Day;
import leaderboard.Leaderboard;
import player.Player;
import purchasable.monsters.*;

/**
 * The environment that the game is built in and run off.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class GameEnvironment {

	/**
	 * Attribute gameLength of type Integer. The length of the game, as set by the player.
	 */
	private int gameLength;
	
	/**
	 * Attribute difficulty of type String. The game difficulty, as set by the player.
	 */
	private String difficulty;
	
	/**
	 * Attribute player of type Player. The instance of the current player.
	 */
	private Player player;
	
	/**
	 * Attribute dayNumber of type Integer. The current day number, initialized to 1.
	 */
	private int dayNumber = 1;
	
	/**
	 * Attribute startingMonsters of type ArrayList[Monster]. An ArrayList of monsters the player can choose from.
	 */
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();
	
	/**
	 * Attribute today of type Day. Current instance of the class Day, the current day.
	 */
	private Day today;
	
	/**
	 * Attribute leaderboard of type static Leaderboard. The leaderboard for all games.
	 */
	private static Leaderboard leaderboard = new Leaderboard();
	
	/**
	 * Attribute shopBuyScreen of type ShopBuy. Instance of the class ShopBuy.
	 */
	private ShopBuy shopBuyScreen;
	
	/**


	/**
	 * Attribute stunned of type ArrayList[Monster]. A list of the monsters which were stunned in the current day. Used to raise the probability of them leaving if the random even MonsterLeaves is called.
	 */
	private ArrayList<Monster> stunned;

	/**
	 * Constructor for the class GameEnvironment. Calls the method setStartingMonsters().
	 */
	public GameEnvironment() {
		setStartingMonsters();
	}
	
	/**
	 * Returns the leaderboard.
	 * @return leaderboard, of type Leaderboard.
	 */
	public static Leaderboard getLeaderboard() {
		return leaderboard;
	}

	/**
	 * Returns the length of the game.
	 * @return gameLength, of type Integer.
	 */
	public int getGameLength() {
		return gameLength;
	}
	
	/**
	 * Sets the length of the game. Return type void.
	 * @param game, of type Integer. The game length.
	 */
	public void setGameLength(int game) {
		gameLength = game;
	}
	
	/**
	 * Returns the difficulty of the game.
	 * @return difficulty, of type String.
	 */
	public String getGameDifficulty() {
		return difficulty;
	}
	
	/**
	 * Sets the game difficulty. Return type void.
	 * @param gameDifficulty, of type String.
	 */
	public void setGameDifficulty(String gameDifficulty) {
		difficulty = gameDifficulty;
	}
	
	/**
	 * Returns the current day number.
	 * @return dayNumber, of type integer.
	 */
	public int getDayNumber() {
		return dayNumber;
	}
	
	/**
	 * Increases the day number by one. Return type void. Takes no parametres.
	 */
	public void increaseDayNumber() {
		dayNumber += 1;
	}
	
	/**
	 * Returns the current instance of the class Day.
	 * @return today, of type Day.
	 */
	public Day getToday() {
		return today;
	}
	
	/**
	 * Sets the private attribute today to the current instance of Day. Return type void.
	 * @param day, of type Day.
	 */
	public void setToday(Day day) {
		today = day;
	}
	
	/**
	 * Returns the current player.
	 * @return player, of type Player.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Sets the private attribute player to the current Player.
	 * @param player, of type Player.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * Returns an ArrayList of Monsters that contains the starting Monsters a player can choose from.
	 * @return startingMonsters, of type ArrayList[Monster].
	 */
	public ArrayList<Monster> getStartingMonsters(){
		return startingMonsters;
	}

	
	/**
	 * Returns an ArrayList of the Monsters which were stunned in the current day.
	 * @return stunned, of type ArrayList[Monster].
	 */
	public ArrayList<Monster> getStunned() {
		return stunned;
	}
	
	
	/**
	 * Sets the contents of the private attribute startingMonsters. Return type void. Take no parametres.
	 */
	private void setStartingMonsters() {
		startingMonsters.add(new Slime());
		startingMonsters.add(new Zombie());
		startingMonsters.add(new UndeadGuard());
		startingMonsters.add(new Skeleton());
		startingMonsters.add(new Dinosaur());
		startingMonsters.add(new Snake());		
	}
	
	/**
	 * Checks the current day number against the game length. If the game is over, adds player score to the leaderboard and launches the EndScreen. If game not yet over, creates a new instance of Day, and launches the SleepScreen.
	 */
	public void sleep() {
		if (getToday().getDayNumber() == getGameLength()) {
			getLeaderboard().addScore(getPlayer().getScore());
			launchEndScreen();
		} else {
			Double goldEarnedToday = today.getGoldEarnedToday();
			int pointsEarnedToday = today.getPointsEarnedToday();
			Day nextDay = new Day(this);
			ArrayList<Monster> team = getPlayer().getInventory().getTeam().getTeam();
			stunned = (ArrayList<Monster>) team.stream().filter(m -> m.getStunnedStatus() == true).collect(Collectors.toList());

			for (Monster monster : team) {
				monster.sleep();
			}

			setToday(nextDay);			
			launchSleepScreen(goldEarnedToday, pointsEarnedToday);
		}
		
	}
	
	/**
	 * Creates a new instance of the class SetupScreen, passing the GameEnvironment object as a parameter.
	 */
	public void launchSetupScreen(){
		new SetupScreen(this);
	}
	
	/**
	 * Closes the current instance of SetupScreen.
	 * @param setupWindow, of type SetupScreen. The window to be closed.
	 */
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
	}
	
	/**
	 * Creates a new instance of the class MainScreen, passing the GameEnvironment object as a parameter.
	 */
	public void launchMainScreen(){
		new MainScreen(this);
	}
	
	/**
	 * Closes the current instance of MainScreen.
	 * @param mainWindow, of type MainScreen. The window to be closed.
	 */
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	/**
	 * Creates a new instance of the class SleepScreen, passing the GameEnvironment object as a parameter.
	 * @param goldEarnedToday, of type double. The amount of gold the player earned in the current day.
	 * @param pointsEarnedToday, of type integer. The amount of gold the player earned in the current day.
	 */
	public void launchSleepScreen(Double goldEarnedToday, int pointsEarnedToday){
		new Sleep(this, goldEarnedToday, pointsEarnedToday);
	}
	
	/**
	 * Closes the current instance of SleepScreen.
	 * @param sleepWindow, of type SleepScreen. The window to be closed.
	 */
	public void closeSleep(Sleep sleepWindow) {
		sleepWindow.closeWindow();
	}
	
	/**
	 * Creates a new instance of the class InventoryScreen, passing the GameEnvironment object as a parameter.
	 */
	public void launchInventoryScreen(){
		new InventoryScreen(this);
	}
	
	/**
	 * Closes the current instance of InventoryScreen.
	 * @param inventoryWindow, of type InventoryScreen. The window to be closed.
	 */
	public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
	}
	
	/**
	 * Sets the private attribute shopBuyScreen to a new instance of the class ShopBuy, passing the GameEnvironment object and the current instance of Shop as parameters.
	 */
	public void launchShopBuyScreen(){
		shopBuyScreen = new ShopBuy(this, today.getTodaysShop());
	}
	
	/**
	 * Closes the current instance of ShopBuy.
	 * @param shopBuyWindow, of type ShopBuy. The window to be closed.
	 */
	public void closeShopBuyScreen(ShopBuy shopBuyWindow) {
		shopBuyWindow.closeWindow();
	}
	
	/**
	 * Returns shopBuyScreen, an instance of ShopBuy. Used to access methods in ShopBuy.
	 * @return shopBuyScreen, of type ShopBuy.
	 */
	public ShopBuy getShopBuyScreen() {
		return shopBuyScreen;
	}
	
	/**
	 * Creates a new instance of the class ShopSell, passing the GameEnvironment object as a parameter.
	 */
	public void launchShopSellScreen(){
		new ShopSell(this);
	}
	
	/**
	 * Closes the current instance of ShopSell.
	 * @param shopSellWindow, of type ShopSell. The window to be closed.
	 */
	public void closeShopSellScreen(ShopSell shopSellWindow) {
		shopSellWindow.closeWindow();
	}
	
	/**
	 * Creates a new instance of the class ChooseBattleScreen, passing the GameEnvironment object as a parameter.
	 */
	public void launchChooseBattleScreen(){
		new ChooseBattleScreen(this);
	}
	
	/**
	 * Closes the current instance of ChooseBattleScreen.
	 * @param chooseBattleWindow, of type ChooseBattleScreen. The window to be closed.
	 */
	public void closeChooseBattleScreen(ChooseBattleScreen chooseBattleWindow) {
		chooseBattleWindow.closeWindow();
	}
	
	/**
	 * Creates a new instance of the class BattleScreen, passing the GameEnvironment object and the attribute selectedBattle as parameters.
	 * @param selectedBattle, of type Battle. The Battle that the player selected.
	 */
	public void launchBattleScreen(Battle selectedBattle){
		new BattleScreen(this, selectedBattle);
	}
	
	/**
	 * Closes the current instance of BattleScreen.
	 * @param battleWindow, of type BattleScreen. The window to be closed.
	 */
	public void closeBattleScreen(BattleScreen battleWindow) {
		battleWindow.closeWindow();
	}
	
	/**
	 * Creates a new instance of the class EndScreen, passing the GameEnvironment object as a parameter.
	 */
	public void launchEndScreen() {
		new EndScreen(this);
	}
	
	/**
	 * Closes the current instance of EndScreen.
	 * @param endScreenWindow, of type EndScreen. The window to be closed.
	 */
	public void closeEndScreen(EndScreen endScreenWindow) {
		endScreenWindow.closeWindow();
	}
	
	/**
	 * Main method for GameEnvironment. Creates an instance of GameEnvironment, and calls the launchSetupScreen() method.
	 * @param args optional arguments
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
	}
	
	
}