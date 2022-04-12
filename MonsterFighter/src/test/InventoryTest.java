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
	
	
	public void fillTestArrays() {
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
	void test() {
		fail("Not yet implemented");
	}

}
