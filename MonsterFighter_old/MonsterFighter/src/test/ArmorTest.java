package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.Item;
import purchasable.items.armors.*;
import purchasable.monsters.*;

class ArmorTest {
//	NOTE: NOT SURE IF THIS TEST IS NECESSARY
	

	private Armor testArmor;
	private Armor testArmor2;
	private Monster testMonster;

	
	@BeforeEach
	void setUp() throws Exception {
		testArmor = new Shield();
		testArmor2 = new Shield();
		testMonster = new Dinosaur();
	}

	@AfterEach
	void tearDown() throws Exception {
		testArmor = null;
		testArmor2 = null;
		testMonster = null;
	}

	@Test
	void testUse() {
		int oldMonsterMax = testMonster.getMaxHealth();
		int oldMonsterArmor = testMonster.getArmorAmount();
		
		Item oldArmor = testArmor.use(testMonster);
		assertEquals(oldMonsterArmor + testArmor.getArmorIncrease(), testMonster.getArmorAmount());
		assertEquals(oldMonsterMax + testArmor.getHealthIncrease(), testMonster.getMaxHealth());
		assertEquals(null, oldArmor);
		
		oldMonsterMax = testMonster.getMaxHealth();
		oldMonsterArmor = testMonster.getArmorAmount();
		
		oldArmor = testArmor2.use(testMonster);
		assertEquals(oldMonsterMax, testMonster.getMaxHealth());
		assertEquals(oldMonsterArmor, testMonster.getArmorAmount());
		assertEquals(testArmor, oldArmor);
	}

}
