package player;

public class PlayerScore implements Comparable<PlayerScore>{
	
	private String playerName;
	private int points = 0;
	
	public PlayerScore(Player player) {
		setName(player.getName());
	}
	
	/**
	 * Constructor for the leaderboard class
	 * @param playerName
	 * @param playerScore
	 */
	public PlayerScore(String playerName, String playerScore) {
		setName(playerName);
		addPoints(Integer.parseInt(playerScore));
	}

	public void addPoints(int numPoints) {
		points = points + numPoints;
		
	}
	
	public int getPoints() {
		return points;
	}
	
	public String getName() {
		return playerName;
	}
	
	public int compareTo(PlayerScore other) {
		Integer thisScore = this.getPoints();
		Integer otherScore = other.getPoints();
		int compareValue = otherScore.compareTo(thisScore);
		
		if (compareValue == 0) {
			compareValue = -1;
		}
		
		return compareValue;
	}
	
	private void setName(String name) {
		playerName = name;
	}
	
	public String toString() {
		String message = getName() + " : " + getPoints();
		return message;
	}
	
	
}
