package purchasable.items;

import exceptions.InsufficientGoldException;
import player.Player;
import purchasable.Purchasable;
import purchasable.items.armors.Armor;
import purchasable.items.food.Food;
import purchasable.items.weapons.Weapon;
import purchasable.monsters.*;

/**
 * Class Item extends the class Purchasable. Items can be buoght by the player from the Shop.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public abstract class Item extends Purchasable {
	
	/**
	 * Constructor for the class Item. Calls the constructor of the superclass Purchasable, giving the parametre name.
	 * @param name, of type String. The name of the object.
	 */
	public Item(String name) {
		super(name);
	}
	
	/**
	 * Lets the player buy an item, throws InsufficientGoldException if the player does not have enough gold to purchase the item
	 * @param player, of type Player. The player trying to buy the item.
	 */
	@Override
	public void buy(Player player) throws InsufficientGoldException {
		player.removeGold(getPurchasePrice());
		player.getInventory().addItem(this);
	}
	
	/**
	 * Lets the player sell an item. 
	 * @param player, of type Player. The player trying to sell the item.
	 */
	@Override
	public void sell(Player player) {
		player.addGold(getSellPrice());
		player.getInventory().removeItem(this);
	}
	
	/**
	 * Abstract method use, for the player to use an item that they have bought.
	 * @param monster, of type Monster. The monster to use the item on.
	 * @return an Item.
	 */
	public abstract Item use(Monster monster);
	
	/**
	 * Creates a description for the item
	 * @return description, of type String.
	 */
	public String createDescription() {
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
					
		return "Name: " + getName()+"\n\n"+effect;
	}
	
	/**
	 * Returns a String description of the item, specifically for when the user owns the item.
	 * @return a String, the description.
	 */
	public String getSellBackDescription() {
		String description = createDescription();
		return description+"\n\nSell-back Price: "+getPurchasePrice();
	}
	
	/**
	 * Returns a String description of the item, specifically for when the user does not own the item.
	 * @return a String, the description.
	 */
	public String getBuyDescription() {
		String description = createDescription();
		return description+"\n\nPrice: "+getPurchasePrice();
	}

}
