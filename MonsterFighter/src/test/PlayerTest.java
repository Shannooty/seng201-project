package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.InsufficientGoldException;
import exceptions.NegativeValueException;
import inventory.Inventory;
import player.Player;

class PlayerTest {
	
	private Player testPlayer;
	
	@BeforeEach
	void setUp() throws Exception {
		testPlayer = new Player("Test dummy", null);
	}

	@AfterEach
	void tearDown() throws Exception {
		testPlayer = null;
	}

	@Test
	void testAddGold() {
		testPlayer.addGold(1000);
		assertEquals(1000, testPlayer.getGoldAmount());
		
		//Testing negative values, should be no change
		NegativeValueException negativeValueException = assertThrows(NegativeValueException.class, 
				() -> testPlayer.addGold(-100));

		assertEquals("Cannot add negative gold", negativeValueException.getMessage());
		assertEquals(1000, testPlayer.getGoldAmount());
		
		//Testing 0 value
		testPlayer.addGold(0);
		assertEquals(1000, testPlayer.getGoldAmount());
	}
	
	@Test
	void testRemoveGold() {
		testPlayer.addGold(1000);
		
		testPlayer.removeGold(500);
		assertEquals(500, testPlayer.getGoldAmount());
		
		//Removing more gold than what's available
		InsufficientGoldException insufficientGoldException = assertThrows(InsufficientGoldException.class,
				() -> testPlayer.removeGold(1000));
		
		assertEquals("Insufficient Gold", insufficientGoldException.getMessage());
		assertEquals(500, testPlayer.getGoldAmount());
		
		//Testing removing negative gold
		NegativeValueException negativeValueException = assertThrows(NegativeValueException.class, 
				() -> testPlayer.removeGold(-300));
		
		assertEquals("Cannot remove negative gold", negativeValueException.getMessage());
		assertEquals(500, testPlayer.getGoldAmount());
		
	}
	
	@Test
	void testGetInventory() {
		Inventory inventory = testPlayer.getInventory();
		assertNotNull(inventory);
	}

}
