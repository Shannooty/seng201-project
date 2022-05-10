package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.NegativeValueException;
import gui.GameEnvironment;
import player.Player;
import player.Team;
import purchasable.items.armors.*;
import purchasable.items.weapons.*;
import purchasable.monsters.*;

class MonsterTest {
	
	private GameEnvironment gameEnvironment = new GameEnvironment();
	private Monster testMonster;
	private Armor testArmor;
	private Weapon testWeapon;
	private Player testPlayer;
	
	@BeforeEach
	void setUp() throws Exception {
		testMonster = new Slime();
		testArmor = new Chainmail();
		testWeapon = new SledgeHammer();
		testPlayer = new Player("Tom", new Skeleton(), gameEnvironment);
		testPlayer.addGold(10000);
	}

	@AfterEach
	void tearDown() throws Exception {
		testMonster = null;
		testArmor = null;
		testWeapon = null;
		testPlayer = null;
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
			if (health >= 0) {
				testMonster.addHealth(health);
				assertTrue(monsterHealth <= testMonster.getHealth());
				assertTrue(testMonster.getHealth() <= testMonster.getMaxHealth());
			} else {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.addHealth(health);});
				assertEquals(exception.getMessage(), "Cannot add negative health");
				assertEquals(monsterHealth, testMonster.getHealth());
			}
		}
	}
	
	@Test
	void testRemoveHealth() throws NegativeValueException {
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
			assertEquals(monsterHealth, testMonster.getHealth());
			
			if (damage >= 0) {
				testMonster.removeHealth(damage);
				assertTrue(monsterHealth >= testMonster.getHealth());
			} else {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.removeHealth(damage);});
				assertEquals("Cannot remove negative health", exception.getMessage());
				assertEquals(monsterHealth, testMonster.getHealth());
			}
		}
		
		//Give armor
		testMonster.addArmor(testArmor);
		monsterHealth = testMonster.getHealth();
		
		//Remove health but with armor
		for (int damage : damageValues) {
			testMonster.addHealth(100000);
			assertEquals(monsterHealth, testMonster.getHealth());
			
			if (damage >= 0) {
				testMonster.removeHealth(damage);
				assertTrue(testMonster.getHealth() <= monsterHealth);
				assertTrue(testMonster.getHealth() - monsterHealth <= damage);
			} else {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.removeHealth(damage);});
				assertEquals("Cannot remove negative health", exception.getMessage());
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
			if (health >= 0) {
				testMonster.addMaxHealth(health);
				assertTrue(testMonster.getMaxHealth() >= currentMaxHealth);
				assertTrue(testMonster.getMaxHealth() >= 0);
			} else {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.addMaxHealth(health);});
				assertEquals(currentMaxHealth, testMonster.getMaxHealth());
				assertEquals(exception.getMessage(), "Cannot add negative health");
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
			if (health >= 0) {
				testMonster.removeMaxHealth(health);
				assertTrue(testMonster.getMaxHealth() <= currentMaxHealth);
				assertTrue(testMonster.getMaxHealth() >= 0);
			} else {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.removeMaxHealth(health);});
				assertEquals(currentMaxHealth, testMonster.getMaxHealth());
				assertEquals(exception.getMessage(), "Cannot remove negative health");
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
			if (speed < 0) {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.addSpeed(speed);});
				assertEquals(exception.getMessage(),"Cannot add negative speed");
				assertEquals(testMonster.getSpeed(), currentSpeed);
			} else {
				testMonster.addSpeed(speed);
				assertTrue(testMonster.getSpeed() >= currentSpeed);
				assertTrue(testMonster.getSpeed() >= 0);
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
			if (speed < 0) {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.removeSpeed(speed);});
				assertEquals(exception.getMessage(),"Cannot remove negative speed");
				assertEquals(testMonster.getSpeed(), currentSpeed);
			} else {
				testMonster.removeSpeed(speed);
				assertTrue(testMonster.getSpeed() <= currentSpeed);
				assertTrue(testMonster.getSpeed() >= 0);
			}
			currentSpeed = testMonster.getSpeed();
		}
	}
	
	@Test
	void testAddAttackDamage() {
		ArrayList<Integer> attackValues = new ArrayList<Integer>();
		attackValues.add(10);
		attackValues.add(15);
		attackValues.add(50);
		attackValues.add(0);
		attackValues.add(-10);
		attackValues.add(Integer.MAX_VALUE);
		attackValues.add(Integer.MIN_VALUE);
		
		int currentAttackDamage = testMonster.getAttackAmount();
		
		for (int attackIncrease : attackValues) {
			if (attackIncrease < 0) {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.addAttackAmount(attackIncrease);});
				assertEquals(exception.getMessage(), "Cannot add negative attack amount");
				assertEquals(testMonster.getAttackAmount(), currentAttackDamage);
			} else {
				testMonster.addAttackAmount(attackIncrease);
				assertTrue(testMonster.getAttackAmount() >= 0);
				assertTrue(testMonster.getAttackAmount() >= currentAttackDamage);
			}
			currentAttackDamage = testMonster.getAttackAmount();
		}
	}
	
	@Test
	void testRemoveAttackDamage() {
		ArrayList<Integer> attackValues = new ArrayList<Integer>();
		attackValues.add(10);
		attackValues.add(15);
		attackValues.add(50);
		attackValues.add(0);
		attackValues.add(-10);
		attackValues.add(Integer.MAX_VALUE);
		attackValues.add(Integer.MIN_VALUE);
		
		int currentAttackDamage = testMonster.getAttackAmount();
		
		for (int attackDecrease : attackValues) {
			if (attackDecrease < 0) {
				NegativeValueException exception = assertThrows(NegativeValueException.class, () -> {testMonster.removeAttackAmount(attackDecrease);});
				assertEquals(exception.getMessage(), "Cannot remove negative attack amount");
				assertEquals(testMonster.getAttackAmount(), currentAttackDamage);
			} else {
				testMonster.removeAttackAmount(attackDecrease);
				assertTrue(testMonster.getAttackAmount() >= 0);
				assertTrue(testMonster.getAttackAmount() <= currentAttackDamage);
			}
			currentAttackDamage = testMonster.getAttackAmount();
		}
	}
	
	@Test
	void testSleep() {
		testMonster.removeHealth(500);
		int expectedHealth = testMonster.getHealth() + testMonster.getHealAmount();
		
		testMonster.sleep();
		assertEquals(expectedHealth, testMonster.getHealth());
		
		//Test sleeping reseting stunned status
		testMonster.removeHealth(100000);
		assertTrue(testMonster.getStunnedStatus());
		
		testMonster.sleep();
		assertFalse(testMonster.getStunnedStatus());
	}
	
	@Test
	void testAddWeapon() {
		int oldMonsterAttack = testMonster.getAttackAmount();
		int expectedAttack = oldMonsterAttack + testWeapon.getDamage();
		
		testMonster.addWeapon(testWeapon);
		assertEquals(expectedAttack, testMonster.getAttackAmount());
		
		Weapon stick = new SharpStick();
		expectedAttack = oldMonsterAttack + stick.getDamage();
		
		Weapon oldWeapon = testMonster.addWeapon(stick);
		assertEquals(expectedAttack, testMonster.getAttackAmount());
		assertEquals(testWeapon, oldWeapon);
	}
	
	@Test
	void testRemoveWeapon() {
		int baseAttackDamage = testMonster.getAttackAmount();
		testMonster.addWeapon(testWeapon);
		
		Weapon oldWeapon = testMonster.removeWeapon();
		assertEquals(baseAttackDamage, testMonster.getAttackAmount());
		assertEquals(oldWeapon, testWeapon);
		
		//Test removing weapon from monster with no weapon
		oldWeapon = testMonster.removeWeapon();
		assertEquals(baseAttackDamage, testMonster.getAttackAmount());
		assertEquals(oldWeapon, null);
	}
	
	@Test
	void testAddArmor() {
		int oldMonsterArmor = testMonster.getArmorAmount();
		int oldMonsterMaxHealth = testMonster.getMaxHealth();
		int oldMonsterHealth = testMonster.getHealth();
		
		int expectedArmor = oldMonsterArmor + testArmor.getArmorIncrease();
		int expectedMaxHealth = oldMonsterMaxHealth + testArmor.getHealthIncrease();
		int expectedHealth = oldMonsterHealth + testArmor.getHealthIncrease();
		
		Armor oldArmor = testMonster.addArmor(testArmor);
		assertEquals(expectedArmor, testMonster.getArmorAmount());
		assertEquals(expectedMaxHealth, testMonster.getMaxHealth());
		assertEquals(expectedHealth, testMonster.getHealth());
		assertEquals(oldArmor, null);
		
		FlowerCrown crown = new FlowerCrown();
		expectedArmor = oldMonsterArmor + crown.getArmorIncrease();
		expectedMaxHealth = oldMonsterMaxHealth + crown.getHealthIncrease();
		expectedHealth = oldMonsterHealth + crown.getHealthIncrease();
		
		oldArmor = testMonster.addArmor(crown);
		assertEquals(expectedArmor, testMonster.getArmorAmount());
		assertEquals(expectedMaxHealth, testMonster.getMaxHealth());
		assertEquals(expectedHealth, testMonster.getHealth());
		assertEquals(oldArmor, testArmor);
	}
	
	@Test
	void testRemoveArmor() {
		int baseMonsterArmor = testMonster.getArmorAmount();
		int baseMonsterMaxHealth = testMonster.getMaxHealth();
		int baseMonsterHealth = testMonster.getHealth();
		
		//Test removing armor from monster who has no armor
		Armor oldArmor = testMonster.removeArmor();
		assertEquals(baseMonsterArmor, testMonster.getArmorAmount());
		assertEquals(baseMonsterMaxHealth, testMonster.getMaxHealth());
		assertEquals(baseMonsterHealth, testMonster.getHealth());
		assertEquals(oldArmor, null);
		
		testMonster.addArmor(testArmor);
		
		oldArmor = testMonster.removeArmor();
		assertEquals(baseMonsterArmor, testMonster.getArmorAmount());
		assertEquals(baseMonsterMaxHealth, testMonster.getMaxHealth());
		assertEquals(baseMonsterHealth, testMonster.getHealth());
		assertEquals(oldArmor, testArmor);
		
	}
	
	@Test
	void testBuy() {
		Team playerTeam = testPlayer.getInventory().getTeam();
		double expectedGold = testPlayer.getGoldAmount() - testMonster.getPurchasePrice();
		assertFalse(playerTeam.getTeam().contains(testMonster));
		
		testMonster.buy(testPlayer);
		assertTrue(playerTeam.getTeam().contains(testMonster));
		assertEquals(expectedGold, testPlayer.getGoldAmount());
	}
	
	@Test
	void testSell() {
		Team playerTeam = testPlayer.getInventory().getTeam();
		testMonster.buy(testPlayer);
		double expectedGold = testPlayer.getGoldAmount() + testMonster.getPurchasePrice();
		
		testMonster.sell(testPlayer);
		assertFalse(playerTeam.getTeam().contains(testMonster));
		assertEquals(expectedGold, testPlayer.getGoldAmount());
	}
}
