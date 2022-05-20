package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import generators.MonsterGenerator;
import gui.GameEnvironment;
import player.Player;
import player.Team;
import purchasable.monsters.Monster;
import random_event.*;

class RandomEventTest {
	
	private RandomEvent testEvent;
	private Player testPlayer;
	private Team playerTeam;
	private Monster startingMonster = MonsterGenerator.newMonster();
	private GameEnvironment game = new GameEnvironment();
	
	@BeforeEach
	void setUp() throws Exception {
		testPlayer = new Player("Bob", startingMonster, game);
		playerTeam = testPlayer.getInventory().getTeam();
		testEvent = new RandomEvent(testPlayer.getInventory(), game);
	}

	@AfterEach
	void tearDown() throws Exception {
		testPlayer = null;
		playerTeam = null;
		testEvent = null;
	}

	@Test
	void testGetRandomEvent() {
		ArrayList<String> validEvents = new ArrayList<String>();
		validEvents.add("MonsterLeaves");
		validEvents.add("NewMonsterJoins");
		validEvents.add("MonsterLevelsUp");
		validEvents.add("Nothing");
		
		String outputEvent;
		
		//Run test 15 times to get all outputs
		for (int i = 0; i < 15; i++) {
			outputEvent = testEvent.getRandomEvent();
			assertTrue(validEvents.contains(outputEvent));
		}
		
	}
	
	@Test
	void runNewMonsterJoins() {
		assertEquals(1, playerTeam.size());
		
		//Should fill up the team with new monsters
		for (int i = 2; i < 5; i++) {
			new NewMonsterJoins(testPlayer.getInventory(), game);
			assertEquals(i, playerTeam.size());
		}
		
		//One more NewMonsterJoins shouldn't do anything
		new NewMonsterJoins(testPlayer.getInventory(), game);
		assertEquals(4, playerTeam.size());
		
		//One more NewMonsterJoins shouldn't do anything
		new NewMonsterJoins(testPlayer.getInventory(), game);
		assertEquals(4, playerTeam.size());
	}
	
	@Test
	void runMonsterLevelsUp() {
		Monster playerMonster = playerTeam.getTeam().get(0);
		int monsterMaxHealth = playerMonster.getMaxHealth();
		
		playerMonster.removeHealth(100);
		int currentHealth = playerMonster.getHealth();
		
		assertFalse(monsterMaxHealth == currentHealth);
		
		new MonsterLevelsUp(testPlayer.getInventory(), game);
		
		assertTrue(monsterMaxHealth < playerMonster.getMaxHealth());
		assertTrue(currentHealth <= playerMonster.getHealth());
	}
	
	@Test
	void runMonsterLeaves() {
		assertEquals(1, playerTeam.size());
		
		new MonsterLeaves(testPlayer.getInventory(), game);
		assertEquals(0, playerTeam.size());
		
		//Remove monster from empty team, no change should occur
		new MonsterLeaves(testPlayer.getInventory(), game);
		assertEquals(0, playerTeam.size());
		
	}

}
