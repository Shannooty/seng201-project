package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.weapons.*;
import purchasable.monsters.*;

class WeaponTest {
//	NOTE: NOT SURE IF THIS TEST IS NECESSARY

	private Weapon testWeapon;
	private Weapon testWeapon2;
	private Monster testMonster;


	@BeforeEach
	void setUp() throws Exception {
		testWeapon = new Knife();
		testWeapon2 = new Knife();
		testMonster = new Snake();
	}

	@AfterEach
	void tearDown() throws Exception {
		testWeapon = null;
		testWeapon2 = null;
	}

	@Test
	void testUseMonster() {
		int oldMonsterDamage = testMonster.getAttackAmount();
		
		Weapon oldWeapon = testWeapon.use(testMonster);
		assertEquals(oldMonsterDamage + testWeapon.getDamage(), testMonster.getAttackAmount());
		assertEquals(null, oldWeapon);
		
		oldMonsterDamage = testMonster.getAttackAmount();
		oldWeapon = testWeapon2.use(testMonster);
		assertEquals(oldMonsterDamage, testMonster.getAttackAmount());
		assertEquals(testWeapon, oldWeapon);
	}

}
