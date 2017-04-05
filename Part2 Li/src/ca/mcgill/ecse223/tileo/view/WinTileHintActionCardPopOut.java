package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class WinTileHintActionCardPopOut extends JFrame {

	private JPanel contentPane;
	private PlayController pmc = TileOPlayPage.pmc;
	
	private JLabel drawnCardLabel;
	private JLabel selectTileLabel;
	private JLabel errorLabel;
	private JLabel hintLabel;
	
	private JButton getHintButton;
	private JButton willRemButton;
	
	private boolean chosen = false;
	private Tile chosenTile = null;
	private String error;
	private String hint;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinTileHintActionCardPopOut frame = new WinTileHintActionCardPopOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinTileHintActionCardPopOut() {
		setAlwaysOnTop(true);
		setTitle("Win Tile Hint Action Card");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		drawnCardLabel = new JLabel ("You have drawn the Win Tile Hint Action Card!");
		drawnCardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		selectTileLabel = new JLabel("Select a tile on the board to check if it, or one of its neighbours is the Win Tile!");
		selectTileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		getHintButton = new JButton("Get Hint!");
		getHintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hint = "";
				error = "";
				if (chosen == false){
					if (chosenTile == null){
						error = "Please click a tile on the board! ";
						errorLabel.setText(error);
					}
					if (TileOPlayPage.getGrid().aTileIsSelected){
						chosenTile = TileOPlayPage.getGrid().selectedTile;
						try
						{
							if (pmc.playWinTileHintActionCard(chosenTile)){
								hint = "The selected tile or one of its neighbours is the Win Tile! Good luck!";
							};
							hint = "The selected tile is not the Win Tile and there are no Win Tiles around! Good luck!";
							chosen = true;
						}
						catch(InvalidInputException f)
						{
							throw new RuntimeException(f.getMessage());
						}
					}
				}
				else if (chosen = true){
					error = "You have already selected a tile!";
					errorLabel.setText(error);
				}
			}
		});
		
		willRemButton = new JButton("I will remember!");
		willRemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chosen == true) {
					TileOPlayPage.setError("");
					TileOPlayPage.refreshData();
					TileOPlayPage.getGrid().aTileIsSelected = false;
					TileOPlayPage.getGrid().aConnectionIsSelected = false;
					TileOPlayPage.getGrid().selectedConnection = null;
					TileOPlayPage.getGrid().selectedTile = null;
					close();
				}
				else {
					error = "You have not select a tile yet! Select a tile to know whether it is the Win Tile!";
					errorLabel.setText(error);
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(drawnCardLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectTileLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(173)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(errorLabel)
								.addComponent(hintLabel))))
					.addContainerGap(39, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(getHintButton)
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(willRemButton)
					.addGap(83))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(drawnCardLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(selectTileLabel)
					.addGap(41)
					.addComponent(errorLabel)
					.addGap(18)
					.addComponent(hintLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getHintButton)
						.addComponent(willRemButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void close() { 
		this.setVisible(false);
		this.setAlwaysOnTop(true);
	    this.dispose();
	}
}
