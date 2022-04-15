package leaderboard;

import java.io.*;
import java.io.IOException;
import java.util.TreeSet;

import player.PlayerScore;

public class Leaderboard {
	
	private TreeSet<PlayerScore> leaderboard = new TreeSet<PlayerScore>();
	private String leaderboardFilePath = "leaderboard.txt";
	
	public Leaderboard() {
		load();
	}

	private void load() {
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(leaderboardFilePath));
			String line;
			String playerName;
			String playerPoints;
			
			while((line = br.readLine()) != null) {
				playerName = line.split(":")[0];
				playerPoints = line.split(":")[1];
				PlayerScore playerScore = new PlayerScore(playerName, playerPoints);
				getLeaderboard().add(playerScore);
			}
		} catch (IOException e) {
			return;
		}
	}
	
	public TreeSet<PlayerScore> getLeaderboard() {
		return leaderboard;
	}
}
