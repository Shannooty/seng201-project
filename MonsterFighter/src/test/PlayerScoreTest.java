package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.NegativeValueException;
import player.Player;
import player.PlayerScore;
import purchasable.monsters.Slime;

class PlayerScoreTest {
	
	private Player testPlayer;
	private PlayerScore player1;
	private PlayerScore player2;
	
	@BeforeEach
	void setUp() throws Exception {
		testPlayer = new Player("Bob", new Slime());
		player1 = new PlayerScore("Bede", "1000");
		player2 = new PlayerScore("Celia", "1000");
		testPlayer.addPoints(500);
	}

	@AfterEach
	void tearDown() throws Exception {
		testPlayer = null;
		player1 = null;
		player2 = null;
	}

	@Test
	void testAddPoints() {
		ArrayList<Integer> testPoints = new ArrayList<Integer>();
		testPoints.add(1000);
		testPoints.add(100);
		testPoints.add(1);
		testPoints.add(0);
		testPoints.add(-100);
		testPoints.add(-200);
		testPoints.add(Integer.MAX_VALUE);
		testPoints.add(Integer.MIN_VALUE);
		
		int currentPoints = testPlayer.getPoints();
		
		for (int points : testPoints) {
			if (points >= 0) {
				testPlayer.addPoints(points);
				assertTrue(currentPoints <= testPlayer.getPoints());
				assertTrue(currentPoints >= 0);
			} else {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testPlayer.addPoints(points);});
				assertEquals("Cannot add negative points to player", exception.getMessage());
				assertEquals(currentPoints, testPlayer.getPoints());
			}
			currentPoints = testPlayer.getPoints();
		}
		
	}
	
	@Test
	void testCompareTo() {
		//Test different scores
		assertEquals(-1, player1.compareTo(testPlayer.getScore()));
		assertEquals(1, testPlayer.getScore().compareTo(player2));
		
		//Test scores with same score, should both be "greater" than each other to favor newer scores.
		assertEquals(-1, player1.compareTo(player2));
		assertEquals(-1, player2.compareTo(player1));
	}

}
