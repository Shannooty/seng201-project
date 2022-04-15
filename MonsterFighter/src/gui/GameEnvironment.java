package gui;

import java.util.ArrayList;

import day.Battle;
import day.Day;
import leaderboard.Leaderboard;
import player.Player;
import purchasable.monsters.*;

class  GameEnvironment {

	private int gameLength;
	private String difficulty;
	private Player player;
	private int dayNumber = 0;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();
	private Day today;
	private static Leaderboard leaderboard = new Leaderboard();

	
	public GameEnvironment() {
		setStartingMonsters();
	}
	
	public static Object getLeaderboard() {
		return leaderboard;
	}

	public int getGameLength() {
		return gameLength;
	}
	
	public void setGameLength(int game) {
		gameLength = game;
	}
	
	public String getGameDifficulty() {
		return difficulty;
	}
	
	public void setGameDifficulty(String gameDifficulty) {
		difficulty = gameDifficulty;
	}
	
	public int getDayNumber() {
		return dayNumber;
	}
	
	public void increaseDayNumber() {
		dayNumber += 1;
	}
	
	public Day getToday() {
		return today;
	}
	
	public void setToday(Day day) {
		today = day;
	}
	
	
	public Player getPlayer() {
		return player;
	}
	
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public ArrayList<Monster> getStartingMonsters(){
		return startingMonsters;
	}
	
	private void setStartingMonsters() {
		startingMonsters.add(new Slime());
		startingMonsters.add(new Zombie());
		startingMonsters.add(new UndeadGuard());
		startingMonsters.add(new Skeleton());
	}
	
	public void sleep() {
		if (getToday().getDayNumber() == getGameLength()) {
			//TODO open end screen
		} else {
			Day nextDay = new Day(getToday().getDayNumber() + 1, getGameDifficulty());
			setToday(nextDay);
			launchSleepScreen();
		}
		
	}
	
	public void launchSetupScreen(){
		SetupScreen setupScreen = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
	}
	
	public void launchMainScreen(){
		MainScreen mainScreen = new MainScreen(this);
	}
	
	public void closeMainScreen(MainScreen mainWindow) {
		mainWindow.closeWindow();
	}
	
	
	public void launchSleepScreen(){
		Sleep sleepScreen = new Sleep(this);
	}
	
	public void closeSleep(Sleep sleepWindow) {
		sleepWindow.closeWindow();
		launchMainScreen();
	}
	
	
	public void launchInventoryScreen(){
		InventoryScreen inventoryScreen = new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
	}
	
	
	public void launchShopBuyScreen(){
		ShopBuy shopBuyScreen = new ShopBuy(this, today.getTodaysShop());
	}
	
	public void closeShopBuyScreen(ShopBuy shopBuyWindow) {
		shopBuyWindow.closeWindow();
	}
	
	
	public void launchShopSellScreen(){
		ShopSell shopSellScreen = new ShopSell(this);
	}
	
	public void closeShopSellScreen(ShopSell shopSellWindow) {
		shopSellWindow.closeWindow();
	}
	
	
	public void launchChooseBattleScreen(){
		ChooseBattleScreen chooseBattleScreen = new ChooseBattleScreen(this);
	}
	
	public void closeChooseBattleScreen(ChooseBattleScreen chooseBattleWindow) {
		chooseBattleWindow.closeWindow();
	}
	
	
	public void launchBattleScreen(Battle selectedBattle){
		BattleScreen battleScreen = new BattleScreen(this, selectedBattle);
	}
	
	public void closeBattleScreen(BattleScreen battleWindow) {
		battleWindow.closeWindow();
	}
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
	}
	
	
}