package items;

public abstract class Item {
	private String itemName;
	
	public Item(String name) {
		setItemName(name);
	}
	
	public void setItemName(String name) {
		itemName = name;
	}
	
	public String getitemName() {
		return name;
	}
}
