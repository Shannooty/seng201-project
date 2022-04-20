package day;
import java.util.ArrayList;

import shop.Shop;
import gui.GameEnvironment;
import player.Team;

public class Day {
	
	private int dayNumber;
	private Shop todaysShop;
	private ArrayList<Battle> todaysBattles = new ArrayList<Battle>();
	private String difficulty;
	private GameEnvironment gameEnvironment;
	private Team team;
	private int pointsEarnedToday = 0;
	private double goldEarnedToday = 0;
	
	public Day(GameEnvironment gameEnvironment) {
		team = gameEnvironment.getPlayer().getInventory().getTeam();
		
		this.gameEnvironment = gameEnvironment;
		difficulty = gameEnvironment.getGameDifficulty();		
		setDayNumber(gameEnvironment.getDayNumber());
		
		
		todaysShop = new Shop(3, 5); //parameters could be randomized
		createDailyBattles(5);
	}
	
	private void setDayNumber(int dayNum) {
		dayNumber = dayNum;
	}
	
	private void createDailyBattles(int numOfBattles) {
		for (int i = 0; i < numOfBattles; i++) {
			todaysBattles.add(new Battle(gameEnvironment));
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
	
	
	public void setGoldEarnedToday(double gold) {
		goldEarnedToday += gold;
	}
	
	public double getGoldEarnedToday() {
		return goldEarnedToday;
	}
	
	public void setPointsEarnedToday(int points) {
		pointsEarnedToday += points;
	}
	
	public int getPointsEarnedToday() {
		return pointsEarnedToday;
	}
	
	

}
