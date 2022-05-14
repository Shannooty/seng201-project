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
import purchasable.items.*;
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
		
		testPlayer = new Player("Murr", new Dinosaur(), game);
		
		game.setPlayer(testPlayer);
		game.setToday(new Day(game));
		
		testMonsters = new ArrayList<Monster>();
		
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
		testMonsters = null;
	}

	@Test
	void testAttack() {
		//Test equal Monster fighting, player should win
		Monster playerMonster = testPlayer.getInventory().getTeam().getTeam().get(0);
		Monster enemyMonster = testMonsters.get(0);
		
		String winner = testBattle.attack(playerMonster, enemyMonster);
		assertTrue(winner.contains("You:"));
		assertTrue(playerMonster.getHealth() > enemyMonster.getHealth());
		
		playerMonster.sleep();
		enemyMonster.sleep();
		
		//Test same Monster again but enemy has higher speed
		Item potion = new SpeedPotion();
		potion.use(enemyMonster);
		
		winner = testBattle.attack(playerMonster, enemyMonster);
		assertTrue(winner.contains("Player"));
		assertTrue(playerMonster.getHealth() < enemyMonster.getHealth());
		
		//Fighting with a stunned Monster
		playerMonster.sleep();
		enemyMonster.sleep();
		
		enemyMonster.removeHealth(10000000);
		winner = testBattle.attack(playerMonster, enemyMonster);
		assertTrue(winner.contains("You:"));
		assertTrue(playerMonster.getHealth() == playerMonster.getMaxHealth());
	}

}
