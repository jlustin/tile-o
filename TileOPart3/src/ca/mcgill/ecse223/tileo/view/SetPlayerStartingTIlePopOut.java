package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.DesignModeController;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.model.NormalTile;
import ca.mcgill.ecse223.tileo.model.Player;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetPlayerStartingTIlePopOut extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	String error;
	ButtonModel chosenNumber;
	String playerNumber;
	int chosenPlayerNumber;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPlayerStartingTIlePopOut frame = new SetPlayerStartingTIlePopOut();
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
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
	
	public SetPlayerStartingTIlePopOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectTheNumber = new JLabel("Select the player's number and");
		
		JRadioButton radioButton = new JRadioButton("2");
		radioButton.setActionCommand("2");
		buttonGroup.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("3");
		radioButton_1.setActionCommand("3");
		buttonGroup.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("4");
		radioButton_2.setActionCommand("4");
		buttonGroup.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("1");
		radioButton_3.setActionCommand("1");
		buttonGroup.add(radioButton_3);
		
		JLabel lblChooseItsStarting = new JLabel("choose its starting tile from the board.");
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				error = "";
				chosenNumber = buttonGroup.getSelection();
				playerNumber = chosenNumber.getActionCommand();
				chosenPlayerNumber = Integer.parseInt(playerNumber);
				
				
				System.out.println(chosenPlayerNumber - 1);
//				DesignModeController dmc = new DesignModeController();
//				Player currentPlayer = TileO.getCurrentGame().getPlayer(chosenPlayerNumber-1);
//				NormalTile startingTile = new NormalTile(0,0,null);
//				dmc.setPlayerStartingTile(currentPlayer, startingTile);
				close();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(190)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(radioButton_2)
								.addComponent(radioButton_1)
								.addComponent(radioButton)
								.addComponent(radioButton_3)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(lblSelectTheNumber))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(lblChooseItsStarting))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(171)
							.addComponent(btnSet)))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectTheNumber)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblChooseItsStarting)
					.addGap(24)
					.addComponent(radioButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton_2)
					.addGap(28)
					.addComponent(btnSet)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
