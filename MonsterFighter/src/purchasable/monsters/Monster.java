package purchasable.monsters;

import java.util.ArrayList;
import java.util.Comparator;

import exceptions.InsufficientGoldException;
import exceptions.NegativeValueException;
import exceptions.TeamFullException;
import player.Player;
import purchasable.Purchasable;
import purchasable.items.armors.Armor;
import purchasable.items.weapons.Weapon;

/**
 * An abstract Monster class that contains all the attributes and methods for all Monster types.
 * @author Bede Nathan
 * @author Celia Allen
 */

public abstract class Monster extends Purchasable implements Comparator<Monster> {
	
	/**
	 * Attribute health, of type integer. The monster's health amount.
	 */
	private int health;
	
	/**
	 * Attribute maxHealth, of type integer. The monster's maximum health amount.
	 */
	private int maxHealth;
	
	/**
	 * Attribute armorAmount, of type integer. The amount of armor a monster has. Default set to 0.
	 */
	private int armorAmount = 0;
	
	/**
	 * Attribute healAmount, of type integer. The amount by which a monster can heal.
	 */
	private int healAmount;
	
	/**
	 * Attribute attackAmount, of type integer. The amount that the monster can attack another monster.
	 */
	private int attackAmount;
	
	/**
	 * Attribute speed, of type integer. The monster's speed.
	 */
	private int speed;
	
	/**
	 * Attribute isStunned, of type boolean. True/false whether the monster is currently stunned.
	 */
	private boolean isStunned = false;
	
	/**
	 * Attribute weaponSlot, of type Weapon. The weapon that the monster is currently holding. Default set to null.
	 */
	private Weapon weaponSlot = null;
	
	/**
	 * Attribute armorSlot, of type Armor. The armor that the monster is currently wearing. Default set to null.
	 */
	private Armor armorSlot = null;
	
	/**
	 * Attribute monsterType, of type String. The monster's type.
	 */
	private String monsterType;
	
	/**
	 * Attribute equipped, of type ArrayList[String]. An ArrayList of the items the monster currently has equipped.
	 */
	private ArrayList<String> equipped = new ArrayList<String>();
	
	/**
	 * Attribute armorModifier, of type static integer. Modifies the amount of damage dealt to a monster when wearing armor.
	 */
	public static int armorModifier = 4;
	
	/**
	 * Main constructor for the abstract superclass of Monster
	 * 
	 * @param name, of type String. Sets the name
	 * @param maxHealth, of type integer. Sets the maximum health
	 * @param attackAmount, of type integer. Sets the base attack damage
	 * @param speed, of type integer. Sets the base speed (determines attack order)
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
	 * @param healAmount, of type integer. The amount of health the monster will be healed by
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
	 * @param rawDamage, of type integer. Damage dealt to the monster
	 */
	public void removeHealth(int rawDamage) {
		int damage = rawDamage - (getArmorAmount() / Monster.armorModifier);
		
		if (damage < 0) {
			damage = 0;
		}
		
		if(rawDamage < 0) {
			throw new NegativeValueException("Cannot remove negative health");
		} else if ((health - damage) <= 0) {
			health = 0;
			isStunned = true;
		} else {
			health = getHealth() - damage;
		}
	}
	
	/**
	 * Returns the monsters current health
	 * @return health, of type integer.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Increases the monsters maximum health limit
	 * @param healthIncrease, of type integer. The value to increase the monsters max health by.
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
	 * @param healthDecrease, of type integer. The value to decrease maxHealth by.
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
	 * @return maxHealth, of type integer.
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Sets the amount a monster heals by while sleeping
	 * @param healAmount, of type integer. The amount to heal by.
	 */
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount; 
	}
	
	/**
	 * Returns the heal amount for a monster
	 * @return healAmount, of type integer.
	 */
	public int getHealAmount() {
		return healAmount;
	}
	
	/**
	 * Adds armor to the monster
	 * @param armourIncrease, of type integer. The amount to increase armor by
	 */
	public void addArmorAmount(int armourIncrease) {
		armorAmount = getArmorAmount() + armourIncrease;
	}
	
	/**
	 * Removes armor from the monster
	 * @param armourDecrease, of type integer. The amount of armor to remove.
	 */
	public void removeArmorAmount(int armourDecrease) {
		armorAmount = getArmorAmount() - armourDecrease;
	}
	
	/**
	 * Gets the current armor amount for the monster
	 * @return current armor amount, of type integer.
	 */
	public int getArmorAmount() {
		return armorAmount;
	}
	
	/**
	 * Adds speed to the monster
	 * @param speedIncrease, of type integer. The amount to increase speed by.
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
	 * @param speedDecrease, of type integer. The amount to decrease speed by.
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
	
	/**
	 * Sets the private attribute monsterType.
	 * @param type, of type String. The monster's type.
	 */
	public void setMonsterType(String type) {
		monsterType = type;
	}
	
	/**
	 * Returns the type of the monster.
	 * @return monsterType, of type String.
	 */
	public String getMonsterType() {
		return monsterType;
	}
	
	/**
	 * Increases the monsters attack damage
	 * @param attackIncrease, of type integer. The amount to increase the monster's attack amount by.
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
	 * Removes attack damage from the monster.
	 * @param attackDecrease, of type integer. The amount to decrease the monsters's attack amount by.
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
	 * Gets the attack damage attribute.
	 * @return attackAmount, of type integer.
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
	 * @param status, of type boolean. The current status of the Monster
	 */
	public void setStunnedStatus(boolean status) {
		isStunned = status;
	}
	
    /**
     * Sets the initialID for the object
     */
    public void setInitialID() {
    	super.instanceId = 0;
    }
	
    /**
     * Makes the monster sleep, heals the monster to maximum health, and resets any stunned status it may have.
     */
	public void sleep() {
		addHealth(getHealAmount());
		setStunnedStatus(false);
	}
	
	/**
	 * Gives a monster a weapon to use, if one is already equipped the old weapon will be returned
	 * @param weapon, of type Weapon. The weapon to equip
	 * @return oldWeapon, of type Weapon. The old weapon or null if none equipped already
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
	 * @return weapon, of type Weapon. The old weapon
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
	 * @param armor, of type Armor. The Armor to equip
	 * @return oldArmor, of type Armor. The already equipped armor
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
	 * @return armor, of type Armor. The equipped armor
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
	
	
	/**
	 * Custom toString method for the class Monster. Returns a string of the monster's type, health, attack amount and speed, each on a new line.
	 */
	public String toString() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "\n\nType: "+type+"\nHealth: "+getHealth() +"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed();
	}
	
	/**
	 * Returns the monster's type, name and id number.
	 * @return a String, the monster description.
	 */
	public String getDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return type+": "+getName()+" "+getID();
	}
	
	/**
	 * Getter for the sell back description for use in the GUI
	 * @return The description String
	 */
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
			for (int i = 1; i < equipped.size(); i++) {
				equippedString += ", ";
				equippedString += equipped.get(i);
			}
		}
		return "Type: "+type+"\nName: "+getName()+"\n\nHealth: "+ getHealth() + " / " + getMaxHealth() +"\nHeal Amount: "+ getHealAmount() + "\nStatus: "+stunnedStatus+"\n\nAttack Amount: "+getAttackAmount()+"\nArmor Amount: "+getArmorAmount()+"\nEquipped: "+equippedString+"\nSpeed: "+getSpeed()+"\n\nSell-back Price: "+getPurchasePrice();
	}
	
	/**
	 * Returns a String description of the monster, specifically for when the user does not own the monster.
	 * @return a String, the description.
	 */
	public String getBuyDescription() {
		String type = getMonsterType().replaceAll("([A-Z])", " $1");
		type = type.substring(0, 1).toUpperCase() + type.substring(1);
		return "Type: "+type+"\nName: "+getName()+"\n\nHealth: "+getHealth()+"\nAttack Amount: "+getAttackAmount()+"\nSpeed: "+getSpeed()+"\n\nPrice: "+getPurchasePrice();
	}
	
	/**
	 * Lets the player purchase the monster
	 */
	@Override
	public void buy(Player player) throws InsufficientGoldException, TeamFullException {
		player.removeGold(this.getPurchasePrice());
		player.getInventory().addMonster(this);
	}
	
	/**
	 * Lets the player sell the Monster, returns equipped items back to player
	 */
	@Override
	public void sell(Player player) {
		if(armorSlot != null) {
			Armor oldArmor = removeArmor();
			player.getInventory().addItem(oldArmor);
		}
		if(weaponSlot != null) {
			Weapon oldWeapon = removeWeapon();
			player.getInventory().addItem(oldWeapon);
		}
		player.addGold(getSellPrice());
		player.getInventory().removeMonster(this);
	}
	
	/**
	 * Compares two monsters based on their speed attribute.
	 */
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
