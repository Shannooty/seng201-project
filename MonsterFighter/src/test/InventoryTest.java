package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inventory.Inventory;
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
		testItems.add(new FlowerCrown());
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
		
		//Remove an item from emtpy inventory
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
		assertEquals(newZombie, inventoryMonsters.get(2));
		
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
}
