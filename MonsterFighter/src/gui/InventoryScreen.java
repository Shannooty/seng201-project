package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import gui.customElements.ImgInventoryPanel;
import player.Inventory;
import player.Player;
import player.Team;
import purchasable.items.Item;
import purchasable.monsters.Monster;
import shop.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The screen that shows the player their inventory.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class InventoryScreen {

	private JFrame frmInventoryscreen;

	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	/**
	 * Attribute inventory of type Inventory. The current inventory.
	 */
	private Inventory inventory;
	
	/**
	 * Attribute team of type ArrayList[Monster]. The player's current team of monsters.
	 */
	private ArrayList<Monster> team;
	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private Monster selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private Item selectedItem;
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private JTextArea txtDescriptionMonsters = new JTextArea("Nothing selected.");
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private JTextArea txtDescriptionItems = new JTextArea("Nothing selected.");
	
	/**
	 * Attribute type of type Object. The current instance of InventoryScreen.
	 */
	private Object type = this;
	
	
	/**
	 * Constructor for the class InventoryScreen. Sets the private attributes gameEnvironment, player, inventory and team. Calls the initialize() method, and sets the frame to visible. 
	 * @param gameManager, of type GameEnvironment. The game manager.
	 */
	public InventoryScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		setInventory(player.getInventory());
		setTeam(inventory.getTeam().getTeam());
		initialize();
		frmInventoryscreen.setVisible(true);
	}
	
	
	/**
	 * Closes the frame frmInventoryscreen.
	 */
	public void closeWindow() {
		frmInventoryscreen.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeInventoryScreen, passing the InventoryScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeInventoryScreen(this);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventoryscreen = new JFrame();
		frmInventoryscreen.setTitle("InventoryScreen");
		frmInventoryscreen.setBounds(100, 100, 850, 570);
		frmInventoryscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryscreen.getContentPane().setLayout(null);
		
		JScrollPane monsterScrollPane = new JScrollPane();
		monsterScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		monsterScrollPane.setBounds(31, 316, 411, 207);
		frmInventoryscreen.getContentPane().add(monsterScrollPane);
		
		JScrollPane itemScrollPane = new JScrollPane();
		itemScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		itemScrollPane.setBounds(31, 68, 409, 205);
		frmInventoryscreen.getContentPane().add(itemScrollPane);
		
		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(monsterScrollPane, team, type);
		monsterScrollPane.setViewportView(monsterPanel);
		
		ImgInventoryPanel itemPanel = new ImgInventoryPanel(itemScrollPane, inventory.getItems(), type);
		itemScrollPane.setViewportView(itemPanel);

		
		txtDescriptionItems.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescriptionItems.setMargin(new Insets(0,7,0,7));
		txtDescriptionItems.setLineWrap(true);
		txtDescriptionItems.setEditable(false);
		frmInventoryscreen.getContentPane().add(txtDescriptionItems);
		
        JScrollPane scrollableTextAreaItems = new JScrollPane(txtDescriptionItems);  
        scrollableTextAreaItems.setBounds(530, 68, 267, 190);
        scrollableTextAreaItems.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextAreaItems.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frmInventoryscreen.getContentPane().add(scrollableTextAreaItems); 
		
		txtDescriptionMonsters.setFont(new Font("Monospaced", Font.PLAIN, 15));		
		txtDescriptionMonsters.setMargin(new Insets(0,7,0,7));
		txtDescriptionMonsters.setLineWrap(true);
		txtDescriptionMonsters.setEditable(false);
		
        JScrollPane scrollableTextAreaMonsters = new JScrollPane(txtDescriptionMonsters);  
        scrollableTextAreaMonsters.setBounds(530, 316, 267, 190);
        scrollableTextAreaMonsters.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextAreaMonsters.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frmInventoryscreen.getContentPane().add(scrollableTextAreaMonsters); 
		
		
		JButton btnHome = new JButton("Return Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setBounds(663, 10, 163, 25);
		frmInventoryscreen.getContentPane().add(btnHome);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Welcome to the inventory, " + player.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(52, 10, 347, 19);
		frmInventoryscreen.getContentPane().add(lblNewLabel);
		
		JLabel lblYourTeam = new JLabel("Your Team:");
		lblYourTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourTeam.setBounds(31, 286, 99, 20);
		frmInventoryscreen.getContentPane().add(lblYourTeam);
		
		JLabel lblNewLabel_1 = new JLabel("Items you own:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 39, 140, 19);
		frmInventoryscreen.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnEquipItem = new JButton("Equip Item");
		btnEquipItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEquipItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] choices = new String[team.size()];
				for (int i = 0; i < team.size(); i++) {
					choices[i] = team.get(i).getDescription();
				}
				String selection = (String) JOptionPane.showInputDialog(
						frmInventoryscreen,
				                    "Which monster do you wish to use this item on?",
				                    "Inventory pop-up",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    choices,
				                    team.get(0).getDescription());

				if (selection != null) {
					String selectedID = selection.substring(selection.length() - 1);
					List<Monster> listOfMonsters = team.stream().filter(s -> selectedID.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
					Monster monsterToEquip = listOfMonsters.get(0);
					inventory.useItem(selectedItem, monsterToEquip);
					txtDescriptionItems.setText("Nothing selected.");
					txtDescriptionMonsters.setText("Nothing selected.");
					ImgInventoryPanel monsterPanel = new ImgInventoryPanel(monsterScrollPane, team, type);
					monsterScrollPane.setViewportView(monsterPanel);
					
					ImgInventoryPanel itemPanel = new ImgInventoryPanel(itemScrollPane, inventory.getItems(), type);
					itemScrollPane.setViewportView(itemPanel);

				}
			}
		});
		btnEquipItem.setBounds(642, 268, 155, 25);
		frmInventoryscreen.getContentPane().add(btnEquipItem);
		
		if (inventory.getItems().size() == 0) {
			btnEquipItem.setEnabled(false);
		}
		
	}
	
	
	/**
	 * Returns the JTextArea that displays the description of the currently selected Monster.
	 * @return txtDescriptionMonsters, of type JTextArea. 
	 */
	public JTextArea getTxtDescriptionMonsters() {
		return txtDescriptionMonsters;
	}
	
	/**
	 * Returns the JTextArea that displays the description of the currently selected Item.
	 * @return txtDescriptionItems, of type JTextArea. 
	 */
	public JTextArea getTxtDescriptionItems() {
		return txtDescriptionItems;
	}
	
	/**
	 * Returns the currently selected Monster.
	 * @return selectedMonster, of type Monster.
	 */
	public Monster getSelectedMonster() {
		return selectedMonster;
	}
	
	/**
	 * Sets the attribute selectedMonster to the currently selected Monster. Return type void.
	 * @param selectedMonster, of type Monster.
	 */
	public void setSelectedMonster(Monster selectedMonster) {
		this.selectedMonster = selectedMonster;
	}
	
	/**
	 * Returns the currently selected Item.
	 * @return selectedItem, of type Item.
	 */
	public Item getSelectedItem() {
		return selectedItem;
	}
	
	/**
	 * Sets the attribute selectedItem to the currently selected Item. Return type void.
	 * @param selectedItem, of type Item.
	 */
	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	/**
	 * Returns the player's team.
	 * @return team, of type ArrayList[Monster].
	 */
	public ArrayList<Monster> getTeam() {
		return team;
	}
	
	/**
	 * Sets the private attribute team to the given parameter team.
	 * @param team, of type ArrayList[Monster].
	 */
	public void setTeam(ArrayList<Monster> team) {
		this.team = team;
	}
	
	/**
	 * Returns the player's inventory.
	 * @return inventory, of type Inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Sets the private attribute inventory to the given parameter inventory.
	 * @param inventory, of type Inventory.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	

	/**
	 * Sets the text of the JTextArea txtDescriptionMonster to the description of the currently selected Monster. Filter's the player's team for the Monster whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Monster's unique id.
	 */
	public void setTxtrDescriptionMonster(String id) {
		List<Monster> listOfMonsters = getTeam().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedMonster(listOfMonsters.get(0));
		String monsterString = getSelectedMonster().getSellBackDescription();
		getTxtDescriptionMonsters().setText(monsterString);
		getTxtDescriptionMonsters().setCaretPosition(0);
	}
	
	/**
	 * Sets the text of the JTextArea txtDescriptionItem to the description of the currently selected Item. Filter's the player's inventory for the Item whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Item's unique id.
	 */
	public void setTxtrDescriptionItem(String text) {
		List<Item> listOfItems = getInventory().getItems().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedItem(listOfItems.get(0));
		String itemString = getSelectedItem().getSellBackDescription();
		getTxtDescriptionItems().setText(itemString);
		getTxtDescriptionItems().setCaretPosition(0);
	}
}
