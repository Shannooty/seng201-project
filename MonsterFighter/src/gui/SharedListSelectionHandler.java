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
	
	
	public SharedListSelectionHandler(DefaultListModel<String> monsters) {
		shopArray = monsters;
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
        ShopBuy.setTxtrDescription(output);
        ShopBuy.setSelectedCost(Double.parseDouble(output.substring(output.indexOf("Price") + 7)));
		

		
	}
	
	

}
