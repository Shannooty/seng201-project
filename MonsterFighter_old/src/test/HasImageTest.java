package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import purchasable.monsters.*;

class HasImageTest {
	
	private Monster testMonster;
	
	@BeforeEach
	void setUp() throws Exception {
		testMonster = new Slime();
	}

	@AfterEach
	void tearDown() throws Exception {
		testMonster = null;
	}

	@Test
	void testSetImg() {
		testMonster.setImgPath("/images/slime.png");
		testMonster.setImg();
		assertTrue(testMonster.getImg() instanceof ImageIcon);
		
		testMonster.setImgPath("/images/non_exsistant_file.png");
		assertThrows(NullPointerException.class, () -> {testMonster.setImg();});
	}

}
