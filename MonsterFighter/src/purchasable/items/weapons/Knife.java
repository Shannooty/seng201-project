package purchasable.items.weapons;

public class Knife extends Weapon{

	public Knife() {
		super("Knife", 60);
		setPurchasePrice(17);
		setSellPrice(17);
		setImgPath("/images/knife.png");
		setImg();
	}
}
