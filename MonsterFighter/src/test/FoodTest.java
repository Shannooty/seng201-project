package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.Item;
import purchasable.items.food.*;

class FoodTest {

	private Food testFood;


	@BeforeEach
	void setUp() throws Exception {
		testFood = new Apple();
	}

	@AfterEach
	void tearDown() throws Exception {
		testFood = null;
	}

	@Test
	void testUse() {
		fail("Not yet implemented");
	}

	@Test
	void testFood() {
		fail("Not yet implemented");
	}

	@Test
	void testGetHealAmount() {
		fail("Not yet implemented");
	}

	@Test
	void testSetHealAmount() {
		fail("Not yet implemented");
	}

}
