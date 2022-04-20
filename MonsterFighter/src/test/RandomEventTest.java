package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import generators.MonsterGenerator;
import player.Player;
import player.Team;
import purchasable.monsters.Monster;
import random_event.*;

class RandomEventTest {
	
	private RandomEvent testEvent;
	private Player testPlayer;
	private Team playerTeam;
	private Monster startingMonster = MonsterGenerator.newMonster();
	
	@BeforeEach
	void setUp() throws Exception {
		testPlayer = new Player("Bob", startingMonster);
		playerTeam = testPlayer.getInventory().getTeam();
		testEvent = new RandomEvent(testPlayer.getInventory());
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
		
		NewMonsterJoins monsterJoinsEvent;
		
		//Should fill up the team with new monsters
		for (int i = 2; i < 5; i++) {
			monsterJoinsEvent = new NewMonsterJoins(testPlayer.getInventory());
			assertEquals(i, playerTeam.size());
		}
		
		//One more NewMonsterJoins shouldn't do anything
		monsterJoinsEvent = new NewMonsterJoins(testPlayer.getInventory());
		assertEquals(4, playerTeam.size());
		
		//One more NewMonsterJoins shouldn't do anything
		monsterJoinsEvent = new NewMonsterJoins(testPlayer.getInventory());
		assertEquals(4, playerTeam.size());
	}
	
	@Test
	void runMonsterLevelsUp() {
		Monster playerMonster = playerTeam.getTeam().get(0);
		int monsterMaxHealth = playerMonster.getMaxHealth();
		
		playerMonster.removeHealth(100);
		int currentHealth = playerMonster.getHealth();
		
		assertFalse(monsterMaxHealth == currentHealth);
		
		MonsterLevelsUp levelUpEvent = new MonsterLevelsUp(testPlayer.getInventory());
		
		assertTrue(monsterMaxHealth < playerMonster.getMaxHealth());
		assertTrue(currentHealth == playerMonster.getHealth());
	}
	
	@Test
	void runMonsterLeaves() {
		
	}

}
