package gui.customElements;

import javax.swing.JToggleButton;

import purchasable.Purchasable;
import purchasable.items.Item;
import purchasable.monsters.Monster;

public class InventoryToggleButton extends JToggleButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449563501811900529L;
	
	private Purchasable buttonObject;
	
	
	public InventoryToggleButton(Purchasable item) {
		setButtonObject(item);
		this.setIcon(item.getImg());
		this.setBorder(null);
		this.setSelectedIcon(item.getImg());
	}
	

	public Purchasable getButtonObject() {
		return buttonObject;
	}

	private void setButtonObject(Purchasable buttonObject) {
		this.buttonObject = buttonObject;
	}
}
