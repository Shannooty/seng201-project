package gui;

import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import day.Battle;
import day.Day;
import gui.customElements.ImgInventoryPanel;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The screen where the player can choose the battle they want to fight.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
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
	 * Attribute day of type Day. The current instance of Day.
	 */
	private Day day;
	
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
	 * Attribute btnStartBattle, of type JButton. A button that allows the user to start the selected battle. Disabled until a battle is selected.
	 */
	private JButton btnStartBattle = new JButton("Start Battle");

	

	/**
	 * Constructor for the class ChooseBattleScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. 
	 * Sets the private variable difficulty through the GameEnvironment class.
	 * Sets the private variable day via the method setDay(), and the private variable possibleBattles using the private variable day.
	 * @param gameManager, of type GameEnvironment. The game manager.
	 */
	public ChooseBattleScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
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
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setMargin(new Insets(0,7,0,7));
		txtDescription.setText("Nothing selected.");
		txtDescription.setLineWrap(true);
		txtDescription.setEditable(false);

        JScrollPane scrollableTextArea = new JScrollPane(txtDescription);  
        scrollableTextArea.setBounds(520, 88, 302, 233);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frmChoosebattle.getContentPane().add(scrollableTextArea); 
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		scrollPane.setBounds(50, 88, 460, 343);
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
		
 	   btnStartBattle.setEnabled(false);
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
		btnStartBattle.setBounds(678, 342, 145, 25);
		frmChoosebattle.getContentPane().add(btnStartBattle);
		
		frmChoosebattle.getRootPane().setDefaultButton(btnStartBattle);
		
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
       if (btnStartBattle.isEnabled() == false) {
    	   btnStartBattle.setEnabled(true);
       }
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
