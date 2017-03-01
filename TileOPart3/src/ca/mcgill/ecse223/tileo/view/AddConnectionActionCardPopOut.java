package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayModeController;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.Game.Mode;
import ca.mcgill.ecse223.tileo.model.TileO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddConnectionActionCardPopOut extends JFrame {
	
	private Tile chosenTile1=null;
	private Tile chosenTile2=null;
	
	private JLabel errorMessage;
	private String error= "";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddConnectionActionCardPopOut frame = new AddConnectionActionCardPopOut();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	private void refreshData() {
		errorMessage.setText("<html>"+error+"<html>");
		if(error == null || error.length()==0){
			close();
		}
	}
	
	public AddConnectionActionCardPopOut() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("You have drawn an Add Connection Action Card. ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblClickOnTwo = new JLabel("Click on two tiles on the board to add a connection between them.");
		lblClickOnTwo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnTileChosen = new JButton("Tile 1 Chosen");
		btnTileChosen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				error = ""; 
				if (TileOPlayPage.getGrid().aTileIsSelected){
					chosenTile1 = TileOPlayPage.getGrid().selectedTile;
				}
				if (chosenTile1 == null){
					error =  "Please select a tile on the board and press 'Tile 1 Chosen' button! ";
				}
				error.trim();
				errorMessage.setText(error);
			}
		});
		
		JButton btnTileChosen_1 = new JButton("Tile 2 Chosen");
		btnTileChosen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				error = ""; 
				if (TileOPlayPage.getGrid().aTileIsSelected){
					chosenTile2 = TileOPlayPage.getGrid().selectedTile;
				}
				if (chosenTile2 == null){
					error =  "Please select a tile on the board and press 'Tile 2 Chosen' button! ";
				}
				error.trim();
				errorMessage.setText(error);
			}
		});
		
		JButton btnConnect = new JButton("Connect!");
		btnConnect.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				error = "";
				PlayModeController pmc = new PlayModeController ();
				if (chosenTile1 == null || chosenTile2 == null){
					error = "Please choose the tiles first!";
				}
				error.trim();
				if (error.length() == 0){
					try {
						pmc.playConnectTilesActionCard(chosenTile1, chosenTile2);
						close();
					}
					catch (InvalidInputException e1){
						throw new RuntimeException (e1.getMessage());
					}
				}	
				refreshData();	
			}
			
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(140, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(180))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblClickOnTwo)
							.addGap(130))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(184)
					.addComponent(btnTileChosen)
					.addGap(18)
					.addComponent(btnTileChosen_1)
					.addGap(18)
					.addComponent(btnConnect)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblClickOnTwo)
					.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTileChosen)
						.addComponent(btnTileChosen_1)
						.addComponent(btnConnect))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
