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

public class ImgInventoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3684204445436872689L;
	private final InventoryButtonGroup buttonGroup = new InventoryButtonGroup();
	
	private String version;
	
//	private void placeItemsInPanel(ArrayList<Monster> itemsToDisplay) {
//	
//	for (Purchasable item : itemsToDisplay) {
//		InventoryToggleButton button = new InventoryToggleButton(item);
//		getButtonGroup().add(button);
//		this.add(button);
//		
//	}
//	
//}
	
	public ImgInventoryPanel(JScrollPane pane, ArrayList<Monster> itemsToDisplay, String version) {
		if (itemsToDisplay.size() > 0) {
			int iconWidth = itemsToDisplay.get(0).getImg().getIconWidth();
			int paneWidth = pane.getWidth();
			int numItems = paneWidth / iconWidth;
			String rowColContraints = "["+ iconWidth + "!]";
			this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
			
			pane.setViewportView(this);
			placeMonstersInPanel(itemsToDisplay);
			
			
			//Delete if going back to og code
			this.version = version;
		}

	}
	
	public ImgInventoryPanel(ArrayList<Item> itemsToDisplay, JScrollPane pane, String version) {
		if (itemsToDisplay.size() > 0) {
			int iconWidth = itemsToDisplay.get(0).getImg().getIconWidth();
			int paneWidth = pane.getWidth();
			int numItems = paneWidth / iconWidth;
			String rowColContraints = "["+ iconWidth + "!]";
			this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
			
			pane.setViewportView(this);
			placeItemsInPanel(itemsToDisplay);
			
			
			//Delete if going back to og code
			this.version = version;
		}
	}
	

	
	public ImgInventoryPanel(ArrayList<Battle> battlesToDisplay, JScrollPane pane) {
		if (battlesToDisplay.size() > 0) {
			int iconWidth = battlesToDisplay.get(0).getImg().getIconWidth();
			int paneWidth = pane.getWidth();
			int numItems = paneWidth / iconWidth;
			String rowColContraints = "["+ iconWidth + "!]";
			this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
			
			pane.setViewportView(this);
			placeBattlesInPanel(battlesToDisplay);
			
			
			//Delete if going back to og code
//			this.version = version;
		}

	}
	
	
	private InventoryButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	
	
	
	// NOTE: If you want to go back to the original code, it's commented out up above, so feel free to comment this version and un-comment the one above
	
	private void placeMonstersInPanel(ArrayList<Monster> itemsToDisplay) {
		
		for (Purchasable item : itemsToDisplay) {
			
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
					  }
					  
				  } 
				} );
			
			getButtonGroup().add(button);
			this.add(button);
			
		}
		
	}
	
	
	private void placeItemsInPanel(ArrayList<Item> itemsToDisplay) {
		
		for (Purchasable item : itemsToDisplay) {
			
			Icon icon = item.getImg();
			JToggleButton button = new JToggleButton(icon);
			button.setName(Integer.toString(item.getID()));
			
			
			button.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
//					  System.out.println(( (Component) e.getSource()).getName());
					  if (version == "ShopBuy") {
						  ShopBuy.setTxtrDescriptionItem(( (Component) e.getSource()).getName());
					  } else if (version == "ShopSell") {
						  ShopSell.setTxtrDescriptionItem(( (Component) e.getSource()).getName());
					  } else if (version == "Inventory") {
						  InventoryScreen.setTxtrDescriptionItem(( (Component) e.getSource()).getName());
					  }
					  
				  } 
				} );
			
			getButtonGroup().add(button);
			this.add(button);
			
		}
		
	}
	
	private void placeBattlesInPanel(ArrayList<Battle> BattlesToDisplay) {
		
		for (Battle item : BattlesToDisplay) {
			
			Icon icon = item.getImg();
//			Icon icon = new ImageIcon("/images/skeleton.png");
//			System.out.println(icon);
			JToggleButton button = new JToggleButton(icon);
			button.setName(Integer.toString(item.getID()));
//			System.out.println("button.getName() " + button.getName());
			
			
			button.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
//					  System.out.println(( (Component) e.getSource()).getName());
					  ChooseBattleScreen.setTxtrDescription(( (Component) e.getSource()).getName());
				  } 
				} );
			
			getButtonGroup().add(button);
			this.add(button);
			
		}
		
	}
	
	
	
}
