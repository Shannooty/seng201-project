package gui.customElements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import day.Battle;
import purchasable.Purchasable;
import purchasable.items.Item;
import purchasable.monsters.Monster;
import net.miginfocom.swing.MigLayout;
import gui.ChooseBattleScreen;
import gui.InventoryScreen;
import gui.ShopBuy;
import gui.ShopSell;
import interfaces.HasImage;

public class ImgInventoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3684204445436872689L;
	private final InventoryButtonGroup buttonGroup = new InventoryButtonGroup();
	
	private String version;
	
	public ImgInventoryPanel(JScrollPane pane, ArrayList<HasImage> toDisplay, String version) {
		if (toDisplay.size() > 0) {
			int iconWidth = toDisplay.get(0).getImg().getIconWidth();
			int paneWidth = pane.getWidth();
			int numItems = paneWidth / iconWidth;
			String rowColContraints = "["+ iconWidth + "!]";
			this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
			
			pane.setViewportView(this);
			placeObjectsInPanel(toDisplay);
			
			this.version = version;
		}
	}
	
	private InventoryButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	
	
	
	// NOTE: If you want to go back to the original code, it's commented out up above, so feel free to comment this version and un-comment the one above
	
	private void placeObjectsInPanel(ArrayList<HasImage> toDisplay) {
		
		for (HasImage item : toDisplay) {
			
			InventoryToggleButton button = new InventoryToggleButton(item);
			button.setName(Integer.toString(item.getID()));
			
			
			button.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
//					  System.out.println(( (Component) e.getSource()).getName());
					  if (version == "ShopBuy") {
						  ShopBuy.setTxtrDescriptionMonster(( (Component) e.getSource()).getName());
					  } else if (version == "ShopSell") {
						  ShopSell.setTxtrDescriptionMonster(( (Component) e.getSource()).getName());
					  } else if (version == "Inventory") {
						  InventoryScreen.setTxtrDescriptionMonster(( (Component) e.getSource()).getName());
					  } else if (version == "ChooseBattleScreen") {
						  ChooseBattleScreen.setTxtrDescription(( (Component) e.getSource()).getName());
					  }
					  
				  } 
				} );
			
			getButtonGroup().add(button);
			this.add(button);
			
		}
		
	}
	
}
