package purchasable.items;

import player.Player;
import purchasable.Purchasable;
import purchasable.monsters.*;

public abstract class Item extends Purchasable {
	
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
	
	
	public String toString() {
		return "Type: "+ getClass()+"\nName: " + getName()+"\n\nPrice: "+getPurchasePrice();
	}

}
