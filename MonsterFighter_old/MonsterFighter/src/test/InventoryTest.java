package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import player.Inventory;
import purchasable.items.*;
import purchasable.items.armors.*;
import purchasable.items.food.*;
import purchasable.items.weapons.*;
import purchasable.monsters.*;

class InventoryTest {
	
	private Inventory testInventory;
	private ArrayList<Item> testItems = new ArrayList<Item>();
	private ArrayList<Monster> testMonsters = new ArrayList<Monster>();
	
	
	private void fillTestArrays() {
		testItems.add(new Apple());
		testItems.add(new Chainmail());
		testItems.add(new SpeedPotion());
		testItems.add(new SharpStick());
		
		testMonsters.add(new Slime());
		testMonsters.add(new Skeleton());
		testMonsters.add(new Zombie());
		testMonsters.add(new UndeadGuard());
	}
	
	@BeforeEach
	void setUp() throws Exception {
		Slime startingMonster = new Slime();
		testInventory = new Inventory(startingMonster);
		fillTestArrays();
	}

	@AfterEach
	void tearDown() throws Exception {
		testInventory = null;
	}

	@Test
	void testAddItem() {
		ArrayList<Item> inventoryItems = testInventory.getItems();
		assertEquals(0, inventoryItems.size());
		
		testInventory.addItem(testItems.get(0));
		assertEquals(1, inventoryItems.size());
		assertEquals(testItems.get(0), inventoryItems.get(0));
		
		testInventory.addItem(testItems.get(1));
		assertEquals(2, inventoryItems.size());
		assertEquals(testItems.get(1), inventoryItems.get(1));
		
		//Add an Item of the same instance
		testInventory.addItem(testItems.get(1));
		assertEquals(2, inventoryItems.size());
		assertEquals(testItems.get(1), inventoryItems.get(1));
		
		//Try adding a null object, size should remain the same
		testInventory.addItem(null);
		assertEquals(2, inventoryItems.size());
		
	}
	
	@Test
	void testRemoveItem() {
		ArrayList<Item> inventoryItems = testInventory.getItems();
		testInventory.addItem(testItems.get(3));
		assertEquals(1, inventoryItems.size());
		
		//Try removing an item that doesn't exist
		testInventory.removeItem(testItems.get(1));
		assertEquals(1, inventoryItems.size());
		
		//Remove the 1 item
		testInventory.removeItem(testItems.get(3));
		assertEquals(0, inventoryItems.size());
		
		//Remove an item from empty inventory
		testInventory.removeItem(testItems.get(0));
		assertEquals(0, inventoryItems.size());
		
	}
	
	@Test
	void testAddMonster() {
		ArrayList<Monster> inventoryMonsters = testInventory.getTeam().getTeam();
		assertEquals(1, inventoryMonsters.size());
		
		testInventory.addMonster(testMonsters.get(0));
		assertEquals(2, inventoryMonsters.size());
		assertEquals(testMonsters.get(0), inventoryMonsters.get(1));
		
		//Try adding the same object twice, shouldn't be possible
		Zombie newZombie = new Zombie();
		testInventory.addMonster(newZombie);
		assertEquals(3, inventoryMonsters.size());
		assertEquals(newZombie, inventoryMonsters.get(0));
		
		testInventory.addMonster(newZombie);
		assertEquals(3, inventoryMonsters.size());
		
		//Try adding a null object
		testInventory.addMonster(null);
		assertEquals(3, inventoryMonsters.size());
	}
	
	@Test
	void testRemoveMonster() {
		ArrayList<Monster> inventoryMonsters = testInventory.getTeam().getTeam();
		assertEquals(1, inventoryMonsters.size());
		
		//Try remove monster that doesn't exist
		testInventory.removeMonster(testMonsters.get(0));
		assertEquals(1, inventoryMonsters.size());
		
		//Try removing null object
		testInventory.removeMonster(null);
		assertEquals(1, inventoryMonsters.size());
		
		//Remove the one object
		testInventory.removeMonster(inventoryMonsters.get(0));
		assertEquals(0, inventoryMonsters.size());
	}
	
	@Test
	void testUseItem() {
		Monster playerMonster = testInventory.getTeam().getTeam().get(0);
		playerMonster.removeHealth(200);
		int monsterHealth = playerMonster.getHealth();
		int monsterSpeed = playerMonster.getSpeed();
		int monsterMaxHealth = playerMonster.getMaxHealth();
		int monsterAttackDamage = playerMonster.getAttackAmount();
		int monsterArmorAmount = playerMonster.getArmorAmount();
		
		//Give inventory a food, speedpotion, weapon and armor
		testInventory.addItem(testItems.get(0));
		testInventory.addItem(testItems.get(1));
		testInventory.addItem(testItems.get(2));
		testInventory.addItem(testItems.get(3));
		
		//Food test
		testInventory.useItem(testInventory.getItems().get(0), playerMonster);
		assertEquals(3, testInventory.getItems().size());
		assertFalse(monsterHealth == playerMonster.getHealth());
		
		monsterHealth = playerMonster.getHealth();
		
		//Armor test
		testInventory.useItem(testInventory.getItems().get(0), playerMonster);
		assertEquals(2, testInventory.getItems().size());
		assertTrue(monsterMaxHealth < playerMonster.getMaxHealth());
		assertTrue(monsterArmorAmount < playerMonster.getArmorAmount());
				
		monsterArmorAmount = playerMonster.getArmorAmount();
		monsterMaxHealth = playerMonster.getMaxHealth();
		
		//SpeedPotion test
		testInventory.useItem(testInventory.getItems().get(0), playerMonster);
		assertEquals(1, testInventory.getItems().size());
		assertFalse(monsterSpeed == playerMonster.getSpeed());
		
		monsterSpeed = playerMonster.getSpeed();
		
		//Weapon test
		testInventory.useItem(testInventory.getItems().get(0), playerMonster);
		assertEquals(0, testInventory.getItems().size());
		assertTrue(monsterAttackDamage < playerMonster.getAttackAmount());
		
		monsterAttackDamage = playerMonster.getAttackAmount();
		
		
		testInventory.addItem(new FlowerCrown());
		
		//Adding a armor ontop of one already equipped
		testInventory.useItem(testInventory.getItems().get(0), playerMonster);
		assertEquals(1, testInventory.getItems().size()); //Tests if old Armor is returned to inventory
		assertTrue(testInventory.getItems().get(0) instanceof Chainmail);
		assertTrue(monsterMaxHealth < playerMonster.getMaxHealth());
		assertTrue(monsterArmorAmount > playerMonster.getArmorAmount());
		
		monsterArmorAmount = playerMonster.getArmorAmount();
		monsterMaxHealth = playerMonster.getMaxHealth();
		
		
		testInventory.addItem(new SledgeHammer());
		
		//Add a new weapon to monster that already has a weapon
		testInventory.useItem(testInventory.getItems().get(1), playerMonster);
		assertEquals(2, testInventory.getItems().size()); //Tests if old Weapon is returned to inventory
		assertTrue(testInventory.getItems().get(1) instanceof SharpStick);
		assertTrue(monsterAttackDamage < playerMonster.getAttackAmount());
	}
}
