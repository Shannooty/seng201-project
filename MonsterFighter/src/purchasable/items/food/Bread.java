package purchasable.items.food;

public class Bread extends Food {
	
	public Bread() {
		super("Bread");
		setHealAmount(120);
		setPurchasePrice(17);
		setSellPrice(17);
		setImgPath("/images/bread.png");
		setImg();
	}

}
