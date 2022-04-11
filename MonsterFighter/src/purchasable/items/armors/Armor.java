package purchasable.items.armors;

import purchasable.items.Item;
import purchasable.monsters.Monster;

public class Armor extends Item {
	
	private int maxHealthIncrease;
	private int armorIncrease;
	
	public Armor(String name, int healthIncrease, int armorAmount) {
		super(name);
		maxHealthIncrease = healthIncrease;
		this.armorIncrease = armorAmount;
	}
	
	public int getHealthIncrease() {
		return maxHealthIncrease;
	}
	
	public int getArmorIncrease() {
		return armorIncrease;
	}
	
	@Override
	public Item use(Monster monster) {
		
		Armor oldArmor = monster.addArmor(this);
		return oldArmor;

	}

}
