package leaderboard;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import player.PlayerScore;

public class Leaderboard {
	
	private ArrayList<PlayerScore> leaderboard = new ArrayList<PlayerScore>();
	private String leaderboardFilePath = "leaderboard.txt";
	private String lineFormat = "%s:%s\n";
	
	public Leaderboard() {
		load();
	}

	
	public ArrayList<PlayerScore> getLeaderboard() {
		return leaderboard;
	}
	
	public void addScore(PlayerScore score) {
		getLeaderboard().add(score);
		getLeaderboard().sort(null);
		save();
	}
	
	public int getPosition(PlayerScore score) {
		int playerPosition = getLeaderboard().indexOf(score);
		return playerPosition + 1;
	}
	
	public void clear() {
		getLeaderboard().clear();
		save();
	}
	
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
	
	private void save() {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(leaderboardFilePath));
			bw.write("Leaderboard:\n");
			
			for (PlayerScore score : getLeaderboard()) {
				String fileLine = String.format(lineFormat, score.getName(), score.getPoints());
				System.out.println(fileLine);
				bw.write(fileLine);
			}
			
			bw.close();
		} catch (IOException e) {
			return;
		}
	}
	
}
