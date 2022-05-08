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
		lblGameOver.setBounds(295, 10, 244, 53);
		frame.getContentPane().add(lblGameOver);
		
		String scoreMessage = "Score : " + getPlayer().getPoints();
		
		JLabel lblScore = new JLabel(scoreMessage);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblScore.setBounds(429, 88, 95, 28);
		frame.getContentPane().add(lblScore);
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setBounds(295, 151, 244, 37);
		frame.getContentPane().add(lblLeaderboard);
		
		JList<String> listLeaderboard = new JList<String>(loadLeaderboard());
		listLeaderboard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listLeaderboard.setVisibleRowCount(20);
		listLeaderboard.setBounds(295, 190, 244, 273);
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
		
		JLabel lblPlayer = new JLabel("Player : "+player.getName());
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer.setBounds(211, 88, 219, 28);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblGold = new JLabel("Gold : "+ player.getGoldAmount());
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGold.setBounds(429, 113, 101, 28);
		frame.getContentPane().add(lblGold);
		
		JLabel lblDuration = new JLabel("Duration : "+ gameEnvironment.getGameLength()+" days.");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuration.setBounds(429, 60, 156, 28);
		frame.getContentPane().add(lblDuration);
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
