import java.util.ArrayList;

import monsters.*;
import player.Player;

public class GameEnvironment {
	
	private int gameLength;
	private String difficulty;
	private Player player;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>(4);
	
	
	public GameEnvironment() {
		setStartingMonsters();
		
	}
	
	public int getGameLength() {
		return gameLength;
	}
	
	
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
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
		GameEnvironment game = new GameEnvironment();
		launchSetUpScreen();
	}
}
