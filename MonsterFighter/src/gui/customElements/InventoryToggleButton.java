package gui.customElements;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import day.Battle;
import purchasable.Purchasable;
import purchasable.items.Item;
import purchasable.monsters.Monster;

public class InventoryToggleButton extends JToggleButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449563501811900529L;
	
	private Purchasable buttonObject;
	
	private Battle battleButtonObject;
	
	
	public InventoryToggleButton(Purchasable item) {
		setButtonObject(item);
		this.setIcon(item.getImg());
		this.setBorder(null);
		this.setSelectedIcon(new ImageIcon(InventoryToggleButton.class.getResource("/images/index1.png")));
	}
	
	public InventoryToggleButton(Battle item) {
		setBattleButtonObject(item);
		this.setIcon(item.getImg());
		this.setBorder(null);
		this.setSelectedIcon(new ImageIcon(InventoryToggleButton.class.getResource("/images/index1.png")));
	}
	

	public Purchasable getButtonObject() {
		return buttonObject;
	}

	private void setButtonObject(Purchasable buttonObject) {
		this.buttonObject = buttonObject;
	}
	
	private void setBattleButtonObject(Battle battleButtonObject) {
		this.battleButtonObject = battleButtonObject;
	}
}
