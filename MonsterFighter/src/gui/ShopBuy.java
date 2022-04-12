package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import player.Player;
import shop.Shop;
import purchasable.monsters.*;





public class ShopBuy extends Shop {

	private JFrame frmShopbuy;
//	private ArrayList<String> monsters;
	private static JTextArea txtrDescription = new JTextArea("");
	private double gold = Player.getGoldAmount();
	
	

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
		super(3,5);
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
		
//		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrDescription.setText("Description:\r\n\r\nPrice:\r\n\r\netc");
		txtrDescription.setBounds(539, 145, 194, 258);
		frmShopbuy.getContentPane().add(txtrDescription);
		
		
//		Shop shop = new Shop(2, 2);
//		Shop.setNumMonsters(2);
//		Shop.addMonsters();
//		shop.addMonsters();
//		shop.addMonsters();
		
		
		ArrayList<Monster> monsterDescription = super.getAvalibleMonsters();
		DefaultListModel<String> monsterStrings = new DefaultListModel<>();
		for(Monster val : monsterDescription)monsterStrings.addElement(val.getDescription());

		
		ArrayList<Monster> monsterInfo = super.getAvalibleMonsters();
		DefaultListModel<Monster> monsterListModel = new DefaultListModel<>();
		monsterListModel.addAll(monsterInfo);
				
		// Create the actual JList, notice that we put the astronautListModel in as an argument to new JList		
		JList<String> availableMonsters = new JList<>(monsterStrings);
		availableMonsters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availableMonsters.setBounds(110, 152, 217, 198);
		frmShopbuy.getContentPane().add(availableMonsters);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmShopbuy, "Are you sure you want to buy this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
//					gold.removeGold();
					
					System.out.println("They pressed yes");
				} else if (choice == JOptionPane.NO_OPTION) {
					System.out.println("They pressed no");
				} else {
					System.out.println("They didn't press either button!");
				}
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuy.setBounds(629, 463, 85, 21);
		frmShopbuy.getContentPane().add(btnBuy);
		

		ListSelectionModel listSelectionModel = availableMonsters.getSelectionModel();
	    listSelectionModel.addListSelectionListener(new SharedListSelectionHandler(monsterListModel));	
	    
//	    
//		JButton btnShowDetailsButton = new JButton("Show Selected Details");
//		btnShowDetailsButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Button pressed! Currently selected astronaut is:");
//				System.out.println(availableMonsters.getSelectedValue());
//			}
//		});
//		btnShowDetailsButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnShowDetailsButton.setBounds(116, 232, 192, 21);
//		frmShopbuy.getContentPane().add(btnShowDetailsButton);
//		
	}
	
	
	public static void setTxtrDescription(String text) {
		txtrDescription.setText(text);

	    // or if a JTextPane by inserting text into its Document here
	}
	
}
