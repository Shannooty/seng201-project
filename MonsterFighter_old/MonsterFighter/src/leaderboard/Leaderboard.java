package leaderboard;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import player.PlayerScore;

/**
 * The leaderboard of previous players and their scores.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Leaderboard {
	
	/**
	 * Attribute leaderboard, of type ArrayList[PlayerScore]. An ArrayList of previous player's scores.
	 */
	private ArrayList<PlayerScore> leaderboard = new ArrayList<PlayerScore>();
	
	/**
	 * Attribute leaderboardFilePath, of type String. The file path to the leaderboard text file.
	 */
	private String leaderboardFilePath = "src/leaderboard/leaderboard.txt";
	
	/**
	 * Attribute lineFormat, of type String. The format for each line in the leaderboard.
	 */
	private String lineFormat = "%s:%s\n";
	
	/**
	 * Constructor for the Leaderboard class. Calls the load() method.
	 */
	public Leaderboard() {
		load();
	}

	/**
	 * Returns the current leaderboard.
	 * @return leaderboard, of type ArrayList[PlayerScore]
	 */
	public ArrayList<PlayerScore> getLeaderboard() {
		return leaderboard;
	}
	
	/**
	 * Adds the player's score to the leaderboard. Return type void.
	 * @param score, of type PlayerScore.
	 */
	public void addScore(PlayerScore score) {
		getLeaderboard().add(score);
		getLeaderboard().sort(null);
		save();
	}
	
	/**
	 * Returns the player's position on the leaderboard.
	 * @param score, of type PlayerScore. Used to calculate the player's position on the leaderboard.
	 * @return playerPosition, of type integer.
	 */
	public int getPosition(PlayerScore score) {
		int playerPosition = getLeaderboard().indexOf(score);
		return playerPosition + 1;
	}
	
	/**
	 * Clears the private ArrayList[PlayerScore] leaderboard. Return type void. Takes no parameters.
	 */
	public void clear() {
		getLeaderboard().clear();
		save();
	}
	
	/**
	 * Loads the leaderboard.txt file to display the leaderboard to the player. Return type void. Takes no parameters.
	 */
	private void load() {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(leaderboardFilePath));
			String line = br.readLine();
			String playerName;
			String playerPoints;
			
			while((line = br.readLine()) != null) {
				playerName = line.split(":")[0];
				playerPoints = line.split(":")[1];
				PlayerScore playerScore = new PlayerScore(playerName, playerPoints);
				getLeaderboard().add(playerScore);
			}
			
			br.close();
		} catch (IOException e) {
			return;
		}
	}
	
	/**
	 * Saves any changes made to the leaderboard to the leaderboard.txt file. Return type void. Takes no parameters.
	 */
	private void save() {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(leaderboardFilePath));
			bw.write("Leaderboard:\n");
			
			for (PlayerScore score : getLeaderboard()) {
				String fileLine = String.format(lineFormat, score.getName(), score.getPoints());
				bw.write(fileLine);
			}
			
			bw.close();
		} catch (IOException e) {
			return;
		}
	}
	
}
