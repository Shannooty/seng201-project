package purchasable.monsters;

import java.util.ArrayList;
import java.util.Comparator;

import exceptions.InsufficientGoldException;
import exceptions.NegativeValueException;
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
	private ArrayList<String> equipped = new ArrayList<String>();
	public static int armorModifier = 4;
	
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
		if(healAmount < 0) {
			throw new NegativeValueException("Cannot add negative health");
		} else if ((health + healAmount) > maxHealth) {
			health = maxHealth;
		} else {
			health = getHealth() + healAmount;
		}		
		
		if (health != 0) {
			isStunned = false;
		}
	}
	
	/**
	 * Removes health from the monster when damaged
	 * @param damage damage dealt to the monster
	 */
	public void removeHealth(int rawDamage) {
		int damage = rawDamage - (getArmorAmount() / Monster.armorModifier);
		
		if (damage < 0) {
			damage = 0;
		}
		
		if(rawDamage < 0) {
			throw new NegativeValueException("Cannot remove negative health");
		} else if ((health - damage) < 0) {
			health = 0;
			isStunned = true;
		} else {
			health = getHealth() - damage;
		}
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
		if (healthIncrease < 0) {
			throw new NegativeValueException("Cannot add negative health");
		} else {
			maxHealth = getMaxHealth() + healthIncrease;
			
			if (maxHealth < 0) {
				maxHealth = Integer.MAX_VALUE;
			}
		}	
	}
	
	/**
	 * Decreases the monsters maximum health limit
	 * @param healthDecrease the value to decrease maxHealth by
	 */
	public void removeMaxHealth(int healthDecrease) {
		if (healthDecrease < 0) {
			throw new NegativeValueException("Cannot remove negative health");
		} else {
			maxHealth = getMaxHealth() - healthDecrease;
			
			if (getMaxHealth() < 0) {
				maxHealth = 0;
			}
		}
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
	
	/**
	 * Adds armor stat to the monster
	 * @param armourIncrease the amount to increase armor by
	 */
	public void addArmorAmount(int armourIncrease) {
		armorAmount = getArmorAmount() + armourIncrease;
	}
	
	/**
	 * Removes armor stat for the monster
	 * @param armourDecrease amount to remove by
	 */
	public void removeArmorAmount(int armourDecrease) {
		armorAmount = getArmorAmount() - armourDecrease;
	}
	
	/**
	 * Gets the armor amount for the monster
	 * @return current armor amount
	 */
	public int getArmorAmount() {
		return armorAmount;
	}
	
	/**
	 * Adds speed to the monster
	 * @param speedIncrease amount to increase speed by
	 */
	public void addSpeed(int speedIncrease) {
		if (speedIncrease < 0) {
			throw new NegativeValueException("Cannot add negative speed");
		} else {
			speed = getSpeed() + speedIncrease;
			
			if (getSpeed() < 0) {
				speed = Integer.MAX_VALUE;
			}
		}
	}
	
	/**
	 * Removes speed from the monster
	 * @param speedDecrease amount to decrease speed by
	 */
	public void removeSpeed(int speedDecrease) {
		if (speedDecrease < 0) {
			throw new NegativeValueException("Cannot remove negative speed");
		} else {
			speed = getSpeed() - speedDecrease;
			
			if (getSpeed() < 0) {
				speed = 0;
			}
		}
	}
	
	/**
	 * Returns the speed attribute
	 * @return the monsters speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	public void setMonsterType(String type) {
		monsterType = type;
	}
	
	public String getMonsterType() {
		return monsterType;
	}
	
	/**
	 * Increases the monsters attack damage
	 * @param attackIncrease the amount to increase
	 */
	public void addAttackAmount(int attackIncrease) {
		if (attackIncrease < 0) {
			throw new NegativeValueException("Cannot add negative attack amount");
		} else {
			attackAmount += attackIncrease;
			
			if (getAttackAmount() < 0) {
				attackAmount = Integer.MAX_VALUE;
			}
		}
	}
	
	/**
	 * Removes attack damage from the monster
	 * @param attackDecrease The amount to decrease by
	 */
	public void removeAttackAmount(int attackDecrease) {
		if (attackDecrease < 0) {
			throw new NegativeValueException("Cannot remove negative attack amount");
		} else {
			attackAmount -= attackDecrease;
			
			if(getAttackAmount() < 0) {
				attackAmount = 0;
			}
		}
	}
	
	/**
	 * Gets the attack damage attribute
	 * @return attack damage
	 */
	public int getAttackAmount() {
		return attackAmount;
	}
	
	/**
	 * Gets the stunned status of the monster
	 * @return boolean value of being stunned
	 */
	public boolean getStunnedStatus() {
		return isStunned;
	}
	
	/**
	 * Sets the stunned status for the monster
	 * @param status
	 */
	public void setStunnedStatus(boolean status) {
		isStunned = status;
	}
	
	
    public void setInitialID() {
    	super.instanceId = 0;
    }
	
    /**
     * Makes the monster sleep and reset any stunned status it may have
     */
	public void sleep() {
		addHealth(getHealAmount());
		setStunnedStatus(false);
	}
	
	/**
	 * Gives a monster a weapon to use, if one is already equipped the old weapon will be returned
	 * @param weapon The weapon to equip
	 * @return The old weapon or null if none equipped already
	 */
	public Weapon addWeapon(Weapon weapon) {
		Weapon oldWeapon = removeWeapon();
		weaponSlot = weapon;
		addAttackAmount(weapon.getDamage());
		equipped.add(weapon.getClass().getSimpleName());
		return oldWeapon;
	}
	
	/**
	 * Removes and returns the equipped weapon from the monster. Returns null if no weapon is equipped
	 * @return The old weapon
	 */
	public Weapon removeWeapon() {
		Weapon weapon = weaponSlot;
		weaponSlot = null;
		if (weapon != null) {
			removeAttackAmount(weapon.getDamage());
		}
		
		return weapon;
	}
	
	/**
	 * Adds Armor to the monster and returns the already equipped armor, returns null if none is already equipped
	 * @param armor The Armor to equip
	 * @return The already equipped armor
	 */
	public Armor addArmor(Armor armor) {
		Armor oldArmor = removeArmor();
		armorSlot = armor;
		addMaxHealth(armor.getHealthIncrease());
		addHealth(armor.getHealthIncrease());
		addArmorAmount(armor.getArmorIncrease());
		equipped.add(armor.getClass().getSimpleName());
		return oldArmor;
	}
	
	/**
	 * Removes the currently equipped armor, returns null if nothing is equipped
	 * @return The equipped armor
	 */
	public Armor removeArmor() {
		Armor armor = armorSlot;
		armorSlot = null;
		if (armor != null) {
			removeArmorAmount(armor.getArmorIncrease());
			removeMaxHealth(armor.getHealthIncrease());
			removeHealth(armor.getHealthIncrease());
			equipped.remove(armor.getClass().getSimpleName());
		}
		
		return armor;
	}
	
	
	
	public String toString() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "\n\nType: "+type+"\nHealth: "+getHealth() +"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed();
	}
	
	public String getDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return type+": "+getName()+" "+getID();
	}
	
	public String getSellBackDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		
		String stunnedStatus = "";
		
		if (isStunned == true) {
			stunnedStatus = "Monster stunned, please heal before battling.";
		} else {
			stunnedStatus = "Okay. Monster can battle.";
		}
		
		
		String equippedString = "N/A";
		
		if (equipped.size() == 1) {
			equippedString = equipped.get(0);
		} else if (equipped.size() > 1) {
			equippedString = equipped.get(0);
			for (int i = 0; i < equipped.size(); i++) {
				equippedString += ", ";
				equippedString += equipped.get(i);
			}
		}
		
		
		
		return "Type: "+type+"\nName: "+getName()+"\n\nHealth: "+ getHealth() + " / " + getMaxHealth() +"\nStatus: "+stunnedStatus+"\n\nAttack Amount: "+getAttackAmount()+"\nArmor Amount: "+getArmorAmount()+"\nEquipped: "+equippedString+"\nSpeed: "+getSpeed()+"\n\nSell-back Price: "+getPurchasePrice();
	}
	
	public String getBuyDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "Type: "+type+"\nName: "+getName()+"\n\nHealth: "+getHealth()+"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed()+"\n\nPrice: "+getPurchasePrice();
	}
	
	/**
	 * Lets the player purchase the monster
	 */
	@Override
	public void buy(Player player) throws InsufficientGoldException {
		player.removeGold(this.getPurchasePrice());
		player.getInventory().addMonster(this);
	}
	
	/**
	 * Lets the player sell the Monster
	 */
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
