package purchasable.monsters;

public class UndeadGuard extends Monster {
	
	public UndeadGuard() {
		super("Royal Guard #7", 1200, 100, 15);
		setImgPath("/images/undead_guard.png");
		setImg();
		setHealAmount(400);
		addArmorAmount(100);
		setMonsterType("undeadGuard");
		setPurchasePrice(70);
	}
	
}
