package purchasable.items.food;

public class Apple extends Food {
	
	public Apple() {
		super("Apple");
		setHealAmount(100);
		setPurchasePrice(15);
		setSellPrice(15);
		setImgPath("/images/skeleton.png");
		setImg();
	}
}
