package monsters;

public abstract class Monster {
	
	private String name;
	private int health;
	private int maxHealth;
	private int armourAmount;
	private int healAmount;
	private int attackAmount;
	private int speed;
	private boolean isStunned = false;
	private boolean hasWeapon = false;
	private boolean hasArmour = false;
	private Weapon weaponSlot = null;
	private Armour armourSlot = null;
	
	
	public Monster(String name, int maxHealth, int attackAmount, int speed) {
		setName(name);
		this.attackAmount = attackAmount;
		this.maxHealth = maxHealth;
		health = maxHealth;
		this.speed = speed;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addHealth(int healAmount) {
		health = getHealth() + healAmount;
	}
	
	public void removeHealth(int damage) {
		health = getHealth() - damage;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void addArmour(int armourIncrease) {
		armourAmount = getArmour() + armourIncrease;
	}
	
	public void removeArmour(int armourDecrease) {
		armourAmount = getArmour() - armourDecrease;
	}
	
	public int getArmour() {
		return armourAmount;
	}
	
	public void addSpeed(int speedIncrease) {
		speed = getSpeed() + speedIncrease;
	}
	
	public void removeSpeed(int speedDecrease) {
		speed = getSpeed() - speedDecrease;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void sleep() {
		addHealth(healAmount);
		
	}
	
	public int getAttackAmount() {
		int weaponDamage = 0;
		
		if (hasWeapon) {
			weaponDamage = weaponSlot.getDamage();
		}
		
		return attackAmount + weaponDamage;
	}
	
	public boolean addWeapon(Weapon weapon) {
		if (hasWeapon) {
			return false;
		} else {
			hasWeapon = true;
			weaponSlot = weapon;
		}
	}
	
	public Weapon removeWeapon() {
		Weapon weapon = weaponSlot;
		weaponSlot = null;
		hasWeapon = false;
		return weapon;
	}
	
	public Armour addArmour(Armour armour) {
		if (hasArmour) {
			return false;
		} else {
			armourSlot = armour;
			hasArmour = true;
			return true;
		}
	}
	
}
