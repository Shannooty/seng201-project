package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.Item;
import purchasable.items.food.*;
import purchasable.monsters.Dinosaur;
import purchasable.monsters.Monster;

class FoodTest {
//	NOTE: NOT SURE IF THIS TEST IS NECESSARY

	private Food testFood;
	private Monster testMonster;


	@BeforeEach
	void setUp() throws Exception {
		testFood = new Apple();
		testMonster = new Dinosaur();
	}

	@AfterEach
	void tearDown() throws Exception {
		testFood = null;
		testMonster = null;
	}

	@Test
	void testUse() {
		int foodHealAmount = testFood.getHealAmount();
		
	}

}
