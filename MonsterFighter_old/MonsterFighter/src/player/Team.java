package player;

import java.util.ArrayList;

import exceptions.TeamFullException;
import purchasable.monsters.Monster;

/**
 * Class that implements the Team functionality for the Player and sorts the Team by their speed attribute
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class Team {
	
	/**
	 * Attribute team, of type ArrayList[Monster]. The player's team of Monsters.
	 */
	private ArrayList<Monster> team = new ArrayList<Monster>();
	
	/**
	 * To access the Team Monster array
	 * @return team, of type ArrayList. The team of Monsters
	 */
	public ArrayList<Monster> getTeam() {
		return team;
	}
	
	/**
	 * Adds a monster to the Team unless the Team is full, in which case will throw a TeamFullException
	 * @param monster, of type Monster. The Monster to be added
	 */
	
	public void add(Monster monster) {
		if (monster != null) {
			if (getTeam().size() == 4) {
				throw new TeamFullException("Team cannot have more than 4 members.");
			}
			
			if (!getTeam().contains(monster)) {
				getTeam().add(monster);
				refreshOrder();
			}
		}
	}
	
	/**
	 * Removes a specific Monster from the Team
	 * @param monster, of type Monster. The Monster to be removed
	 */
	public void remove(Monster monster) {
		getTeam().remove(monster);
		refreshOrder();
	}
	
	/**
	 * Refreshes the team order when adding or removing Monsters
	 */
	public void refreshOrder() {
		sort(getTeam());
	}
	
	/**
	 * Gives the size of the team
	 * @return Size of team
	 */
	public int size() {
		return getTeam().size();
	}
	
	/**
	 * Does the sorting for the team
	 * @param list, of type ArrayList[Monster]
	 */
	private void sort(ArrayList<Monster> list)
    {
		list.sort((o2, o1) -> Integer.compare(o1.getSpeed(), o2.getSpeed()));
    }
}
