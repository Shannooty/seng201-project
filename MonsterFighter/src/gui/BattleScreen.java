package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import player.Player;
import player.Team;
import purchasable.monsters.Monster;

import javax.swing.JTextArea;

import day.Battle;
import day.Day;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleScreen {

	private JFrame frmBattlescreen;
	private GameEnvironment gameEnvironment;
	private Player player;
	private ArrayList<Monster> team;
	private Day day;
	private ArrayList<Monster> monstersToFight;
	private Battle selectedBattle;
	private Team actualTeam;
	private JTextPane textPaneFight = new JTextPane();
	private JTextPane textAreaGame = new JTextPane();
	private JTextPane textAreaPlayer = new JTextPane();
	private JTextPane textPanePlayerMonster = new JTextPane();
	private JTextPane textPaneGameMonster = new JTextPane();
	private JButton btnFinish = new JButton("Finish");
	private JButton btnContinue = new JButton("Continue");
	


	/**
	 * Create the application.
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
		textAreaPlayer.setText(team.toString());
		textAreaPlayer.setBounds(34, 38, 228, 426);
		frmBattlescreen.getContentPane().add(textAreaPlayer);
		
//		JTextPane textAreaGame = new JTextPane();
		textAreaGame.setText(monstersToFight.toString());
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
		
		
		
		btnFinish.setVisible(false);
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day.removeBattle(selectedBattle);
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFinish.setBounds(350, 277, 128, 25);
		frmBattlescreen.getContentPane().add(btnFinish);
		
		
		textPanePlayerMonster.setText("You: "+(team.get(0)).getDescription());
		textPanePlayerMonster.setBounds(272, 38, 128, 120);
		frmBattlescreen.getContentPane().add(textPanePlayerMonster);
		
		
		
		textPaneGameMonster.setText("Us: "+((monstersToFight.get(0))).getDescription());
		textPaneGameMonster.setBounds(431, 38, 128, 120);
		frmBattlescreen.getContentPane().add(textPaneGameMonster);
		
		
		
	}
	
	
	public ArrayList<Monster> getTeamBattle() {
		return team;
	}
	
	public void setTeam(ArrayList<Monster> team) {
		this.team = team;
	}
	
	
	public void fight() {
		if (getTeamBattle().size() > 0 && monstersToFight.size() > 0) {
			Monster winner = selectedBattle.attack(getTeamBattle().get(0), monstersToFight.get(0));
			updateStatus(winner.toString());
		} else {
			String gameWinner;
			if (getTeamBattle().size() == 0 ) {
				gameWinner = "game";
			} else {
				gameWinner = "you";	
			}
			updateStatus("end, winner: " + gameWinner);
			day.setPointsEarnedToday(selectedBattle.getPoints());
			day.setGoldEarnedToday(selectedBattle.getGold());
			btnFinish.setVisible(true);
			btnContinue.setVisible(false);
//			System.out.println(actualTeam.getTeam().size());
		}
	}
	
	public void updateStatus(String winner) {
		setTeam(getCurrentTeam(actualTeam.getTeam()));
		textPaneFight.setText("Winner: " + winner);
		textAreaPlayer.setText(team.toString());
		textAreaGame.setText(monstersToFight.toString());
		
//		textPanePlayerMonster.setText("You: "+(team.get(0)).getDescription());
//		textPaneGameMonster.setText("Us: "+((monstersToFight.get(0))).getDescription());

	}
	
	public ArrayList<Monster> getCurrentTeam(ArrayList<Monster> actualTeam) {
		return (ArrayList<Monster>) actualTeam.stream().filter(m -> m.getStunnedStatus() == false).collect(Collectors.toList());
	}
}
