package monsters;

public class Slime extends Monster {
	
	public Slime() {
		super("Slimey Boy", 750, 300, 20);
		setImgPath("/images/slime.png");
		setImg();
		setHealAmount(300);
	}
	
}
