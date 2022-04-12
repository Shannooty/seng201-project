package gui;

import java.util.ArrayList;

import day.Day;
import player.Player;
import purchasable.monsters.*;

class  GameEnvironment {

	private static int gameLength;
	private static String difficulty;
	private Player player;
	private static int dayNumber = 0;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();
	private static Day today;

	
	public GameEnvironment() {
		setStartingMonsters();
	}
	
	public static int getgameLength() {
		return gameLength;
	}
	
	public static void setGameLength(int game) {
		gameLength = game;
	}
	
	public String getGameDifficulty() {
		return difficulty;
	}
	
	public static void setGameDifficulty(String gameDifficulty) {
		difficulty = gameDifficulty;
	}
	
	public static int getDayNumber() {
		return dayNumber;
	}
	
	public static void increaseDayNumber() {
		dayNumber += 1;
	}
	
	public Day getToday() {
		return today;
	}
	
	public static void setToday(Day day) {
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
	}
	
	
	public void launchShopBuyScreen(){
		ShopBuy shopBuyScreen = new ShopBuy(this);
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
	
	
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
	}
	
	
}