package generators;

import generators.registries.AvalibleArmors;
import generators.registries.AvalibleFoods;
import generators.registries.AvalibleItemTypes;
import generators.registries.AvalibleWeapons;
import purchasable.items.*;
import purchasable.items.armors.*;
import purchasable.items.weapons.*;
import purchasable.items.food.*;

/**
 * ItemGenerator class that provides the ability to create a random Item object of random type or specific type
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class ItemGenerator extends Generator {
	
	/**
	 * Will return a new random item of any type
	 * @return The new Item object
	 */
	public static Item newItem() {
		AvalibleItemTypes itemType = AvalibleItemTypes.randomItemType();
		
		switch (itemType) {
		case ARMOR:
			return newArmor();
		case FOOD:
			return newFood();
		case POTION:
			return newPotion();
		case WEAPON:
			return newWeapon();
		default:
			return null;
		}
	}
	
	/**
	 * Method for creating a random Armor from the available armor types
	 * @return The new Armor object
	 */
	public static Armor newArmor() {
		AvalibleArmors armorType = AvalibleArmors.randomArmor();
		
		switch(armorType) {
		case FLOWERCROWN:
			return new FlowerCrown();
		case SHIELD:
			return new Shield();
		case CHAINMAIL:
			return new Chainmail();
		default:
			return null;
		
		}
	}
	
	/**
	 * Method for creating a random Food from the available food types
	 * @return The new Food object
	 */
	public static Food newFood() {
		AvalibleFoods foodType = AvalibleFoods.randomFood();
		
		switch(foodType) {
		case APPLE:
			return new Apple();
		case BREAD:
			return new Bread();
		case MUSHROOM:
			return new Mushroom();
		default:
			return null;
		
		}
	}
	/**
	 * Method for creating a random Weapon from the available weapon types
	 * @return The new Weapon object
	 */
	public static Weapon newWeapon() {
		AvalibleWeapons weaponType = AvalibleWeapons.randomWeapon();
		
		switch(weaponType) {
		case SHARPSTICK:
			return new SharpStick();
		case SLEDGEHAMMER:
			return new SledgeHammer();
		case KNIFE:
			return new Knife();
		default:
			return null;
		
		}
	}
	
	/**
	 * Returns a new SpeedPotion item
	 * @return the SpeedPotion object
	 */
	public static SpeedPotion newPotion() {
		return new SpeedPotion();
	}
}
