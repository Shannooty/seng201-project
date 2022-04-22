package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.items.armors.*;
import purchasable.monsters.*;

class MonsterTest {
	
	private Monster testMonster;
	private Armor testArmor;
	
	@BeforeEach
	void setUp() throws Exception {
		testMonster = new Slime();
		testArmor = new Chainmail();
	}

	@AfterEach
	void tearDown() throws Exception {
		testMonster = null;
		testArmor = null;
	}

	@Test
	void testAddHealth() {
		ArrayList<Integer> healthValues = new ArrayList<Integer>();
		healthValues.add(100);
		healthValues.add(200);
		healthValues.add(10);
		healthValues.add(0);
		healthValues.add(-300);
		healthValues.add(Integer.MAX_VALUE);
		healthValues.add(Integer.MIN_VALUE);
		
		testMonster.removeHealth(Integer.MAX_VALUE);
		int monsterHealth = testMonster.getHealth();
		
		for (int health : healthValues) {
			testMonster.removeHealth(Integer.MAX_VALUE);
			testMonster.addHealth(health);
			
			if (health > 0) {
				assertTrue(monsterHealth < testMonster.getHealth());
				assertTrue(testMonster.getHealth() <= testMonster.getMaxHealth());
			} else {
				assertTrue(monsterHealth == testMonster.getHealth());
			}
		}
	}
	
	@Test
	void testRemoveHealth() {
		ArrayList<Integer> damageValues = new ArrayList<Integer>();
		damageValues.add(400);
		damageValues.add(100);
		damageValues.add(50);
		damageValues.add(0);
		damageValues.add(-100);
		damageValues.add(10000);
		damageValues.add(Integer.MAX_VALUE);
		damageValues.add(Integer.MIN_VALUE);
		
		int monsterHealth = testMonster.getHealth();
		
		for (int damage : damageValues) {
			testMonster.addHealth(100000);
			testMonster.removeHealth(damage);
			assertTrue(monsterHealth >= 0);
			
			if (damage > 0) {
				assertTrue(monsterHealth >= testMonster.getHealth());
			} else {
				assertEquals(monsterHealth, testMonster.getHealth());
			}
		}
		
		//Give armor
		testMonster.addArmor(testArmor);
		int armorAmount = testArmor.getArmorIncrease();
		int armorModifier = Monster.armorModifier;
		
		//Remove health but with armor
		for (int damage : damageValues) {
			testMonster.addHealth(100000);
			
			testMonster.removeHealth(damage);
			assertTrue(monsterHealth >= 0);
			
			if (damage > 0) {
				assertTrue(testMonster.getHealth() < monsterHealth);
				assertTrue(testMonster.getHealth() - monsterHealth < damage);
			} else {
				assertEquals(monsterHealth, testMonster.getHealth());
			}
		}
		
	}
	
	@Test
	void testAddMaxHealth() {
		ArrayList<Integer> healthValues = new ArrayList<Integer>();
		healthValues.add(100);
		healthValues.add(200);
		healthValues.add(10);
		healthValues.add(0);
		healthValues.add(-300);
		healthValues.add(Integer.MAX_VALUE);
		healthValues.add(Integer.MIN_VALUE);
		
		int currentMaxHealth = testMonster.getMaxHealth();
		
		for (int health : healthValues) {
			testMonster.addMaxHealth(health);
			assertTrue(testMonster.getMaxHealth() >= currentMaxHealth);
			assertTrue(testMonster.getMaxHealth() >= 0);
			
			if (health < 0) {
				assertEquals(health, testMonster.getMaxHealth() - currentMaxHealth );
			} else {
				assertEquals(currentMaxHealth, testMonster.getMaxHealth());
			}
			currentMaxHealth = testMonster.getMaxHealth();
		}
	}
	
	@Test
	void testRemoveMaxHealth() {
		ArrayList<Integer> healthValues = new ArrayList<Integer>();
		healthValues.add(100);
		healthValues.add(200);
		healthValues.add(10);
		healthValues.add(0);
		healthValues.add(-300);
		healthValues.add(Integer.MAX_VALUE);
		healthValues.add(Integer.MIN_VALUE);
		
		int currentMaxHealth = testMonster.getMaxHealth();
		
		for (int health : healthValues) {
			testMonster.removeMaxHealth(health);
			assertTrue(testMonster.getMaxHealth() <= currentMaxHealth);
			assertTrue(testMonster.getMaxHealth() >= 0);
			
			if (health < 0) {
				assertEquals(health, testMonster.getMaxHealth() - currentMaxHealth);
			} else {
				assertEquals(currentMaxHealth, testMonster.getMaxHealth());
			}
			currentMaxHealth = testMonster.getMaxHealth();
		}
	}
	
	@Test
	void testAddSpeed() {
		ArrayList<Integer> speedValues = new ArrayList<Integer>();
		speedValues.add(10);
		speedValues.add(15);
		speedValues.add(50);
		speedValues.add(0);
		speedValues.add(-10);
		speedValues.add(Integer.MAX_VALUE);
		speedValues.add(Integer.MIN_VALUE);
		
		int currentSpeed = testMonster.getSpeed();
		
		for (int speed : speedValues) {
			testMonster.addSpeed(speed);
			assertTrue(testMonster.getSpeed() >= currentSpeed);
			assertTrue(testMonster.getSpeed() >= 0);
			
			if (speed <= 0) {
				assertEquals(testMonster.getSpeed(), currentSpeed);
			}
			currentSpeed = testMonster.getSpeed();
		}
	}
	
	@Test
	void testRemoveSpeed() {
		ArrayList<Integer> speedValues = new ArrayList<Integer>();
		speedValues.add(10);
		speedValues.add(15);
		speedValues.add(50);
		speedValues.add(0);
		speedValues.add(-10);
		speedValues.add(Integer.MAX_VALUE);
		speedValues.add(Integer.MIN_VALUE);
		
		testMonster.addSpeed(1000);
		int currentSpeed = testMonster.getSpeed();
		
		for (int speed : speedValues) {
			testMonster.addSpeed(speed);
			assertTrue(testMonster.getSpeed() <= currentSpeed);
			assertTrue(testMonster.getSpeed() >= 0);
			
			if (speed <= 0) {
				assertEquals(testMonster.getSpeed(), currentSpeed);
			}
			currentSpeed = testMonster.getSpeed();
		}
	}
}
