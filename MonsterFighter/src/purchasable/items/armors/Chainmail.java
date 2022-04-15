package purchasable.items.armors;

public class Chainmail extends Armor {

	public Chainmail() {
		super("Chainmail", 250, 300);
		setPurchasePrice(60);
		setImgPath("/images/skeleton.png");
		setImg();
	}
}