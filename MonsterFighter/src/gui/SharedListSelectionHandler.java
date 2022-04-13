package gui;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import purchasable.items.Item;
import purchasable.monsters.Monster;
import gui.ShopBuy;


/**
 * 
 * @author 
 *
 */
public class SharedListSelectionHandler implements ListSelectionListener {

	/**
	 * Attribute shopArray of type DefaultListModel<String>. Contains the items that are displayed to the user that they can purchase or sell.
	 */
	private DefaultListModel<String> shopArray;
	
	/**
	 * Attribute shopVersion of type String. The version of the shop that is currently being viewed. (ShopBuy or ShopSell.)
	 */
	private String shopVersion;
	
	
	/**
	 * Constructor for the class SharedListSelectionHandler. Sets the private variable shopArray to the purchasable given, sets the private variable shopVersion to shop.
	 * @param purchasable of type DefaultListModel<String>. A list of the purchasable Monsters/Items that are to be displayed to the user.
	 * @param shop of type String. The version of the shop that is currently be viewed (ShopBuy or ShopSell), so the correct JTextPane is updated.
	 */
	public SharedListSelectionHandler(DefaultListModel<String> purchasable, String shop) {
		shopArray = purchasable;
		shopVersion = shop;
	}
	
	
	
	/**
	 * Overridden method that gets the currently selected Item/Monster in the Shop, and updates a JTextPane to display further information about the selected Item/Monster.
	 * @param e, of type ListSelectionEvent. The item in the list which has been selected. 
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {

		String output = "";
		
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();

        if (!lsm.getValueIsAdjusting() && !lsm.isSelectionEmpty()) {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    output += (shopArray.get(i));
                }
            }
        }

        if (shopVersion == "ShopBuy") {
        	ShopBuy.setTxtrDescription(output);
            ShopBuy.setSelectedCost(Double.parseDouble(output.substring(output.indexOf("Price") + 7)));
        } else if (shopVersion == "ShopSell") {
        	ShopSell.setSelectedMonster(output);
//          ShopSell.setSelectedPrice(Double.parseDouble(output.substring(output.indexOf("Price") + 7)));
        }
		
	}

}