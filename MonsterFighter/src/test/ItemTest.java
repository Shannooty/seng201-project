package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.armors.*;
import purchasable.items.food.*;
import purchasable.items.weapons.*;
import purchasable.monsters.Dinosaur;
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
		testMonster = new Dinosaur();
	}

	@AfterEach
	void tearDown() throws Exception {
		testWeapon = null;
		testFood = null;
		testArmor = null;
		testMonster = null;
	}



	@Test
	void testUse() {
		int monsterOldDamage = testMonster.getAttackAmount();
		testWeapon.use(testMonster);
		assertTrue(testMonster.getAttackAmount() == monsterOldDamage + testWeapon.getDamage());
		
		//Test adding food to full health monster
		int monsterOldHealth = testMonster.getHealth();
		testFood.use(testMonster);
		assertEquals(monsterOldHealth, testMonster.getHealth());
		
		testMonster.removeHealth(500);
		monsterOldHealth = testMonster.getHealth();
		testFood.use(testMonster);
		assertEquals(testMonster.getHealth(), monsterOldHealth + testFood.getHealAmount());
		
		int monsterOldMaxHealth = testMonster.getMaxHealth();
		int monsterOldArmorAmount = testMonster.getArmorAmount();
		testArmor.use(testMonster);
		assertTrue(testMonster.getMaxHealth() == monsterOldMaxHealth + testArmor.getHealthIncrease());
		assertTrue(testMonster.getArmorAmount() == monsterOldArmorAmount + testArmor.getArmorIncrease());
	}
	
	@Test
	void testSell() {
		
	}

}
