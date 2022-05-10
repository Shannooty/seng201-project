package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.weapons.*;

class WeaponTest {
//	NOTE: NOT SURE IF THIS TEST IS NECESSARY

	private Weapon testWeapon;


	@BeforeEach
	void setUp() throws Exception {
		testWeapon = new Knife();
	}

	@AfterEach
	void tearDown() throws Exception {
		testWeapon = null;
	}

	@Test
	void testWeapon() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDamage() {
		fail("Not yet implemented");
	}

	@Test
	void testUseMonster() {
		fail("Not yet implemented");
	}

}