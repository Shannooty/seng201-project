package purchasable.monsters;

import javax.swing.ImageIcon;

import purchasable.Purchasable;
import purchasable.items.armors.Armor;
import purchasable.items.weapons.Weapon;



public abstract class Monster extends Purchasable {
	
	private String name;
	private int health;
	private int maxHealth;
	private int armorAmount = 0;
	private int healAmount;
	private int attackAmount;
	private int speed;
	private boolean isStunned = false;
	private Weapon weaponSlot = null;
	private Armor armorSlot = null;
	private String imgPath;
	private ImageIcon img;
	private String monsterType;
	
	
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
	
	
	public void addMaxHealth(int healthIncrease) {
		maxHealth = getMaxHealth() + healthIncrease;
	}
	
	public void removeMaxHealth(int healthDecrease) {
		maxHealth = getMaxHealth() - healthDecrease;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount; 
	}
	
	public int getHealAmount() {
		return healAmount;
	}
	
	public void addArmorAmount(int armourIncrease) {
		armorAmount = getArmorAmount() + armourIncrease;
	}
	
	public void removeArmorAmount(int armourDecrease) {
		armorAmount = getArmorAmount() - armourDecrease;
	}
	
	public int getArmorAmount() {
		return armorAmount;
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
	
	public void setMonsterType(String type) {
		monsterType = type;
	}
	
	public String getMonsterType() {
		return monsterType;
	}
	
	public void addAttackAmount(int attackIncrease) {
		attackAmount += attackIncrease;
	}
	
	public void removeAttackAmount(int attackDecrease) {
		attackAmount -= attackDecrease;
	}
	
	public int getAttackAmount() {
		return attackAmount;
	}
	
	public boolean getStunnedStatus() {
		return isStunned;
	}
	
	public void setStunnedStatus(boolean status) {
		isStunned = status;
	}
	
	public void sleep() {
		addHealth(getHealAmount());
		
	}
	
	public Weapon addWeapon(Weapon weapon) {
		Weapon oldWeapon = removeWeapon();
		weaponSlot = weapon;
		addAttackAmount(weapon.getDamage());
		
		return oldWeapon;
	}
	
	public Weapon removeWeapon() {
		Weapon weapon = weaponSlot;
		weaponSlot = null;
		removeAttackAmount(weapon.getDamage());
		
		return weapon;
	}
	
	public Armor addArmor(Armor armor) {
		Armor oldArmor = removeArmor();
		armorSlot = armor;
		addMaxHealth(armor.getHealthIncrease());
		addArmorAmount(armor.getArmorIncrease());
		
		return oldArmor;
	}
	
	public Armor removeArmor() {
		Armor armor = armorSlot;
		armorSlot = null;
		removeMaxHealth(armor.getHealthIncrease());
		removeArmorAmount(armor.getArmorIncrease());
		
		return armor;
	}

	public ImageIcon getImg() {
		return img;
	}
	
	public void setImg() {
		this.img = new ImageIcon(Monster.class.getResource(imgPath));
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	public String toString() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "Type: "+type+"\nName: "+getName()+"\nHealth: "+getHealth()+"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed();
	}
	
	public String getDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return type+": "+getName();
	}
	
	
}
