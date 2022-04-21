package gui.customElements;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import day.Battle;
import interfaces.HasImage;

/**
 * Custom toggle button for storing a object reference to be used in the ImgInventoryPanel. Objects must extend HasImage interface.
 * @author Bede Nathan, Celia Allen
 *
 */
public class InventoryToggleButton extends JToggleButton {

	private static final long serialVersionUID = -5449563501811900529L;
	
	private HasImage buttonObject;
	
	/**
	 * Constructor for the toggle button.
	 * @param <T> Class object which extends HasImage interface
	 * @param item A object which extends HasImage interface
	 */
	public <T extends HasImage> InventoryToggleButton(T item) {
		setButtonObject(item);
		this.setIcon(item.getImg());
		this.setBorder(null);
		this.setSelectedIcon(new ImageIcon(InventoryToggleButton.class.getResource("/images/index1.png")));
		
		if (item instanceof Battle) {
			setBattleInfo();
		}
	}
	
	/**
	 * Getter for the buttonObject
	 * @return The object stored in the button
	 */
	public HasImage getButtonObject() {
		return buttonObject;
	}
	
	/**
	 * Sets info for the battle if the button object is type Battle
	 */
	public void setBattleInfo() {
		Battle battle = (Battle) getButtonObject();
		this.setText("Number of monsters to fight: "+Integer.toString(battle.getNumMonsters()));
		this.setHorizontalTextPosition(JLabel.CENTER);
		this.setVerticalTextPosition(JLabel.CENTER);
	}
	
	/**
	 * Sets the buttons stored object.
	 * @param item Object to be stored
	 */
	private void setButtonObject(HasImage item) {
		this.buttonObject = item;
	}
}
