package gui.customElements;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import purchasable.Purchasable;

import net.miginfocom.swing.MigLayout;

public class ImgInventoryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3684204445436872689L;
	private static final InventoryButtonGroup buttonGroup = new InventoryButtonGroup();
	
	public ImgInventoryPanel(JScrollPane pane, ArrayList<Purchasable> itemsToDisplay) {
		int iconWidth = itemsToDisplay.get(0).getImg().getIconWidth();
		int paneWidth = pane.getWidth();
		int numItems = paneWidth / iconWidth;
		String rowColContraints = "["+ iconWidth + "!]";
		this.setLayout(new MigLayout("wrap " + numItems, rowColContraints, rowColContraints));
		
		pane.setViewportView(this);
		placeItemsInPanel(itemsToDisplay);
	}

	private void placeItemsInPanel(ArrayList<Purchasable> itemsToDisplay) {
		
		for (Purchasable item : itemsToDisplay) {
			InventoryToggleButton button = new InventoryToggleButton(item);
			getButtonGroup().add(button);
			this.add(button);
		}
		
	}
	
	private static InventoryButtonGroup getButtonGroup() {
		return buttonGroup;
	}
}
