package purchasable.items.food;

import purchasable.items.Item;
import purchasable.monsters.Monster;

public class Food extends Item {
	
	private int healAmount;
	
	
	public Food(String itemName) {
		super(itemName);
	}
	
	public int getHealAmount() {
		return healAmount;
	}
	
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
	@Override
	public Item use(Monster monster) {
		monster.addHealth(getHealAmount());
		return null;
	}

}
