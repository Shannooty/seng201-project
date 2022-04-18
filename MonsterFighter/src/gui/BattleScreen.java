package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import player.Player;
import player.Team;
import purchasable.monsters.Monster;

import javax.swing.JTextArea;

import day.Battle;
import day.Day;
import javax.swing.JTextPane;

public class BattleScreen {

	private JFrame frmBattlescreen;
	private GameEnvironment gameEnvironment;
	private Player player;
	private static Team team;
	private Day day;
	private ArrayList<Monster> monstersToFight;
	private Battle selectedBattle;
	private JTextPane textPaneFight;


	/**
	 * Create the application.
	 */
	public BattleScreen(GameEnvironment gameManager, Battle selectedBattle) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		team = player.getInventory().getTeam();
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
		
		JTextPane textAreaPlayer = new JTextPane();
		textAreaPlayer.setText(team.getTeam().toString());
		textAreaPlayer.setBounds(34, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaPlayer);
		
		JTextPane textAreaGame = new JTextPane();
		textAreaGame.setText(monstersToFight.toString());
		textAreaGame.setBounds(569, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaGame);
		
		JTextPane textPaneFight = new JTextPane();
		textPaneFight.setText("You: " + (team.getTeam().get(0)).getDescription() + "\nvs.\nUs: " + ((monstersToFight.get(0))).getDescription());
		textPaneFight.setBounds(318, 136, 197, 237);
		frmBattlescreen.getContentPane().add(textPaneFight);
		
		selectedBattle.attack(team.getTeam().get(0), monstersToFight.get(0));
	}
	
	
	public void updateStatus() {
		this.textPaneFight.setText("");
	}
}
