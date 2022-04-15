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

public class BattleScreen {

	private JFrame frmBattlescreen;
	private GameEnvironment gameEnvironment;
	private Player player;
	private static Team team;
	private Day day;
	private ArrayList<Monster> monstersToFight;
	private Battle selectedBattle;


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
		
		JTextArea textAreaPlayer = new JTextArea();
		textAreaPlayer.setText(team.getTeam().toString());
		textAreaPlayer.setBounds(34, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaPlayer);
		
		JTextArea textAreaGame = new JTextArea();
		textAreaGame.setText(monstersToFight.toString());
		textAreaGame.setBounds(569, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaGame);
	}

}
