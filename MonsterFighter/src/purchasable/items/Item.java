package purchasable.items;

import purchasable.Purchasable;
import purchasable.monsters.*;

public abstract class Item extends Purchasable {
	private String itemName;
	
	public Item(String name) {
		setItemName(name);
	}
	
	public void setItemName(String name) {
		itemName = name;
	}
	
	public String getitemName() {
		return itemName;
	}
	
	public abstract Item use(Monster monster);
}
