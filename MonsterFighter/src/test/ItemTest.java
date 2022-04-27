package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.Item;
import purchasable.items.armors.*;
import purchasable.items.food.*;
import purchasable.items.weapons.*;
import purchasable.monsters.Monster;

class ItemTest {

	private Monster testMonster;
	private Weapon testWeapon;
	private Food testFood;
	private Armor testArmor;


	@BeforeEach
	void setUp() throws Exception {
		testWeapon = new Knife();
		testFood = new Apple();
		testArmor = new Shield();
	}

	@AfterEach
	void tearDown() throws Exception {
		testWeapon = null;
		testFood = null;
		testArmor = null;
	}



	@Test
	void testUse() {
		int monsterOldDamage = testMonster.getAttackAmount();
		testWeapon.use(testMonster);
		assertTrue(testMonster.getAttackAmount() == monsterOldDamage + testWeapon.getDamage());
		
		int monsterOldHealth = testMonster.getHealth();
		testFood.use(testMonster);
		assertTrue(testMonster.getHealth() == monsterOldHealth + testFood.getHealAmount());
		
		int monsterOldMaxHealth = testMonster.getMaxHealth();
		int monsterOldArmorAmount = testMonster.getArmorAmount();
		testArmor.use(testMonster);
		assertTrue(testMonster.getMaxHealth() == monsterOldMaxHealth + testArmor.getHealthIncrease());
		assertTrue(testMonster.getArmorAmount() == monsterOldArmorAmount + testArmor.getArmorIncrease());
	}

//	@Test
//	void testCreateDescription() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetSellBackDescription() {
//		fail("Not yet implemented");
//	}

}
