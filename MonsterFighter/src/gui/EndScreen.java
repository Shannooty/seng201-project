package gui;

import javax.swing.JFrame;

import player.Player;
import player.PlayerScore;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * The screen that is shown to the player when the game ends.
 * @author Bede Nathan
 * @author Celia Allen
 *
 */
public class EndScreen {

	/**
	 * Attribute frmEndscreen, of type JFrame. The frame which is displayed to the user. Contains the UI for the EndScreen.
	 */
	private JFrame frmEndscreen;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	/**
	 * Attribute playerPosition of type Integer. The position of the player on the leaderboard.
	 */
	private int playerPosition;
	
	
	
	/**
	 * COnstructor for the class EndScreen. Sets the private attributes gameEnvironment and player, calls the initialize() method, and sets the frame to visible. 
	 * @param manager, of type GameEnvironment. Used to access logic in the class GameEnvironment.
	 */
	public EndScreen(GameEnvironment manager) {
		gameEnvironment = manager;
		setPlayer(manager.getPlayer());
		initialize();
		frmEndscreen.setVisible(true);
	}
	
	/**
	 * Closes the frame frmEndscreen.
	 */
	public void closeWindow() {
		frmEndscreen.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeEndScreen, passing the EndScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeEndScreen(this);
	}
	
	/**
	 * Returns a list of all the player's on the leaderboard and their score.
	 * @return model, of type DefaultListModel[String]. 
	 */
	public DefaultListModel<String> loadLeaderboard() {
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
		frmEndscreen = new JFrame();
		frmEndscreen.setBounds(100, 100, 850, 570);
		frmEndscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEndscreen.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over!");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGameOver.setBounds(295, 10, 244, 53);
		frmEndscreen.getContentPane().add(lblGameOver);
		
		String scoreMessage = "Score : " + getPlayer().getPoints();
		
		JLabel lblScore = new JLabel(scoreMessage);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblScore.setBounds(429, 88, 95, 28);
		frmEndscreen.getContentPane().add(lblScore);
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setBounds(295, 151, 244, 37);
		frmEndscreen.getContentPane().add(lblLeaderboard);
		
		JList<String> listLeaderboard = new JList<String>(loadLeaderboard());
		listLeaderboard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listLeaderboard.setVisibleRowCount(20);
		listLeaderboard.setBounds(295, 190, 244, 273);
		frmEndscreen.getContentPane().add(listLeaderboard);
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
		frmEndscreen.getContentPane().add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuit.setBounds(429, 478, 110, 28);
		frmEndscreen.getContentPane().add(btnQuit);
		
		JLabel lblPlayer = new JLabel("Player : "+player.getName());
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayer.setBounds(211, 88, 219, 28);
		frmEndscreen.getContentPane().add(lblPlayer);
		
		JLabel lblGold = new JLabel("Gold : "+ player.getGoldAmount());
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGold.setBounds(429, 113, 101, 28);
		frmEndscreen.getContentPane().add(lblGold);
		
		JLabel lblDuration = new JLabel("Duration : "+ gameEnvironment.getGameLength()+" days.");
		lblDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDuration.setBounds(429, 60, 156, 28);
		frmEndscreen.getContentPane().add(lblDuration);
	}

	/**
	 * Returns the position of the player on the leaderboard.
	 * @return playerPosition, of type integer.
	 */
	private int getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * Returns the current instance of GameEnvironment.
	 * @return gameEnvironment, of type GameEnvironment.
	 */
	public GameEnvironment getGameEnvironment() {
		return gameEnvironment;
	}

	/**
	 * Returns the current player
	 * @return player, of type Player.
	 */
	private Player getPlayer() {
		return player;
	}

	/**
	 * Sets the private attribute player to the Player passed to it.
	 * @param player, of type Player. The current player.
	 */
	private void setPlayer(Player player) {
		this.player = player;
	}
}
