package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import day.Battle;
import day.Day;
import gui.GameEnvironment;
import player.Player;
import purchasable.monsters.*;

class BattleTest {
	
	private Battle testBattle;
	private GameEnvironment game;
	private Player testPlayer;
	private ArrayList<Monster> testMonsters;
	
	@BeforeEach
	void setUp() throws Exception {
		game = new GameEnvironment();
		game.setGameLength(10);
		game.setGameDifficulty("Hard");
		game.setToday(new Day(game));
		
		testPlayer = new Player("Murr", new Dinosaur(), game);
		
		game.setPlayer(testPlayer);
		
		createTestMonsters();
		
		testBattle = new Battle(game);
	}
	
	private void createTestMonsters() {
		testMonsters.add(new Dinosaur());
		testMonsters.add(new Slime());
		testMonsters.add(new Skeleton());
		testMonsters.add(new Snake());
		testMonsters.add(new UndeadGuard());
		testMonsters.add(new Zombie());
	}
	
	@AfterEach
	void tearDown() throws Exception {
		testBattle = null;
		game = null;
	}

	@Test
	void testAttack() {
		fail("Not yet implemented");
	}

}
