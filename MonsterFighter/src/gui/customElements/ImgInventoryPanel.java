package gui.customElements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import purchasable.items.Item;
import purchasable.items.weapons.Weapon;
import purchasable.monsters.Monster;
import gui.ChooseBattleScreen;
import gui.InventoryScreen;
import gui.ShopBuy;
import gui.ShopSell;
import interfaces.HasImage;


/**
 * Custom panel for displaying Objects which implement HasImage interface
 * @author Bede Nathan, Celia Allen
 */
public class ImgInventoryPanel extends JPanel {

	private static final long serialVersionUID = -3684204445436872689L;
	private final InventoryButtonGroup buttonGroup = new InventoryButtonGroup();
	
//	private String version;
	
	private Object gui;
	
	
	/**
	 * General constructor for the ImgInventoryPanel
	 * @param pane The JScrollPane the panel will be added to
	 * @param toDisplay The ArrayList of objects. Objects must implement HasImage interface
	 * @param type, of type Object. Represents the gui screen that the constructor was called from.
	 */
	public ImgInventoryPanel(JScrollPane pane, ArrayList<? extends HasImage> toDisplay, Object type) {
		if (toDisplay.size() > 0) {
			int iconWidth = toDisplay.get(0).getImg().getIconWidth();
			int paneWidth = pane.getWidth();
			int numItems = paneWidth / iconWidth;
			String rowColContraints = "["+ iconWidth + "!]";
			this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
			
			pane.setViewportView(this);
			placeObjectsInPanel(toDisplay);
			
//			this.version = version;
			this.gui = type;
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
	
	
	public Object getType() {
		return gui;
	}
	
}
