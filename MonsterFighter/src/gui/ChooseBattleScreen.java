package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import interfaces.HasImage;
import day.Battle;
import day.Day;
import generators.MonsterGenerator;
import gui.customElements.ImgInventoryPanel;
import purchasable.items.Item;
import purchasable.monsters.Monster;
import shop.Shop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ChooseBattleScreen {

	/**
	 * Attribute frmChoosebattle of type JFrame. The frame which is displayed to the user. Contains the UI for the ChooseBattleScreen.
	 */
	private JFrame frmChoosebattle;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute possibleBattles of type ArrayList<Battle>. An ArrayList of the possible Battles the player can choose from.
	 */
	private ArrayList<Battle> possibleBattles = new ArrayList<Battle>();
	
	/**
	 * Attribute difficulty, of type String. The game difficulty, set by the player when setting up the game.
	 */
	private String difficulty;
	
	/**
	 * Attribute day of type Day. The current instance of Day.
	 */
	private Day day;
	

//	private ImageIcon[] imagesToUse;
//	private ArrayList<Monster> gameMonsters;
	
	/**
	 * Attribute selectedBattle of type Battle. The Battle that the player has currently selected.
	 */
	private Battle selectedBattle;
	
	/**
	 * Attribute txtDescription of type JTextArea. A JTextArea that displays the details of the selected Battle.
	 */
	private JTextArea txtDescription = new JTextArea("");
	
	/**
	 * Attribute type of type Object. The current instance of the object ChooseBattleScreen. Passed to the class ImgInventoryPanel so it can pass a selected item back to the correct class.
	 */
	private Object type = this;
	

	/**
	 * Constructor for the class ChooseBattleScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. 
	 * Sets the private variable difficulty through the GameEnvironment class.
	 * Sets the private variable day via the method setDay(), and the private variable possibleBattles using the private variable day.
	 * @param gameManager
	 */
	public ChooseBattleScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		difficulty = gameEnvironment.getGameDifficulty();
//		System.out.println(difficulty);
//		for (int i = 0; i < 6; i++) {
//			Battle battle = new Battle(difficulty);
//			possibleBattles.add(battle);
//		}
		setDay(gameEnvironment.getToday());	
		possibleBattles = day.getBattles();
		initialize();
		frmChoosebattle.setVisible(true);
	}
	
	/**
	 * Closes the frame frmChoosebattle.
	 */
	public void closeWindow() {
		frmChoosebattle.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeChooseBattleScreen, passing the ChooseBattleScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeChooseBattleScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChoosebattle = new JFrame();
		frmChoosebattle.setTitle("ChooseBattle");
		frmChoosebattle.setBounds(100, 100, 850, 570);
		frmChoosebattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChoosebattle.getContentPane().setLayout(null);
		
		
//		imagesToUse = new ImageIcon[possibleBattles.size()]; 
//		imagesToUse[0] = new ImageIcon(ImageCarousel.class.getResource("/images/zombie.png"), "skeleton");
//		for (int i = 1; i < possibleBattles.size(); i++) {
//			imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource("/images/skeleton.png"), "skeleton");
//		}
//		
//		ImageCarousel images = new ImageCarousel(imagesToUse);
//		images.setSize(290, 195);
//		images.setLocation(266, 195);
//		frmChoosebattle.getContentPane().add(images);
		
		
//		JTextPane txtDescription = new JTextPane();
 
		
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setMargin(new Insets(0,7,0,7));
		txtDescription.setText("Nothing selected.");
		txtDescription.setLineWrap(true);
		txtDescription.setEditable(false);
		
//		txtDescription.setBounds(473, 88, 302, 233);
////		JScrollPane scrollableTextArea = new JScrollPane(txtDescription);  
////        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
//		frmChoosebattle.getContentPane().add(txtDescription);
		
//		JTextArea textArea = new JTextArea("hello");  
        JScrollPane scrollableTextArea = new JScrollPane(txtDescription);  
        scrollableTextArea.setBounds(473, 88, 302, 233);
  
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        frmChoosebattle.getContentPane().add(scrollableTextArea); 
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		scrollPane.setBounds(52, 88, 411, 343);
		frmChoosebattle.getContentPane().add(scrollPane);

		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, possibleBattles, type);
		scrollPane.setViewportView(monsterPanel);
		

		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnReturnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReturnHome.setBounds(672, 10, 154, 25);
		frmChoosebattle.getContentPane().add(btnReturnHome);
		
		JButton btnStartBattle = new JButton("Start Battle");
		btnStartBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmChoosebattle, "Are you sure you want to start this battle?",  "Battle Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
						gameEnvironment.launchBattleScreen(selectedBattle);
						finishedWindow();
					}
			}
		});
		btnStartBattle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStartBattle.setBounds(631, 342, 145, 25);
		frmChoosebattle.getContentPane().add(btnStartBattle);
		

		
//		JTextArea textArea = new JTextArea();
//		textArea.setText(possibleBattles.toString());
//		textArea.setBounds(72, 68, 458, 215);
//		frmChoosebattle.getContentPane().add(textArea);
		
		
//		System.out.println(possibleBattles);
	}
	
	/**
	 * Returns the JTextArea where the description of the currently selected battle is displayed.
	 * @return txtDescription, of type JTextArea.
	 */
	public JTextArea getTxtDescription() {
		return txtDescription;
	}
	
	/**
	 * Returns the currently selected Battle.
	 * @return selectedBattle, of type Battle.
	 */
	public Battle getSelectedBattle() {
		return selectedBattle;
	}
	
	/**
	 * Sets the private attribute selectedBattle to the currently selected battle. Return type void.
	 * @param selectedBattle, of type Battle.
	 */
	public void setSelectedBattle(Battle selectedBattle) {
		this.selectedBattle = selectedBattle;
	}
	
	/**
	 * Returns the current instance of Day.
	 * @return day, of type Day.
	 */
	public Day getDay() {
		return day;
	}
	
	/**
	 * Sets the private attribute day to the current day. Return type void.
	 * @param day, of type Day.
	 */
	public void setDay(Day day) {
		this.day = day;
	}

	/**
	 * Sets the value of txtDescription to the currently selected battle by filtering the available Battles using the given id number. Return type void.
	 * @param id, of type String. The currently selected Battle's id number.
	 */
	public void setTxtrDescription(String id) {
		List<Battle> battles = getDay().getBattles().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedBattle(battles.get(0));
		String battleString = getSelectedBattle().toString();
		getTxtDescription().setText(battleString);
		getTxtDescription().setCaretPosition(0);
	}
}
