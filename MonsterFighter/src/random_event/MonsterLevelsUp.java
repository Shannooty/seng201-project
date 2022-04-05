package random_event;
import java.util.Random;
import inventory.Inventory;
import monsters.Monster;

public class MonsterLevelsUp extends RandomEvent {
	
	Random random = new Random();
	private int[] healthIncrease = {10, 5, 8, 15, 30};
	
	public MonsterLevelsUp() {
		levelUpSetUp();
	}
	
	public void levelUpSetUp() {
		int health = healthIncrease[(random.nextInt(healthIncrease.length))];
		Monster monster = Inventory.team.get(random.nextInt(Inventory.team.size()));
		heal(health, monster);
	}
	
	public void heal(int health, Monster monster) {
		monster.addMaxHealth(health);
	}

}
