package day;
import java.util.ArrayList;

import shop.Shop;

public class Day {
	
	private int dayNumber;
	private Shop todaysShop;
	private ArrayList<Battle> todaysBattles = new ArrayList<Battle>();
	private String difficulty;
	
	public Day(int dayNumber, String difficulty) {
		this.difficulty = difficulty;
		setDayNumber(dayNumber);
		todaysShop = new Shop(3, 5); //parameters could be randomized
		createDailyBattles(5);
	}
	
	private void setDayNumber(int dayNum) {
		dayNumber = dayNum;
	}
	
	private void createDailyBattles(int numOfBattles) {
		for (int i = 0; i < numOfBattles; i++) {
			todaysBattles.add(new Battle(difficulty));
		}
	}
	
	public ArrayList<Battle> getBattles(){
		return todaysBattles;
	}
	
	
	public void setTodaysShop(Shop shop) {
		todaysShop = shop;
	}
	
	public Shop getTodaysShop() {
		return todaysShop;
	}
	
	public int getDayNumber() {
		return dayNumber;
		
	}
	
	public void battle() {
//		create instance of Battle
	}
	
	

}
