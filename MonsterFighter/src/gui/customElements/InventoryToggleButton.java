package gui.customElements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import day.Battle;
import interfaces.HasImage;
import purchasable.Purchasable;
import purchasable.items.Item;
import purchasable.monsters.Monster;

public class InventoryToggleButton extends JToggleButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5449563501811900529L;
	
	private HasImage buttonObject;
	
	public <T extends HasImage> InventoryToggleButton(T item) {
		setButtonObject(item);
		this.setIcon(item.getImg());
		this.setBorder(null);
		this.setSelectedIcon(new ImageIcon(InventoryToggleButton.class.getResource("/images/index1.png")));
		
		if (item instanceof Battle) {
			setBattleInfo((Battle)item);
		}
	}

	public HasImage getButtonObject() {
		return buttonObject;
	}
	
	public void setBattleInfo(Battle battle) {
		this.setText("Number of monsters to fight: "+Integer.toString(battle.getNumMonsters()));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.CENTER);
	}
	
	private void setButtonObject(HasImage item) {
		this.buttonObject = item;
	}
}
