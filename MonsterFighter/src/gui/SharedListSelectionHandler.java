package gui;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import purchasable.monsters.Monster;
import gui.ShopBuy;

public class SharedListSelectionHandler implements ListSelectionListener {

	
	private DefaultListModel<Monster> monstersArray;
	
	public SharedListSelectionHandler(DefaultListModel<Monster> monsters) {
		monstersArray = monsters;
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
                    output += (monstersArray.get(i));
                }
            }
        }
        ShopBuy.setTxtrDescription(output);
		

		
	}
	
	

}
