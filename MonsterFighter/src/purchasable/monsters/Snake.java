package purchasable.monsters;

public class Snake extends Monster {
	
	public Snake() {
		super("Snek", 700, 320, 18);
		setImgPath("/images/snake.png");
		setImg();
		setHealAmount(320);
		setMonsterType("snake");
		setPurchasePrice(65);
		setSellPrice(65);
	}
}
