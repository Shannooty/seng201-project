package generators;

import generators.registries.AvalibleArmors;
import generators.registries.AvalibleFoods;
import generators.registries.AvalibleItemTypes;
import generators.registries.AvalibleWeapons;
import purchasable.items.*;
import purchasable.items.armors.*;
import purchasable.items.weapons.*;
import purchasable.items.food.*;

public class ItemGenerator extends Generator {
	
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
	
	public static Armor newArmor() {
		AvalibleArmors armorType = AvalibleArmors.randomArmor();
		
		switch(armorType) {
		case FLOWERCROWN:
			return new FlowerCrown();
		default:
			return null;
		
		}
	}
	
	public static Food newFood() {
		AvalibleFoods foodType = AvalibleFoods.randomFood();
		
		switch(foodType) {
		case APPLE:
			return new Apple();
		default:
			return null;
		
		}
	}
	
	public static Weapon newWeapon() {
		AvalibleWeapons weaponType = AvalibleWeapons.randomWeapon();
		
		switch(weaponType) {
		case SHARPSTICK:
			return new SharpStick();
		default:
			return null;
		
		}
	}
	
	public static SpeedPotion newPotion() {
		return new SpeedPotion();
	}
}
