import java.awt.EventQueue;

import java.util.ArrayList;

import monsters.*;
import player.Player;

class  GameEnvironment {

	private int gameLength;
	private String difficulty;
	private Player player;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();


	public int getgameLength() {
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
	
	public Player getPlayer() {
		return player;
	}
	
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	private void setStartingMonsters() {
		startingMonsters.add(new Slime());
		startingMonsters.add(new Zombie());
		startingMonsters.add(new UndeadGuard());
		startingMonsters.add(new Skeleton());
	}
	
	public void launchSetUpScreen(){
		//TODO create setupscreen class and pass the game through
	}

	
	public static void main(String[] args) {
		SetupScreen game = new SetupScreen();
		game.launchSetUpScreen();
	}
	
	
}