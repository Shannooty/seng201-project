package purchasable.items;

import purchasable.Purchasable;
import purchasable.monsters.*;

public abstract class Item extends Purchasable {
	
	public Item(String name) {
		super(name);
	}
	
	
	public abstract Item use(Monster monster);
	
	
	public String toString() {
		return "Type: "+ getClass()+"\nName: " + getName()+"\n\nPrice: "+getPurchasePrice();
	}

}
