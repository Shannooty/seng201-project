package player;

import java.util.ArrayList;

import exceptions.TeamFullException;
import gui.GameEnvironment;
import purchasable.monsters.Monster;

/**
 * Class that implements the Team functionality for the Player and sorts the Team by their speed attribute
 * @author Bede Nathan, Celia Allen
 *
 */
public class Team {
	public ArrayList<Monster> team = new ArrayList<Monster>();
	
	public GameEnvironment gameEnvironment;
	
	
	
	public Team(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
	}
	
	
	/**
	 * To access the Team Monster array
	 * @return ArrayList of the Team Monsters
	 */
	public ArrayList<Monster> getTeam() {
		return team;
	}
	
	/**
	 * Adds a monster to the Team unless the Team is full, in which case will throw a TeamFullException
	 * @param monster Monster to be added
	 */
	
	public void add(Monster monster) {
		if (monster != null) {
			if (getTeam().size() == 4) {
				throw new TeamFullException("Team cannot have more than 4 members", gameEnvironment);
			}
			
			if (!getTeam().contains(monster)) {
				getTeam().add(monster);
				refreshOrder();
			}
		}
	}
	
	/**
	 * Removes a specific Monster from the Team
	 * @param monster Monster to be removed
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
	 * @param list
	 */
	private void sort(ArrayList<Monster> list)
    {
        list.sort((o1, o2) -> Integer.compare(o1.getSpeed(), o2.getSpeed()));
    }
}
