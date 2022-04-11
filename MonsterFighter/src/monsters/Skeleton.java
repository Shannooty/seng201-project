package monsters;

public class Skeleton extends Monster {
	
	
	
	public Skeleton() {
		super("Bare Bones", 600, 350, 35);
		setImgPath("/images/skeleton.png");
		setImg();
		setHealAmount(200);
		setMonsterType("Skeleton");
	}
	
}
