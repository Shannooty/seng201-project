package gui.customElements;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import purchasable.Purchasable;
import purchasable.monsters.Monster;
import net.miginfocom.swing.MigLayout;
import gui.ShopBuy;

public class ImgInventoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3684204445436872689L;
	private final InventoryButtonGroup buttonGroup = new InventoryButtonGroup();
	
	
	public ImgInventoryPanel(JScrollPane pane, ArrayList<Monster> itemsToDisplay) {
		int iconWidth = itemsToDisplay.get(0).getImg().getIconWidth();
		int paneWidth = pane.getWidth();
		int numItems = paneWidth / iconWidth;
		String rowColContraints = "["+ iconWidth + "!]";
		this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
		
		pane.setViewportView(this);
		placeItemsInPanel(itemsToDisplay);
	}

//	private void placeItemsInPanel(ArrayList<Monster> itemsToDisplay) {
//		
//		for (Purchasable item : itemsToDisplay) {
//			InventoryToggleButton button = new InventoryToggleButton(item);
//			getButtonGroup().add(button);
//			this.add(button);
//			
//		}
//		
//	}
	
	private InventoryButtonGroup getButtonGroup() {
		return buttonGroup;
	}
	
	
	
	
	private void placeItemsInPanel(ArrayList<Monster> itemsToDisplay) {
		
		for (Purchasable item : itemsToDisplay) {
			
			Icon icon = item.getImg();
			JToggleButton button = new JToggleButton(icon);
			button.setName(Integer.toString(item.getID()));
			
			button.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) { 
//					  System.out.println(( (Component) e.getSource()).getName());
					  ShopBuy.setTxtrDescription(( (Component) e.getSource()).getName());
				  } 
				} );
			
			getButtonGroup().add(button);
			this.add(button);
			
		}
		
	}
	
	
}
