package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import player.Player;
import player.PlayerScore;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import leaderboard.Leaderboard;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private Player player;
	private int playerPosition;
	
	/**
	 * Create the application.
	 */
	public EndScreen(GameEnvironment manager) {
		gameEnvironment = manager;
		setPlayer(manager.getPlayer());
		
		initialize();
		frame.setVisible(true);
		
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	
	public void finishedWindow() {
		gameEnvironment.closeEndScreen(this);
	}
	
	private DefaultListModel<String> loadLeaderboard() {
		int position = 0;
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		for (PlayerScore score : GameEnvironment.getLeaderboard().getLeaderboard()) {
			String displayMessage = ++position + " " + score;
			model.addElement(displayMessage);
			
			if (score == getPlayer().getScore()) {
				playerPosition = position - 1;
			}
		}
		return model;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over!");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGameOver.setBounds(248, 11, 337, 53);
		frame.getContentPane().add(lblGameOver);
		
		String scoreMessage = "Score : " + getPlayer().getPoints();
		
		JLabel lblScore = new JLabel(scoreMessage);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setBounds(257, 61, 320, 53);
		frame.getContentPane().add(lblScore);
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setBounds(295, 115, 244, 46);
		frame.getContentPane().add(lblLeaderboard);
		
		JList<String> listLeaderboard = new JList<String>(loadLeaderboard());
		listLeaderboard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listLeaderboard.setVisibleRowCount(20);
		listLeaderboard.setBounds(295, 157, 244, 306);
		frame.getContentPane().add(listLeaderboard);
		listLeaderboard.setSelectedIndex(getPlayerPosition());
		listLeaderboard.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				listLeaderboard.setSelectedIndex(getPlayerPosition());
			}
		});
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				GameEnvironment.main(null);
			}
		});
		btnPlayAgain.setBounds(295, 478, 110, 28);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuit.setBounds(429, 478, 110, 28);
		frame.getContentPane().add(btnQuit);
	}

	private int getPlayerPosition() {
		return playerPosition;
	}

	public GameEnvironment getGameEnvironment() {
		return gameEnvironment;
	}

	private Player getPlayer() {
		return player;
	}

	private void setPlayer(Player player) {
		this.player = player;
	}

}
