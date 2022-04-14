package player;

import java.util.ArrayList;

import purchasable.monsters.Monster;

public class Team {
	public ArrayList<Monster> team = new ArrayList<Monster>();
	
	public ArrayList<Monster> getTeam() {
		return team;
	}
	
	public void add(Monster monster) {
		if (monster != null) {
			if (!getTeam().contains(monster)) {
				getTeam().add(monster);
				refreshOrder();
			}
		}
	}
	
	public void remove(Monster monster) {
		getTeam().remove(monster);
		refreshOrder();
	}
	
	public void refreshOrder() {
//		getTeam().sort(null);
		sort(getTeam());
	}
	
	public void sort(ArrayList<Monster> list)
    {
        list.sort((o1, o2) -> Integer.compare(o1.getSpeed(), o2.getSpeed()));
    }
}
