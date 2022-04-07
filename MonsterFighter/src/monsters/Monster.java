package monsters;

import items.armors.Armor;
import interfaces.Purchasable;
import items.weapons.Weapon;



public class Monster implements Purchasable {
	
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

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPurchasePrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSellPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDescription() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPurchasePrice(double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSellBackPrice(double price) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
