package player;

import exceptions.NegativeValueException;

/**
 * The PlayerScore class deals with storing the points scored by the player in a way that can be used by a leaderboard
 * @author Bede Nathan, Celia Allen
 *
 */
public class PlayerScore implements Comparable<PlayerScore>{
	
	private String playerName;
	private int points = 0;
	
	/**
	 * Constructor to be used by the player class
	 * @param player the player whose score will be stored
	 */
	public PlayerScore(Player player) {
		setName(player.getName());
	}
	
	/**
	 * Constructor for the PlayerScore class used for previously saved scores
	 * @param playerName name of the player
	 * @param playerScore string representation of the score
	 */
	public PlayerScore(String playerName, String playerScore) {
		setName(playerName);
		addPoints(Integer.parseInt(playerScore));
	}
	
	/**
	 * Increases the number of points the player has
	 * @param numPoints number of points to increase by
	 */
	public void addPoints(int numPoints) throws NegativeValueException {
		if (numPoints < 0) {
			throw new NegativeValueException("Cannot add negative points to player");
		} else {
			points = points + numPoints;
			
			if (points < 0) {
				points = Integer.MAX_VALUE;
			}
		}
	}
	
	/**
	 * Returns the points the player currently has
	 * @return the number of points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Returns the name of the player
	 * @return the player name
	 */
	public String getName() {
		return playerName;
	}
	
	/**
	 * Sets the player name for the class
	 * @param name the name of the player
	 */
	private void setName(String name) {
		playerName = name;
	}
	
	/**
	 * Provides a natural ordering to different PlayerScores so they can be sorted.
	 * @return int value to determine order
	 */
	public int compareTo(PlayerScore other) {
		Integer thisScore = this.getPoints();
		Integer otherScore = other.getPoints();
		int compareValue = otherScore.compareTo(thisScore);
		
		if (compareValue == 0) {
			compareValue = -1;
		}
		
		return compareValue;
	}
	
	/**
	 * String representation of the score, used in the leaderboard
	 */
	public String toString() {
		String message = getName() + " : " + getPoints();
		return message;
	}
	
	
}
