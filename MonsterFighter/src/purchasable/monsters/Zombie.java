package purchasable.monsters;

public class Zombie extends Monster {
	
	public Zombie() {
		super("SENG-201 Student", 1000, 200, 30);
		setImgPath("/images/zombie.png");
		setImg();
		setHealAmount(1000);
		setMonsterType("zombie");
		setPurchasePrice(75);
		setSellPrice(75);
	}
	
}
