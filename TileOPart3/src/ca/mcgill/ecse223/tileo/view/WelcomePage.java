package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.DesignModeController;
import ca.mcgill.ecse223.tileo.controller.InvalidInputException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	String error;
	ButtonModel chosenNumber;
	String numberOfPlayers;
	int chosenNumberOfPlayers;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 605, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Create a new game by selecting the number of players");
		
		JRadioButton radioButton = new JRadioButton("2");
		radioButton.setActionCommand("2");
		buttonGroup.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("3");
		radioButton_1.setActionCommand("3");
		buttonGroup.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("4");
		radioButton_2.setActionCommand("4");
		buttonGroup.add(radioButton_2);
		
		JButton btnCreateGame = new JButton("Create Game");
		btnCreateGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				error = "";
				chosenNumber = buttonGroup.getSelection();
				numberOfPlayers = chosenNumber.getActionCommand();
				chosenNumberOfPlayers =  Integer.parseInt(numberOfPlayers);

				
//				numberOfPlayers = buttonGroup.toString();
//				chosenNumberOfPlayers = Integer.parseInt(numberOfPlayers);
				
			
				DesignModeController dmc = new DesignModeController ();
				try 
				{
					dmc.createGame(chosenNumberOfPlayers);
					System.out.print(" " + chosenNumberOfPlayers);
					close ();
				}
				catch (InvalidInputException e){
					error = e.getMessage();
					
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Load existing game by selecting one existing game");
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblContinueEditing = new JLabel("");
		
		JButton btnNewButton = new JButton("Continue designing last design?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addComponent(radioButton)
					.addGap(18)
					.addComponent(radioButton_1)
					.addGap(18)
					.addComponent(radioButton_2)
					.addGap(116)
					.addComponent(btnCreateGame)
					.addContainerGap(132, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(164))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(345, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(153))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(494, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(271))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(505, Short.MAX_VALUE)
					.addComponent(lblContinueEditing)
					.addGap(210))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(511, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(193))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioButton_1)
						.addComponent(radioButton)
						.addComponent(radioButton_2)
						.addComponent(btnCreateGame))
					.addGap(28)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblContinueEditing)
					.addGap(57)
					.addComponent(btnNewButton)
					.addContainerGap(169, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void close() { 
		this.setVisible(false);
	    this.dispose();
	}
}
