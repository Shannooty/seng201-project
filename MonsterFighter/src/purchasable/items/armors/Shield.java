package purchasable.items.armors;

public class Shield extends Armor {

	public Shield() {
		super("Shield", 200, 100);
		setPurchasePrice(30);
		setImgPath("/images/skeleton.png");
		setImg();
	}
}
