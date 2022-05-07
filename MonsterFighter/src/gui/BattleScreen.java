package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import player.Player;
import player.Team;
import purchasable.monsters.Monster;

import javax.swing.JTextArea;

import day.Battle;
import day.Day;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author
 *
 */
public class BattleScreen {

	/**
	 * Attribute frmBattlescreen of type JFrame. The frame which is displayed to the user. Contains the UI for the BattleScreen.
	 */
	private JFrame frmBattlescreen;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	/**
	 * Attribute team of type ArrayList<Monster>. An ArrayList of all the Monsters in the player's team that are not stunned.
	 */
	private ArrayList<Monster> team;
	
	/**
	 * Attribute day of type Day. The current instance of Day.
	 */
	private Day day;
	
	/**
	 * Attribute monstersToFight of type ArrayList<Monster>. ArrayList of the Monsters the player must fight.
	 */
	private ArrayList<Monster> monstersToFight;
	
	/**
	 * Attribute selectedBattle of type Battle. The Battle that the player selected to fight.
	 */
	private Battle selectedBattle;
	
	/**
	 * Attribute actualTeam of type Team. The player's actual team, which still contains stunned Monsters.
	 */
	private Team actualTeam;
	
	/**
	 * Attribute textPaneFight of type JTextPane. A JTextPane that displays the winner of each round of the battle.
	 */
	private JTextPane textPaneFight = new JTextPane();
	
	/**
	 * Attribute textAreaGame of type JTextPane. A JTextPane that displays the Monsters the game still has available to fight the player.
	 */
	private JTextPane textAreaGame = new JTextPane();
	
	/**
	 * Attribute textAreaPlayer of type JTextPane. A JTextPane that displays the Monsters the player still has available to fight.
	 */
	private JTextPane textAreaPlayer = new JTextPane();
	
	/**
	 * Attribute textPanePlayerMonster of type JTextPane. A JTextPane that displays the current Monster from the player's team that is fighting.
	 */
	private JTextPane textPanePlayerMonster = new JTextPane();
	
	/**
	 * Attribute textPaneGameMonster of type JTextPane. A JTextPane that displays the current Monster from the game's team that is fighting.
	 */
	private JTextPane textPaneGameMonster = new JTextPane();
	
//	private JButton btnFinish = new JButton("Finish");
	
	/**
	 * Attribute btnContinue of type JButton. A JButton that starts the next round of the battle.
	 */
	private JButton btnContinue = new JButton("Continue");
	


	/**
	 * Constructor for the class BattleScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. Sets the private variables player, day, and monstersToFight, all through the GameEnvironment class. 
	 * Sets the private variable team to the player's team, using the setTeam() method.
	 * @param gameManager, of type GameEnvironment. The class that manages what windows are open.
	 * @param selectedBattle, of type Battle. The current Battle being fought.
	 */
	public BattleScreen(GameEnvironment gameManager, Battle selectedBattle) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		this.actualTeam = player.getInventory().getTeam();

		setTeam(getCurrentTeam(actualTeam.getTeam()));
//		System.out.println(team);
//		team = (ArrayList<Monster>) actualTeam.getTeam().stream().filter(Monster::getStunnedStatus).collect(Collectors.toList());
		
		day = gameEnvironment.getToday();
		this.selectedBattle = selectedBattle;
		monstersToFight = selectedBattle.getGameMonsters();
		initialize();
		frmBattlescreen.setVisible(true);
	}
	
	
	/**
	 * Closes the frame frmBattlescreen.
	 */
	public void closeWindow() {
		frmBattlescreen.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeBattleScreen, passing the BattleScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeBattleScreen(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattlescreen = new JFrame();
		frmBattlescreen.setTitle("BattleScreen");
		frmBattlescreen.setBounds(100, 100, 850, 570);
		frmBattlescreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattlescreen.getContentPane().setLayout(null);
		
//		JTextPane textAreaPlayer = new JTextPane();
		
//		ArrayList<ImageIcon> monsterImgs = new ArrayList<ImageIcon>();
//		
//		for (Monster monster: team) {	
//			monsterImgs.add(monster.getImg());
//		}
		

//		textAreaPlayer.setWrapStyleWord(true);
		textAreaPlayer.setEditable(false);
		textAreaPlayer.setText(team.toString().replaceAll("[\\[\\],]","").trim());
		textAreaPlayer.setBounds(34, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaPlayer);

//		JTextPane textAreaGame = new JTextPane();
		textAreaGame.setText(monstersToFight.toString().replaceAll("[\\[\\],]","").trim());
		textAreaGame.setBounds(569, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaGame);
		
//		JTextPane textPaneFight = new JTextPane();
//		textPaneFight.setText();
		textPaneFight.setBounds(320, 344, 197, 120);
		frmBattlescreen.getContentPane().add(textPaneFight);
		
		
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fight();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinue.setBounds(350, 297, 128, 25);
		frmBattlescreen.getContentPane().add(btnContinue);
		
		
		
//		btnFinish.setVisible(false);
//		btnFinish.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				day.removeBattle(selectedBattle);
//				gameEnvironment.launchMainScreen();
//				finishedWindow();
//			}
//		});
//		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		btnFinish.setBounds(350, 277, 128, 25);
//		frmBattlescreen.getContentPane().add(btnFinish);
		
		
		textPanePlayerMonster.setText("You: "+(team.get(0)).getDescription());
		textPanePlayerMonster.setBounds(272, 38, 128, 120);
		frmBattlescreen.getContentPane().add(textPanePlayerMonster);
		
		
		
		textPaneGameMonster.setText("Us: "+((monstersToFight.get(0))).getDescription());
		textPaneGameMonster.setBounds(431, 38, 128, 120);
		frmBattlescreen.getContentPane().add(textPaneGameMonster);
		
		JLabel lblVsLabel = new JLabel("Vs.");
		lblVsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVsLabel.setBounds(405, 80, 23, 19);
		frmBattlescreen.getContentPane().add(lblVsLabel);
		
		JLabel lblYourTeamLabel = new JLabel("Your team:");
		lblYourTeamLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourTeamLabel.setBounds(34, 10, 169, 18);
		frmBattlescreen.getContentPane().add(lblYourTeamLabel);
		
		JLabel lblGameTeam = new JLabel("Game team:");
		lblGameTeam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGameTeam.setBounds(569, 10, 169, 18);
		frmBattlescreen.getContentPane().add(lblGameTeam);
		
		
		
	}
	
	/**
	 * Returns an ArrayList of the all the player's Monsters who are not stunned.
	 * @return team, of type ArrayList<Monster>.
	 */
	public ArrayList<Monster> getTeamBattle() {
		return team;
	}
	
	/**
	 * Sets the private variable team. Return type void.
	 * @param team, of type ArrayList<Monster>. An ArrayList of the all the player's Monsters who are not stunned.
	 */
	public void setTeam(ArrayList<Monster> team) {
		this.team = team;
	}
	
	/**
	 * Calls the method Battle.attack if both the player and game have monsters to fight. If not, it checks if the result was a draw, win, or loss for the player and displays the result to the user. Awards gold and points to the user if the battle was won, or a draw. 
	 * Removes the fought Battle from the available battles.
	 * Calls launchMainScreen() and finishedWindow() to open the MainScreen and close the current window.
	 */
	public void fight() {
		if (getTeamBattle().size() > 0 && monstersToFight.size() > 0) {
			Monster winner = selectedBattle.attack(getTeamBattle().get(0), monstersToFight.get(0));
			updateStatus("Winner: "+winner.toString());
		} else {
			String gameWinner = "";
			if ((getTeamBattle().size() == 0 && monstersToFight.size() == 0)) {
				gameWinner = "It was a draw. You receive half the gold and points.";
				
				JOptionPane.showMessageDialog(frmBattlescreen, "End of game.\nWinner: "+gameWinner);
				day.setPointsEarnedToday((selectedBattle.getPoints())/2);
				day.setGoldEarnedToday((selectedBattle.getGold())/2);
				
			} else {
				if (getTeamBattle().size() == 0 && monstersToFight.size() != 0) {
					gameWinner = "You lost.";
				} else if (getTeamBattle().size() != 0 && monstersToFight.size() == 0) {
					gameWinner = "You Won!";	
					day.setPointsEarnedToday(selectedBattle.getPoints());
					day.setGoldEarnedToday(selectedBattle.getGold());
				} 
				JOptionPane.showMessageDialog(frmBattlescreen, "End of game.\n"+gameWinner);
				
			}
			
//			updateStatus("end, winner: " + gameWinner);
			
//			btnFinish.setVisible(true);
			btnContinue.setVisible(false);			
			day.removeBattle(selectedBattle);
			gameEnvironment.launchMainScreen();
			finishedWindow();
		}
	}
	
	/**
	 * Updates the private attribute team to contain no stunned Monsters. Return type void.
	 * Updates the status of the GUI, specifically the contents of textPaneFight, textAreaPlayer and textAreaGame.
	 * @param winner, of type String. A string representation of the Monster who won the most recent round of the Battle.
	 */
	public void updateStatus(String winner) {
		setTeam(getCurrentTeam(actualTeam.getTeam()));
		textPaneFight.setText(winner);
		textAreaPlayer.setText(getTeamBattle().toString().replaceAll("[\\[\\],]","").trim());
		textAreaGame.setText(monstersToFight.toString().replaceAll("[\\[\\],]","").trim());
		
//		textPanePlayerMonster.setText("You: "+(team.get(0)).getDescription());
//		textPaneGameMonster.setText("Us: "+((monstersToFight.get(0))).getDescription());

	}
	
	/**
	 * Filters the player's actual team for the Monsters who are not stunned, and returns an ArrayList of those Monsters.
	 * @param actualTeam, of type ArrayList<Monster>. The player's actual team, including stunned Monsters.
	 * @return an ArrayList of type Monster. All the player's Monsters who are not stunned.
	 */
	public ArrayList<Monster> getCurrentTeam(ArrayList<Monster> actualTeam) {
		return (ArrayList<Monster>) actualTeam.stream().filter(m -> m.getStunnedStatus() == false).collect(Collectors.toList());
	}
}
