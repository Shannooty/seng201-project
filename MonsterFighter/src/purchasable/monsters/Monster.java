package purchasable.monsters;

import java.util.Comparator;

import player.Player;
import purchasable.Purchasable;
import purchasable.items.armors.Armor;
import purchasable.items.weapons.Weapon;

/**
 * 
 * @author Bede Nathan, Celia Allen
 * 
 * <p>An abstract Monster class that contains all the attributes and methods for all Monster types.
 */

public abstract class Monster extends Purchasable implements Comparator<Monster> {
	
	private int health;
	private int maxHealth;
	private int armorAmount = 0;
	private int healAmount;
	private int attackAmount;
	private int speed;
	private boolean isStunned = false;
	private Weapon weaponSlot = null;
	private Armor armorSlot = null;
	private String monsterType;
	
	/**
	 * Main constructor for the abstract superclass of Monster
	 * 
	 * @param name Sets the name
	 * @param maxHealth Sets the maximum health
	 * @param attackAmount Sets the base attack damage
	 * @param speed Sets the base speed (determines attack order)
	 */
	public Monster(String name, int maxHealth, int attackAmount, int speed) {
		super(name);
		this.attackAmount = attackAmount;
		this.maxHealth = maxHealth;
		health = maxHealth;
		this.speed = speed;
		
	}
	
	/**
	 * Heals the unit by the inputed healAmount
	 * @param healAmount amount of health the monster will be healed by
	 */
	public void addHealth(int healAmount) {
		health = getHealth() + healAmount;
	}
	
	/**
	 * Removes health from the monster when damaged
	 * @param damage damage dealt to the monster
	 */
	public void removeHealth(int damage) {
		health = getHealth() - damage;
	}
	
	/**
	 * Returns the monsters current health
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Increases the monsters maximum health limit
	 * @param healthIncrease the value to increase the monsters max health by
	 */
	public void addMaxHealth(int healthIncrease) {
		maxHealth = getMaxHealth() + healthIncrease;
	}
	
	/**
	 * Decreases the monsters maximum health limit
	 * @param healthDecrease the value to decrease maxHealth by
	 */
	public void removeMaxHealth(int healthDecrease) {
		maxHealth = getMaxHealth() - healthDecrease;
	}
	
	/**
	 * Returns the maximum health value
	 * @return maxHealth
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Sets the amount a monster heals by while sleeping
	 * @param healAmount amount to heal by
	 */
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount; 
	}
	
	/**
	 * Returns the heal amount for a monster
	 * @return healAmount
	 */
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
	
	
    public void setInitialID() {
    	super.instanceId = 0;
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
	
	public String toString() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "\nType: "+type+"\nHealth: "+getHealth()+"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed();
	}
	
	public String getDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return type+": "+getName()+" "+getID();
	}
	
	public String getSellBackDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "Type: "+type+"\nName: "+getName()+"\n\nHealth: "+getHealth()+"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed()+"\n\nSell-back Price: "+getPurchasePrice();
	}
	
	public String getBuyDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "Type: "+type+"\nName: "+getName()+"\n\nHealth: "+getHealth()+"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed()+"\n\nPrice: "+getPurchasePrice();
	}
	
	
	@Override
	public void buy(Player player) {
		player.removeGold(this.getPurchasePrice());
		player.getInventory().addMonster(this);
	}
	
	@Override
	public void sell(Player player) {
		player.addGold(getSellPrice());
		player.getInventory().removeMonster(this);
	}
	
	@Override
	public int compare(Monster monster1, Monster monster2) {
		int monsterSpeed1 = monster1.getSpeed();
		int monsterSpeed2 = monster2.getSpeed();
		
		if (monsterSpeed1 > monsterSpeed2) {
			return 1;
		} else if (monsterSpeed1 < monsterSpeed2) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
