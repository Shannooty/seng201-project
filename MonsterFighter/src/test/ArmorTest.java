package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.Item;
import purchasable.items.armors.*;

class ArmorTest {

	private Armor testArmor;

	
	@BeforeEach
	void setUp() throws Exception {
		testArmor = new Shield();
	}

	@AfterEach
	void tearDown() throws Exception {
		testArmor = null;
	}

	@Test
	void testUse() {
		fail("Not yet implemented");
	}

	@Test
	void testArmor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetHealthIncrease() {
		fail("Not yet implemented");
	}

	@Test
	void testGetArmorIncrease() {
		fail("Not yet implemented");
	}

}
