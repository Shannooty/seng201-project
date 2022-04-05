import java.util.ArrayList;


//needs classes Item and Monster

public class Inventory {
	
	public ArrayList<Item> ownedItems = new ArrayList<Items>;
	public ArrayList<Monster> team = new ArrayList<Monster>;
	
	public void removeItem(Item item) {
		ownedItems.remove(item);
	}
	
	public void addItem(Item item) {
		ownedItems.add(item);
	}
	
	public void removeMonster(Monster monster) {
		team.remove(monster);
	}
	
	public void addMonster(Monster monster) {
		team.add(monster);
	}

}
