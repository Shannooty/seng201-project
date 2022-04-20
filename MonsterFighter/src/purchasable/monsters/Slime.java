package purchasable.monsters;

public class Slime extends Monster {
	
	public Slime() {
		super("Slimey Boy", 750, 300, 20);
		setImgPath("/images/slime.png");
		setImg();
		setHealAmount(300);
		setMonsterType("slime");
		setPurchasePrice(65);
		setSellPrice(65);
	}
}
