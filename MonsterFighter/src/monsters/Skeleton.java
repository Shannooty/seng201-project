package monsters;

public class Skeleton extends Monster {
	
	private static String imgPath = "/images/skeleton.png";
	
	public Skeleton() {
		super("Bare Bones", 600, 350, 35);
		setImgPath(Skeleton.imgPath);
		setHealAmount(200);
	}
	
}
