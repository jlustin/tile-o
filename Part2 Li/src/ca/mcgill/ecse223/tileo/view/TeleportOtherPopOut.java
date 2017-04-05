package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;
import ca.mcgill.ecse223.tileo.model.Tile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TeleportOtherPopOut extends JFrame {
	public void close() { 
		this.setVisible(false);
		chosenTile = null;
		error = "";
	}

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TeleportOtherPopOut frame = new TeleportOtherPopOut();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
private PlayController pmc = TileOPlayPage.pmc;
private Tile chosenTile = null;
String error = "";
	public static void addNums(String[] str, int number){
		for (int i = 1; i < number+1 ; i++){
			str[i-1] = String.valueOf(i);			
		}
	}
	/**
	 * Create the frame.
	 */
	public TeleportOtherPopOut() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel errorLbl = new JLabel("");
		errorLbl.setForeground(Color.RED);
		JLabel lblNewLabel = new JLabel("You have drawn a TeleportOther Action Card!");
		
		JLabel lblPleaseSelectA = new JLabel("Please select a player you would like to move and the tile");
		JComboBox comboBox = new JComboBox();
		String[] playerNum = new String[TileOApplication.getTileO().getCurrentGame().numberOfPlayers()];
		addNums(playerNum, TileOApplication.getTileO().getCurrentGame().numberOfPlayers());
		comboBox.setModel(new DefaultComboBoxModel(playerNum));	
		
		JButton btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (TileOPlayPage.getGrid().aTileIsSelected){
					chosenTile = TileOPlayPage.getGrid().selectedTile;
					//if(chosenTile==null){ //possibly redundant error checking
					//	error = error + "Please click a tile on the board! ";
					//	errorLbl.setText(error);
					//}
				}
				
				error = "";
				int chosenPlayerNumber = comboBox.getSelectedIndex();
				//Tile chosenTile = null;
//				if (TileODesignPage.getGrid().aTileIsSelected){
//					chosenTile = TileODesignPage.getGrid().selectedTile;
//				}
				if (chosenPlayerNumber == TileOApplication.getTileO().getCurrentGame().getCurrentPlayer().getNumber() - 1)
				{
					error = "You cannot teleport yourself!";
				}
				if(chosenTile == null){
					error = "Please choose a tile on the board!";
				}
				error.trim();
				if(error.length()==0) {
					pmc.playTeleportOtherActionCard(chosenPlayerNumber, chosenTile);
					TileOPlayPage.setError("");
					TileOPlayPage.refreshData();
					TileOPlayPage.getGrid().aTileIsSelected = false;
					TileOPlayPage.getGrid().aConnectionIsSelected = false;
					TileOPlayPage.getGrid().selectedConnection = null;
					TileOPlayPage.getGrid().selectedTile = null;
					close();
				}
				else
				{
					errorLbl.setText(error);
				}
				//refreshData();		
				
			}
		});
		
		
		
		//JComboBox comboBox = new JComboBox();
		
							
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblNewLabel)
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(lblPleaseSelectA)
					.addGap(35))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(errorLbl, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
							.addComponent(btnMove)
							.addGap(98))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblPleaseSelectA)
					.addGap(18)
					.addComponent(errorLbl, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMove)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
