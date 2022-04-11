package purchasable.items;

import purchasable.monsters.Monster;

public class SpeedPotion extends Item {
	
	private int speedIncrease = 10;
	
	public SpeedPotion() {
		super("Speed Potion");
	}
	
	public int getSpeedIncrease() {
		return speedIncrease;
	}
	
	@Override
	public Item use(Monster monster) {
		monster.addSpeed(getSpeedIncrease());
		return null;
	}

}
