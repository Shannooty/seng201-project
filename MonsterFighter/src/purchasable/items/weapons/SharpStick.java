package purchasable.items.weapons;


public class SharpStick extends Weapon {

	public SharpStick() {
		super("Sharp Stick", 50);
		setPurchasePrice(12);
		setSellPrice(12);
		setImgPath("/images/sharpStick.png");
		setImg();
	}

}
