package purchasable.items.food;

public class Mushroom extends Food {
	public Mushroom() {
		super("Mushroom");
		setHealAmount(70);
		setPurchasePrice(10);
		setSellPrice(10);
		setImgPath("/images/skeleton.png");
		setImg();
	}
}
