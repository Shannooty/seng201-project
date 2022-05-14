package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.food.*;
import purchasable.monsters.Dinosaur;
import purchasable.monsters.Monster;

class FoodTest {

	private Food testApple;
	private Food testBread;
	private Food testMushroom;
	private Monster testMonster;


	@BeforeEach
	void setUp() throws Exception {
		testApple = new Apple();
		testBread = new Bread();
		testMushroom = new Mushroom();		
		testMonster = new Dinosaur();
	}

	@AfterEach
	void tearDown() throws Exception {
		testApple = null;
		testBread = null;
		testMushroom = null;
		testMonster = null;
	}

	@Test
	void testUse() {
		assertEquals(100, testApple.getHealAmount());
		assertEquals(120, testBread.getHealAmount());
		assertEquals(70, testMushroom.getHealAmount());
		
		testMonster.removeHealth(111);
		testApple.use(testMonster);
		assertEquals(789, testMonster.getHealth());
		
		testMonster.removeHealth(100);
		testBread.use(testMonster);
		assertEquals(800, testMonster.getHealth());
		
		testMonster.removeHealth(111);
		testMushroom.use(testMonster);
		assertEquals(759, testMonster.getHealth());
		
		testMonster.removeHealth(759);
		testApple.use(testMonster);
		testBread.use(testMonster);
		testMushroom.use(testMonster);
		assertEquals(290, testMonster.getHealth());

		
		testBread.use(testMonster);
		testBread.use(testMonster);
		testBread.use(testMonster);
		testBread.use(testMonster);
		testBread.use(testMonster);
		assertEquals(800, testMonster.getHealth());

		
		
		
		

	}

}
