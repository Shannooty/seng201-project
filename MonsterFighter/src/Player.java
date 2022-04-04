
public class Player {
	
	
	private String name;
	private double goldAmount = 0;
	private int currentPoints = 0;
//	private Inventory inventory;
//	private Team team;
	
	
	
	public String getName() {
		return name;
	}
	
	
	private void setName(String newName) {
		name = newName;
	}
	
	private double getGoldAmount() {
		return goldAmount;
	}
	
	private void addGold(double gold) {
		goldAmount += gold;
	}
	
	private void removeGold(double gold) {
		goldAmount -= gold;
	}
	
	private int getPoints() {
		return currentPoints;
	}
	
	private void addPoints(int points) {
		currentPoints += points;
	}
	

}
