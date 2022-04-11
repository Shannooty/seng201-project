package day;
import java.util.ArrayList;

import shop.Shop;

public class Day {
	
	private int dayNumber;
	private Shop todaysShop;
	private ArrayList<Battle> todaysBattles = new ArrayList<Battle>();
	
	public Day(int dayNumber) {
		setDayNumber(dayNumber);
		todaysShop = new Shop(3, 5); //parameters could be randomized
		createDailyBattles(5);
	}
	
	private void setDayNumber(int dayNum) {
		dayNumber = dayNum;
	}
	
	private void createDailyBattles(int numOfBattles) {
		for (int i = 0; i < numOfBattles; i++) {
			todaysBattles.add(new Battle());
		}
	}
	
	public void viewShop() {
//		open shop window
//		testing
//		testing again
//		testing once more
	}
	
	public void sleep() {
//		create instance of RandomEvent
		
	}
	
	public void battle() {
//		create instance of Battle
	}
	
	

}
