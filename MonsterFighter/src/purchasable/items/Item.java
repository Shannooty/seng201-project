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
	
	public String getItemName() {
		return itemName;
	}
	
	public abstract Item use(Monster monster);
	
	
	public String toString() {
		return "Type: "+ getClass()+"\nName: " + getItemName()+"\n\nPrice: "+getPurchasePrice();
	}
}
