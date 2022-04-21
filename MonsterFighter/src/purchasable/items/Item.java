package purchasable.items;

import player.Player;
import purchasable.Purchasable;
import purchasable.items.armors.Armor;
import purchasable.items.food.Food;
import purchasable.items.weapons.Weapon;
import purchasable.monsters.*;

public abstract class Item extends Purchasable {
	
	private boolean equipped = false;
	
	public Item(String name) {
		super(name);
	}
	
	@Override
	public void buy(Player player) {
		player.removeGold(getPurchasePrice());
		player.getInventory().addItem(this);
	}
	
	@Override
	public void sell(Player player) {
		player.addGold(getSellPrice());
		player.getInventory().removeItem(this);
	}
	
	public abstract Item use(Monster monster);
	
	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}
	
	public boolean getEquipped() {
		return equipped;
	}
	
	public String createDescription() {
		String type = (String.valueOf(getClass()).split("\\."))[2];
		String typeEdited = (type.substring(0, 1).toUpperCase() + type.substring(1, type.length())).replaceAll("s", "");
		String effect = "";
		
		if (this instanceof Food) {
			effect = "Heal: " + Integer.toString(((Food) this).getHealAmount());
		} else if (this instanceof Weapon) {
			effect = "Increase attack damage: " +Integer.toString(((Weapon) this).getDamage());
		} else if (this instanceof Armor) {
			effect = "Increase armor: "+Integer.toString(((Armor) this).getArmorIncrease());
			effect += "\nIncrease maximum health: "+Integer.toString(((Armor) this).getHealthIncrease());
		} else if (this instanceof SpeedPotion) {
			effect = "Increase speed: "+Integer.toString(((SpeedPotion) this).getSpeedIncrease());
		}
			

		
		return "Type: "+typeEdited+"\nName: " + getName()+"\n\n"+effect+"\n\nEquipped: "+getEquipped();
	}
	
	public String getSellBackDescription() {
		String description = createDescription();
		return description+"\n\nSell-back Price: "+getPurchasePrice();
	}
	
	public String getBuyDescription() {
		String description = createDescription();
		return description+"\n\nPrice: "+getPurchasePrice();
	}

}
