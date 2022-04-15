package leaderboard;

import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

import player.PlayerScore;

public class Leaderboard {
	
	private TreeSet<PlayerScore> leaderboard = new TreeSet<PlayerScore>();
	private String leaderboardFilePath = "leaderboard.txt";
	private String lineFormat = "%s:%s\n";
	
	public Leaderboard() {
		load();
	}

	
	public TreeSet<PlayerScore> getLeaderboard() {
		return leaderboard;
	}
	
	public void addScore(PlayerScore score) {
		getLeaderboard().add(score);
		save();
	}
	
	public int getPosition(PlayerScore score) {
		Iterator<PlayerScore> leaderboardIterator = getLeaderboard().iterator();
		int playerPosition = -1;
		int counter = 0;
		
		while (playerPosition == -1 && leaderboardIterator.hasNext()) {
			counter++;
			if (leaderboardIterator.next() == score) {
				playerPosition = counter;
			}
		}
		
		return playerPosition;
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
			
			br.close();
		} catch (IOException e) {
			return;
		}
	}
	
	private void save() {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(leaderboardFilePath));
			
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
	
	public static void main(String[] args) {
		
	}
}
