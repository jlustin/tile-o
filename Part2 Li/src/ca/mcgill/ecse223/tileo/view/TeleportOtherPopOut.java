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

public class TeleportOtherPopOut extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
					if(chosenTile==null){ //possibly redundant error checking
						error = error + "Please click a tile on the board! ";
					//	errorLbl.setText(error);
					}
				}
				
				error = "";
				int chosenPlayerNumber = comboBox.getSelectedIndex() + 1;
				Tile chosenTile = null;
				if (TileODesignPage.getGrid().aTileIsSelected){
					chosenTile = TileODesignPage.getGrid().selectedTile;
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
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnMove)
					.addGap(176))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(190))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblPleaseSelectA)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnMove)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
