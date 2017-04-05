package ca.mcgill.ecse223.tileo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.tileo.controller.InvalidInputException;
import ca.mcgill.ecse223.tileo.controller.PlayController;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendBackToStartPopOut extends JFrame {
	private PlayController pmc = TileOPlayPage.pmc;
	private int chosenPlayer;
	private String error;

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the frame.
	 */
	public SendBackToStartPopOut() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblYouHaveDrawn = new JLabel("You have drawn a Send Back to Start Acton Card,");
		
		JLabel lblNewLabel = new JLabel("please select a player");
		
		JLabel lblAndClickOn = new JLabel("and click on the \"Send\" button to send him/her");
		
		JLabel lblBack = new JLabel("back to his/her starting position.");
		
		JRadioButton radioButton = new JRadioButton("1");
		buttonGroup.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		buttonGroup.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		buttonGroup.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		buttonGroup.add(radioButton_3);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				error = "";
				ButtonModel chosenPlayer = buttonGroup.getSelection();
				
				error.trim();
				if(error.length()==0){
					try{
					PlayController pmc = new PlayController();
					int index = Integer.parseInt(chosenPlayer.getActionCommand());
					pmc.playSendBackToStartActionCard(index);
					}
					catch(InvalidInputException e1){
						throw new RuntimeException(e1.getMessage());
					}
				}
				
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(lblYouHaveDrawn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(lblBack))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(lblAndClickOn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(189)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(radioButton_1)
								.addComponent(radioButton)
								.addComponent(radioButton_3)
								.addComponent(radioButton_2)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addComponent(btnSend)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblYouHaveDrawn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAndClickOn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton)
					.addGap(3)
					.addComponent(radioButton_1)
					.addGap(5)
					.addComponent(radioButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSend)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
