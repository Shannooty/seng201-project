package gui;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import purchasable.items.Item;
import purchasable.monsters.Monster;
import gui.ShopBuy;

public class SharedListSelectionHandler implements ListSelectionListener {

	
	private DefaultListModel<String> shopArray;
	private String shopVersion;
	
	
	public SharedListSelectionHandler(DefaultListModel<String> monsters, String shop) {
		shopArray = monsters;
		shopVersion = shop;
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
//		
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
//        System.out.println("output"+output);
        if (shopVersion == "ShopBuy") {
        	ShopBuy.setTxtrDescription(output);
            ShopBuy.setSelectedCost(Double.parseDouble(output.substring(output.indexOf("Price") + 7)));
        } else if (shopVersion == "ShopSell") {
        	ShopSell.setSelectedMonster(output);
//          ShopSell.setSelectedPrice(Double.parseDouble(output.substring(output.indexOf("Price") + 7)));
        }
        
        
        
        
        
		
	}
	
	
	
	

}
