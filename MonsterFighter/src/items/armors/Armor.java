package items.armors;

import items.Item;
import monsters.Monster;

public class Armor extends Item {
	
	private int maxHealthIncrease;
	private int damageDecrease;
	
	public Armor(String name, int healthIncrease, int damageReduction) {
		super(name);
		maxHealthIncrease = healthIncrease;
		damageDecrease = damageReduction;
	}
	
	public int getHealthIncrease() {
		return maxHealthIncrease;
	}
	
	public int getDamageDecrease() {
		return damageDecrease;
	}
	
	@Override
	public void use(Monster monster) {
		boolean successful;
		successful = monster.addArmor(this);
		// do something useful if monster already has an armor piece equipped

	}

}
