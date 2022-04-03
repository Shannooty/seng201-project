package items;

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
	public void use(Monster monster) {
		// TODO Auto-generated method stub

	}
	
	public void remove(Monster monster) {
		//TODO
	}

}
