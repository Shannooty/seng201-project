package gui.customElements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
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
	
	private String version;
	
	
	/**
	 * General constructor for the ImgInventoryPanel
	 * @param pane The JScrollPane the panel will be added to
	 * @param toDisplay The ArrayList of objects. Objects must implement HasImage interface
	 * @param version Version string for different GUI screens
	 */
	public ImgInventoryPanel(JScrollPane pane, ArrayList<? extends HasImage> toDisplay, String version) {
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
