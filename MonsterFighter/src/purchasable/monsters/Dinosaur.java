package purchasable.monsters;

public class Dinosaur extends Monster {
	
	public Dinosaur() {
		super("Rexter", 800, 400, 12);
		setImgPath("/images/dinosaur.png");
		setImg();
		setHealAmount(400);
		setMonsterType("dinosaur");
		setPurchasePrice(75);
		setSellPrice(75);
	}
}
