package random_event;
import java.util.Random;
import inventory.Inventory;
import monsters.Monster;

public class NewMonsterJoins extends RandomEvent {

	
	Random random = new Random();
	private String[] monsterNames = {"DefaultBlobOne", "DefaultBlobTwo", "DefaultBlobThree", "DefaultBlobFour", "kevin"};
	private int[] monsterHealth = {900, 750, 1000, 500, 850};
	private int[] monsterAttack = {900, 750, 1000, 500, 850};
	private int[] monsterSpeeds = {45, 50, 55, 35, 30, 27};
	
	
	public NewMonsterJoins() {
		createMonster();
	}
	
	public void createMonster() {
		
		String name = monsterNames[(random.nextInt(monsterNames.length))];
		int health = monsterHealth[(random.nextInt(monsterHealth.length))];
		int attack = monsterAttack[(random.nextInt(monsterAttack.length))];
		int speed = monsterSpeeds[(random.nextInt(monsterSpeeds.length))];
		Monster newMonster = new Monster(name, health, attack, speed);
		Inventory.team.add(newMonster);
		addMonster(newMonster);
	}
	
	public void addMonster(Monster monster) {
		Inventory.team.add(monster);
	}
}
