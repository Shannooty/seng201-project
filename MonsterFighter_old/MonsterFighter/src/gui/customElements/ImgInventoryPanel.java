package gui.customElements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import purchasable.items.Item;
import purchasable.monsters.Monster;
import gui.ChooseBattleScreen;
import gui.InventoryScreen;
import gui.ShopBuy;
import gui.ShopSell;
import interfaces.HasImage;


/**
 * Custom panel for displaying Objects which implement HasImage interface
 * @author Bede Nathan
 * @author Celia Allen
 */
public class ImgInventoryPanel extends JPanel {

	/**
	 * Attribute serialVersionUID, of type static final long. A serialVersion.
	 */
	private static final long serialVersionUID = -3684204445436872689L;
	
	/**
	 * Attribute InventoryButtonGroup, of type final buttonGroup. A group of buttons.
	 */
	private final InventoryButtonGroup buttonGroup = new InventoryButtonGroup();
	
	/**
	 * Attribute gui, of type Object. An instance of the class that called the ImgInventoryPanel constructor.
	 */
	private Object gui;
	
	
	/**
	 * General constructor for the ImgInventoryPanel
	 * @param pane The JScrollPane the panel will be added to
	 * @param toDisplay The ArrayList of objects. Objects must implement HasImage interface
	 * @param gui, of type Object. Represents the gui screen that the constructor was called from.
	 */
	public ImgInventoryPanel(JScrollPane pane, ArrayList<? extends HasImage> toDisplay, Object gui) {
		if (toDisplay.size() > 0) {
			int iconWidth = toDisplay.get(0).getImg().getIconWidth();
			int iconHeight = toDisplay.get(0).getImg().getIconHeight();
			int paneWidth = pane.getWidth();
			int numItems = paneWidth / iconWidth;
			String colContraints = "["+ iconWidth + "!]";
			String rowContraints = "["+ iconHeight + "!]";
			this.setLayout(new MigLayout("wrap " + numItems, colContraints, rowContraints));
			
			pane.setViewportView(this);
			placeObjectsInPanel(toDisplay);
			this.gui = gui;
		}
	}
	
	/**
	 * Gets the button group for the pane
	 * @return the button group
	 */
	private InventoryButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	
	/**
	 * Places all the objects into the panel
	 * @param toDisplay ArrayList of objects which extend HasImage interface
	 */
	private void placeObjectsInPanel(ArrayList<? extends HasImage> toDisplay) {
		
		for (HasImage item : toDisplay) {
			
			InventoryToggleButton button = new InventoryToggleButton(item);
			button.setName(Integer.toString(item.getID()));

			button.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
					  if (gui instanceof ShopBuy) {
						  if (item instanceof Item) {
							  ((ShopBuy) gui).setTxtrDescriptionItem(( (Component) e.getSource()).getName());
						  } else if (item instanceof Monster) {
							  ((ShopBuy) gui).setTxtrDescriptionMonster(( (Component) e.getSource()).getName());
						  }
						  
					  } else if (gui instanceof ShopSell) {
						  if (item instanceof Item) {
							  ((ShopSell) gui).setTxtrDescriptionItem(( (Component) e.getSource()).getName());
						  } else if (item instanceof Monster) {
							  ((ShopSell) gui).setTxtrDescriptionMonster(( (Component) e.getSource()).getName());
						  }
						  
					  } else if (gui instanceof InventoryScreen) {
						  if (item instanceof Item) {
							  ((InventoryScreen) gui).setTxtrDescriptionItem(( (Component) e.getSource()).getName());
						  } else if (item instanceof Monster) {
							  ((InventoryScreen) gui).setTxtrDescriptionMonster(( (Component) e.getSource()).getName());
						  }
						  
					  } else if (gui instanceof ChooseBattleScreen) {
						  ((ChooseBattleScreen) gui).setTxtrDescription(( (Component) e.getSource()).getName());
					  }
					  
				  } 
				} );
			
			getButtonGroup().add(button);
			this.add(button);
			
		}
		
	}
	
	/**
	 * Returns the Object gui that called the ImgInventoryPanel constructor.
	 * @return gui, of type Object
	 */
	public Object getType() {
		return gui;
	}
	
}
