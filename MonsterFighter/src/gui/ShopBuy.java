package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import shop.Shop;
import purchasable.monsters.*;





public class ShopBuy {

	private JFrame frmShopbuy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopBuy window = new ShopBuy();
					window.frmShopbuy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopBuy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShopbuy = new JFrame();
		frmShopbuy.setTitle("ShopBuy");
		frmShopbuy.setBounds(100, 100, 850, 570);
		frmShopbuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopbuy.getContentPane().setLayout(null);
		
		JLabel lblGoldAmount = new JLabel("Amount of gold:");
		lblGoldAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmount.setBounds(10, 10, 177, 20);
		frmShopbuy.getContentPane().add(lblGoldAmount);
		
		JButton btnShopSell = new JButton("Sell");
		btnShopSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShopSell.setBounds(741, 10, 85, 21);
		frmShopbuy.getContentPane().add(btnShopSell);
		
		JTextArea txtrDescriptionPriceEtc = new JTextArea();
		txtrDescriptionPriceEtc.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrDescriptionPriceEtc.setText("Description:\r\n\r\nPrice:\r\n\r\netc");
		txtrDescriptionPriceEtc.setBounds(539, 145, 194, 258);
		frmShopbuy.getContentPane().add(txtrDescriptionPriceEtc);
		
		Shop shop = new Shop(2, 2);
//		shop.addMonsters();
//		shop.addMonsters();
//		shop.addMonsters();
		
		ArrayList<Monster> mobster = shop.getAvalibleMonsters();
		
		System.out.println(mobster);
		
		DefaultListModel<Monster> monsterListModel = new DefaultListModel<>();
		// Add the existing items to the ListModel
		monsterListModel.addAll(mobster);
		
		// Create the actual JList, notice that we put the astronautListModel in as an argument to new JList		
		JList<Monster> availableMonsters = new JList<>(monsterListModel);
		availableMonsters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availableMonsters.setBounds(204, 15, 217, 198);
		frmShopbuy.getContentPane().add(availableMonsters);
		
		JButton btnShowDetailsButton = new JButton("Show Selected Details");
		btnShowDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button pressed! Currently selected astronaut is:");
				System.out.println(availableMonsters.getSelectedValue());
			}
		});
		btnShowDetailsButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowDetailsButton.setBounds(116, 232, 192, 21);
		frmShopbuy.getContentPane().add(btnShowDetailsButton);
		
	}
}
