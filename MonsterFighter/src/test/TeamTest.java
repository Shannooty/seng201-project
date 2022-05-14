package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TeamFullException;
import player.Team;
import purchasable.monsters.*;

class TeamTest {
	
	private Team testTeam;
	private ArrayList<Monster> testMonsters = new ArrayList<Monster>();
	
	@BeforeEach
	void setUp() throws Exception {
		testTeam = new Team();
		setTestMonsters();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		testTeam = null;
		testMonsters = null;
	}
	
	private void setTestMonsters() {
		Slime newSlime = new Slime();
		Zombie newZombie = new Zombie();
		UndeadGuard newGuard = new UndeadGuard();
		Skeleton newSkeleton = new Skeleton();
		Skeleton newSkeleton2 = new Skeleton();
		
		testMonsters.add(newGuard);
		testMonsters.add(newZombie);
		testMonsters.add(newSlime);
		testMonsters.add(newSkeleton);
		testMonsters.add(newSkeleton2);
	}
	
	private void fillTeam() {
		testTeam.add(testMonsters.get(0));
		testTeam.add(testMonsters.get(1));
		testTeam.add(testMonsters.get(2));
		testTeam.add(testMonsters.get(3));
	}
	
	private boolean isInOrder(Team team) {
		//Team should be in increasing order
		boolean inOrder = true;
		int lastSpeed = Integer.MIN_VALUE;
		
		for (Monster monster : team.getTeam()) {
			if (monster.getSpeed() < lastSpeed) {
				inOrder = false;
			} else {
				lastSpeed = monster.getSpeed();
			}
		}
		return inOrder;
	}

	@Test
	void testAdd() {
		assertEquals(0, testTeam.getTeam().size());
		
		testTeam.add(testMonsters.get(0));
		assertEquals(1, testTeam.getTeam().size());
		assertEquals(testMonsters.get(0), testTeam.getTeam().get(0));
		
		testTeam.add(testMonsters.get(1));
		assertEquals(2, testTeam.getTeam().size());
		assertEquals(testMonsters.get(1), testTeam.getTeam().get(1));
		
		//Try adding null object, no change to team expected
		testTeam.add(null);
		assertEquals(2, testTeam.getTeam().size());
		
		//Try adding same object into team, no expected change
		testTeam.add(testMonsters.get(1));
		assertEquals(2, testTeam.getTeam().size());
		
		//Fill up team
		testTeam.add(testMonsters.get(2));
		testTeam.add(testMonsters.get(3));
		assertEquals(4, testTeam.getTeam().size());
		
		//Try adding more monsters than the limit
		TeamFullException teamFullException = assertThrows(TeamFullException.class, 
				() -> testTeam.add(testMonsters.get(4)));
		
		assertEquals("Team cannot have more than 4 members.", teamFullException.getMessage());
		assertEquals(4, testTeam.getTeam().size());
	}
	
	@Test
	void testRemove() {
		//Fill team up
		fillTeam();
		assertEquals(4, testTeam.getTeam().size());
		
		testTeam.remove(testMonsters.get(0));
		assertEquals(3, testTeam.getTeam().size());
		
		//remove a monster that's not in the team
		testTeam.remove(testMonsters.get(0));
		assertEquals(3, testTeam.getTeam().size());
		
		//Remove null object from team
		testTeam.remove(null);
		assertEquals(3, testTeam.getTeam().size());
	}
	
	@Test
	void testRefreshOrder() {
		fillTeam();
		
		//Change the speed of the last monster
		testTeam.getTeam().get(3).removeSpeed(100);
		
		assertFalse(isInOrder(testTeam));
		testTeam.refreshOrder();
		assertTrue(isInOrder(testTeam));
		
		//Change a team monsters speed to MAX_VALUE
		Monster monsterMax = testTeam.getTeam().get(1);
		monsterMax.removeSpeed(monsterMax.getSpeed());
		monsterMax.addSpeed(Integer.MAX_VALUE);
		
		assertFalse(isInOrder(testTeam));
		testTeam.refreshOrder();
		assertTrue(isInOrder(testTeam));
		
		//Change a team monsters speed to 0
		Monster monsterMin = testTeam.getTeam().get(2);
		monsterMin.removeSpeed(monsterMin.getSpeed());
		assertFalse(isInOrder(testTeam));
		testTeam.refreshOrder();
		assertTrue(isInOrder(testTeam));
	}

}
