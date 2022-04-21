package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import player.Player;
import purchasable.items.Item;
import purchasable.monsters.Monster;
import purchasable.monsters.Slime;
import shop.Shop;

class ShopTest {
	
	private Shop testShop;
	private Player testPlayer;
	
	@BeforeEach
	void setUp() throws Exception {
		testShop = new Shop(5,5);
		testPlayer = new Player("Crash Test Dummy", new Slime());
	}

	@AfterEach
	void tearDown() throws Exception {
		testShop = null;
		testPlayer = null;
	}

	@Test
	void testPurchase() {
		Monster selectedMonster = testShop.getAvalibleMonsters().get(0);
		Item selectedItem = testShop.getAvalibleItems().get(0);
		testPlayer.addGold(10000);
		
		
		testShop.purchase(selectedMonster, testPlayer);
		assertEquals(4, testShop.getAvalibleMonsters().size());
		
		testShop.purchase(selectedItem, testPlayer);
		assertEquals(4, testShop.getAvalibleMonsters().size());
	}

}
