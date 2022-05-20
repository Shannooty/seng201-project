package gui.customElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import day.Battle;
import interfaces.HasImage;

/**
 * Custom toggle button for storing a object reference to be used in the ImgInventoryPanel. Objects must extend HasImage interface.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class InventoryToggleButton extends JToggleButton {

	/**
	 * Attribute serialVersionUID, of type static final long. A serialVersion.
	 */
	private static final long serialVersionUID = -5449563501811900529L;
	
	/**
	 * Attribute buttonObject, of type HasImage. A button that has an image associated with it.
	 */
	private HasImage buttonObject;
	
	/**
	 * Constructor for the toggle button.
	 * @param <T> Class object which extends HasImage interface
	 * @param item A object which extends HasImage interface
	 */
	public <T extends HasImage> InventoryToggleButton(T item) {
		setButtonObject(item);
		this.setIcon(item.getImg());
		this.setBorder(new LineBorder(new Color(0,0,0,1)));
		
		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setBorder(new LineBorder(Color.BLACK));
			}
			@Override
			public void focusLost(FocusEvent e) {
				setBorder(new LineBorder(new Color(0,0,0,1)));
			}
		});
		
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
		this.setFont(new Font("Tahoma", Font.BOLD, 11));
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
