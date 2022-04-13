package player;

import java.util.ArrayList;

import purchasable.monsters.Monster;

public class Team {
	public ArrayList<Monster> team = new ArrayList<Monster>();
	
	public ArrayList<Monster> getTeam() {
		return team;
	}
	
	public void add(Monster monster) {
		getTeam().add(monster);
		refreshOrder();
	}
	
	public void remove(Monster monster) {
		getTeam().remove(monster);
		refreshOrder();
	}
	
	public void refreshOrder() {
		getTeam().sort(null);
	}
}
