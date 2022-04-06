package items.weapons;

import items.Item;
import monsters.Monster;

public class Weapon extends Item {
	
	private int attackIncrease;
	
	public Weapon(String name, int damage) {
		super(name);
		attackIncrease = damage;
	}
	
	public int getDamage() {
		return attackIncrease;
	}
	
	@Override
	public Weapon use(Monster monster) {
		
		Weapon oldWeapon = monster.addWeapon(this);
		return oldWeapon;

	}
	

}
