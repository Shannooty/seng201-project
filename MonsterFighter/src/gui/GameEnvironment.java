package gui;

import java.util.ArrayList;
import monsters.*;
import player.Player;

class  GameEnvironment {

	private static int gameLength;
	private static String difficulty;
	private Player player;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();

	
	public GameEnvironment() {
		setStartingMonsters();
	}
	
	public int getgameLength() {
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
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetupScreen();
	}
	
	
}