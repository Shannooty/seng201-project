package random_event;
import java.util.Random;

import inventory.Inventory;

public class MonsterLeaves extends RandomEvent {

	Random random = new Random();

	public MonsterLeaves() {
		removeMonster();
	}
	
	public void removeMonster() {
		Inventory.team.remove(random.nextInt(Inventory.team.size()));
	}
	

}
